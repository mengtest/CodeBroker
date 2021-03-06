package com.codebroker.core.actor;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.thrift.TException;

import com.codebroker.core.entities.User;
import com.codebroker.protocol.ThriftSerializerFactory;
import com.message.thrift.actor.ActorMessage;
import com.message.thrift.actor.Operation;
import com.message.thrift.actor.session.ReBindUser;
import com.message.thrift.actor.usermanager.CreateUserWithSession;
import com.message.thrift.actor.usermanager.RemoveUser;
import com.message.thrift.actor.usermanager.SetReBindKey;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class UserManagerActor extends AbstractActor {


	public static final String IDENTIFY = UserManagerActor.class.getSimpleName().toString();

	public static final String USER_PRFIX = "USER-";
	public static final String NPC_PRFIX = "NPC-";
	
	private static final AtomicInteger USER_ID = new AtomicInteger(1);
	
	private Map<String, ActorRef> userRefMap = new TreeMap<String, ActorRef>();
	private Map<String, String> rebindKeyUserMap = new TreeMap<String, String>();
	
	private final ActorRef worldRef;

	public UserManagerActor(ActorRef worldRef) {
		super();
		this.worldRef = worldRef;
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder()
		 .match(byte[].class, msg -> {
			ActorMessage actorMessage = ThriftSerializerFactory.getActorMessage(msg);
			switch (actorMessage.op) 
			{
			//创建网络玩家
			case USER_MANAGER_CREATE_USER_WITH_SESSION:
				CreateUserWithSession createUserWithSession=new CreateUserWithSession();
				ThriftSerializerFactory.deserialize(createUserWithSession, actorMessage.messageRaw);
				createWorldUser(createUserWithSession.reBindKey,getSender());
				break;
			//移除玩家
			case USER_MANAGER_REMOVE_USER:
				RemoveUser removeUser=new RemoveUser();
				ThriftSerializerFactory.deserialize(removeUser, actorMessage.messageRaw);
				removeUser(removeUser.userID);
				break;
			//会话从新绑定玩家
			case USER_MANAGER_SESSION_REBING_USER:
				SetReBindKey bindKey=new SetReBindKey();
				ThriftSerializerFactory.deserialize(bindKey, actorMessage.messageRaw);
				rebindKeyUserMap.put(bindKey.reBindKey, bindKey.userId);
				break;
			default:

				break;
			}
		})
		 .match(FindUserByRebindKey.class, msg -> {
			processReBind(msg);
		}).build();
	}

	private void createWorldUser(String reBindKey, ActorRef sender) {
		int id = USER_ID.incrementAndGet();
		User user = new User();
		ActorRef actorOf = null;
		ActorContext context = getContext();

		String userid = USER_PRFIX + id;
		user.setUserId(userid);
		ReBindUser bindUser=new ReBindUser();
		try {
			actorOf = context.actorOf(Props.create(UserActor.class, user, false, sender), userid);
			user.setActorRef(actorOf);
			userRefMap.put(userid, actorOf);
			bindUser.success=true;
		} catch (Exception e) {
			bindUser.success=false;
		}
		byte[] actorMessageWithSubClass = ThriftSerializerFactory.getActorMessageWithSubClass(Operation.SESSION_REBIND_USER, bindUser);
		sender.tell(actorMessageWithSubClass, actorOf);

	}

	/**
	 * 处理重连接
	 * 
	 * @param msg
	 * @throws TException 
	 */
	private void processReBind(FindUserByRebindKey msg) throws TException {
		if (rebindKeyUserMap.containsKey(msg.bindKey)) {
			String key = rebindKeyUserMap.get(msg.bindKey);
			if (userRefMap.containsKey(key)) {
				ActorRef user = userRefMap.get(key);
				
				user.tell(ThriftSerializerFactory.getTbaseMessage(Operation.USER_RE_BINDUSER_IOSESSION_ACTOR), getSender());
				
				ReBindUser reBindUser=new ReBindUser(true);
				byte[] actorMessageWithSubClass = ThriftSerializerFactory.getActorMessageWithSubClass(Operation.SESSION_REBIND_USER, reBindUser);
				getSender().tell(actorMessageWithSubClass, user);
			} else {
				ReBindUser reBindUser=new ReBindUser(false);
				byte[] actorMessageWithSubClass = ThriftSerializerFactory.getActorMessageWithSubClass(Operation.SESSION_REBIND_USER, reBindUser);
				getSender().tell(actorMessageWithSubClass, ActorRef.noSender());
			}
		} else {
			ReBindUser reBindUser=new ReBindUser(false);
			byte[] actorMessageWithSubClass = ThriftSerializerFactory.getActorMessageWithSubClass(Operation.SESSION_REBIND_USER, reBindUser);
			
			getSender().tell(actorMessageWithSubClass, ActorRef.noSender());
		}
	}


	private void removeUser(String userId) {
		userRefMap.remove(userId);
	}



	public static class FindUserByRebindKey {
		public final String bindKey;

		public FindUserByRebindKey(String bindKey) {
			super();
			this.bindKey = bindKey;
		}

	}
}

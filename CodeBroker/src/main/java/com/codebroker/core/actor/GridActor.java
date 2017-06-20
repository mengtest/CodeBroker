package com.codebroker.core.actor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.codebroker.api.IUser;
import com.codebroker.api.event.IEvent;
import com.codebroker.api.event.IEventListener;
import com.codebroker.core.actor.UserActor.AddEventListener;
import com.codebroker.core.actor.UserActor.DispatchEvent;
import com.codebroker.core.actor.UserActor.HasEventListener;
import com.codebroker.core.actor.UserActor.RemoveEventListener;
import com.codebroker.core.entities.Grid;

import akka.actor.AbstractActor;

public class GridActor extends AbstractActor {

	private final Grid grid;

	private Map<String, IUser> userMap = new TreeMap<String, IUser>();

	private final Map<String, IEventListener> eventListener = new HashMap<String, IEventListener>();
	
	public GridActor(Grid grid) {
		super();
		this.grid = grid;
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder()
		  .match(EnterGrid.class, msg -> {
			if (userMap.containsKey(msg.user.getUserId())) {
				getSender().tell(false, getSelf());
			} else {
				userMap.put(msg.user.getUserId(), msg.user);
				getSender().tell(true, getSelf());
			}
		}).match(LeaveGrid.class, msg -> {
			if (userMap.containsKey(msg.userId)) {
				userMap.remove(msg.userId);
			}

		}).match(AddEventListener.class, msg -> {
			eventListener.put(msg.topic, msg.paramIEventListener);
		}).match(RemoveEventListener.class, msg->{
			eventListener.remove(msg.topic);
		}).match(HasEventListener.class, msg->{
			getSender().tell(eventListener.containsKey(msg.topic), getSelf());
		}).match(DispatchEvent.class, msg->{
			dispatchEvent(msg);
		}).build();
	}

	private void dispatchEvent(DispatchEvent msg) {
		IEvent paramIEvent = msg.paramIEvent;
		try{
			IEventListener iEventListener = eventListener.get(paramIEvent.getTopic());
			if(iEventListener!=null){
				iEventListener.handleEvent(paramIEvent);
			}		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static class EnterGrid implements Serializable {

		private static final long serialVersionUID = -7809307785484209371L;
		public final IUser user;

		public EnterGrid(IUser user) {
			super();
			this.user = user;
		}

	}

	public static class LeaveGrid implements Serializable {
		private static final long serialVersionUID = 2793900887224969528L;
		public final String userId;

		public LeaveGrid(String userId) {
			super();
			this.userId = userId;
		}
	}

	public static class BroadCastAllUser implements Serializable {
		private static final long serialVersionUID = 2143027987941307508L;

		public final String jsonString;

		public BroadCastAllUser(String jsonString) {
			super();
			this.jsonString = jsonString;
		}

	}
	
	public static class AddEventListener{
		public final String topic;
		public final IEventListener paramIEventListener;
		
		public AddEventListener(String topic, IEventListener paramIEventListener) {
			super();
			this.topic = topic;
			this.paramIEventListener = paramIEventListener;
		}
		
	}
	
	public static class RemoveEventListener{
		public final String topic;

		public RemoveEventListener(String topic) {
			super();
			this.topic = topic;
		}
	}
	
	public static class DispatchEvent implements Serializable{
		
		private static final long serialVersionUID = -382183759904733665L;
		
		public final IEvent paramIEvent;

		public DispatchEvent(IEvent paramIEvent) {
			super();
			this.paramIEvent = paramIEvent;
		}
		
	}
	
	public static class HasEventListener implements Serializable{

		private static final long serialVersionUID = 6661678840156738466L;
		
		public final String topic;

		public HasEventListener(String topic) {
			super();
			this.topic = topic;
		}
		
	}
}
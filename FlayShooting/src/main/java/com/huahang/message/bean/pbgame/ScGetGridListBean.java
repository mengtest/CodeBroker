package com.huahang.message.bean.pbgame;

import com.google.protobuf.Message;
import com.google.protobuf.InvalidProtocolBufferException;
import com.codebroker.api.JavaProtocolTransform;
import com.message.protocol.PBGame.SC_GET_GRID_LIST.*;

public class ScGetGridListBean implements JavaProtocolTransform {
	
	public static final int REQUEST_ID = com.message.protocol.Message.PB.MessageKey.SC_GET_GRID_LIST_VALUE;
	
	private java.util.List<java.lang.String> areaId;


	public java.util.List<java.lang.String> getAreaId()
	{
		return areaId;
	}

	public void setAreaId(java.util.List<java.lang.String> areaId)
	{
		this.areaId = areaId;
	}
	

	@Override
	public void protocolToJavaBean(Message message)
	{
		com.message.protocol.PBGame.SC_GET_GRID_LIST protocal = (com.message.protocol.PBGame.SC_GET_GRID_LIST) message;
				{
				java.util.List<java.lang.String> list = protocal.getAreaIdList();
				this.setAreaId(list);
				}
	}

	@Override
	public com.message.protocol.PBGame.SC_GET_GRID_LIST javaBeanToProtocol()
	{
		Builder newBuilder = com.message.protocol.PBGame.SC_GET_GRID_LIST.newBuilder();
						{
			newBuilder.addAllAreaId(this.getAreaId());
			}
		return newBuilder.build();
	}

	@Override
	public byte[] getByteArray()
	{
		return javaBeanToProtocol().toByteArray();
	}

	@Override
	public com.message.protocol.PBGame.SC_GET_GRID_LIST bytesToProtocol(byte[] bytes) throws InvalidProtocolBufferException
	{
		return com.message.protocol.PBGame.SC_GET_GRID_LIST.parseFrom(bytes);
	}
}
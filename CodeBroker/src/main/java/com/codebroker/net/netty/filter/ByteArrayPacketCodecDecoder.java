package com.codebroker.net.netty.filter;

import java.util.List;

import com.codebroker.protocol.BaseByteArrayPacket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 网络数据包解析 |4| |4| |……| 数据包长度 操作码 数据.
 *
 * @author ZERO
 */

public class ByteArrayPacketCodecDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

		if (in.readableBytes() < 4) {
			return;
		}

		in.markReaderIndex();
//		byte[] bytes = ByteBufUtil.getBytes(in);

		int dataLength = in.readInt();
		if (in.readableBytes() < dataLength) {
			in.resetReaderIndex();
			return;
		}

		int opcode = in.readInt();

		byte[] decoded = new byte[dataLength - 4];
		in.readBytes(decoded);
		
		BaseByteArrayPacket messagePack = new BaseByteArrayPacket(opcode, decoded);
		
		out.add(messagePack);

	}

}

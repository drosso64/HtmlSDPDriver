package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_TRADER_CONNECTION_INFO extends SMPMessage
{
	public static final long CLASS_ID = 100067;

	private long MemberId = 0;
	private long TraderId = 0;
	private TI_CONNECTION_TYPE_Enum ConnectionType = TI_CONNECTION_TYPE_Enum.TI_CONNECTION_TYPE_LeasedLines;
	private TI_SECURITY_TYPE_Enum SecurityTpe = TI_SECURITY_TYPE_Enum.TI_SECURITY_TYPE_PlainTCP;
	private TI_PROTOCOL_SOURCE_Enum ProtocolSource = TI_PROTOCOL_SOURCE_Enum.TI_PROTOCOL_SOURCE_Sdp;
	private TI_IP_ADDRESS_INFO[] IPAddressInfo = new TI_IP_ADDRESS_INFO[20];

	public TI_TRADER_CONNECTION_INFO()
	{
		for (int i=0; i < IPAddressInfo.length; ++i)
		{
			IPAddressInfo[i] = new TI_IP_ADDRESS_INFO();
		}
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public TI_CONNECTION_TYPE_Enum getConnectionType()
	{
		return ConnectionType;
	}
	public void setConnectionType(TI_CONNECTION_TYPE_Enum value)
	{
		ConnectionType = value;
	}
	public TI_SECURITY_TYPE_Enum getSecurityTpe()
	{
		return SecurityTpe;
	}
	public void setSecurityTpe(TI_SECURITY_TYPE_Enum value)
	{
		SecurityTpe = value;
	}
	public TI_PROTOCOL_SOURCE_Enum getProtocolSource()
	{
		return ProtocolSource;
	}
	public void setProtocolSource(TI_PROTOCOL_SOURCE_Enum value)
	{
		ProtocolSource = value;
	}
	public TI_IP_ADDRESS_INFO[] getIPAddressInfo()
	{
		return IPAddressInfo;
	}
	public void setIPAddressInfo(TI_IP_ADDRESS_INFO[] value)
	{
		IPAddressInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		ConnectionType = ConnectionType.getEnum(byteBuffer.readInt());
		SecurityTpe = SecurityTpe.getEnum(byteBuffer.readInt());
		ProtocolSource = ProtocolSource.getEnum(byteBuffer.readInt());
		for (int i=0; i < IPAddressInfo.length; ++i)
		{
			IPAddressInfo[i].readXDR(byteBuffer);
		}
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ConnectionType.getValue());
		byteBuffer.writeInt(SecurityTpe.getValue());
		byteBuffer.writeInt(ProtocolSource.getValue());
		for (int i=0; i < IPAddressInfo.length; ++i)
		{
			IPAddressInfo[i].writeXDR(byteBuffer);
		}

		return byteBuffer.position() - init;
	}
	@Override
	public long getSMPClassId()
	{
		return CLASS_ID;
	}
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(1024);
		stringBuilder.append("TI_TRADER_CONNECTION_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("ConnectionType(").append(ConnectionType).append(")");
		stringBuilder.append("SecurityTpe(").append(SecurityTpe).append(")");
		stringBuilder.append("ProtocolSource(").append(ProtocolSource).append(")");
		for (int i=0; i < IPAddressInfo.length; ++i)
		{
			stringBuilder.append("IPAddressInfo[").append(i).append("](").append(IPAddressInfo[i].toString()).append(")");
		}
		return stringBuilder.toString();
	}
}

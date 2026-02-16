package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_SETTL_GROUP_MEMBER_PARAMS_UPDATE extends SMPMessage
{
	public static final long CLASS_ID = 114808;

	private long RequestId = 0;
	private long SettlGroupId = 0;
	private long MemberId = 0;
	private TI_FLAG_Enum SameDaySettleFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_SETTL_GROUP_MEMBER_PARAMS_UPDATE()
	{
	}

	public long getRequestId()
	{
		return RequestId;
	}
	public void setRequestId(long value)
	{
		RequestId = value;
	}
	public long getSettlGroupId()
	{
		return SettlGroupId;
	}
	public void setSettlGroupId(long value)
	{
		SettlGroupId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public TI_FLAG_Enum getSameDaySettleFg()
	{
		return SameDaySettleFg;
	}
	public void setSameDaySettleFg(TI_FLAG_Enum value)
	{
		SameDaySettleFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RequestId = (long)byteBuffer.readInt();
		SettlGroupId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		SameDaySettleFg = SameDaySettleFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RequestId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SameDaySettleFg.getValue());

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
		stringBuilder.append("BV_SETTL_GROUP_MEMBER_PARAMS_UPDATE::");
		stringBuilder.append("RequestId(").append(RequestId).append(")");
		stringBuilder.append("SettlGroupId(").append(SettlGroupId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("SameDaySettleFg(").append(SameDaySettleFg).append(")");
		return stringBuilder.toString();
	}
}

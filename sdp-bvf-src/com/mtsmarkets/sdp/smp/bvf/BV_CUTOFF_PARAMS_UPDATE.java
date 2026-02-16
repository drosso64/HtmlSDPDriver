package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CUTOFF_PARAMS_UPDATE extends SMPMessage
{
	public static final long CLASS_ID = 114809;

	private long RequestId = 0;
	private long SettlGroupId = 0;
	private BV_CUTOFF_TYPE_Enum CutoffType = BV_CUTOFF_TYPE_Enum.BV_CUTOFF_TYPE_RFCQSameDaySettlement;
	private long CutoffTime = 0;

	public BV_CUTOFF_PARAMS_UPDATE()
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
	public BV_CUTOFF_TYPE_Enum getCutoffType()
	{
		return CutoffType;
	}
	public void setCutoffType(BV_CUTOFF_TYPE_Enum value)
	{
		CutoffType = value;
	}
	public long getCutoffTime()
	{
		return CutoffTime;
	}
	public void setCutoffTime(long value)
	{
		CutoffTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RequestId = (long)byteBuffer.readInt();
		SettlGroupId = (long)byteBuffer.readInt();
		CutoffType = CutoffType.getEnum(byteBuffer.readInt());
		CutoffTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RequestId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt(CutoffType.getValue());
		byteBuffer.writeLong(CutoffTime);

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
		stringBuilder.append("BV_CUTOFF_PARAMS_UPDATE::");
		stringBuilder.append("RequestId(").append(RequestId).append(")");
		stringBuilder.append("SettlGroupId(").append(SettlGroupId).append(")");
		stringBuilder.append("CutoffType(").append(CutoffType).append(")");
		stringBuilder.append("CutoffTime(").append(CutoffTime).append(")");
		return stringBuilder.toString();
	}
}

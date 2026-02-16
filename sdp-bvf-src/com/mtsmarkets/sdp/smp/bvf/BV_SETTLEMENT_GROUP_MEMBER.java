package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_SETTLEMENT_GROUP_MEMBER extends SMPMessage
{
	public static final long CLASS_ID = 114101;

	private long SettlGroupId = 0;
	private long MemberId = 0;
	private long SettlSystemId = 0;
	private long StartDate = 0;
	private TI_SETTL_TYPE_Enum SettlType = TI_SETTL_TYPE_Enum.TI_SETTL_TYPE_Manual;
	private TI_FLAG_Enum SameDaySettleFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_SETTLEMENT_GROUP_MEMBER()
	{
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
	public long getSettlSystemId()
	{
		return SettlSystemId;
	}
	public void setSettlSystemId(long value)
	{
		SettlSystemId = value;
	}
	public long getStartDate()
	{
		return StartDate;
	}
	public void setStartDate(long value)
	{
		StartDate = value;
	}
	public TI_SETTL_TYPE_Enum getSettlType()
	{
		return SettlType;
	}
	public void setSettlType(TI_SETTL_TYPE_Enum value)
	{
		SettlType = value;
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
		SettlGroupId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		SettlSystemId = (long)byteBuffer.readInt();
		StartDate = (long)byteBuffer.readInt();
		SettlType = SettlType.getEnum(byteBuffer.readInt());
		SameDaySettleFg = SameDaySettleFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SettlGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlSystemId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StartDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(SettlType.getValue());
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
		stringBuilder.append("BV_SETTLEMENT_GROUP_MEMBER::");
		stringBuilder.append("SettlGroupId(").append(SettlGroupId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("SettlSystemId(").append(SettlSystemId).append(")");
		stringBuilder.append("StartDate(").append(StartDate).append(")");
		stringBuilder.append("SettlType(").append(SettlType).append(")");
		stringBuilder.append("SameDaySettleFg(").append(SameDaySettleFg).append(")");
		return stringBuilder.toString();
	}
}

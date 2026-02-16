package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MEMBER_PRIVATE_INFO extends SMPMessage
{
	public static final long CLASS_ID = 400058;

	private long MemberId = 0;
	private TI_FLAG_Enum RfcqTimeBlockFg = TI_FLAG_Enum.TI_FLAG_No;
	private long StartRfcqTimeBlock = 0;
	private long StopRfcqTimeBlock = 0;
	private TI_FLAG_Enum AutoExecutionRuleOwnershipFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_MEMBER_PRIVATE_INFO()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public TI_FLAG_Enum getRfcqTimeBlockFg()
	{
		return RfcqTimeBlockFg;
	}
	public void setRfcqTimeBlockFg(TI_FLAG_Enum value)
	{
		RfcqTimeBlockFg = value;
	}
	public long getStartRfcqTimeBlock()
	{
		return StartRfcqTimeBlock;
	}
	public void setStartRfcqTimeBlock(long value)
	{
		StartRfcqTimeBlock = value;
	}
	public long getStopRfcqTimeBlock()
	{
		return StopRfcqTimeBlock;
	}
	public void setStopRfcqTimeBlock(long value)
	{
		StopRfcqTimeBlock = value;
	}
	public TI_FLAG_Enum getAutoExecutionRuleOwnershipFg()
	{
		return AutoExecutionRuleOwnershipFg;
	}
	public void setAutoExecutionRuleOwnershipFg(TI_FLAG_Enum value)
	{
		AutoExecutionRuleOwnershipFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		RfcqTimeBlockFg = RfcqTimeBlockFg.getEnum(byteBuffer.readInt());
		StartRfcqTimeBlock = byteBuffer.readLong();
		StopRfcqTimeBlock = byteBuffer.readLong();
		AutoExecutionRuleOwnershipFg = AutoExecutionRuleOwnershipFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(RfcqTimeBlockFg.getValue());
		byteBuffer.writeLong(StartRfcqTimeBlock);
		byteBuffer.writeLong(StopRfcqTimeBlock);
		byteBuffer.writeInt(AutoExecutionRuleOwnershipFg.getValue());

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
		stringBuilder.append("BV_MEMBER_PRIVATE_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("RfcqTimeBlockFg(").append(RfcqTimeBlockFg).append(")");
		stringBuilder.append("StartRfcqTimeBlock(").append(StartRfcqTimeBlock).append(")");
		stringBuilder.append("StopRfcqTimeBlock(").append(StopRfcqTimeBlock).append(")");
		stringBuilder.append("AutoExecutionRuleOwnershipFg(").append(AutoExecutionRuleOwnershipFg).append(")");
		return stringBuilder.toString();
	}
}

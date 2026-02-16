package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_ASSET extends SMPMessage
{
	public static final long CLASS_ID = 114993;

	private long FirstLevel = 0;
	private long SecondLevel = 0;

	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_ASSET()
	{
	}

	public long getFirstLevel()
	{
		return FirstLevel;
	}
	public void setFirstLevel(long value)
	{
		FirstLevel = value;
	}
	public long getSecondLevel()
	{
		return SecondLevel;
	}
	public void setSecondLevel(long value)
	{
		SecondLevel = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FirstLevel = (long)byteBuffer.readInt();
		SecondLevel = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FirstLevel & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondLevel & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_ASSET::");
		stringBuilder.append("FirstLevel(").append(FirstLevel).append(")");
		stringBuilder.append("SecondLevel(").append(SecondLevel).append(")");
		return stringBuilder.toString();
	}
}

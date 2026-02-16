package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_AUTO_EXECUTION_RULE_EXEC_TRADER extends SMPMessage
{
	public static final long CLASS_ID = 114909;

	private long ExecTraderId = 0;
	private String ExecTraderName = "";

	public BV_AUTO_EXECUTION_RULE_EXEC_TRADER()
	{
	}

	public long getExecTraderId()
	{
		return ExecTraderId;
	}
	public void setExecTraderId(long value)
	{
		ExecTraderId = value;
	}
	public String getExecTraderName()
	{
		return ExecTraderName;
	}
	public void setExecTraderName(String value)
	{
		ExecTraderName = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ExecTraderId = (long)byteBuffer.readInt();
		ExecTraderName = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ExecTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(ExecTraderName);

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
		stringBuilder.append("BV_AUTO_EXECUTION_RULE_EXEC_TRADER::");
		stringBuilder.append("ExecTraderId(").append(ExecTraderId).append(")");
		stringBuilder.append("ExecTraderName(").append(ExecTraderName).append(")");
		return stringBuilder.toString();
	}
}

package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_EXEC_TIME extends SMPMessage
{
	public static final long CLASS_ID = 410000;

	private short ExecutionTimeNum = 0;
	private long[] ExecutionTimeList = new long[50];
	private TI_FLAG_Enum NoExecutionTimeFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_EXEC_TIME()
	{
	}

	public short getExecutionTimeNum()
	{
		return ExecutionTimeNum;
	}
	public void setExecutionTimeNum(short value)
	{
		ExecutionTimeNum = value;
	}
	public long[] getExecutionTimeList()
	{
		return ExecutionTimeList;
	}
	public void setExecutionTimeList(long[] value)
	{
		ExecutionTimeList = value;
	}
	public TI_FLAG_Enum getNoExecutionTimeFg()
	{
		return NoExecutionTimeFg;
	}
	public void setNoExecutionTimeFg(TI_FLAG_Enum value)
	{
		NoExecutionTimeFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ExecutionTimeNum = (short)byteBuffer.readInt();
		for (int i=0; i < ExecutionTimeList.length; ++i)
		{
			ExecutionTimeList[i] = byteBuffer.readLong();
		}
		NoExecutionTimeFg = NoExecutionTimeFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ExecutionTimeNum & 0xFFFFL));
		for (int i=0; i < ExecutionTimeList.length; ++i)
		{
			byteBuffer.writeLong(ExecutionTimeList[i]);
		}
		byteBuffer.writeInt(NoExecutionTimeFg.getValue());

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_EXEC_TIME::");
		stringBuilder.append("ExecutionTimeNum(").append(ExecutionTimeNum).append(")");
		for (int i=0; i < ExecutionTimeList.length; ++i)
		{
			stringBuilder.append("ExecutionTimeList[").append(i).append("](").append(ExecutionTimeList[i]).append(")");
		}
		stringBuilder.append("NoExecutionTimeFg(").append(NoExecutionTimeFg).append(")");
		return stringBuilder.toString();
	}
}

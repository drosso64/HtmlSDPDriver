package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FINANCIAL_CALCULATOR extends SMPMessage
{
	public static final long CLASS_ID = 100073;

	private long CalculationRequestId = 0;
	private long FunctionId = 0;
	private TI_FINANCIAL_CALCULATOR_VALUE[] InputValues = new TI_FINANCIAL_CALCULATOR_VALUE[32];
	private TI_FINANCIAL_CALCULATOR_VALUE[] OutputValues = new TI_FINANCIAL_CALCULATOR_VALUE[32];

	public TI_FINANCIAL_CALCULATOR()
	{
		for (int i=0; i < InputValues.length; ++i)
		{
			InputValues[i] = new TI_FINANCIAL_CALCULATOR_VALUE();
		}
		for (int i=0; i < OutputValues.length; ++i)
		{
			OutputValues[i] = new TI_FINANCIAL_CALCULATOR_VALUE();
		}
	}

	public long getCalculationRequestId()
	{
		return CalculationRequestId;
	}
	public void setCalculationRequestId(long value)
	{
		CalculationRequestId = value;
	}
	public long getFunctionId()
	{
		return FunctionId;
	}
	public void setFunctionId(long value)
	{
		FunctionId = value;
	}
	public TI_FINANCIAL_CALCULATOR_VALUE[] getInputValues()
	{
		return InputValues;
	}
	public void setInputValues(TI_FINANCIAL_CALCULATOR_VALUE[] value)
	{
		InputValues = value;
	}
	public TI_FINANCIAL_CALCULATOR_VALUE[] getOutputValues()
	{
		return OutputValues;
	}
	public void setOutputValues(TI_FINANCIAL_CALCULATOR_VALUE[] value)
	{
		OutputValues = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CalculationRequestId = (long)byteBuffer.readInt();
		FunctionId = (long)byteBuffer.readInt();
		for (int i=0; i < InputValues.length; ++i)
		{
			InputValues[i].readXDR(byteBuffer);
		}
		for (int i=0; i < OutputValues.length; ++i)
		{
			OutputValues[i].readXDR(byteBuffer);
		}
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(CalculationRequestId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FunctionId & 0xFFFFFFFFL));
		for (int i=0; i < InputValues.length; ++i)
		{
			InputValues[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < OutputValues.length; ++i)
		{
			OutputValues[i].writeXDR(byteBuffer);
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
		stringBuilder.append("TI_FINANCIAL_CALCULATOR::");
		stringBuilder.append("CalculationRequestId(").append(CalculationRequestId).append(")");
		stringBuilder.append("FunctionId(").append(FunctionId).append(")");
		for (int i=0; i < InputValues.length; ++i)
		{
			stringBuilder.append("InputValues[").append(i).append("](").append(InputValues[i].toString()).append(")");
		}
		for (int i=0; i < OutputValues.length; ++i)
		{
			stringBuilder.append("OutputValues[").append(i).append("](").append(OutputValues[i].toString()).append(")");
		}
		return stringBuilder.toString();
	}
}

package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INSTRUMENT_PER_FUNCTION extends SMPMessage
{
	public static final long CLASS_ID = 114951;

	private TI_TRADING_FUNCTION_Enum FunctionId = TI_TRADING_FUNCTION_Enum.TI_TRADING_FUNCTION_FirmQuote;
	private double MinQty = 0;
	private double MinQtyCap = 0;
	private TI_POSSIBLE_QUOTING_Enum PossibleQuoting = TI_POSSIBLE_QUOTING_Enum.TI_POSSIBLE_QUOTING_None;

	public BV_INSTRUMENT_PER_FUNCTION()
	{
	}

	public TI_TRADING_FUNCTION_Enum getFunctionId()
	{
		return FunctionId;
	}
	public void setFunctionId(TI_TRADING_FUNCTION_Enum value)
	{
		FunctionId = value;
	}
	public double getMinQty()
	{
		return MinQty;
	}
	public void setMinQty(double value)
	{
		MinQty = value;
	}
	public double getMinQtyCap()
	{
		return MinQtyCap;
	}
	public void setMinQtyCap(double value)
	{
		MinQtyCap = value;
	}
	public TI_POSSIBLE_QUOTING_Enum getPossibleQuoting()
	{
		return PossibleQuoting;
	}
	public void setPossibleQuoting(TI_POSSIBLE_QUOTING_Enum value)
	{
		PossibleQuoting = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FunctionId = FunctionId.getEnum(byteBuffer.readInt());
		MinQty = byteBuffer.readDouble();
		MinQtyCap = byteBuffer.readDouble();
		PossibleQuoting = PossibleQuoting.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(FunctionId.getValue());
		byteBuffer.writeDouble(MinQty);
		byteBuffer.writeDouble(MinQtyCap);
		byteBuffer.writeInt(PossibleQuoting.getValue());

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
		stringBuilder.append("BV_INSTRUMENT_PER_FUNCTION::");
		stringBuilder.append("FunctionId(").append(FunctionId).append(")");
		stringBuilder.append("MinQty(").append(MinQty).append(")");
		stringBuilder.append("MinQtyCap(").append(MinQtyCap).append(")");
		stringBuilder.append("PossibleQuoting(").append(PossibleQuoting).append(")");
		return stringBuilder.toString();
	}
}

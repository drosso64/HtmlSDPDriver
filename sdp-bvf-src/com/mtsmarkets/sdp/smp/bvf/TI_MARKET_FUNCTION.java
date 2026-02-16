package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MARKET_FUNCTION extends SMPMessage
{
	public static final long CLASS_ID = 100059;

	private TI_FUNCTION_Enum FunctionId = TI_FUNCTION_Enum.TI_FUNCTION_FirmQuote;
	private String FunctionName = "";
	private TI_FUNCTION_LEVEL_Enum Level = TI_FUNCTION_LEVEL_Enum.TI_FUNCTION_LEVEL_Platform;
	private TI_FUNCTION_ACTION_Enum AllowedAction = TI_FUNCTION_ACTION_Enum.TI_FUNCTION_ACTION_None;

	public TI_MARKET_FUNCTION()
	{
	}

	public TI_FUNCTION_Enum getFunctionId()
	{
		return FunctionId;
	}
	public void setFunctionId(TI_FUNCTION_Enum value)
	{
		FunctionId = value;
	}
	public String getFunctionName()
	{
		return FunctionName;
	}
	public void setFunctionName(String value)
	{
		FunctionName = value;
	}
	public TI_FUNCTION_LEVEL_Enum getLevel()
	{
		return Level;
	}
	public void setLevel(TI_FUNCTION_LEVEL_Enum value)
	{
		Level = value;
	}
	public TI_FUNCTION_ACTION_Enum getAllowedAction()
	{
		return AllowedAction;
	}
	public void setAllowedAction(TI_FUNCTION_ACTION_Enum value)
	{
		AllowedAction = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FunctionId = FunctionId.getEnum(byteBuffer.readInt());
		FunctionName = byteBuffer.readString();
		Level = Level.getEnum(byteBuffer.readInt());
		AllowedAction = AllowedAction.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(FunctionId.getValue());
		byteBuffer.writeString(FunctionName);
		byteBuffer.writeInt(Level.getValue());
		byteBuffer.writeInt(AllowedAction.getValue());

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
		stringBuilder.append("TI_MARKET_FUNCTION::");
		stringBuilder.append("FunctionId(").append(FunctionId).append(")");
		stringBuilder.append("FunctionName(").append(FunctionName).append(")");
		stringBuilder.append("Level(").append(Level).append(")");
		stringBuilder.append("AllowedAction(").append(AllowedAction).append(")");
		return stringBuilder.toString();
	}
}

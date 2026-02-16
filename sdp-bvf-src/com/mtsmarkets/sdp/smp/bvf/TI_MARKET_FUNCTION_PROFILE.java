package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MARKET_FUNCTION_PROFILE extends SMPMessage
{
	public static final long CLASS_ID = 100058;

	private TI_MEMBER_PROFILE_Enum MemberProfile = TI_MEMBER_PROFILE_Enum.TI_MEMBER_PROFILE_None;
	private long MarketId = 0;
	private TI_FUNCTION_Enum FunctionId = TI_FUNCTION_Enum.TI_FUNCTION_FirmQuote;
	private TI_FUNCTION_ACTION_Enum AllowedAction = TI_FUNCTION_ACTION_Enum.TI_FUNCTION_ACTION_None;

	public TI_MARKET_FUNCTION_PROFILE()
	{
	}

	public TI_MEMBER_PROFILE_Enum getMemberProfile()
	{
		return MemberProfile;
	}
	public void setMemberProfile(TI_MEMBER_PROFILE_Enum value)
	{
		MemberProfile = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public TI_FUNCTION_Enum getFunctionId()
	{
		return FunctionId;
	}
	public void setFunctionId(TI_FUNCTION_Enum value)
	{
		FunctionId = value;
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
		MemberProfile = MemberProfile.getEnum(byteBuffer.readInt());
		MarketId = (long)byteBuffer.readInt();
		FunctionId = FunctionId.getEnum(byteBuffer.readInt());
		AllowedAction = AllowedAction.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(MemberProfile.getValue());
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt(FunctionId.getValue());
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
		stringBuilder.append("TI_MARKET_FUNCTION_PROFILE::");
		stringBuilder.append("MemberProfile(").append(MemberProfile).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("FunctionId(").append(FunctionId).append(")");
		stringBuilder.append("AllowedAction(").append(AllowedAction).append(")");
		return stringBuilder.toString();
	}
}

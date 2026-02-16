package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MEMBER_SECTION_INSTRUMENT_CLASS_EXCEPTION extends SMPMessage
{
	public static final long CLASS_ID = 100060;

	private long InstrumentClassId = 0;
	private long MemberId = 0;
	private long MarketId = 0;
	private long SectionId = 0;
	private TI_MEMBER_PROFILE_Enum MemberProfile = TI_MEMBER_PROFILE_Enum.TI_MEMBER_PROFILE_None;
	private TI_FUNCTION_Enum FunctionId = TI_FUNCTION_Enum.TI_FUNCTION_FirmQuote;
	private TI_FUNCTION_ACTION_Enum AllowedAction = TI_FUNCTION_ACTION_Enum.TI_FUNCTION_ACTION_None;

	public TI_MEMBER_SECTION_INSTRUMENT_CLASS_EXCEPTION()
	{
	}

	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public TI_MEMBER_PROFILE_Enum getMemberProfile()
	{
		return MemberProfile;
	}
	public void setMemberProfile(TI_MEMBER_PROFILE_Enum value)
	{
		MemberProfile = value;
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
		InstrumentClassId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		MemberProfile = MemberProfile.getEnum(byteBuffer.readInt());
		FunctionId = FunctionId.getEnum(byteBuffer.readInt());
		AllowedAction = AllowedAction.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MemberProfile.getValue());
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
		stringBuilder.append("TI_MEMBER_SECTION_INSTRUMENT_CLASS_EXCEPTION::");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("MemberProfile(").append(MemberProfile).append(")");
		stringBuilder.append("FunctionId(").append(FunctionId).append(")");
		stringBuilder.append("AllowedAction(").append(AllowedAction).append(")");
		return stringBuilder.toString();
	}
}

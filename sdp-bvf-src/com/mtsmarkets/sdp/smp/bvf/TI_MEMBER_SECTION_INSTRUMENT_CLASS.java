package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MEMBER_SECTION_INSTRUMENT_CLASS extends SMPMessage
{
	public static final long CLASS_ID = 100041;

	private long InstrumentClassId = 0;
	private long MemberId = 0;
	private long MarketId = 0;
	private long SectionId = 0;
	private TI_MEMBER_PROFILE_Enum MemberProfile = TI_MEMBER_PROFILE_Enum.TI_MEMBER_PROFILE_None;
	private TI_FLAG_Enum MTSLiveEnabledFg = TI_FLAG_Enum.TI_FLAG_No;

	public TI_MEMBER_SECTION_INSTRUMENT_CLASS()
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
	public TI_FLAG_Enum getMTSLiveEnabledFg()
	{
		return MTSLiveEnabledFg;
	}
	public void setMTSLiveEnabledFg(TI_FLAG_Enum value)
	{
		MTSLiveEnabledFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentClassId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		MemberProfile = MemberProfile.getEnum(byteBuffer.readInt());
		MTSLiveEnabledFg = MTSLiveEnabledFg.getEnum(byteBuffer.readInt());
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
		byteBuffer.writeInt(MTSLiveEnabledFg.getValue());

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
		stringBuilder.append("TI_MEMBER_SECTION_INSTRUMENT_CLASS::");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("MemberProfile(").append(MemberProfile).append(")");
		stringBuilder.append("MTSLiveEnabledFg(").append(MTSLiveEnabledFg).append(")");
		return stringBuilder.toString();
	}
}

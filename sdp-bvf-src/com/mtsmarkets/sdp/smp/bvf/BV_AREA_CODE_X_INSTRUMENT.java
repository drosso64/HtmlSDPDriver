package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_AREA_CODE_X_INSTRUMENT extends SMPMessage
{
	public static final long CLASS_ID = 400035;

	private short AreaCodeId = 0;
	private long InstrumentId = 0;
	private TI_FLAG_Enum ExemptedPostTradeTransparencyFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_POST_TRADE_DEFERRAL_Enum ExemptedPostTradeTransparencySuperDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_SUPER_DEFERRAL_EXTENDED_DEFERRAL_TIME SuperDeferralExtendedDeferralTime = new TI_SUPER_DEFERRAL_EXTENDED_DEFERRAL_TIME();

	public BV_AREA_CODE_X_INSTRUMENT()
	{
	}

	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public TI_FLAG_Enum getExemptedPostTradeTransparencyFg()
	{
		return ExemptedPostTradeTransparencyFg;
	}
	public void setExemptedPostTradeTransparencyFg(TI_FLAG_Enum value)
	{
		ExemptedPostTradeTransparencyFg = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getExemptedPostTradeTransparencySuperDeferral()
	{
		return ExemptedPostTradeTransparencySuperDeferral;
	}
	public void setExemptedPostTradeTransparencySuperDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		ExemptedPostTradeTransparencySuperDeferral = value;
	}
	public TI_SUPER_DEFERRAL_EXTENDED_DEFERRAL_TIME getSuperDeferralExtendedDeferralTime()
	{
		return SuperDeferralExtendedDeferralTime;
	}
	public void setSuperDeferralExtendedDeferralTime(TI_SUPER_DEFERRAL_EXTENDED_DEFERRAL_TIME value)
	{
		SuperDeferralExtendedDeferralTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		AreaCodeId = (short)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		ExemptedPostTradeTransparencyFg = ExemptedPostTradeTransparencyFg.getEnum(byteBuffer.readInt());
		ExemptedPostTradeTransparencySuperDeferral = ExemptedPostTradeTransparencySuperDeferral.getEnum(byteBuffer.readInt());
		SuperDeferralExtendedDeferralTime.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ExemptedPostTradeTransparencyFg.getValue());
		byteBuffer.writeInt(ExemptedPostTradeTransparencySuperDeferral.getValue());
		SuperDeferralExtendedDeferralTime.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_AREA_CODE_X_INSTRUMENT::");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("ExemptedPostTradeTransparencyFg(").append(ExemptedPostTradeTransparencyFg).append(")");
		stringBuilder.append("ExemptedPostTradeTransparencySuperDeferral(").append(ExemptedPostTradeTransparencySuperDeferral).append(")");
		stringBuilder.append("SuperDeferralExtendedDeferralTime(").append(SuperDeferralExtendedDeferralTime.toString()).append(")");
		return stringBuilder.toString();
	}
}

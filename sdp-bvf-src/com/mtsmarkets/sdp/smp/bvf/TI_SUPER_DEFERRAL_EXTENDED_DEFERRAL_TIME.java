package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_SUPER_DEFERRAL_EXTENDED_DEFERRAL_TIME extends SMPMessage
{
	public static final long CLASS_ID = 100924;

	private short SuperDeferralExtendedDeferralTimeValue = 0;
	private TI_PERIOD_Enum SuperDeferralExtendedDeferralTimeUnit = TI_PERIOD_Enum.TI_PERIOD_Day;

	public TI_SUPER_DEFERRAL_EXTENDED_DEFERRAL_TIME()
	{
	}

	public short getSuperDeferralExtendedDeferralTimeValue()
	{
		return SuperDeferralExtendedDeferralTimeValue;
	}
	public void setSuperDeferralExtendedDeferralTimeValue(short value)
	{
		SuperDeferralExtendedDeferralTimeValue = value;
	}
	public TI_PERIOD_Enum getSuperDeferralExtendedDeferralTimeUnit()
	{
		return SuperDeferralExtendedDeferralTimeUnit;
	}
	public void setSuperDeferralExtendedDeferralTimeUnit(TI_PERIOD_Enum value)
	{
		SuperDeferralExtendedDeferralTimeUnit = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SuperDeferralExtendedDeferralTimeValue = (short)byteBuffer.readInt();
		SuperDeferralExtendedDeferralTimeUnit = SuperDeferralExtendedDeferralTimeUnit.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SuperDeferralExtendedDeferralTimeValue & 0xFFFFL));
		byteBuffer.writeInt(SuperDeferralExtendedDeferralTimeUnit.getValue());

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
		stringBuilder.append("TI_SUPER_DEFERRAL_EXTENDED_DEFERRAL_TIME::");
		stringBuilder.append("SuperDeferralExtendedDeferralTimeValue(").append(SuperDeferralExtendedDeferralTimeValue).append(")");
		stringBuilder.append("SuperDeferralExtendedDeferralTimeUnit(").append(SuperDeferralExtendedDeferralTimeUnit).append(")");
		return stringBuilder.toString();
	}
}

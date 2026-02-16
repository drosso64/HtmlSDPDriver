package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_AREA_CODE extends SMPMessage
{
	public static final long CLASS_ID = 100229;

	private short AreaCodeId = 0;
	private String AreaCodeShortDesc = "";
	private String AreaCodeDesc = "";
	private TI_FLAG_Enum MarkUpVisibleFg = TI_FLAG_Enum.TI_FLAG_No;
	private String CurrencyCode = "";
	private TI_FLAG_Enum MandatoryExecInvestIdFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_AREA_CODE()
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
	public String getAreaCodeShortDesc()
	{
		return AreaCodeShortDesc;
	}
	public void setAreaCodeShortDesc(String value)
	{
		AreaCodeShortDesc = value;
	}
	public String getAreaCodeDesc()
	{
		return AreaCodeDesc;
	}
	public void setAreaCodeDesc(String value)
	{
		AreaCodeDesc = value;
	}
	public TI_FLAG_Enum getMarkUpVisibleFg()
	{
		return MarkUpVisibleFg;
	}
	public void setMarkUpVisibleFg(TI_FLAG_Enum value)
	{
		MarkUpVisibleFg = value;
	}
	public String getCurrencyCode()
	{
		return CurrencyCode;
	}
	public void setCurrencyCode(String value)
	{
		CurrencyCode = value;
	}
	public TI_FLAG_Enum getMandatoryExecInvestIdFg()
	{
		return MandatoryExecInvestIdFg;
	}
	public void setMandatoryExecInvestIdFg(TI_FLAG_Enum value)
	{
		MandatoryExecInvestIdFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		AreaCodeId = (short)byteBuffer.readInt();
		AreaCodeShortDesc = byteBuffer.readString();
		AreaCodeDesc = byteBuffer.readString();
		MarkUpVisibleFg = MarkUpVisibleFg.getEnum(byteBuffer.readInt());
		CurrencyCode = byteBuffer.readString();
		MandatoryExecInvestIdFg = MandatoryExecInvestIdFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeString(AreaCodeShortDesc);
		byteBuffer.writeString(AreaCodeDesc);
		byteBuffer.writeInt(MarkUpVisibleFg.getValue());
		byteBuffer.writeString(CurrencyCode);
		byteBuffer.writeInt(MandatoryExecInvestIdFg.getValue());

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
		stringBuilder.append("BV_AREA_CODE::");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("AreaCodeShortDesc(").append(AreaCodeShortDesc).append(")");
		stringBuilder.append("AreaCodeDesc(").append(AreaCodeDesc).append(")");
		stringBuilder.append("MarkUpVisibleFg(").append(MarkUpVisibleFg).append(")");
		stringBuilder.append("CurrencyCode(").append(CurrencyCode).append(")");
		stringBuilder.append("MandatoryExecInvestIdFg(").append(MandatoryExecInvestIdFg).append(")");
		return stringBuilder.toString();
	}
}

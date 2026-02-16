package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FINANCIAL_CALCULATION_LABEL extends SMPMessage
{
	public static final long CLASS_ID = 100072;

	private String LabelCode = "";
	private TI_LANGUAGE_ISO_CODE_Enum LabelISOCode = TI_LANGUAGE_ISO_CODE_Enum.TI_LANGUAGE_ISO_CODE_Italian;
	private String LabelText = "";

	public TI_FINANCIAL_CALCULATION_LABEL()
	{
	}

	public String getLabelCode()
	{
		return LabelCode;
	}
	public void setLabelCode(String value)
	{
		LabelCode = value;
	}
	public TI_LANGUAGE_ISO_CODE_Enum getLabelISOCode()
	{
		return LabelISOCode;
	}
	public void setLabelISOCode(TI_LANGUAGE_ISO_CODE_Enum value)
	{
		LabelISOCode = value;
	}
	public String getLabelText()
	{
		return LabelText;
	}
	public void setLabelText(String value)
	{
		LabelText = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		LabelCode = byteBuffer.readString();
		LabelISOCode = LabelISOCode.getEnum(byteBuffer.readInt());
		LabelText = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(LabelCode);
		byteBuffer.writeInt(LabelISOCode.getValue());
		byteBuffer.writeString(LabelText);

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
		stringBuilder.append("TI_FINANCIAL_CALCULATION_LABEL::");
		stringBuilder.append("LabelCode(").append(LabelCode).append(")");
		stringBuilder.append("LabelISOCode(").append(LabelISOCode).append(")");
		stringBuilder.append("LabelText(").append(LabelText).append(")");
		return stringBuilder.toString();
	}
}

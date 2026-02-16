package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FINANCIAL_CALCULATION_FIELD extends SMPMessage
{
	public static final long CLASS_ID = 100071;

	private long FunctionId = 0;
	private long FieldId = 0;
	private String LabelCode = "";
	private String FieldlDescription = "";
	private long Position = 0;
	private TI_CALCULATION_FIELD_DIRECTION_Enum Direction = TI_CALCULATION_FIELD_DIRECTION_Enum.TI_CALCULATION_FIELD_DIRECTION_In;
	private TI_CALCULATION_FIELD_DOMAIN_Enum DataDomain = TI_CALCULATION_FIELD_DOMAIN_Enum.TI_CALCULATION_FIELD_DOMAIN_Long;
	private TI_CALCULATION_FIELD_BUSINESS_TYPE_Enum BusinessType = TI_CALCULATION_FIELD_BUSINESS_TYPE_Enum.TI_CALCULATION_FIELD_BUSINESS_TYPE_FinInstr;
	private TI_FLAG_Enum MandatoryFg = TI_FLAG_Enum.TI_FLAG_No;

	public TI_FINANCIAL_CALCULATION_FIELD()
	{
	}

	public long getFunctionId()
	{
		return FunctionId;
	}
	public void setFunctionId(long value)
	{
		FunctionId = value;
	}
	public long getFieldId()
	{
		return FieldId;
	}
	public void setFieldId(long value)
	{
		FieldId = value;
	}
	public String getLabelCode()
	{
		return LabelCode;
	}
	public void setLabelCode(String value)
	{
		LabelCode = value;
	}
	public String getFieldlDescription()
	{
		return FieldlDescription;
	}
	public void setFieldlDescription(String value)
	{
		FieldlDescription = value;
	}
	public long getPosition()
	{
		return Position;
	}
	public void setPosition(long value)
	{
		Position = value;
	}
	public TI_CALCULATION_FIELD_DIRECTION_Enum getDirection()
	{
		return Direction;
	}
	public void setDirection(TI_CALCULATION_FIELD_DIRECTION_Enum value)
	{
		Direction = value;
	}
	public TI_CALCULATION_FIELD_DOMAIN_Enum getDataDomain()
	{
		return DataDomain;
	}
	public void setDataDomain(TI_CALCULATION_FIELD_DOMAIN_Enum value)
	{
		DataDomain = value;
	}
	public TI_CALCULATION_FIELD_BUSINESS_TYPE_Enum getBusinessType()
	{
		return BusinessType;
	}
	public void setBusinessType(TI_CALCULATION_FIELD_BUSINESS_TYPE_Enum value)
	{
		BusinessType = value;
	}
	public TI_FLAG_Enum getMandatoryFg()
	{
		return MandatoryFg;
	}
	public void setMandatoryFg(TI_FLAG_Enum value)
	{
		MandatoryFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FunctionId = (long)byteBuffer.readInt();
		FieldId = (long)byteBuffer.readInt();
		LabelCode = byteBuffer.readString();
		FieldlDescription = byteBuffer.readString();
		Position = (long)byteBuffer.readInt();
		Direction = Direction.getEnum(byteBuffer.readInt());
		DataDomain = DataDomain.getEnum(byteBuffer.readInt());
		BusinessType = BusinessType.getEnum(byteBuffer.readInt());
		MandatoryFg = MandatoryFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FunctionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FieldId & 0xFFFFFFFFL));
		byteBuffer.writeString(LabelCode);
		byteBuffer.writeString(FieldlDescription);
		byteBuffer.writeInt((int)(Position & 0xFFFFFFFFL));
		byteBuffer.writeInt(Direction.getValue());
		byteBuffer.writeInt(DataDomain.getValue());
		byteBuffer.writeInt(BusinessType.getValue());
		byteBuffer.writeInt(MandatoryFg.getValue());

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
		stringBuilder.append("TI_FINANCIAL_CALCULATION_FIELD::");
		stringBuilder.append("FunctionId(").append(FunctionId).append(")");
		stringBuilder.append("FieldId(").append(FieldId).append(")");
		stringBuilder.append("LabelCode(").append(LabelCode).append(")");
		stringBuilder.append("FieldlDescription(").append(FieldlDescription).append(")");
		stringBuilder.append("Position(").append(Position).append(")");
		stringBuilder.append("Direction(").append(Direction).append(")");
		stringBuilder.append("DataDomain(").append(DataDomain).append(")");
		stringBuilder.append("BusinessType(").append(BusinessType).append(")");
		stringBuilder.append("MandatoryFg(").append(MandatoryFg).append(")");
		return stringBuilder.toString();
	}
}

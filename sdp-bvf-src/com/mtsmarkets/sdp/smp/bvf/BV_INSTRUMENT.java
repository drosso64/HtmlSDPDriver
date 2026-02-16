package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INSTRUMENT extends SMPMessage
{
	public static final long CLASS_ID = 400008;

	private long FinancialInstrumentId = 0;
	private long BenchmarkIndexId = 0;
	private double QuotedMargin = 0;
	private BV_DISCOUNT_MARGIN_FORMULA_TYPE_Enum DiscountMarginFormulaType = BV_DISCOUNT_MARGIN_FORMULA_TYPE_Enum.BV_DISCOUNT_MARGIN_FORMULA_TYPE_None;
	private TI_FLAG_Enum CallProvisionFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum MWCProvisionFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum PerpetualFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum UnseasonedBondFg = TI_FLAG_Enum.TI_FLAG_No;
	private String MiFIRIdentifier = "";
	private long MiFIRBondTypeId = 0;
	private long BondSeniorityId = 0;

	public BV_INSTRUMENT()
	{
	}

	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public long getBenchmarkIndexId()
	{
		return BenchmarkIndexId;
	}
	public void setBenchmarkIndexId(long value)
	{
		BenchmarkIndexId = value;
	}
	public double getQuotedMargin()
	{
		return QuotedMargin;
	}
	public void setQuotedMargin(double value)
	{
		QuotedMargin = value;
	}
	public BV_DISCOUNT_MARGIN_FORMULA_TYPE_Enum getDiscountMarginFormulaType()
	{
		return DiscountMarginFormulaType;
	}
	public void setDiscountMarginFormulaType(BV_DISCOUNT_MARGIN_FORMULA_TYPE_Enum value)
	{
		DiscountMarginFormulaType = value;
	}
	public TI_FLAG_Enum getCallProvisionFg()
	{
		return CallProvisionFg;
	}
	public void setCallProvisionFg(TI_FLAG_Enum value)
	{
		CallProvisionFg = value;
	}
	public TI_FLAG_Enum getMWCProvisionFg()
	{
		return MWCProvisionFg;
	}
	public void setMWCProvisionFg(TI_FLAG_Enum value)
	{
		MWCProvisionFg = value;
	}
	public TI_FLAG_Enum getPerpetualFg()
	{
		return PerpetualFg;
	}
	public void setPerpetualFg(TI_FLAG_Enum value)
	{
		PerpetualFg = value;
	}
	public TI_FLAG_Enum getUnseasonedBondFg()
	{
		return UnseasonedBondFg;
	}
	public void setUnseasonedBondFg(TI_FLAG_Enum value)
	{
		UnseasonedBondFg = value;
	}
	public String getMiFIRIdentifier()
	{
		return MiFIRIdentifier;
	}
	public void setMiFIRIdentifier(String value)
	{
		MiFIRIdentifier = value;
	}
	public long getMiFIRBondTypeId()
	{
		return MiFIRBondTypeId;
	}
	public void setMiFIRBondTypeId(long value)
	{
		MiFIRBondTypeId = value;
	}
	public long getBondSeniorityId()
	{
		return BondSeniorityId;
	}
	public void setBondSeniorityId(long value)
	{
		BondSeniorityId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		BenchmarkIndexId = (long)byteBuffer.readInt();
		QuotedMargin = byteBuffer.readDouble();
		DiscountMarginFormulaType = DiscountMarginFormulaType.getEnum(byteBuffer.readInt());
		CallProvisionFg = CallProvisionFg.getEnum(byteBuffer.readInt());
		MWCProvisionFg = MWCProvisionFg.getEnum(byteBuffer.readInt());
		PerpetualFg = PerpetualFg.getEnum(byteBuffer.readInt());
		UnseasonedBondFg = UnseasonedBondFg.getEnum(byteBuffer.readInt());
		MiFIRIdentifier = byteBuffer.readString();
		MiFIRBondTypeId = (long)byteBuffer.readInt();
		BondSeniorityId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BenchmarkIndexId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(QuotedMargin);
		byteBuffer.writeInt(DiscountMarginFormulaType.getValue());
		byteBuffer.writeInt(CallProvisionFg.getValue());
		byteBuffer.writeInt(MWCProvisionFg.getValue());
		byteBuffer.writeInt(PerpetualFg.getValue());
		byteBuffer.writeInt(UnseasonedBondFg.getValue());
		byteBuffer.writeString(MiFIRIdentifier);
		byteBuffer.writeInt((int)(MiFIRBondTypeId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BondSeniorityId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_INSTRUMENT::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("BenchmarkIndexId(").append(BenchmarkIndexId).append(")");
		stringBuilder.append("QuotedMargin(").append(QuotedMargin).append(")");
		stringBuilder.append("DiscountMarginFormulaType(").append(DiscountMarginFormulaType).append(")");
		stringBuilder.append("CallProvisionFg(").append(CallProvisionFg).append(")");
		stringBuilder.append("MWCProvisionFg(").append(MWCProvisionFg).append(")");
		stringBuilder.append("PerpetualFg(").append(PerpetualFg).append(")");
		stringBuilder.append("UnseasonedBondFg(").append(UnseasonedBondFg).append(")");
		stringBuilder.append("MiFIRIdentifier(").append(MiFIRIdentifier).append(")");
		stringBuilder.append("MiFIRBondTypeId(").append(MiFIRBondTypeId).append(")");
		stringBuilder.append("BondSeniorityId(").append(BondSeniorityId).append(")");
		return stringBuilder.toString();
	}
}

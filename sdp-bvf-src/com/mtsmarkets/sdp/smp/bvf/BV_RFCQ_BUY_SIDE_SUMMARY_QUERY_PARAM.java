package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_BUY_SIDE_SUMMARY_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 114197;

	private TI_QUERY_OP_Enum SectionOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String Section = "";
	private TI_QUERY_OP_Enum InstrumentClassOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentClass = "";
	private TI_QUERY_OP_Enum InstrumentOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String Instrument = "";
	private TI_QUERY_OP_Enum RFCQTypeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_RFCQ_TYPE_Enum RFCQType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private TI_QUERY_OP_Enum YourSellSideOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String YourSellSide = "";
	private TI_QUERY_OP_Enum YourSellSideShortDescOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String YourSellSideShortDesc = "";
	private TI_QUERY_OP_Enum TimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TimeFrom = 0;
	private TI_QUERY_OP_Enum TimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TimeTo = 0;
	private TI_QUERY_OP_Enum TransactionIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TransactionId = 0;
	private TI_QUERY_OP_Enum BuySideTraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String BuySideTraderName = "";
	private TI_QUERY_OP_Enum SellSideTraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String SellSideTraderName = "";
	private TI_QUERY_OP_Enum AccountCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String AccountCode = "";
	private TI_QUERY_OP_Enum ClientOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ClientOrderId = "";
	private TI_QUERY_OP_Enum StageOrderNrOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long StageOrderNr = 0;
	private TI_QUERY_OP_Enum DealIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DealId = 0;
	private TI_QUERY_OP_Enum DateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateFrom = 0;
	private TI_QUERY_OP_Enum DateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateTo = 0;
	private TI_QUERY_OP_Enum LegIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private short LegId = 0;
	private TI_QUERY_OP_Enum PreAgreedFgOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_RFCQ_BUY_SIDE_SUMMARY_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getSectionOp()
	{
		return SectionOp;
	}
	public void setSectionOp(TI_QUERY_OP_Enum value)
	{
		SectionOp = value;
	}
	public String getSection()
	{
		return Section;
	}
	public void setSection(String value)
	{
		Section = value;
	}
	public TI_QUERY_OP_Enum getInstrumentClassOp()
	{
		return InstrumentClassOp;
	}
	public void setInstrumentClassOp(TI_QUERY_OP_Enum value)
	{
		InstrumentClassOp = value;
	}
	public String getInstrumentClass()
	{
		return InstrumentClass;
	}
	public void setInstrumentClass(String value)
	{
		InstrumentClass = value;
	}
	public TI_QUERY_OP_Enum getInstrumentOp()
	{
		return InstrumentOp;
	}
	public void setInstrumentOp(TI_QUERY_OP_Enum value)
	{
		InstrumentOp = value;
	}
	public String getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(String value)
	{
		Instrument = value;
	}
	public TI_QUERY_OP_Enum getRFCQTypeOp()
	{
		return RFCQTypeOp;
	}
	public void setRFCQTypeOp(TI_QUERY_OP_Enum value)
	{
		RFCQTypeOp = value;
	}
	public TI_RFCQ_TYPE_Enum getRFCQType()
	{
		return RFCQType;
	}
	public void setRFCQType(TI_RFCQ_TYPE_Enum value)
	{
		RFCQType = value;
	}
	public TI_QUERY_OP_Enum getYourSellSideOp()
	{
		return YourSellSideOp;
	}
	public void setYourSellSideOp(TI_QUERY_OP_Enum value)
	{
		YourSellSideOp = value;
	}
	public String getYourSellSide()
	{
		return YourSellSide;
	}
	public void setYourSellSide(String value)
	{
		YourSellSide = value;
	}
	public TI_QUERY_OP_Enum getYourSellSideShortDescOp()
	{
		return YourSellSideShortDescOp;
	}
	public void setYourSellSideShortDescOp(TI_QUERY_OP_Enum value)
	{
		YourSellSideShortDescOp = value;
	}
	public String getYourSellSideShortDesc()
	{
		return YourSellSideShortDesc;
	}
	public void setYourSellSideShortDesc(String value)
	{
		YourSellSideShortDesc = value;
	}
	public TI_QUERY_OP_Enum getTimeFromOp()
	{
		return TimeFromOp;
	}
	public void setTimeFromOp(TI_QUERY_OP_Enum value)
	{
		TimeFromOp = value;
	}
	public long getTimeFrom()
	{
		return TimeFrom;
	}
	public void setTimeFrom(long value)
	{
		TimeFrom = value;
	}
	public TI_QUERY_OP_Enum getTimeToOp()
	{
		return TimeToOp;
	}
	public void setTimeToOp(TI_QUERY_OP_Enum value)
	{
		TimeToOp = value;
	}
	public long getTimeTo()
	{
		return TimeTo;
	}
	public void setTimeTo(long value)
	{
		TimeTo = value;
	}
	public TI_QUERY_OP_Enum getTransactionIdOp()
	{
		return TransactionIdOp;
	}
	public void setTransactionIdOp(TI_QUERY_OP_Enum value)
	{
		TransactionIdOp = value;
	}
	public long getTransactionId()
	{
		return TransactionId;
	}
	public void setTransactionId(long value)
	{
		TransactionId = value;
	}
	public TI_QUERY_OP_Enum getBuySideTraderNameOp()
	{
		return BuySideTraderNameOp;
	}
	public void setBuySideTraderNameOp(TI_QUERY_OP_Enum value)
	{
		BuySideTraderNameOp = value;
	}
	public String getBuySideTraderName()
	{
		return BuySideTraderName;
	}
	public void setBuySideTraderName(String value)
	{
		BuySideTraderName = value;
	}
	public TI_QUERY_OP_Enum getSellSideTraderNameOp()
	{
		return SellSideTraderNameOp;
	}
	public void setSellSideTraderNameOp(TI_QUERY_OP_Enum value)
	{
		SellSideTraderNameOp = value;
	}
	public String getSellSideTraderName()
	{
		return SellSideTraderName;
	}
	public void setSellSideTraderName(String value)
	{
		SellSideTraderName = value;
	}
	public TI_QUERY_OP_Enum getAccountCodeOp()
	{
		return AccountCodeOp;
	}
	public void setAccountCodeOp(TI_QUERY_OP_Enum value)
	{
		AccountCodeOp = value;
	}
	public String getAccountCode()
	{
		return AccountCode;
	}
	public void setAccountCode(String value)
	{
		AccountCode = value;
	}
	public TI_QUERY_OP_Enum getClientOrderIdOp()
	{
		return ClientOrderIdOp;
	}
	public void setClientOrderIdOp(TI_QUERY_OP_Enum value)
	{
		ClientOrderIdOp = value;
	}
	public String getClientOrderId()
	{
		return ClientOrderId;
	}
	public void setClientOrderId(String value)
	{
		ClientOrderId = value;
	}
	public TI_QUERY_OP_Enum getStageOrderNrOp()
	{
		return StageOrderNrOp;
	}
	public void setStageOrderNrOp(TI_QUERY_OP_Enum value)
	{
		StageOrderNrOp = value;
	}
	public long getStageOrderNr()
	{
		return StageOrderNr;
	}
	public void setStageOrderNr(long value)
	{
		StageOrderNr = value;
	}
	public TI_QUERY_OP_Enum getDealIdOp()
	{
		return DealIdOp;
	}
	public void setDealIdOp(TI_QUERY_OP_Enum value)
	{
		DealIdOp = value;
	}
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
	}
	public TI_QUERY_OP_Enum getDateFromOp()
	{
		return DateFromOp;
	}
	public void setDateFromOp(TI_QUERY_OP_Enum value)
	{
		DateFromOp = value;
	}
	public long getDateFrom()
	{
		return DateFrom;
	}
	public void setDateFrom(long value)
	{
		DateFrom = value;
	}
	public TI_QUERY_OP_Enum getDateToOp()
	{
		return DateToOp;
	}
	public void setDateToOp(TI_QUERY_OP_Enum value)
	{
		DateToOp = value;
	}
	public long getDateTo()
	{
		return DateTo;
	}
	public void setDateTo(long value)
	{
		DateTo = value;
	}
	public TI_QUERY_OP_Enum getLegIdOp()
	{
		return LegIdOp;
	}
	public void setLegIdOp(TI_QUERY_OP_Enum value)
	{
		LegIdOp = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public TI_QUERY_OP_Enum getPreAgreedFgOp()
	{
		return PreAgreedFgOp;
	}
	public void setPreAgreedFgOp(TI_QUERY_OP_Enum value)
	{
		PreAgreedFgOp = value;
	}
	public TI_FLAG_Enum getPreAgreedFg()
	{
		return PreAgreedFg;
	}
	public void setPreAgreedFg(TI_FLAG_Enum value)
	{
		PreAgreedFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionOp = SectionOp.getEnum(byteBuffer.readInt());
		Section = byteBuffer.readString();
		InstrumentClassOp = InstrumentClassOp.getEnum(byteBuffer.readInt());
		InstrumentClass = byteBuffer.readString();
		InstrumentOp = InstrumentOp.getEnum(byteBuffer.readInt());
		Instrument = byteBuffer.readString();
		RFCQTypeOp = RFCQTypeOp.getEnum(byteBuffer.readInt());
		RFCQType = RFCQType.getEnum(byteBuffer.readInt());
		YourSellSideOp = YourSellSideOp.getEnum(byteBuffer.readInt());
		YourSellSide = byteBuffer.readString();
		YourSellSideShortDescOp = YourSellSideShortDescOp.getEnum(byteBuffer.readInt());
		YourSellSideShortDesc = byteBuffer.readString();
		TimeFromOp = TimeFromOp.getEnum(byteBuffer.readInt());
		TimeFrom = byteBuffer.readLong();
		TimeToOp = TimeToOp.getEnum(byteBuffer.readInt());
		TimeTo = byteBuffer.readLong();
		TransactionIdOp = TransactionIdOp.getEnum(byteBuffer.readInt());
		TransactionId = (long)byteBuffer.readInt();
		BuySideTraderNameOp = BuySideTraderNameOp.getEnum(byteBuffer.readInt());
		BuySideTraderName = byteBuffer.readString();
		SellSideTraderNameOp = SellSideTraderNameOp.getEnum(byteBuffer.readInt());
		SellSideTraderName = byteBuffer.readString();
		AccountCodeOp = AccountCodeOp.getEnum(byteBuffer.readInt());
		AccountCode = byteBuffer.readString();
		ClientOrderIdOp = ClientOrderIdOp.getEnum(byteBuffer.readInt());
		ClientOrderId = byteBuffer.readString();
		StageOrderNrOp = StageOrderNrOp.getEnum(byteBuffer.readInt());
		StageOrderNr = (long)byteBuffer.readInt();
		DealIdOp = DealIdOp.getEnum(byteBuffer.readInt());
		DealId = (long)byteBuffer.readInt();
		DateFromOp = DateFromOp.getEnum(byteBuffer.readInt());
		DateFrom = (long)byteBuffer.readInt();
		DateToOp = DateToOp.getEnum(byteBuffer.readInt());
		DateTo = (long)byteBuffer.readInt();
		LegIdOp = LegIdOp.getEnum(byteBuffer.readInt());
		LegId = (short)byteBuffer.readInt();
		PreAgreedFgOp = PreAgreedFgOp.getEnum(byteBuffer.readInt());
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(SectionOp.getValue());
		byteBuffer.writeString(Section);
		byteBuffer.writeInt(InstrumentClassOp.getValue());
		byteBuffer.writeString(InstrumentClass);
		byteBuffer.writeInt(InstrumentOp.getValue());
		byteBuffer.writeString(Instrument);
		byteBuffer.writeInt(RFCQTypeOp.getValue());
		byteBuffer.writeInt(RFCQType.getValue());
		byteBuffer.writeInt(YourSellSideOp.getValue());
		byteBuffer.writeString(YourSellSide);
		byteBuffer.writeInt(YourSellSideShortDescOp.getValue());
		byteBuffer.writeString(YourSellSideShortDesc);
		byteBuffer.writeInt(TimeFromOp.getValue());
		byteBuffer.writeLong(TimeFrom);
		byteBuffer.writeInt(TimeToOp.getValue());
		byteBuffer.writeLong(TimeTo);
		byteBuffer.writeInt(TransactionIdOp.getValue());
		byteBuffer.writeInt((int)(TransactionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(BuySideTraderNameOp.getValue());
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeInt(SellSideTraderNameOp.getValue());
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt(AccountCodeOp.getValue());
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeInt(ClientOrderIdOp.getValue());
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt(StageOrderNrOp.getValue());
		byteBuffer.writeInt((int)(StageOrderNr & 0xFFFFFFFFL));
		byteBuffer.writeInt(DealIdOp.getValue());
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeInt(DateFromOp.getValue());
		byteBuffer.writeInt((int)(DateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(DateToOp.getValue());
		byteBuffer.writeInt((int)(DateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(LegIdOp.getValue());
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(PreAgreedFgOp.getValue());
		byteBuffer.writeInt(PreAgreedFg.getValue());

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
		stringBuilder.append("BV_RFCQ_BUY_SIDE_SUMMARY_QUERY_PARAM::");
		stringBuilder.append("SectionOp(").append(SectionOp).append(")");
		stringBuilder.append("Section(").append(Section).append(")");
		stringBuilder.append("InstrumentClassOp(").append(InstrumentClassOp).append(")");
		stringBuilder.append("InstrumentClass(").append(InstrumentClass).append(")");
		stringBuilder.append("InstrumentOp(").append(InstrumentOp).append(")");
		stringBuilder.append("Instrument(").append(Instrument).append(")");
		stringBuilder.append("RFCQTypeOp(").append(RFCQTypeOp).append(")");
		stringBuilder.append("RFCQType(").append(RFCQType).append(")");
		stringBuilder.append("YourSellSideOp(").append(YourSellSideOp).append(")");
		stringBuilder.append("YourSellSide(").append(YourSellSide).append(")");
		stringBuilder.append("YourSellSideShortDescOp(").append(YourSellSideShortDescOp).append(")");
		stringBuilder.append("YourSellSideShortDesc(").append(YourSellSideShortDesc).append(")");
		stringBuilder.append("TimeFromOp(").append(TimeFromOp).append(")");
		stringBuilder.append("TimeFrom(").append(TimeFrom).append(")");
		stringBuilder.append("TimeToOp(").append(TimeToOp).append(")");
		stringBuilder.append("TimeTo(").append(TimeTo).append(")");
		stringBuilder.append("TransactionIdOp(").append(TransactionIdOp).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("BuySideTraderNameOp(").append(BuySideTraderNameOp).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("SellSideTraderNameOp(").append(SellSideTraderNameOp).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("AccountCodeOp(").append(AccountCodeOp).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("ClientOrderIdOp(").append(ClientOrderIdOp).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("StageOrderNrOp(").append(StageOrderNrOp).append(")");
		stringBuilder.append("StageOrderNr(").append(StageOrderNr).append(")");
		stringBuilder.append("DealIdOp(").append(DealIdOp).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("DateFromOp(").append(DateFromOp).append(")");
		stringBuilder.append("DateFrom(").append(DateFrom).append(")");
		stringBuilder.append("DateToOp(").append(DateToOp).append(")");
		stringBuilder.append("DateTo(").append(DateTo).append(")");
		stringBuilder.append("LegIdOp(").append(LegIdOp).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("PreAgreedFgOp(").append(PreAgreedFgOp).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		return stringBuilder.toString();
	}
}

package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214225;

	private TI_QUERY_OP_Enum InstrumentClassOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentClass = "";
	private TI_QUERY_OP_Enum InstrumentOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String Instrument = "";
	private TI_QUERY_OP_Enum TransactionIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TransactionId = 0;
	private TI_QUERY_OP_Enum LegIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private short LegId = 0;
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

	public BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_QUERY_PARAM()
	{
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentClassOp = InstrumentClassOp.getEnum(byteBuffer.readInt());
		InstrumentClass = byteBuffer.readString();
		InstrumentOp = InstrumentOp.getEnum(byteBuffer.readInt());
		Instrument = byteBuffer.readString();
		TransactionIdOp = TransactionIdOp.getEnum(byteBuffer.readInt());
		TransactionId = (long)byteBuffer.readInt();
		LegIdOp = LegIdOp.getEnum(byteBuffer.readInt());
		LegId = (short)byteBuffer.readInt();
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
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(InstrumentClassOp.getValue());
		byteBuffer.writeString(InstrumentClass);
		byteBuffer.writeInt(InstrumentOp.getValue());
		byteBuffer.writeString(Instrument);
		byteBuffer.writeInt(TransactionIdOp.getValue());
		byteBuffer.writeInt((int)(TransactionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(LegIdOp.getValue());
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_QUERY_PARAM::");
		stringBuilder.append("InstrumentClassOp(").append(InstrumentClassOp).append(")");
		stringBuilder.append("InstrumentClass(").append(InstrumentClass).append(")");
		stringBuilder.append("InstrumentOp(").append(InstrumentOp).append(")");
		stringBuilder.append("Instrument(").append(Instrument).append(")");
		stringBuilder.append("TransactionIdOp(").append(TransactionIdOp).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("LegIdOp(").append(LegIdOp).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
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
		return stringBuilder.toString();
	}
}

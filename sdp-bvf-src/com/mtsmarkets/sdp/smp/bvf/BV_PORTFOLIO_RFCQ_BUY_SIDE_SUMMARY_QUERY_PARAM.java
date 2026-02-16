package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214224;

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
	private TI_QUERY_OP_Enum DateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateFrom = 0;
	private TI_QUERY_OP_Enum DateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateTo = 0;
	private TI_QUERY_OP_Enum PreAgreedFgOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_QUERY_OP_Enum ClientRfcqIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ClientRfcqId = "";

	public BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_QUERY_PARAM()
	{
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
	public TI_QUERY_OP_Enum getClientRfcqIdOp()
	{
		return ClientRfcqIdOp;
	}
	public void setClientRfcqIdOp(TI_QUERY_OP_Enum value)
	{
		ClientRfcqIdOp = value;
	}
	public String getClientRfcqId()
	{
		return ClientRfcqId;
	}
	public void setClientRfcqId(String value)
	{
		ClientRfcqId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
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
		DateFromOp = DateFromOp.getEnum(byteBuffer.readInt());
		DateFrom = (long)byteBuffer.readInt();
		DateToOp = DateToOp.getEnum(byteBuffer.readInt());
		DateTo = (long)byteBuffer.readInt();
		PreAgreedFgOp = PreAgreedFgOp.getEnum(byteBuffer.readInt());
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		ClientRfcqIdOp = ClientRfcqIdOp.getEnum(byteBuffer.readInt());
		ClientRfcqId = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

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
		byteBuffer.writeInt(DateFromOp.getValue());
		byteBuffer.writeInt((int)(DateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(DateToOp.getValue());
		byteBuffer.writeInt((int)(DateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(PreAgreedFgOp.getValue());
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeInt(ClientRfcqIdOp.getValue());
		byteBuffer.writeString(ClientRfcqId);

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_QUERY_PARAM::");
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
		stringBuilder.append("DateFromOp(").append(DateFromOp).append(")");
		stringBuilder.append("DateFrom(").append(DateFrom).append(")");
		stringBuilder.append("DateToOp(").append(DateToOp).append(")");
		stringBuilder.append("DateTo(").append(DateTo).append(")");
		stringBuilder.append("PreAgreedFgOp(").append(PreAgreedFgOp).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("ClientRfcqIdOp(").append(ClientRfcqIdOp).append(")");
		stringBuilder.append("ClientRfcqId(").append(ClientRfcqId).append(")");
		return stringBuilder.toString();
	}
}

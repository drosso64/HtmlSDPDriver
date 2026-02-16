package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_SELL_SIDE_SUMMARY_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214226;

	private TI_QUERY_OP_Enum YourBuySideOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String YourBuySide = "";
	private TI_QUERY_OP_Enum YourBuySideShortDescOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String YourBuySideShortDesc = "";
	private TI_QUERY_OP_Enum TimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TimeFrom = 0;
	private TI_QUERY_OP_Enum TimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TimeTo = 0;
	private TI_QUERY_OP_Enum TransactionIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TransactionId = 0;
	private TI_QUERY_OP_Enum SellSideTraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String SellSideTraderName = "";
	private TI_QUERY_OP_Enum BuySideTraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String BuySideTraderName = "";
	private TI_QUERY_OP_Enum DateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateFrom = 0;
	private TI_QUERY_OP_Enum DateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateTo = 0;

	public BV_PORTFOLIO_RFCQ_SELL_SIDE_SUMMARY_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getYourBuySideOp()
	{
		return YourBuySideOp;
	}
	public void setYourBuySideOp(TI_QUERY_OP_Enum value)
	{
		YourBuySideOp = value;
	}
	public String getYourBuySide()
	{
		return YourBuySide;
	}
	public void setYourBuySide(String value)
	{
		YourBuySide = value;
	}
	public TI_QUERY_OP_Enum getYourBuySideShortDescOp()
	{
		return YourBuySideShortDescOp;
	}
	public void setYourBuySideShortDescOp(TI_QUERY_OP_Enum value)
	{
		YourBuySideShortDescOp = value;
	}
	public String getYourBuySideShortDesc()
	{
		return YourBuySideShortDesc;
	}
	public void setYourBuySideShortDesc(String value)
	{
		YourBuySideShortDesc = value;
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
		YourBuySideOp = YourBuySideOp.getEnum(byteBuffer.readInt());
		YourBuySide = byteBuffer.readString();
		YourBuySideShortDescOp = YourBuySideShortDescOp.getEnum(byteBuffer.readInt());
		YourBuySideShortDesc = byteBuffer.readString();
		TimeFromOp = TimeFromOp.getEnum(byteBuffer.readInt());
		TimeFrom = byteBuffer.readLong();
		TimeToOp = TimeToOp.getEnum(byteBuffer.readInt());
		TimeTo = byteBuffer.readLong();
		TransactionIdOp = TransactionIdOp.getEnum(byteBuffer.readInt());
		TransactionId = (long)byteBuffer.readInt();
		SellSideTraderNameOp = SellSideTraderNameOp.getEnum(byteBuffer.readInt());
		SellSideTraderName = byteBuffer.readString();
		BuySideTraderNameOp = BuySideTraderNameOp.getEnum(byteBuffer.readInt());
		BuySideTraderName = byteBuffer.readString();
		DateFromOp = DateFromOp.getEnum(byteBuffer.readInt());
		DateFrom = (long)byteBuffer.readInt();
		DateToOp = DateToOp.getEnum(byteBuffer.readInt());
		DateTo = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(YourBuySideOp.getValue());
		byteBuffer.writeString(YourBuySide);
		byteBuffer.writeInt(YourBuySideShortDescOp.getValue());
		byteBuffer.writeString(YourBuySideShortDesc);
		byteBuffer.writeInt(TimeFromOp.getValue());
		byteBuffer.writeLong(TimeFrom);
		byteBuffer.writeInt(TimeToOp.getValue());
		byteBuffer.writeLong(TimeTo);
		byteBuffer.writeInt(TransactionIdOp.getValue());
		byteBuffer.writeInt((int)(TransactionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SellSideTraderNameOp.getValue());
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt(BuySideTraderNameOp.getValue());
		byteBuffer.writeString(BuySideTraderName);
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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_SELL_SIDE_SUMMARY_QUERY_PARAM::");
		stringBuilder.append("YourBuySideOp(").append(YourBuySideOp).append(")");
		stringBuilder.append("YourBuySide(").append(YourBuySide).append(")");
		stringBuilder.append("YourBuySideShortDescOp(").append(YourBuySideShortDescOp).append(")");
		stringBuilder.append("YourBuySideShortDesc(").append(YourBuySideShortDesc).append(")");
		stringBuilder.append("TimeFromOp(").append(TimeFromOp).append(")");
		stringBuilder.append("TimeFrom(").append(TimeFrom).append(")");
		stringBuilder.append("TimeToOp(").append(TimeToOp).append(")");
		stringBuilder.append("TimeTo(").append(TimeTo).append(")");
		stringBuilder.append("TransactionIdOp(").append(TransactionIdOp).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("SellSideTraderNameOp(").append(SellSideTraderNameOp).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("BuySideTraderNameOp(").append(BuySideTraderNameOp).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("DateFromOp(").append(DateFromOp).append(")");
		stringBuilder.append("DateFrom(").append(DateFrom).append(")");
		stringBuilder.append("DateToOp(").append(DateToOp).append(")");
		stringBuilder.append("DateTo(").append(DateTo).append(")");
		return stringBuilder.toString();
	}
}

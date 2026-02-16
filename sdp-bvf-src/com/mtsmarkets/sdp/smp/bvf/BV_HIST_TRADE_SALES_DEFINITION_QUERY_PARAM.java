package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_TRADE_SALES_DEFINITION_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214228;

	private TI_QUERY_OP_Enum TradeIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TradeId = 0;
	private TI_QUERY_OP_Enum TradeDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TradeDateFrom = 0;
	private TI_QUERY_OP_Enum TradeDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TradeDateTo = 0;
	private TI_QUERY_OP_Enum TradeTimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TradeTimeFrom = 0;
	private TI_QUERY_OP_Enum TradeTimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TradeTimeTo = 0;
	private TI_QUERY_OP_Enum MemberCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String MemberCode = "";
	private TI_QUERY_OP_Enum CtpyCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String CtpyCode = "";
	private TI_QUERY_OP_Enum SalesNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String SalesName = "";

	public BV_HIST_TRADE_SALES_DEFINITION_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getTradeIdOp()
	{
		return TradeIdOp;
	}
	public void setTradeIdOp(TI_QUERY_OP_Enum value)
	{
		TradeIdOp = value;
	}
	public long getTradeId()
	{
		return TradeId;
	}
	public void setTradeId(long value)
	{
		TradeId = value;
	}
	public TI_QUERY_OP_Enum getTradeDateFromOp()
	{
		return TradeDateFromOp;
	}
	public void setTradeDateFromOp(TI_QUERY_OP_Enum value)
	{
		TradeDateFromOp = value;
	}
	public long getTradeDateFrom()
	{
		return TradeDateFrom;
	}
	public void setTradeDateFrom(long value)
	{
		TradeDateFrom = value;
	}
	public TI_QUERY_OP_Enum getTradeDateToOp()
	{
		return TradeDateToOp;
	}
	public void setTradeDateToOp(TI_QUERY_OP_Enum value)
	{
		TradeDateToOp = value;
	}
	public long getTradeDateTo()
	{
		return TradeDateTo;
	}
	public void setTradeDateTo(long value)
	{
		TradeDateTo = value;
	}
	public TI_QUERY_OP_Enum getTradeTimeFromOp()
	{
		return TradeTimeFromOp;
	}
	public void setTradeTimeFromOp(TI_QUERY_OP_Enum value)
	{
		TradeTimeFromOp = value;
	}
	public long getTradeTimeFrom()
	{
		return TradeTimeFrom;
	}
	public void setTradeTimeFrom(long value)
	{
		TradeTimeFrom = value;
	}
	public TI_QUERY_OP_Enum getTradeTimeToOp()
	{
		return TradeTimeToOp;
	}
	public void setTradeTimeToOp(TI_QUERY_OP_Enum value)
	{
		TradeTimeToOp = value;
	}
	public long getTradeTimeTo()
	{
		return TradeTimeTo;
	}
	public void setTradeTimeTo(long value)
	{
		TradeTimeTo = value;
	}
	public TI_QUERY_OP_Enum getMemberCodeOp()
	{
		return MemberCodeOp;
	}
	public void setMemberCodeOp(TI_QUERY_OP_Enum value)
	{
		MemberCodeOp = value;
	}
	public String getMemberCode()
	{
		return MemberCode;
	}
	public void setMemberCode(String value)
	{
		MemberCode = value;
	}
	public TI_QUERY_OP_Enum getCtpyCodeOp()
	{
		return CtpyCodeOp;
	}
	public void setCtpyCodeOp(TI_QUERY_OP_Enum value)
	{
		CtpyCodeOp = value;
	}
	public String getCtpyCode()
	{
		return CtpyCode;
	}
	public void setCtpyCode(String value)
	{
		CtpyCode = value;
	}
	public TI_QUERY_OP_Enum getSalesNameOp()
	{
		return SalesNameOp;
	}
	public void setSalesNameOp(TI_QUERY_OP_Enum value)
	{
		SalesNameOp = value;
	}
	public String getSalesName()
	{
		return SalesName;
	}
	public void setSalesName(String value)
	{
		SalesName = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		TradeIdOp = TradeIdOp.getEnum(byteBuffer.readInt());
		TradeId = (long)byteBuffer.readInt();
		TradeDateFromOp = TradeDateFromOp.getEnum(byteBuffer.readInt());
		TradeDateFrom = (long)byteBuffer.readInt();
		TradeDateToOp = TradeDateToOp.getEnum(byteBuffer.readInt());
		TradeDateTo = (long)byteBuffer.readInt();
		TradeTimeFromOp = TradeTimeFromOp.getEnum(byteBuffer.readInt());
		TradeTimeFrom = byteBuffer.readLong();
		TradeTimeToOp = TradeTimeToOp.getEnum(byteBuffer.readInt());
		TradeTimeTo = byteBuffer.readLong();
		MemberCodeOp = MemberCodeOp.getEnum(byteBuffer.readInt());
		MemberCode = byteBuffer.readString();
		CtpyCodeOp = CtpyCodeOp.getEnum(byteBuffer.readInt());
		CtpyCode = byteBuffer.readString();
		SalesNameOp = SalesNameOp.getEnum(byteBuffer.readInt());
		SalesName = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(TradeIdOp.getValue());
		byteBuffer.writeInt((int)(TradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt(TradeDateFromOp.getValue());
		byteBuffer.writeInt((int)(TradeDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(TradeDateToOp.getValue());
		byteBuffer.writeInt((int)(TradeDateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(TradeTimeFromOp.getValue());
		byteBuffer.writeLong(TradeTimeFrom);
		byteBuffer.writeInt(TradeTimeToOp.getValue());
		byteBuffer.writeLong(TradeTimeTo);
		byteBuffer.writeInt(MemberCodeOp.getValue());
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeInt(CtpyCodeOp.getValue());
		byteBuffer.writeString(CtpyCode);
		byteBuffer.writeInt(SalesNameOp.getValue());
		byteBuffer.writeString(SalesName);

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
		stringBuilder.append("BV_HIST_TRADE_SALES_DEFINITION_QUERY_PARAM::");
		stringBuilder.append("TradeIdOp(").append(TradeIdOp).append(")");
		stringBuilder.append("TradeId(").append(TradeId).append(")");
		stringBuilder.append("TradeDateFromOp(").append(TradeDateFromOp).append(")");
		stringBuilder.append("TradeDateFrom(").append(TradeDateFrom).append(")");
		stringBuilder.append("TradeDateToOp(").append(TradeDateToOp).append(")");
		stringBuilder.append("TradeDateTo(").append(TradeDateTo).append(")");
		stringBuilder.append("TradeTimeFromOp(").append(TradeTimeFromOp).append(")");
		stringBuilder.append("TradeTimeFrom(").append(TradeTimeFrom).append(")");
		stringBuilder.append("TradeTimeToOp(").append(TradeTimeToOp).append(")");
		stringBuilder.append("TradeTimeTo(").append(TradeTimeTo).append(")");
		stringBuilder.append("MemberCodeOp(").append(MemberCodeOp).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("CtpyCodeOp(").append(CtpyCodeOp).append(")");
		stringBuilder.append("CtpyCode(").append(CtpyCode).append(")");
		stringBuilder.append("SalesNameOp(").append(SalesNameOp).append(")");
		stringBuilder.append("SalesName(").append(SalesName).append(")");
		return stringBuilder.toString();
	}
}

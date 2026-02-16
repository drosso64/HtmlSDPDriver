package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_ORDER_STAGING_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214205;

	private TI_QUERY_OP_Enum MsgIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgId = 0;
	private TI_QUERY_OP_Enum MsgDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateFrom = 0;
	private TI_QUERY_OP_Enum MsgDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateTo = 0;
	private TI_QUERY_OP_Enum MsgTimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeFrom = 0;
	private TI_QUERY_OP_Enum MsgTimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeTo = 0;
	private TI_QUERY_OP_Enum InstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentCode = "";
	private TI_QUERY_OP_Enum ClientOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ClientOrderId = "";
	private TI_QUERY_OP_Enum LinkIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String LinkId = "";
	private TI_QUERY_OP_Enum AccountCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String AccountCode = "";
	private TI_QUERY_OP_Enum TraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String TraderName = "";
	private TI_QUERY_OP_Enum ExecTraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ExecTraderName = "";
	private TI_QUERY_OP_Enum ExternalTraderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ExternalTraderId = "";

	public BV_HIST_ORDER_STAGING_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getMsgIdOp()
	{
		return MsgIdOp;
	}
	public void setMsgIdOp(TI_QUERY_OP_Enum value)
	{
		MsgIdOp = value;
	}
	public long getMsgId()
	{
		return MsgId;
	}
	public void setMsgId(long value)
	{
		MsgId = value;
	}
	public TI_QUERY_OP_Enum getMsgDateFromOp()
	{
		return MsgDateFromOp;
	}
	public void setMsgDateFromOp(TI_QUERY_OP_Enum value)
	{
		MsgDateFromOp = value;
	}
	public long getMsgDateFrom()
	{
		return MsgDateFrom;
	}
	public void setMsgDateFrom(long value)
	{
		MsgDateFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgDateToOp()
	{
		return MsgDateToOp;
	}
	public void setMsgDateToOp(TI_QUERY_OP_Enum value)
	{
		MsgDateToOp = value;
	}
	public long getMsgDateTo()
	{
		return MsgDateTo;
	}
	public void setMsgDateTo(long value)
	{
		MsgDateTo = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeFromOp()
	{
		return MsgTimeFromOp;
	}
	public void setMsgTimeFromOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeFromOp = value;
	}
	public long getMsgTimeFrom()
	{
		return MsgTimeFrom;
	}
	public void setMsgTimeFrom(long value)
	{
		MsgTimeFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeToOp()
	{
		return MsgTimeToOp;
	}
	public void setMsgTimeToOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeToOp = value;
	}
	public long getMsgTimeTo()
	{
		return MsgTimeTo;
	}
	public void setMsgTimeTo(long value)
	{
		MsgTimeTo = value;
	}
	public TI_QUERY_OP_Enum getInstrumentCodeOp()
	{
		return InstrumentCodeOp;
	}
	public void setInstrumentCodeOp(TI_QUERY_OP_Enum value)
	{
		InstrumentCodeOp = value;
	}
	public String getInstrumentCode()
	{
		return InstrumentCode;
	}
	public void setInstrumentCode(String value)
	{
		InstrumentCode = value;
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
	public TI_QUERY_OP_Enum getLinkIdOp()
	{
		return LinkIdOp;
	}
	public void setLinkIdOp(TI_QUERY_OP_Enum value)
	{
		LinkIdOp = value;
	}
	public String getLinkId()
	{
		return LinkId;
	}
	public void setLinkId(String value)
	{
		LinkId = value;
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
	public TI_QUERY_OP_Enum getTraderNameOp()
	{
		return TraderNameOp;
	}
	public void setTraderNameOp(TI_QUERY_OP_Enum value)
	{
		TraderNameOp = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public TI_QUERY_OP_Enum getExecTraderNameOp()
	{
		return ExecTraderNameOp;
	}
	public void setExecTraderNameOp(TI_QUERY_OP_Enum value)
	{
		ExecTraderNameOp = value;
	}
	public String getExecTraderName()
	{
		return ExecTraderName;
	}
	public void setExecTraderName(String value)
	{
		ExecTraderName = value;
	}
	public TI_QUERY_OP_Enum getExternalTraderIdOp()
	{
		return ExternalTraderIdOp;
	}
	public void setExternalTraderIdOp(TI_QUERY_OP_Enum value)
	{
		ExternalTraderIdOp = value;
	}
	public String getExternalTraderId()
	{
		return ExternalTraderId;
	}
	public void setExternalTraderId(String value)
	{
		ExternalTraderId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MsgIdOp = MsgIdOp.getEnum(byteBuffer.readInt());
		MsgId = (long)byteBuffer.readInt();
		MsgDateFromOp = MsgDateFromOp.getEnum(byteBuffer.readInt());
		MsgDateFrom = (long)byteBuffer.readInt();
		MsgDateToOp = MsgDateToOp.getEnum(byteBuffer.readInt());
		MsgDateTo = (long)byteBuffer.readInt();
		MsgTimeFromOp = MsgTimeFromOp.getEnum(byteBuffer.readInt());
		MsgTimeFrom = byteBuffer.readLong();
		MsgTimeToOp = MsgTimeToOp.getEnum(byteBuffer.readInt());
		MsgTimeTo = byteBuffer.readLong();
		InstrumentCodeOp = InstrumentCodeOp.getEnum(byteBuffer.readInt());
		InstrumentCode = byteBuffer.readString();
		ClientOrderIdOp = ClientOrderIdOp.getEnum(byteBuffer.readInt());
		ClientOrderId = byteBuffer.readString();
		LinkIdOp = LinkIdOp.getEnum(byteBuffer.readInt());
		LinkId = byteBuffer.readString();
		AccountCodeOp = AccountCodeOp.getEnum(byteBuffer.readInt());
		AccountCode = byteBuffer.readString();
		TraderNameOp = TraderNameOp.getEnum(byteBuffer.readInt());
		TraderName = byteBuffer.readString();
		ExecTraderNameOp = ExecTraderNameOp.getEnum(byteBuffer.readInt());
		ExecTraderName = byteBuffer.readString();
		ExternalTraderIdOp = ExternalTraderIdOp.getEnum(byteBuffer.readInt());
		ExternalTraderId = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(MsgIdOp.getValue());
		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateFromOp.getValue());
		byteBuffer.writeInt((int)(MsgDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateToOp.getValue());
		byteBuffer.writeInt((int)(MsgDateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgTimeFromOp.getValue());
		byteBuffer.writeLong(MsgTimeFrom);
		byteBuffer.writeInt(MsgTimeToOp.getValue());
		byteBuffer.writeLong(MsgTimeTo);
		byteBuffer.writeInt(InstrumentCodeOp.getValue());
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeInt(ClientOrderIdOp.getValue());
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt(LinkIdOp.getValue());
		byteBuffer.writeString(LinkId);
		byteBuffer.writeInt(AccountCodeOp.getValue());
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeInt(TraderNameOp.getValue());
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt(ExecTraderNameOp.getValue());
		byteBuffer.writeString(ExecTraderName);
		byteBuffer.writeInt(ExternalTraderIdOp.getValue());
		byteBuffer.writeString(ExternalTraderId);

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
		stringBuilder.append("BV_HIST_ORDER_STAGING_QUERY_PARAM::");
		stringBuilder.append("MsgIdOp(").append(MsgIdOp).append(")");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("MsgDateFromOp(").append(MsgDateFromOp).append(")");
		stringBuilder.append("MsgDateFrom(").append(MsgDateFrom).append(")");
		stringBuilder.append("MsgDateToOp(").append(MsgDateToOp).append(")");
		stringBuilder.append("MsgDateTo(").append(MsgDateTo).append(")");
		stringBuilder.append("MsgTimeFromOp(").append(MsgTimeFromOp).append(")");
		stringBuilder.append("MsgTimeFrom(").append(MsgTimeFrom).append(")");
		stringBuilder.append("MsgTimeToOp(").append(MsgTimeToOp).append(")");
		stringBuilder.append("MsgTimeTo(").append(MsgTimeTo).append(")");
		stringBuilder.append("InstrumentCodeOp(").append(InstrumentCodeOp).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("ClientOrderIdOp(").append(ClientOrderIdOp).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("LinkIdOp(").append(LinkIdOp).append(")");
		stringBuilder.append("LinkId(").append(LinkId).append(")");
		stringBuilder.append("AccountCodeOp(").append(AccountCodeOp).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("TraderNameOp(").append(TraderNameOp).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("ExecTraderNameOp(").append(ExecTraderNameOp).append(")");
		stringBuilder.append("ExecTraderName(").append(ExecTraderName).append(")");
		stringBuilder.append("ExternalTraderIdOp(").append(ExternalTraderIdOp).append(")");
		stringBuilder.append("ExternalTraderId(").append(ExternalTraderId).append(")");
		return stringBuilder.toString();
	}
}

package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_REGISTRATION_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214218;

	private TI_QUERY_OP_Enum MsgIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgId = 0;
	private TI_QUERY_OP_Enum DateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateFrom = 0;
	private TI_QUERY_OP_Enum DateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateTo = 0;
	private TI_QUERY_OP_Enum TimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TimeFrom = 0;
	private TI_QUERY_OP_Enum TimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TimeTo = 0;
	private TI_QUERY_OP_Enum ProviderOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long Provider = 0;
	private TI_QUERY_OP_Enum ProviderCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ProviderCode = "";
	private TI_QUERY_OP_Enum ProviderShortDescOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ProviderShortDesc = "";
	private TI_QUERY_OP_Enum ProviderDescOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ProviderDesc = "";
	private TI_QUERY_OP_Enum AggressorOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long Aggressor = 0;
	private TI_QUERY_OP_Enum AggressorCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String AggressorCode = "";
	private TI_QUERY_OP_Enum AggressorShortDescOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String AggressorShortDesc = "";
	private TI_QUERY_OP_Enum AggressorDescOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String AggressorDesc = "";
	private TI_QUERY_OP_Enum DealerOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String DealerOrderId = "";
	private TI_QUERY_OP_Enum LegIdFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private short LegIdFrom = 0;
	private TI_QUERY_OP_Enum LegIdToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private short LegIdTo = 0;
	private TI_QUERY_OP_Enum InstrumentIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long InstrumentId = 0;
	private TI_QUERY_OP_Enum InstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentCode = "";
	private TI_QUERY_OP_Enum InstrumentDescOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentDesc = "";
	private TI_QUERY_OP_Enum DealIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DealId = 0;
	private TI_QUERY_OP_Enum StageOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long StageOrderId = 0;
	private TI_QUERY_OP_Enum ClientOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ClientOrderId = "";
	private TI_QUERY_OP_Enum AccountCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String AccountCode = "";

	public BV_TRADE_REGISTRATION_QUERY_PARAM()
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
	public TI_QUERY_OP_Enum getProviderOp()
	{
		return ProviderOp;
	}
	public void setProviderOp(TI_QUERY_OP_Enum value)
	{
		ProviderOp = value;
	}
	public long getProvider()
	{
		return Provider;
	}
	public void setProvider(long value)
	{
		Provider = value;
	}
	public TI_QUERY_OP_Enum getProviderCodeOp()
	{
		return ProviderCodeOp;
	}
	public void setProviderCodeOp(TI_QUERY_OP_Enum value)
	{
		ProviderCodeOp = value;
	}
	public String getProviderCode()
	{
		return ProviderCode;
	}
	public void setProviderCode(String value)
	{
		ProviderCode = value;
	}
	public TI_QUERY_OP_Enum getProviderShortDescOp()
	{
		return ProviderShortDescOp;
	}
	public void setProviderShortDescOp(TI_QUERY_OP_Enum value)
	{
		ProviderShortDescOp = value;
	}
	public String getProviderShortDesc()
	{
		return ProviderShortDesc;
	}
	public void setProviderShortDesc(String value)
	{
		ProviderShortDesc = value;
	}
	public TI_QUERY_OP_Enum getProviderDescOp()
	{
		return ProviderDescOp;
	}
	public void setProviderDescOp(TI_QUERY_OP_Enum value)
	{
		ProviderDescOp = value;
	}
	public String getProviderDesc()
	{
		return ProviderDesc;
	}
	public void setProviderDesc(String value)
	{
		ProviderDesc = value;
	}
	public TI_QUERY_OP_Enum getAggressorOp()
	{
		return AggressorOp;
	}
	public void setAggressorOp(TI_QUERY_OP_Enum value)
	{
		AggressorOp = value;
	}
	public long getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(long value)
	{
		Aggressor = value;
	}
	public TI_QUERY_OP_Enum getAggressorCodeOp()
	{
		return AggressorCodeOp;
	}
	public void setAggressorCodeOp(TI_QUERY_OP_Enum value)
	{
		AggressorCodeOp = value;
	}
	public String getAggressorCode()
	{
		return AggressorCode;
	}
	public void setAggressorCode(String value)
	{
		AggressorCode = value;
	}
	public TI_QUERY_OP_Enum getAggressorShortDescOp()
	{
		return AggressorShortDescOp;
	}
	public void setAggressorShortDescOp(TI_QUERY_OP_Enum value)
	{
		AggressorShortDescOp = value;
	}
	public String getAggressorShortDesc()
	{
		return AggressorShortDesc;
	}
	public void setAggressorShortDesc(String value)
	{
		AggressorShortDesc = value;
	}
	public TI_QUERY_OP_Enum getAggressorDescOp()
	{
		return AggressorDescOp;
	}
	public void setAggressorDescOp(TI_QUERY_OP_Enum value)
	{
		AggressorDescOp = value;
	}
	public String getAggressorDesc()
	{
		return AggressorDesc;
	}
	public void setAggressorDesc(String value)
	{
		AggressorDesc = value;
	}
	public TI_QUERY_OP_Enum getDealerOrderIdOp()
	{
		return DealerOrderIdOp;
	}
	public void setDealerOrderIdOp(TI_QUERY_OP_Enum value)
	{
		DealerOrderIdOp = value;
	}
	public String getDealerOrderId()
	{
		return DealerOrderId;
	}
	public void setDealerOrderId(String value)
	{
		DealerOrderId = value;
	}
	public TI_QUERY_OP_Enum getLegIdFromOp()
	{
		return LegIdFromOp;
	}
	public void setLegIdFromOp(TI_QUERY_OP_Enum value)
	{
		LegIdFromOp = value;
	}
	public short getLegIdFrom()
	{
		return LegIdFrom;
	}
	public void setLegIdFrom(short value)
	{
		LegIdFrom = value;
	}
	public TI_QUERY_OP_Enum getLegIdToOp()
	{
		return LegIdToOp;
	}
	public void setLegIdToOp(TI_QUERY_OP_Enum value)
	{
		LegIdToOp = value;
	}
	public short getLegIdTo()
	{
		return LegIdTo;
	}
	public void setLegIdTo(short value)
	{
		LegIdTo = value;
	}
	public TI_QUERY_OP_Enum getInstrumentIdOp()
	{
		return InstrumentIdOp;
	}
	public void setInstrumentIdOp(TI_QUERY_OP_Enum value)
	{
		InstrumentIdOp = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
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
	public TI_QUERY_OP_Enum getInstrumentDescOp()
	{
		return InstrumentDescOp;
	}
	public void setInstrumentDescOp(TI_QUERY_OP_Enum value)
	{
		InstrumentDescOp = value;
	}
	public String getInstrumentDesc()
	{
		return InstrumentDesc;
	}
	public void setInstrumentDesc(String value)
	{
		InstrumentDesc = value;
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
	public TI_QUERY_OP_Enum getStageOrderIdOp()
	{
		return StageOrderIdOp;
	}
	public void setStageOrderIdOp(TI_QUERY_OP_Enum value)
	{
		StageOrderIdOp = value;
	}
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MsgIdOp = MsgIdOp.getEnum(byteBuffer.readInt());
		MsgId = (long)byteBuffer.readInt();
		DateFromOp = DateFromOp.getEnum(byteBuffer.readInt());
		DateFrom = (long)byteBuffer.readInt();
		DateToOp = DateToOp.getEnum(byteBuffer.readInt());
		DateTo = (long)byteBuffer.readInt();
		TimeFromOp = TimeFromOp.getEnum(byteBuffer.readInt());
		TimeFrom = byteBuffer.readLong();
		TimeToOp = TimeToOp.getEnum(byteBuffer.readInt());
		TimeTo = byteBuffer.readLong();
		ProviderOp = ProviderOp.getEnum(byteBuffer.readInt());
		Provider = (long)byteBuffer.readInt();
		ProviderCodeOp = ProviderCodeOp.getEnum(byteBuffer.readInt());
		ProviderCode = byteBuffer.readString();
		ProviderShortDescOp = ProviderShortDescOp.getEnum(byteBuffer.readInt());
		ProviderShortDesc = byteBuffer.readString();
		ProviderDescOp = ProviderDescOp.getEnum(byteBuffer.readInt());
		ProviderDesc = byteBuffer.readString();
		AggressorOp = AggressorOp.getEnum(byteBuffer.readInt());
		Aggressor = (long)byteBuffer.readInt();
		AggressorCodeOp = AggressorCodeOp.getEnum(byteBuffer.readInt());
		AggressorCode = byteBuffer.readString();
		AggressorShortDescOp = AggressorShortDescOp.getEnum(byteBuffer.readInt());
		AggressorShortDesc = byteBuffer.readString();
		AggressorDescOp = AggressorDescOp.getEnum(byteBuffer.readInt());
		AggressorDesc = byteBuffer.readString();
		DealerOrderIdOp = DealerOrderIdOp.getEnum(byteBuffer.readInt());
		DealerOrderId = byteBuffer.readString();
		LegIdFromOp = LegIdFromOp.getEnum(byteBuffer.readInt());
		LegIdFrom = (short)byteBuffer.readInt();
		LegIdToOp = LegIdToOp.getEnum(byteBuffer.readInt());
		LegIdTo = (short)byteBuffer.readInt();
		InstrumentIdOp = InstrumentIdOp.getEnum(byteBuffer.readInt());
		InstrumentId = (long)byteBuffer.readInt();
		InstrumentCodeOp = InstrumentCodeOp.getEnum(byteBuffer.readInt());
		InstrumentCode = byteBuffer.readString();
		InstrumentDescOp = InstrumentDescOp.getEnum(byteBuffer.readInt());
		InstrumentDesc = byteBuffer.readString();
		DealIdOp = DealIdOp.getEnum(byteBuffer.readInt());
		DealId = (long)byteBuffer.readInt();
		StageOrderIdOp = StageOrderIdOp.getEnum(byteBuffer.readInt());
		StageOrderId = (long)byteBuffer.readInt();
		ClientOrderIdOp = ClientOrderIdOp.getEnum(byteBuffer.readInt());
		ClientOrderId = byteBuffer.readString();
		AccountCodeOp = AccountCodeOp.getEnum(byteBuffer.readInt());
		AccountCode = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(MsgIdOp.getValue());
		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt(DateFromOp.getValue());
		byteBuffer.writeInt((int)(DateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(DateToOp.getValue());
		byteBuffer.writeInt((int)(DateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(TimeFromOp.getValue());
		byteBuffer.writeLong(TimeFrom);
		byteBuffer.writeInt(TimeToOp.getValue());
		byteBuffer.writeLong(TimeTo);
		byteBuffer.writeInt(ProviderOp.getValue());
		byteBuffer.writeInt((int)(Provider & 0xFFFFFFFFL));
		byteBuffer.writeInt(ProviderCodeOp.getValue());
		byteBuffer.writeString(ProviderCode);
		byteBuffer.writeInt(ProviderShortDescOp.getValue());
		byteBuffer.writeString(ProviderShortDesc);
		byteBuffer.writeInt(ProviderDescOp.getValue());
		byteBuffer.writeString(ProviderDesc);
		byteBuffer.writeInt(AggressorOp.getValue());
		byteBuffer.writeInt((int)(Aggressor & 0xFFFFFFFFL));
		byteBuffer.writeInt(AggressorCodeOp.getValue());
		byteBuffer.writeString(AggressorCode);
		byteBuffer.writeInt(AggressorShortDescOp.getValue());
		byteBuffer.writeString(AggressorShortDesc);
		byteBuffer.writeInt(AggressorDescOp.getValue());
		byteBuffer.writeString(AggressorDesc);
		byteBuffer.writeInt(DealerOrderIdOp.getValue());
		byteBuffer.writeString(DealerOrderId);
		byteBuffer.writeInt(LegIdFromOp.getValue());
		byteBuffer.writeInt((int)(LegIdFrom & 0xFFFFL));
		byteBuffer.writeInt(LegIdToOp.getValue());
		byteBuffer.writeInt((int)(LegIdTo & 0xFFFFL));
		byteBuffer.writeInt(InstrumentIdOp.getValue());
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InstrumentCodeOp.getValue());
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeInt(InstrumentDescOp.getValue());
		byteBuffer.writeString(InstrumentDesc);
		byteBuffer.writeInt(DealIdOp.getValue());
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeInt(StageOrderIdOp.getValue());
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ClientOrderIdOp.getValue());
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt(AccountCodeOp.getValue());
		byteBuffer.writeString(AccountCode);

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
		stringBuilder.append("BV_TRADE_REGISTRATION_QUERY_PARAM::");
		stringBuilder.append("MsgIdOp(").append(MsgIdOp).append(")");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("DateFromOp(").append(DateFromOp).append(")");
		stringBuilder.append("DateFrom(").append(DateFrom).append(")");
		stringBuilder.append("DateToOp(").append(DateToOp).append(")");
		stringBuilder.append("DateTo(").append(DateTo).append(")");
		stringBuilder.append("TimeFromOp(").append(TimeFromOp).append(")");
		stringBuilder.append("TimeFrom(").append(TimeFrom).append(")");
		stringBuilder.append("TimeToOp(").append(TimeToOp).append(")");
		stringBuilder.append("TimeTo(").append(TimeTo).append(")");
		stringBuilder.append("ProviderOp(").append(ProviderOp).append(")");
		stringBuilder.append("Provider(").append(Provider).append(")");
		stringBuilder.append("ProviderCodeOp(").append(ProviderCodeOp).append(")");
		stringBuilder.append("ProviderCode(").append(ProviderCode).append(")");
		stringBuilder.append("ProviderShortDescOp(").append(ProviderShortDescOp).append(")");
		stringBuilder.append("ProviderShortDesc(").append(ProviderShortDesc).append(")");
		stringBuilder.append("ProviderDescOp(").append(ProviderDescOp).append(")");
		stringBuilder.append("ProviderDesc(").append(ProviderDesc).append(")");
		stringBuilder.append("AggressorOp(").append(AggressorOp).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor).append(")");
		stringBuilder.append("AggressorCodeOp(").append(AggressorCodeOp).append(")");
		stringBuilder.append("AggressorCode(").append(AggressorCode).append(")");
		stringBuilder.append("AggressorShortDescOp(").append(AggressorShortDescOp).append(")");
		stringBuilder.append("AggressorShortDesc(").append(AggressorShortDesc).append(")");
		stringBuilder.append("AggressorDescOp(").append(AggressorDescOp).append(")");
		stringBuilder.append("AggressorDesc(").append(AggressorDesc).append(")");
		stringBuilder.append("DealerOrderIdOp(").append(DealerOrderIdOp).append(")");
		stringBuilder.append("DealerOrderId(").append(DealerOrderId).append(")");
		stringBuilder.append("LegIdFromOp(").append(LegIdFromOp).append(")");
		stringBuilder.append("LegIdFrom(").append(LegIdFrom).append(")");
		stringBuilder.append("LegIdToOp(").append(LegIdToOp).append(")");
		stringBuilder.append("LegIdTo(").append(LegIdTo).append(")");
		stringBuilder.append("InstrumentIdOp(").append(InstrumentIdOp).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentCodeOp(").append(InstrumentCodeOp).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InstrumentDescOp(").append(InstrumentDescOp).append(")");
		stringBuilder.append("InstrumentDesc(").append(InstrumentDesc).append(")");
		stringBuilder.append("DealIdOp(").append(DealIdOp).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("StageOrderIdOp(").append(StageOrderIdOp).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("ClientOrderIdOp(").append(ClientOrderIdOp).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("AccountCodeOp(").append(AccountCodeOp).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		return stringBuilder.toString();
	}
}

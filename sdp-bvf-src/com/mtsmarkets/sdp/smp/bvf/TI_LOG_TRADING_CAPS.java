package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_LOG_TRADING_CAPS extends SMPMessage
{
	public static final long CLASS_ID = 100834;

	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private long MarketId = 0;
	private TI_TRADING_CAPS_FUNCTION_Enum FunctionId = TI_TRADING_CAPS_FUNCTION_Enum.TI_TRADING_CAPS_FUNCTION_FirmQuote;
	private String Currency = "";
	private long ProductType = 0;
	private long InstrumentClassId = 0;
	private double WarningLimit = 0;
	private double BlockingLimit = 0;
	private TI_TRADING_CAPS_MODALITY_Enum CapsModality = TI_TRADING_CAPS_MODALITY_Enum.TI_TRADING_CAPS_MODALITY_MaturityAdjusted;
	private TI_TRADING_CAPS_MODALITY_SETTING_Enum ModalitySetting = TI_TRADING_CAPS_MODALITY_SETTING_Enum.TI_TRADING_CAPS_MODALITY_SETTING_Currency;
	private TI_TRADING_CAPS_EVENT_Enum Event = TI_TRADING_CAPS_EVENT_Enum.TI_TRADING_CAPS_EVENT_Enable;
	private TI_TRADING_CAPS_STATUS_Enum Status = TI_TRADING_CAPS_STATUS_Enum.TI_TRADING_CAPS_STATUS_Enabled;
	private String UserData = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private String SubmitterTraderName = "";

	public TI_LOG_TRADING_CAPS()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public TI_TRADING_CAPS_FUNCTION_Enum getFunctionId()
	{
		return FunctionId;
	}
	public void setFunctionId(TI_TRADING_CAPS_FUNCTION_Enum value)
	{
		FunctionId = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public long getProductType()
	{
		return ProductType;
	}
	public void setProductType(long value)
	{
		ProductType = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public double getWarningLimit()
	{
		return WarningLimit;
	}
	public void setWarningLimit(double value)
	{
		WarningLimit = value;
	}
	public double getBlockingLimit()
	{
		return BlockingLimit;
	}
	public void setBlockingLimit(double value)
	{
		BlockingLimit = value;
	}
	public TI_TRADING_CAPS_MODALITY_Enum getCapsModality()
	{
		return CapsModality;
	}
	public void setCapsModality(TI_TRADING_CAPS_MODALITY_Enum value)
	{
		CapsModality = value;
	}
	public TI_TRADING_CAPS_MODALITY_SETTING_Enum getModalitySetting()
	{
		return ModalitySetting;
	}
	public void setModalitySetting(TI_TRADING_CAPS_MODALITY_SETTING_Enum value)
	{
		ModalitySetting = value;
	}
	public TI_TRADING_CAPS_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(TI_TRADING_CAPS_EVENT_Enum value)
	{
		Event = value;
	}
	public TI_TRADING_CAPS_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_TRADING_CAPS_STATUS_Enum value)
	{
		Status = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
	}
	public long getCreationDate()
	{
		return CreationDate;
	}
	public void setCreationDate(long value)
	{
		CreationDate = value;
	}
	public long getCreationTime()
	{
		return CreationTime;
	}
	public void setCreationTime(long value)
	{
		CreationTime = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}
	public long getSubmitterMemberId()
	{
		return SubmitterMemberId;
	}
	public void setSubmitterMemberId(long value)
	{
		SubmitterMemberId = value;
	}
	public long getSubmitterTraderId()
	{
		return SubmitterTraderId;
	}
	public void setSubmitterTraderId(long value)
	{
		SubmitterTraderId = value;
	}
	public String getSubmitterTraderName()
	{
		return SubmitterTraderName;
	}
	public void setSubmitterTraderName(String value)
	{
		SubmitterTraderName = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		MarketId = (long)byteBuffer.readInt();
		FunctionId = FunctionId.getEnum(byteBuffer.readInt());
		Currency = byteBuffer.readString();
		ProductType = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		WarningLimit = byteBuffer.readDouble();
		BlockingLimit = byteBuffer.readDouble();
		CapsModality = CapsModality.getEnum(byteBuffer.readInt());
		ModalitySetting = ModalitySetting.getEnum(byteBuffer.readInt());
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		UserData = byteBuffer.readString();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		SubmitterMemberId = (long)byteBuffer.readInt();
		SubmitterTraderId = (long)byteBuffer.readInt();
		SubmitterTraderName = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt(FunctionId.getValue());
		byteBuffer.writeString(Currency);
		byteBuffer.writeInt((int)(ProductType & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(WarningLimit);
		byteBuffer.writeDouble(BlockingLimit);
		byteBuffer.writeInt(CapsModality.getValue());
		byteBuffer.writeInt(ModalitySetting.getValue());
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeString(UserData);
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt((int)(SubmitterMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterTraderName);

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
		stringBuilder.append("TI_LOG_TRADING_CAPS::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("FunctionId(").append(FunctionId).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("ProductType(").append(ProductType).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("WarningLimit(").append(WarningLimit).append(")");
		stringBuilder.append("BlockingLimit(").append(BlockingLimit).append(")");
		stringBuilder.append("CapsModality(").append(CapsModality).append(")");
		stringBuilder.append("ModalitySetting(").append(ModalitySetting).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("SubmitterTraderName(").append(SubmitterTraderName).append(")");
		return stringBuilder.toString();
	}
}

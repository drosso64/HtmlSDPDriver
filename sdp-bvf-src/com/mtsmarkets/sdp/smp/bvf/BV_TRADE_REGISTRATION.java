package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_REGISTRATION extends SMPMessage
{
	public static final long CLASS_ID = 400066;

	private TI_MSG_INFO MsgInfo = new TI_MSG_INFO();
	private String SectionCode = "";
	private BV_TRADE_REGISTRATION_MEMBER_INFO Provider = new BV_TRADE_REGISTRATION_MEMBER_INFO();
	private BV_TRADE_REGISTRATION_MEMBER_INFO Aggressor = new BV_TRADE_REGISTRATION_MEMBER_INFO();
	private String DealerOrderId = "";
	private String OriginalDealerOrderId = "";
	private BV_TRADE_REGISTRATION_TYPE_Enum RegistrationType = BV_TRADE_REGISTRATION_TYPE_Enum.BV_TRADE_REGISTRATION_TYPE_Bond;
	private BV_TRADE_FUTURE_ACCOUNT_INFO ProviderExchangeAccountInfo = new BV_TRADE_FUTURE_ACCOUNT_INFO();
	private BV_TRADE_FUTURE_ACCOUNT_INFO AggressorExchangeAccountInfo = new BV_TRADE_FUTURE_ACCOUNT_INFO();
	private short NumOfLegs = 0;
	private BV_TRADE_REGISTRATION_LEG_INFO[] Legs = new BV_TRADE_REGISTRATION_LEG_INFO[20];
	private BV_VALUE SpreadValue = new BV_VALUE();
	private double ConversionFactor = 0;
	private BV_VALUE GrossBasis = new BV_VALUE();
	private BV_HEDGE_RATIO_Enum HedgeRatio = BV_HEDGE_RATIO_Enum.BV_HEDGE_RATIO_None;
	private BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Enum GoodForTime = BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Enum.BV_TRADE_REGISTRATION_GOOD_FOR_TIME_EOD;
	private long Duration = 0;
	private long Timeout = 0;
	private BV_TRADE_REGISTRATION_EVENT_Enum Event = BV_TRADE_REGISTRATION_EVENT_Enum.BV_TRADE_REGISTRATION_EVENT_Send;
	private BV_TRADE_REGISTRATION_STATUS_Enum Status = BV_TRADE_REGISTRATION_STATUS_Enum.BV_TRADE_REGISTRATION_STATUS_Processing;
	private BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum ProviderStatus = BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum.BV_TRADE_REGISTRATION_MEMBER_STATUS_None;
	private BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum AggressorStatus = BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum.BV_TRADE_REGISTRATION_MEMBER_STATUS_None;
	private long UpdateTime = 0;

	public BV_TRADE_REGISTRATION()
	{
		for (int i=0; i < Legs.length; ++i)
		{
			Legs[i] = new BV_TRADE_REGISTRATION_LEG_INFO();
		}
	}

	public TI_MSG_INFO getMsgInfo()
	{
		return MsgInfo;
	}
	public void setMsgInfo(TI_MSG_INFO value)
	{
		MsgInfo = value;
	}
	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
	}
	public BV_TRADE_REGISTRATION_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_TRADE_REGISTRATION_MEMBER_INFO value)
	{
		Provider = value;
	}
	public BV_TRADE_REGISTRATION_MEMBER_INFO getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(BV_TRADE_REGISTRATION_MEMBER_INFO value)
	{
		Aggressor = value;
	}
	public String getDealerOrderId()
	{
		return DealerOrderId;
	}
	public void setDealerOrderId(String value)
	{
		DealerOrderId = value;
	}
	public String getOriginalDealerOrderId()
	{
		return OriginalDealerOrderId;
	}
	public void setOriginalDealerOrderId(String value)
	{
		OriginalDealerOrderId = value;
	}
	public BV_TRADE_REGISTRATION_TYPE_Enum getRegistrationType()
	{
		return RegistrationType;
	}
	public void setRegistrationType(BV_TRADE_REGISTRATION_TYPE_Enum value)
	{
		RegistrationType = value;
	}
	public BV_TRADE_FUTURE_ACCOUNT_INFO getProviderExchangeAccountInfo()
	{
		return ProviderExchangeAccountInfo;
	}
	public void setProviderExchangeAccountInfo(BV_TRADE_FUTURE_ACCOUNT_INFO value)
	{
		ProviderExchangeAccountInfo = value;
	}
	public BV_TRADE_FUTURE_ACCOUNT_INFO getAggressorExchangeAccountInfo()
	{
		return AggressorExchangeAccountInfo;
	}
	public void setAggressorExchangeAccountInfo(BV_TRADE_FUTURE_ACCOUNT_INFO value)
	{
		AggressorExchangeAccountInfo = value;
	}
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public BV_TRADE_REGISTRATION_LEG_INFO[] getLegs()
	{
		return Legs;
	}
	public void setLegs(BV_TRADE_REGISTRATION_LEG_INFO[] value)
	{
		Legs = value;
	}
	public BV_VALUE getSpreadValue()
	{
		return SpreadValue;
	}
	public void setSpreadValue(BV_VALUE value)
	{
		SpreadValue = value;
	}
	public double getConversionFactor()
	{
		return ConversionFactor;
	}
	public void setConversionFactor(double value)
	{
		ConversionFactor = value;
	}
	public BV_VALUE getGrossBasis()
	{
		return GrossBasis;
	}
	public void setGrossBasis(BV_VALUE value)
	{
		GrossBasis = value;
	}
	public BV_HEDGE_RATIO_Enum getHedgeRatio()
	{
		return HedgeRatio;
	}
	public void setHedgeRatio(BV_HEDGE_RATIO_Enum value)
	{
		HedgeRatio = value;
	}
	public BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Enum getGoodForTime()
	{
		return GoodForTime;
	}
	public void setGoodForTime(BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Enum value)
	{
		GoodForTime = value;
	}
	public long getDuration()
	{
		return Duration;
	}
	public void setDuration(long value)
	{
		Duration = value;
	}
	public long getTimeout()
	{
		return Timeout;
	}
	public void setTimeout(long value)
	{
		Timeout = value;
	}
	public BV_TRADE_REGISTRATION_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_TRADE_REGISTRATION_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_TRADE_REGISTRATION_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_TRADE_REGISTRATION_STATUS_Enum value)
	{
		Status = value;
	}
	public BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum getProviderStatus()
	{
		return ProviderStatus;
	}
	public void setProviderStatus(BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum value)
	{
		ProviderStatus = value;
	}
	public BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum getAggressorStatus()
	{
		return AggressorStatus;
	}
	public void setAggressorStatus(BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum value)
	{
		AggressorStatus = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MsgInfo.readXDR(byteBuffer);
		SectionCode = byteBuffer.readString();
		Provider.readXDR(byteBuffer);
		Aggressor.readXDR(byteBuffer);
		DealerOrderId = byteBuffer.readString();
		OriginalDealerOrderId = byteBuffer.readString();
		RegistrationType = RegistrationType.getEnum(byteBuffer.readInt());
		ProviderExchangeAccountInfo.readXDR(byteBuffer);
		AggressorExchangeAccountInfo.readXDR(byteBuffer);
		NumOfLegs = (short)byteBuffer.readInt();
		for (int i=0; i < Legs.length; ++i)
		{
			Legs[i].readXDR(byteBuffer);
		}
		SpreadValue.readXDR(byteBuffer);
		ConversionFactor = byteBuffer.readDouble();
		GrossBasis.readXDR(byteBuffer);
		HedgeRatio = HedgeRatio.getEnum(byteBuffer.readInt());
		GoodForTime = GoodForTime.getEnum(byteBuffer.readInt());
		Duration = (long)byteBuffer.readInt();
		Timeout = byteBuffer.readLong();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		ProviderStatus = ProviderStatus.getEnum(byteBuffer.readInt());
		AggressorStatus = AggressorStatus.getEnum(byteBuffer.readInt());
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		MsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeString(SectionCode);
		Provider.writeXDR(byteBuffer);
		Aggressor.writeXDR(byteBuffer);
		byteBuffer.writeString(DealerOrderId);
		byteBuffer.writeString(OriginalDealerOrderId);
		byteBuffer.writeInt(RegistrationType.getValue());
		ProviderExchangeAccountInfo.writeXDR(byteBuffer);
		AggressorExchangeAccountInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		for (int i=0; i < Legs.length; ++i)
		{
			Legs[i].writeXDR(byteBuffer);
		}
		SpreadValue.writeXDR(byteBuffer);
		byteBuffer.writeDouble(ConversionFactor);
		GrossBasis.writeXDR(byteBuffer);
		byteBuffer.writeInt(HedgeRatio.getValue());
		byteBuffer.writeInt(GoodForTime.getValue());
		byteBuffer.writeInt((int)(Duration & 0xFFFFFFFFL));
		byteBuffer.writeLong(Timeout);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(ProviderStatus.getValue());
		byteBuffer.writeInt(AggressorStatus.getValue());
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("BV_TRADE_REGISTRATION::");
		stringBuilder.append("MsgInfo(").append(MsgInfo.toString()).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("DealerOrderId(").append(DealerOrderId).append(")");
		stringBuilder.append("OriginalDealerOrderId(").append(OriginalDealerOrderId).append(")");
		stringBuilder.append("RegistrationType(").append(RegistrationType).append(")");
		stringBuilder.append("ProviderExchangeAccountInfo(").append(ProviderExchangeAccountInfo.toString()).append(")");
		stringBuilder.append("AggressorExchangeAccountInfo(").append(AggressorExchangeAccountInfo.toString()).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		for (int i=0; i < Legs.length; ++i)
		{
			stringBuilder.append("Legs[").append(i).append("](").append(Legs[i].toString()).append(")");
		}
		stringBuilder.append("SpreadValue(").append(SpreadValue.toString()).append(")");
		stringBuilder.append("ConversionFactor(").append(ConversionFactor).append(")");
		stringBuilder.append("GrossBasis(").append(GrossBasis.toString()).append(")");
		stringBuilder.append("HedgeRatio(").append(HedgeRatio).append(")");
		stringBuilder.append("GoodForTime(").append(GoodForTime).append(")");
		stringBuilder.append("Duration(").append(Duration).append(")");
		stringBuilder.append("Timeout(").append(Timeout).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("ProviderStatus(").append(ProviderStatus).append(")");
		stringBuilder.append("AggressorStatus(").append(AggressorStatus).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}

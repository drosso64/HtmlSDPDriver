package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_BUY_SIDE_TRADING_LIST_LEG_INFO extends SMPMessage
{
	public static final long CLASS_ID = 100206;

	private long BuySideMemberId = 0;
	private long TradingListId = 0;
	private long RfcqReqId = 0;
	private short LegId = 0;
	private short ParticipatingSellSideNr = 0;
	private TI_RFCQ_PROVIDER_STATUS_Enum[] ProviderStatus = new TI_RFCQ_PROVIDER_STATUS_Enum[20];
	private TI_RFCQ_REQUEST_STATUS_Enum LegStatus = TI_RFCQ_REQUEST_STATUS_Enum.TI_RFCQ_REQUEST_STATUS_Processing;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_RFCQ_BUY_SIDE_TRADING_LIST_LEG_INFO()
	{
		for (int i=0; i < ProviderStatus.length; ++i)
		{
			ProviderStatus[i] = TI_RFCQ_PROVIDER_STATUS_Enum.TI_RFCQ_PROVIDER_STATUS_Processing;
		}
	}

	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public long getTradingListId()
	{
		return TradingListId;
	}
	public void setTradingListId(long value)
	{
		TradingListId = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public short getParticipatingSellSideNr()
	{
		return ParticipatingSellSideNr;
	}
	public void setParticipatingSellSideNr(short value)
	{
		ParticipatingSellSideNr = value;
	}
	public TI_RFCQ_PROVIDER_STATUS_Enum[] getProviderStatus()
	{
		return ProviderStatus;
	}
	public void setProviderStatus(TI_RFCQ_PROVIDER_STATUS_Enum[] value)
	{
		ProviderStatus = value;
	}
	public TI_RFCQ_REQUEST_STATUS_Enum getLegStatus()
	{
		return LegStatus;
	}
	public void setLegStatus(TI_RFCQ_REQUEST_STATUS_Enum value)
	{
		LegStatus = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		BuySideMemberId = (long)byteBuffer.readInt();
		TradingListId = (long)byteBuffer.readInt();
		RfcqReqId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		ParticipatingSellSideNr = (short)byteBuffer.readInt();
		for (int i=0; i < ProviderStatus.length; ++i)
		{
			ProviderStatus[i] = ProviderStatus[i].getEnum(byteBuffer.readInt());
		}
		LegStatus = LegStatus.getEnum(byteBuffer.readInt());
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt((int)(ParticipatingSellSideNr & 0xFFFFL));
		for (int i=0; i < ProviderStatus.length; ++i)
		{
			byteBuffer.writeInt(ProviderStatus[i].getValue());
		}
		byteBuffer.writeInt(LegStatus.getValue());
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
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
		stringBuilder.append("BV_RFCQ_BUY_SIDE_TRADING_LIST_LEG_INFO::");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("ParticipatingSellSideNr(").append(ParticipatingSellSideNr).append(")");
		for (int i=0; i < ProviderStatus.length; ++i)
		{
			stringBuilder.append("ProviderStatus[").append(i).append("](").append(ProviderStatus[i]).append(")");
		}
		stringBuilder.append("LegStatus(").append(LegStatus).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}

package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_SELL_SIDE_MEMBER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114947;

	private long ProviderId = 0;
	private TI_RFCQ_PROVIDER_STATUS_Enum ProviderStatus = TI_RFCQ_PROVIDER_STATUS_Enum.TI_RFCQ_PROVIDER_STATUS_Processing;
	private short[] MarketAffiliation = new short[3];
	private BV_RFCQ_DEALER_SELECTION_TYPE_Enum DealerSelectionType = BV_RFCQ_DEALER_SELECTION_TYPE_Enum.BV_RFCQ_DEALER_SELECTION_Manual;

	public BV_RFCQ_SELL_SIDE_MEMBER_INFO()
	{
	}

	public long getProviderId()
	{
		return ProviderId;
	}
	public void setProviderId(long value)
	{
		ProviderId = value;
	}
	public TI_RFCQ_PROVIDER_STATUS_Enum getProviderStatus()
	{
		return ProviderStatus;
	}
	public void setProviderStatus(TI_RFCQ_PROVIDER_STATUS_Enum value)
	{
		ProviderStatus = value;
	}
	public short[] getMarketAffiliation()
	{
		return MarketAffiliation;
	}
	public void setMarketAffiliation(short[] value)
	{
		MarketAffiliation = value;
	}
	public BV_RFCQ_DEALER_SELECTION_TYPE_Enum getDealerSelectionType()
	{
		return DealerSelectionType;
	}
	public void setDealerSelectionType(BV_RFCQ_DEALER_SELECTION_TYPE_Enum value)
	{
		DealerSelectionType = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ProviderId = (long)byteBuffer.readInt();
		ProviderStatus = ProviderStatus.getEnum(byteBuffer.readInt());
		for (int i=0; i < MarketAffiliation.length; ++i)
		{
			MarketAffiliation[i] = (short)byteBuffer.readInt();
		}
		DealerSelectionType = DealerSelectionType.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ProviderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ProviderStatus.getValue());
		for (int i=0; i < MarketAffiliation.length; ++i)
		{
			byteBuffer.writeInt((int)(MarketAffiliation[i] & 0xFFFFL));
		}
		byteBuffer.writeInt(DealerSelectionType.getValue());

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
		stringBuilder.append("BV_RFCQ_SELL_SIDE_MEMBER_INFO::");
		stringBuilder.append("ProviderId(").append(ProviderId).append(")");
		stringBuilder.append("ProviderStatus(").append(ProviderStatus).append(")");
		for (int i=0; i < MarketAffiliation.length; ++i)
		{
			stringBuilder.append("MarketAffiliation[").append(i).append("](").append(MarketAffiliation[i]).append(")");
		}
		stringBuilder.append("DealerSelectionType(").append(DealerSelectionType).append(")");
		return stringBuilder.toString();
	}
}

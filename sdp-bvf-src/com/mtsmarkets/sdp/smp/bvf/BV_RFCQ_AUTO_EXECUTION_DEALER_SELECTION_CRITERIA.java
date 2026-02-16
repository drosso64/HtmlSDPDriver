package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_DEALER_SELECTION_CRITERIA extends SMPMessage
{
	public static final long CLASS_ID = 114998;

	private long DealerGroupId = 0;
	private BV_RFCQ_DEALER_SELECTION_TYPE_Enum DealerSelectionType = BV_RFCQ_DEALER_SELECTION_TYPE_Enum.BV_RFCQ_DEALER_SELECTION_Manual;
	private short DealerGroupNum = 0;
	private BV_RFCQ_DEALER_GROUP_SELECTION_TYPE_Enum DealerGroupSelectionType = BV_RFCQ_DEALER_GROUP_SELECTION_TYPE_Enum.BV_RFCQ_DEALER_GROUP_SELECTION_TYPE_OriginalRotation;
	private short MinimumDealers = 0;
	private BV_RFCQ_AUTO_EXECUTION_DEALER_LIST_TYPE_Enum DealerListType = BV_RFCQ_AUTO_EXECUTION_DEALER_LIST_TYPE_Enum.BV_RFCQ_AUTO_EXECUTION_DEALER_LIST_TYPE_None;
	private short DealerNum = 0;
	private long[] DealerList = new long[100];
	private double DealerHitRate = 0;
	private double DealerPickupRate = 0;
	private short MaximumDealers = 0;
	private double DealerAxeSize = 0;
	private BV_SETTLEMENT_MODE_Enum SettlementMode = BV_SETTLEMENT_MODE_Enum.BV_SETTLEMENT_MODE_Any;

	public BV_RFCQ_AUTO_EXECUTION_DEALER_SELECTION_CRITERIA()
	{
	}

	public long getDealerGroupId()
	{
		return DealerGroupId;
	}
	public void setDealerGroupId(long value)
	{
		DealerGroupId = value;
	}
	public BV_RFCQ_DEALER_SELECTION_TYPE_Enum getDealerSelectionType()
	{
		return DealerSelectionType;
	}
	public void setDealerSelectionType(BV_RFCQ_DEALER_SELECTION_TYPE_Enum value)
	{
		DealerSelectionType = value;
	}
	public short getDealerGroupNum()
	{
		return DealerGroupNum;
	}
	public void setDealerGroupNum(short value)
	{
		DealerGroupNum = value;
	}
	public BV_RFCQ_DEALER_GROUP_SELECTION_TYPE_Enum getDealerGroupSelectionType()
	{
		return DealerGroupSelectionType;
	}
	public void setDealerGroupSelectionType(BV_RFCQ_DEALER_GROUP_SELECTION_TYPE_Enum value)
	{
		DealerGroupSelectionType = value;
	}
	public short getMinimumDealers()
	{
		return MinimumDealers;
	}
	public void setMinimumDealers(short value)
	{
		MinimumDealers = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_DEALER_LIST_TYPE_Enum getDealerListType()
	{
		return DealerListType;
	}
	public void setDealerListType(BV_RFCQ_AUTO_EXECUTION_DEALER_LIST_TYPE_Enum value)
	{
		DealerListType = value;
	}
	public short getDealerNum()
	{
		return DealerNum;
	}
	public void setDealerNum(short value)
	{
		DealerNum = value;
	}
	public long[] getDealerList()
	{
		return DealerList;
	}
	public void setDealerList(long[] value)
	{
		DealerList = value;
	}
	public double getDealerHitRate()
	{
		return DealerHitRate;
	}
	public void setDealerHitRate(double value)
	{
		DealerHitRate = value;
	}
	public double getDealerPickupRate()
	{
		return DealerPickupRate;
	}
	public void setDealerPickupRate(double value)
	{
		DealerPickupRate = value;
	}
	public short getMaximumDealers()
	{
		return MaximumDealers;
	}
	public void setMaximumDealers(short value)
	{
		MaximumDealers = value;
	}
	public double getDealerAxeSize()
	{
		return DealerAxeSize;
	}
	public void setDealerAxeSize(double value)
	{
		DealerAxeSize = value;
	}
	public BV_SETTLEMENT_MODE_Enum getSettlementMode()
	{
		return SettlementMode;
	}
	public void setSettlementMode(BV_SETTLEMENT_MODE_Enum value)
	{
		SettlementMode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DealerGroupId = (long)byteBuffer.readInt();
		DealerSelectionType = DealerSelectionType.getEnum(byteBuffer.readInt());
		DealerGroupNum = (short)byteBuffer.readInt();
		DealerGroupSelectionType = DealerGroupSelectionType.getEnum(byteBuffer.readInt());
		MinimumDealers = (short)byteBuffer.readInt();
		DealerListType = DealerListType.getEnum(byteBuffer.readInt());
		DealerNum = (short)byteBuffer.readInt();
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i] = (long)byteBuffer.readInt();
		}
		DealerHitRate = byteBuffer.readDouble();
		DealerPickupRate = byteBuffer.readDouble();
		MaximumDealers = (short)byteBuffer.readInt();
		DealerAxeSize = byteBuffer.readDouble();
		SettlementMode = SettlementMode.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(DealerGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt(DealerSelectionType.getValue());
		byteBuffer.writeInt((int)(DealerGroupNum & 0xFFFFL));
		byteBuffer.writeInt(DealerGroupSelectionType.getValue());
		byteBuffer.writeInt((int)(MinimumDealers & 0xFFFFL));
		byteBuffer.writeInt(DealerListType.getValue());
		byteBuffer.writeInt((int)(DealerNum & 0xFFFFL));
		for (int i=0; i < DealerList.length; ++i)
		{
			byteBuffer.writeInt((int)(DealerList[i] & 0xFFFFFFFFL));
		}
		byteBuffer.writeDouble(DealerHitRate);
		byteBuffer.writeDouble(DealerPickupRate);
		byteBuffer.writeInt((int)(MaximumDealers & 0xFFFFL));
		byteBuffer.writeDouble(DealerAxeSize);
		byteBuffer.writeInt(SettlementMode.getValue());

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_DEALER_SELECTION_CRITERIA::");
		stringBuilder.append("DealerGroupId(").append(DealerGroupId).append(")");
		stringBuilder.append("DealerSelectionType(").append(DealerSelectionType).append(")");
		stringBuilder.append("DealerGroupNum(").append(DealerGroupNum).append(")");
		stringBuilder.append("DealerGroupSelectionType(").append(DealerGroupSelectionType).append(")");
		stringBuilder.append("MinimumDealers(").append(MinimumDealers).append(")");
		stringBuilder.append("DealerListType(").append(DealerListType).append(")");
		stringBuilder.append("DealerNum(").append(DealerNum).append(")");
		for (int i=0; i < DealerList.length; ++i)
		{
			stringBuilder.append("DealerList[").append(i).append("](").append(DealerList[i]).append(")");
		}
		stringBuilder.append("DealerHitRate(").append(DealerHitRate).append(")");
		stringBuilder.append("DealerPickupRate(").append(DealerPickupRate).append(")");
		stringBuilder.append("MaximumDealers(").append(MaximumDealers).append(")");
		stringBuilder.append("DealerAxeSize(").append(DealerAxeSize).append(")");
		stringBuilder.append("SettlementMode(").append(SettlementMode).append(")");
		return stringBuilder.toString();
	}
}

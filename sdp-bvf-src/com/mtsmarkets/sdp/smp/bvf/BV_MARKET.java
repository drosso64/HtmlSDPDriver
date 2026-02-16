package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MARKET extends SMPMessage
{
	public static final long CLASS_ID = 400024;

	private long MarketId = 0;
	private long SwitchRFCQTimer = 0;
	private short SwitchRFCQMaxNumRecipients = 0;
	private short SwitchRFCQAuditTrailDelay = 0;
	private short SwitchRFCQMinAutomaticMatchingTimeout = 0;
	private short SwitchRFCQAcceptanceTimeout = 0;
	private long ButterflyRFCQTimer = 0;
	private short ButterflyRFCQMaxNumRecipients = 0;
	private short ButterflyRFCQAuditTrailDelay = 0;
	private short ButterflyRFCQMinAutomaticMatchingTimeout = 0;
	private short ButterflyRFCQAcceptanceTimeout = 0;
	private short MultiLegRFCQMaxNumLegs = 0;
	private short MultiLegRFCQMaxDueInTime = 0;
	private long MultilegRFCQTimer = 0;
	private short MultilegRFCQMaxNumRecipients = 0;
	private short MultilegRFCQAuditTrailDelay = 0;
	private short MultilegRFCQMinAutomaticMatchingTimeout = 0;
	private short MultilegRFCQAcceptanceTimeout = 0;
	private long DoubleSidedRFCQTimer = 0;
	private short DoubleSidedRFCQMaxNumRecipients = 0;
	private short DoubleSidedRFCQAuditTrailDelay = 0;
	private short DoubleSidedRFCQMinAutomaticMatchingTimeout = 0;
	private short DoubleSidedRFCQAcceptanceTimeout = 0;
	private TI_FLAG_Enum DoubleSidedRFCQDoubleAutoAcceptanceFg = TI_FLAG_Enum.TI_FLAG_No;
	private short MaxNumInventoryGroups = 0;
	private short MaxNumMemberPerInventoryGroup = 0;
	private short MaxNumInventoryGroupConfigurations = 0;
	private short MaxNumInventoryGroupExceptions = 0;
	private long SwitchRFCQPreTradeTransparencyMinTime = 0;
	private long SwitchRFCQPreTradeTransparencyMaxTime = 0;
	private long ButterflyRFCQPreTradeTransparencyMinTime = 0;
	private long ButterflyRFCQPreTradeTransparencyMaxTime = 0;
	private long MultilegRFCQPreTradeTransparencyMinTime = 0;
	private long MultilegRFCQPreTradeTransparencyMaxTime = 0;
	private long DoubleSidedRFCQPreTradeTransparencyMinTime = 0;
	private long DoubleSidedRFCQPreTradeTransparencyMaxTime = 0;
	private short PortfolioRFCQTimer = 0;
	private short PortfolioRFCQAcceptanceTimeout = 0;
	private short PortfolioRFCQDueInTime = 0;

	public BV_MARKET()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getSwitchRFCQTimer()
	{
		return SwitchRFCQTimer;
	}
	public void setSwitchRFCQTimer(long value)
	{
		SwitchRFCQTimer = value;
	}
	public short getSwitchRFCQMaxNumRecipients()
	{
		return SwitchRFCQMaxNumRecipients;
	}
	public void setSwitchRFCQMaxNumRecipients(short value)
	{
		SwitchRFCQMaxNumRecipients = value;
	}
	public short getSwitchRFCQAuditTrailDelay()
	{
		return SwitchRFCQAuditTrailDelay;
	}
	public void setSwitchRFCQAuditTrailDelay(short value)
	{
		SwitchRFCQAuditTrailDelay = value;
	}
	public short getSwitchRFCQMinAutomaticMatchingTimeout()
	{
		return SwitchRFCQMinAutomaticMatchingTimeout;
	}
	public void setSwitchRFCQMinAutomaticMatchingTimeout(short value)
	{
		SwitchRFCQMinAutomaticMatchingTimeout = value;
	}
	public short getSwitchRFCQAcceptanceTimeout()
	{
		return SwitchRFCQAcceptanceTimeout;
	}
	public void setSwitchRFCQAcceptanceTimeout(short value)
	{
		SwitchRFCQAcceptanceTimeout = value;
	}
	public long getButterflyRFCQTimer()
	{
		return ButterflyRFCQTimer;
	}
	public void setButterflyRFCQTimer(long value)
	{
		ButterflyRFCQTimer = value;
	}
	public short getButterflyRFCQMaxNumRecipients()
	{
		return ButterflyRFCQMaxNumRecipients;
	}
	public void setButterflyRFCQMaxNumRecipients(short value)
	{
		ButterflyRFCQMaxNumRecipients = value;
	}
	public short getButterflyRFCQAuditTrailDelay()
	{
		return ButterflyRFCQAuditTrailDelay;
	}
	public void setButterflyRFCQAuditTrailDelay(short value)
	{
		ButterflyRFCQAuditTrailDelay = value;
	}
	public short getButterflyRFCQMinAutomaticMatchingTimeout()
	{
		return ButterflyRFCQMinAutomaticMatchingTimeout;
	}
	public void setButterflyRFCQMinAutomaticMatchingTimeout(short value)
	{
		ButterflyRFCQMinAutomaticMatchingTimeout = value;
	}
	public short getButterflyRFCQAcceptanceTimeout()
	{
		return ButterflyRFCQAcceptanceTimeout;
	}
	public void setButterflyRFCQAcceptanceTimeout(short value)
	{
		ButterflyRFCQAcceptanceTimeout = value;
	}
	public short getMultiLegRFCQMaxNumLegs()
	{
		return MultiLegRFCQMaxNumLegs;
	}
	public void setMultiLegRFCQMaxNumLegs(short value)
	{
		MultiLegRFCQMaxNumLegs = value;
	}
	public short getMultiLegRFCQMaxDueInTime()
	{
		return MultiLegRFCQMaxDueInTime;
	}
	public void setMultiLegRFCQMaxDueInTime(short value)
	{
		MultiLegRFCQMaxDueInTime = value;
	}
	public long getMultilegRFCQTimer()
	{
		return MultilegRFCQTimer;
	}
	public void setMultilegRFCQTimer(long value)
	{
		MultilegRFCQTimer = value;
	}
	public short getMultilegRFCQMaxNumRecipients()
	{
		return MultilegRFCQMaxNumRecipients;
	}
	public void setMultilegRFCQMaxNumRecipients(short value)
	{
		MultilegRFCQMaxNumRecipients = value;
	}
	public short getMultilegRFCQAuditTrailDelay()
	{
		return MultilegRFCQAuditTrailDelay;
	}
	public void setMultilegRFCQAuditTrailDelay(short value)
	{
		MultilegRFCQAuditTrailDelay = value;
	}
	public short getMultilegRFCQMinAutomaticMatchingTimeout()
	{
		return MultilegRFCQMinAutomaticMatchingTimeout;
	}
	public void setMultilegRFCQMinAutomaticMatchingTimeout(short value)
	{
		MultilegRFCQMinAutomaticMatchingTimeout = value;
	}
	public short getMultilegRFCQAcceptanceTimeout()
	{
		return MultilegRFCQAcceptanceTimeout;
	}
	public void setMultilegRFCQAcceptanceTimeout(short value)
	{
		MultilegRFCQAcceptanceTimeout = value;
	}
	public long getDoubleSidedRFCQTimer()
	{
		return DoubleSidedRFCQTimer;
	}
	public void setDoubleSidedRFCQTimer(long value)
	{
		DoubleSidedRFCQTimer = value;
	}
	public short getDoubleSidedRFCQMaxNumRecipients()
	{
		return DoubleSidedRFCQMaxNumRecipients;
	}
	public void setDoubleSidedRFCQMaxNumRecipients(short value)
	{
		DoubleSidedRFCQMaxNumRecipients = value;
	}
	public short getDoubleSidedRFCQAuditTrailDelay()
	{
		return DoubleSidedRFCQAuditTrailDelay;
	}
	public void setDoubleSidedRFCQAuditTrailDelay(short value)
	{
		DoubleSidedRFCQAuditTrailDelay = value;
	}
	public short getDoubleSidedRFCQMinAutomaticMatchingTimeout()
	{
		return DoubleSidedRFCQMinAutomaticMatchingTimeout;
	}
	public void setDoubleSidedRFCQMinAutomaticMatchingTimeout(short value)
	{
		DoubleSidedRFCQMinAutomaticMatchingTimeout = value;
	}
	public short getDoubleSidedRFCQAcceptanceTimeout()
	{
		return DoubleSidedRFCQAcceptanceTimeout;
	}
	public void setDoubleSidedRFCQAcceptanceTimeout(short value)
	{
		DoubleSidedRFCQAcceptanceTimeout = value;
	}
	public TI_FLAG_Enum getDoubleSidedRFCQDoubleAutoAcceptanceFg()
	{
		return DoubleSidedRFCQDoubleAutoAcceptanceFg;
	}
	public void setDoubleSidedRFCQDoubleAutoAcceptanceFg(TI_FLAG_Enum value)
	{
		DoubleSidedRFCQDoubleAutoAcceptanceFg = value;
	}
	public short getMaxNumInventoryGroups()
	{
		return MaxNumInventoryGroups;
	}
	public void setMaxNumInventoryGroups(short value)
	{
		MaxNumInventoryGroups = value;
	}
	public short getMaxNumMemberPerInventoryGroup()
	{
		return MaxNumMemberPerInventoryGroup;
	}
	public void setMaxNumMemberPerInventoryGroup(short value)
	{
		MaxNumMemberPerInventoryGroup = value;
	}
	public short getMaxNumInventoryGroupConfigurations()
	{
		return MaxNumInventoryGroupConfigurations;
	}
	public void setMaxNumInventoryGroupConfigurations(short value)
	{
		MaxNumInventoryGroupConfigurations = value;
	}
	public short getMaxNumInventoryGroupExceptions()
	{
		return MaxNumInventoryGroupExceptions;
	}
	public void setMaxNumInventoryGroupExceptions(short value)
	{
		MaxNumInventoryGroupExceptions = value;
	}
	public long getSwitchRFCQPreTradeTransparencyMinTime()
	{
		return SwitchRFCQPreTradeTransparencyMinTime;
	}
	public void setSwitchRFCQPreTradeTransparencyMinTime(long value)
	{
		SwitchRFCQPreTradeTransparencyMinTime = value;
	}
	public long getSwitchRFCQPreTradeTransparencyMaxTime()
	{
		return SwitchRFCQPreTradeTransparencyMaxTime;
	}
	public void setSwitchRFCQPreTradeTransparencyMaxTime(long value)
	{
		SwitchRFCQPreTradeTransparencyMaxTime = value;
	}
	public long getButterflyRFCQPreTradeTransparencyMinTime()
	{
		return ButterflyRFCQPreTradeTransparencyMinTime;
	}
	public void setButterflyRFCQPreTradeTransparencyMinTime(long value)
	{
		ButterflyRFCQPreTradeTransparencyMinTime = value;
	}
	public long getButterflyRFCQPreTradeTransparencyMaxTime()
	{
		return ButterflyRFCQPreTradeTransparencyMaxTime;
	}
	public void setButterflyRFCQPreTradeTransparencyMaxTime(long value)
	{
		ButterflyRFCQPreTradeTransparencyMaxTime = value;
	}
	public long getMultilegRFCQPreTradeTransparencyMinTime()
	{
		return MultilegRFCQPreTradeTransparencyMinTime;
	}
	public void setMultilegRFCQPreTradeTransparencyMinTime(long value)
	{
		MultilegRFCQPreTradeTransparencyMinTime = value;
	}
	public long getMultilegRFCQPreTradeTransparencyMaxTime()
	{
		return MultilegRFCQPreTradeTransparencyMaxTime;
	}
	public void setMultilegRFCQPreTradeTransparencyMaxTime(long value)
	{
		MultilegRFCQPreTradeTransparencyMaxTime = value;
	}
	public long getDoubleSidedRFCQPreTradeTransparencyMinTime()
	{
		return DoubleSidedRFCQPreTradeTransparencyMinTime;
	}
	public void setDoubleSidedRFCQPreTradeTransparencyMinTime(long value)
	{
		DoubleSidedRFCQPreTradeTransparencyMinTime = value;
	}
	public long getDoubleSidedRFCQPreTradeTransparencyMaxTime()
	{
		return DoubleSidedRFCQPreTradeTransparencyMaxTime;
	}
	public void setDoubleSidedRFCQPreTradeTransparencyMaxTime(long value)
	{
		DoubleSidedRFCQPreTradeTransparencyMaxTime = value;
	}
	public short getPortfolioRFCQTimer()
	{
		return PortfolioRFCQTimer;
	}
	public void setPortfolioRFCQTimer(short value)
	{
		PortfolioRFCQTimer = value;
	}
	public short getPortfolioRFCQAcceptanceTimeout()
	{
		return PortfolioRFCQAcceptanceTimeout;
	}
	public void setPortfolioRFCQAcceptanceTimeout(short value)
	{
		PortfolioRFCQAcceptanceTimeout = value;
	}
	public short getPortfolioRFCQDueInTime()
	{
		return PortfolioRFCQDueInTime;
	}
	public void setPortfolioRFCQDueInTime(short value)
	{
		PortfolioRFCQDueInTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SwitchRFCQTimer = (long)byteBuffer.readInt();
		SwitchRFCQMaxNumRecipients = (short)byteBuffer.readInt();
		SwitchRFCQAuditTrailDelay = (short)byteBuffer.readInt();
		SwitchRFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		SwitchRFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		ButterflyRFCQTimer = (long)byteBuffer.readInt();
		ButterflyRFCQMaxNumRecipients = (short)byteBuffer.readInt();
		ButterflyRFCQAuditTrailDelay = (short)byteBuffer.readInt();
		ButterflyRFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		ButterflyRFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		MultiLegRFCQMaxNumLegs = (short)byteBuffer.readInt();
		MultiLegRFCQMaxDueInTime = (short)byteBuffer.readInt();
		MultilegRFCQTimer = (long)byteBuffer.readInt();
		MultilegRFCQMaxNumRecipients = (short)byteBuffer.readInt();
		MultilegRFCQAuditTrailDelay = (short)byteBuffer.readInt();
		MultilegRFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		MultilegRFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		DoubleSidedRFCQTimer = (long)byteBuffer.readInt();
		DoubleSidedRFCQMaxNumRecipients = (short)byteBuffer.readInt();
		DoubleSidedRFCQAuditTrailDelay = (short)byteBuffer.readInt();
		DoubleSidedRFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		DoubleSidedRFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		DoubleSidedRFCQDoubleAutoAcceptanceFg = DoubleSidedRFCQDoubleAutoAcceptanceFg.getEnum(byteBuffer.readInt());
		MaxNumInventoryGroups = (short)byteBuffer.readInt();
		MaxNumMemberPerInventoryGroup = (short)byteBuffer.readInt();
		MaxNumInventoryGroupConfigurations = (short)byteBuffer.readInt();
		MaxNumInventoryGroupExceptions = (short)byteBuffer.readInt();
		SwitchRFCQPreTradeTransparencyMinTime = (long)byteBuffer.readInt();
		SwitchRFCQPreTradeTransparencyMaxTime = (long)byteBuffer.readInt();
		ButterflyRFCQPreTradeTransparencyMinTime = (long)byteBuffer.readInt();
		ButterflyRFCQPreTradeTransparencyMaxTime = (long)byteBuffer.readInt();
		MultilegRFCQPreTradeTransparencyMinTime = (long)byteBuffer.readInt();
		MultilegRFCQPreTradeTransparencyMaxTime = (long)byteBuffer.readInt();
		DoubleSidedRFCQPreTradeTransparencyMinTime = (long)byteBuffer.readInt();
		DoubleSidedRFCQPreTradeTransparencyMaxTime = (long)byteBuffer.readInt();
		PortfolioRFCQTimer = (short)byteBuffer.readInt();
		PortfolioRFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		PortfolioRFCQDueInTime = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQAuditTrailDelay & 0xFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQAuditTrailDelay & 0xFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(MultiLegRFCQMaxNumLegs & 0xFFFFL));
		byteBuffer.writeInt((int)(MultiLegRFCQMaxDueInTime & 0xFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQAuditTrailDelay & 0xFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQAuditTrailDelay & 0xFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt(DoubleSidedRFCQDoubleAutoAcceptanceFg.getValue());
		byteBuffer.writeInt((int)(MaxNumInventoryGroups & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxNumMemberPerInventoryGroup & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxNumInventoryGroupConfigurations & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxNumInventoryGroupExceptions & 0xFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQPreTradeTransparencyMinTime & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQPreTradeTransparencyMaxTime & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQPreTradeTransparencyMinTime & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQPreTradeTransparencyMaxTime & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQPreTradeTransparencyMinTime & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQPreTradeTransparencyMaxTime & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQPreTradeTransparencyMinTime & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQPreTradeTransparencyMaxTime & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(PortfolioRFCQTimer & 0xFFFFL));
		byteBuffer.writeInt((int)(PortfolioRFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(PortfolioRFCQDueInTime & 0xFFFFL));

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
		stringBuilder.append("BV_MARKET::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SwitchRFCQTimer(").append(SwitchRFCQTimer).append(")");
		stringBuilder.append("SwitchRFCQMaxNumRecipients(").append(SwitchRFCQMaxNumRecipients).append(")");
		stringBuilder.append("SwitchRFCQAuditTrailDelay(").append(SwitchRFCQAuditTrailDelay).append(")");
		stringBuilder.append("SwitchRFCQMinAutomaticMatchingTimeout(").append(SwitchRFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("SwitchRFCQAcceptanceTimeout(").append(SwitchRFCQAcceptanceTimeout).append(")");
		stringBuilder.append("ButterflyRFCQTimer(").append(ButterflyRFCQTimer).append(")");
		stringBuilder.append("ButterflyRFCQMaxNumRecipients(").append(ButterflyRFCQMaxNumRecipients).append(")");
		stringBuilder.append("ButterflyRFCQAuditTrailDelay(").append(ButterflyRFCQAuditTrailDelay).append(")");
		stringBuilder.append("ButterflyRFCQMinAutomaticMatchingTimeout(").append(ButterflyRFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("ButterflyRFCQAcceptanceTimeout(").append(ButterflyRFCQAcceptanceTimeout).append(")");
		stringBuilder.append("MultiLegRFCQMaxNumLegs(").append(MultiLegRFCQMaxNumLegs).append(")");
		stringBuilder.append("MultiLegRFCQMaxDueInTime(").append(MultiLegRFCQMaxDueInTime).append(")");
		stringBuilder.append("MultilegRFCQTimer(").append(MultilegRFCQTimer).append(")");
		stringBuilder.append("MultilegRFCQMaxNumRecipients(").append(MultilegRFCQMaxNumRecipients).append(")");
		stringBuilder.append("MultilegRFCQAuditTrailDelay(").append(MultilegRFCQAuditTrailDelay).append(")");
		stringBuilder.append("MultilegRFCQMinAutomaticMatchingTimeout(").append(MultilegRFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("MultilegRFCQAcceptanceTimeout(").append(MultilegRFCQAcceptanceTimeout).append(")");
		stringBuilder.append("DoubleSidedRFCQTimer(").append(DoubleSidedRFCQTimer).append(")");
		stringBuilder.append("DoubleSidedRFCQMaxNumRecipients(").append(DoubleSidedRFCQMaxNumRecipients).append(")");
		stringBuilder.append("DoubleSidedRFCQAuditTrailDelay(").append(DoubleSidedRFCQAuditTrailDelay).append(")");
		stringBuilder.append("DoubleSidedRFCQMinAutomaticMatchingTimeout(").append(DoubleSidedRFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("DoubleSidedRFCQAcceptanceTimeout(").append(DoubleSidedRFCQAcceptanceTimeout).append(")");
		stringBuilder.append("DoubleSidedRFCQDoubleAutoAcceptanceFg(").append(DoubleSidedRFCQDoubleAutoAcceptanceFg).append(")");
		stringBuilder.append("MaxNumInventoryGroups(").append(MaxNumInventoryGroups).append(")");
		stringBuilder.append("MaxNumMemberPerInventoryGroup(").append(MaxNumMemberPerInventoryGroup).append(")");
		stringBuilder.append("MaxNumInventoryGroupConfigurations(").append(MaxNumInventoryGroupConfigurations).append(")");
		stringBuilder.append("MaxNumInventoryGroupExceptions(").append(MaxNumInventoryGroupExceptions).append(")");
		stringBuilder.append("SwitchRFCQPreTradeTransparencyMinTime(").append(SwitchRFCQPreTradeTransparencyMinTime).append(")");
		stringBuilder.append("SwitchRFCQPreTradeTransparencyMaxTime(").append(SwitchRFCQPreTradeTransparencyMaxTime).append(")");
		stringBuilder.append("ButterflyRFCQPreTradeTransparencyMinTime(").append(ButterflyRFCQPreTradeTransparencyMinTime).append(")");
		stringBuilder.append("ButterflyRFCQPreTradeTransparencyMaxTime(").append(ButterflyRFCQPreTradeTransparencyMaxTime).append(")");
		stringBuilder.append("MultilegRFCQPreTradeTransparencyMinTime(").append(MultilegRFCQPreTradeTransparencyMinTime).append(")");
		stringBuilder.append("MultilegRFCQPreTradeTransparencyMaxTime(").append(MultilegRFCQPreTradeTransparencyMaxTime).append(")");
		stringBuilder.append("DoubleSidedRFCQPreTradeTransparencyMinTime(").append(DoubleSidedRFCQPreTradeTransparencyMinTime).append(")");
		stringBuilder.append("DoubleSidedRFCQPreTradeTransparencyMaxTime(").append(DoubleSidedRFCQPreTradeTransparencyMaxTime).append(")");
		stringBuilder.append("PortfolioRFCQTimer(").append(PortfolioRFCQTimer).append(")");
		stringBuilder.append("PortfolioRFCQAcceptanceTimeout(").append(PortfolioRFCQAcceptanceTimeout).append(")");
		stringBuilder.append("PortfolioRFCQDueInTime(").append(PortfolioRFCQDueInTime).append(")");
		return stringBuilder.toString();
	}
}

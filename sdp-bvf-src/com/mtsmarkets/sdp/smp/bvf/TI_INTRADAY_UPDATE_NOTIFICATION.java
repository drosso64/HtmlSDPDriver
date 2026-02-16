package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INTRADAY_UPDATE_NOTIFICATION extends SMPMessage
{
	public static final long CLASS_ID = 100236;

	private long MarketId = 0;
	private long EntityId = 0;
	private TI_INTRADAY_UPDATE_ENTITY_TYPE_Enum EntityType = TI_INTRADAY_UPDATE_ENTITY_TYPE_Enum.TI_INTRADAY_UPDATE_ENTITY_TYPE_FinancialInstrument;
	private TI_INTRADAY_UPDATE_NOTIFICATION_TYPE_Enum NotificationType = TI_INTRADAY_UPDATE_NOTIFICATION_TYPE_Enum.TI_INTRADAY_UPDATE_NOTIFICATION_TYPE_Start;
	private TI_INTRADAY_UPDATE_TYPE_Enum UpdateType = TI_INTRADAY_UPDATE_TYPE_Enum.TI_INTRADAY_UPDATE_TYPE_Add;
	private long UpdateTime = 0;

	public TI_INTRADAY_UPDATE_NOTIFICATION()
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
	public long getEntityId()
	{
		return EntityId;
	}
	public void setEntityId(long value)
	{
		EntityId = value;
	}
	public TI_INTRADAY_UPDATE_ENTITY_TYPE_Enum getEntityType()
	{
		return EntityType;
	}
	public void setEntityType(TI_INTRADAY_UPDATE_ENTITY_TYPE_Enum value)
	{
		EntityType = value;
	}
	public TI_INTRADAY_UPDATE_NOTIFICATION_TYPE_Enum getNotificationType()
	{
		return NotificationType;
	}
	public void setNotificationType(TI_INTRADAY_UPDATE_NOTIFICATION_TYPE_Enum value)
	{
		NotificationType = value;
	}
	public TI_INTRADAY_UPDATE_TYPE_Enum getUpdateType()
	{
		return UpdateType;
	}
	public void setUpdateType(TI_INTRADAY_UPDATE_TYPE_Enum value)
	{
		UpdateType = value;
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
		MarketId = (long)byteBuffer.readInt();
		EntityId = (long)byteBuffer.readInt();
		EntityType = EntityType.getEnum(byteBuffer.readInt());
		NotificationType = NotificationType.getEnum(byteBuffer.readInt());
		UpdateType = UpdateType.getEnum(byteBuffer.readInt());
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EntityId & 0xFFFFFFFFL));
		byteBuffer.writeInt(EntityType.getValue());
		byteBuffer.writeInt(NotificationType.getValue());
		byteBuffer.writeInt(UpdateType.getValue());
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
		stringBuilder.append("TI_INTRADAY_UPDATE_NOTIFICATION::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("EntityId(").append(EntityId).append(")");
		stringBuilder.append("EntityType(").append(EntityType).append(")");
		stringBuilder.append("NotificationType(").append(NotificationType).append(")");
		stringBuilder.append("UpdateType(").append(UpdateType).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}

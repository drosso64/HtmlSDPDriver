package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_SETTL_GROUP_INFO extends SMPMessage
{
	public static final long CLASS_ID = 100029;

	private long SettlGroupId = 0;
	private long MarketId = 0;
	private String SettlGroupCode = "";
	private String SettlGroupDesc = "";
	private TI_SETTL_TYPE_Enum SettlType = TI_SETTL_TYPE_Enum.TI_SETTL_TYPE_Manual;
	private long SettlCalendarId = 0;
	private TI_FLAG_Enum SameDaySettleFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_SETTLEMENT_MODE_Enum SettlementMode = TI_SETTLEMENT_MODE_Enum.TI_SETTLEMENT_MODE_None;

	public TI_SETTL_GROUP_INFO()
	{
	}

	public long getSettlGroupId()
	{
		return SettlGroupId;
	}
	public void setSettlGroupId(long value)
	{
		SettlGroupId = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public String getSettlGroupCode()
	{
		return SettlGroupCode;
	}
	public void setSettlGroupCode(String value)
	{
		SettlGroupCode = value;
	}
	public String getSettlGroupDesc()
	{
		return SettlGroupDesc;
	}
	public void setSettlGroupDesc(String value)
	{
		SettlGroupDesc = value;
	}
	public TI_SETTL_TYPE_Enum getSettlType()
	{
		return SettlType;
	}
	public void setSettlType(TI_SETTL_TYPE_Enum value)
	{
		SettlType = value;
	}
	public long getSettlCalendarId()
	{
		return SettlCalendarId;
	}
	public void setSettlCalendarId(long value)
	{
		SettlCalendarId = value;
	}
	public TI_FLAG_Enum getSameDaySettleFg()
	{
		return SameDaySettleFg;
	}
	public void setSameDaySettleFg(TI_FLAG_Enum value)
	{
		SameDaySettleFg = value;
	}
	public TI_SETTLEMENT_MODE_Enum getSettlementMode()
	{
		return SettlementMode;
	}
	public void setSettlementMode(TI_SETTLEMENT_MODE_Enum value)
	{
		SettlementMode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SettlGroupId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		SettlGroupCode = byteBuffer.readString();
		SettlGroupDesc = byteBuffer.readString();
		SettlType = SettlType.getEnum(byteBuffer.readInt());
		SettlCalendarId = (long)byteBuffer.readInt();
		SameDaySettleFg = SameDaySettleFg.getEnum(byteBuffer.readInt());
		SettlementMode = SettlementMode.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SettlGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeString(SettlGroupCode);
		byteBuffer.writeString(SettlGroupDesc);
		byteBuffer.writeInt(SettlType.getValue());
		byteBuffer.writeInt((int)(SettlCalendarId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SameDaySettleFg.getValue());
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
		stringBuilder.append("TI_SETTL_GROUP_INFO::");
		stringBuilder.append("SettlGroupId(").append(SettlGroupId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SettlGroupCode(").append(SettlGroupCode).append(")");
		stringBuilder.append("SettlGroupDesc(").append(SettlGroupDesc).append(")");
		stringBuilder.append("SettlType(").append(SettlType).append(")");
		stringBuilder.append("SettlCalendarId(").append(SettlCalendarId).append(")");
		stringBuilder.append("SameDaySettleFg(").append(SameDaySettleFg).append(")");
		stringBuilder.append("SettlementMode(").append(SettlementMode).append(")");
		return stringBuilder.toString();
	}
}

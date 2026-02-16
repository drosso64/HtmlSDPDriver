package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_SETTL_SYSTEM extends SMPMessage
{
	public static final long CLASS_ID = 100028;

	private long SettlSystemId = 0;
	private String SettlSystemDesc = "";
	private TI_FLAG_Enum ClearingHouseFlag = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum ManageOpenDatesFlag = TI_FLAG_Enum.TI_FLAG_No;

	public TI_SETTL_SYSTEM()
	{
	}

	public long getSettlSystemId()
	{
		return SettlSystemId;
	}
	public void setSettlSystemId(long value)
	{
		SettlSystemId = value;
	}
	public String getSettlSystemDesc()
	{
		return SettlSystemDesc;
	}
	public void setSettlSystemDesc(String value)
	{
		SettlSystemDesc = value;
	}
	public TI_FLAG_Enum getClearingHouseFlag()
	{
		return ClearingHouseFlag;
	}
	public void setClearingHouseFlag(TI_FLAG_Enum value)
	{
		ClearingHouseFlag = value;
	}
	public TI_FLAG_Enum getManageOpenDatesFlag()
	{
		return ManageOpenDatesFlag;
	}
	public void setManageOpenDatesFlag(TI_FLAG_Enum value)
	{
		ManageOpenDatesFlag = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SettlSystemId = (long)byteBuffer.readInt();
		SettlSystemDesc = byteBuffer.readString();
		ClearingHouseFlag = ClearingHouseFlag.getEnum(byteBuffer.readInt());
		ManageOpenDatesFlag = ManageOpenDatesFlag.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SettlSystemId & 0xFFFFFFFFL));
		byteBuffer.writeString(SettlSystemDesc);
		byteBuffer.writeInt(ClearingHouseFlag.getValue());
		byteBuffer.writeInt(ManageOpenDatesFlag.getValue());

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
		stringBuilder.append("TI_SETTL_SYSTEM::");
		stringBuilder.append("SettlSystemId(").append(SettlSystemId).append(")");
		stringBuilder.append("SettlSystemDesc(").append(SettlSystemDesc).append(")");
		stringBuilder.append("ClearingHouseFlag(").append(ClearingHouseFlag).append(")");
		stringBuilder.append("ManageOpenDatesFlag(").append(ManageOpenDatesFlag).append(")");
		return stringBuilder.toString();
	}
}

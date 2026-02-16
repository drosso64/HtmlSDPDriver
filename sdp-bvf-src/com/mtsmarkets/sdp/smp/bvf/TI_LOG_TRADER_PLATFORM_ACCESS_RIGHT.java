package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_LOG_TRADER_PLATFORM_ACCESS_RIGHT extends SMPMessage
{
	public static final long CLASS_ID = 100843;

	private TI_TRADER_PLATFORM_ACCESS_RIGHT Info = new TI_TRADER_PLATFORM_ACCESS_RIGHT();
	private TI_FLAG_Enum DeletedFg = TI_FLAG_Enum.TI_FLAG_No;

	public TI_LOG_TRADER_PLATFORM_ACCESS_RIGHT()
	{
	}

	public TI_TRADER_PLATFORM_ACCESS_RIGHT getInfo()
	{
		return Info;
	}
	public void setInfo(TI_TRADER_PLATFORM_ACCESS_RIGHT value)
	{
		Info = value;
	}
	public TI_FLAG_Enum getDeletedFg()
	{
		return DeletedFg;
	}
	public void setDeletedFg(TI_FLAG_Enum value)
	{
		DeletedFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Info.readXDR(byteBuffer);
		DeletedFg = DeletedFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Info.writeXDR(byteBuffer);
		byteBuffer.writeInt(DeletedFg.getValue());

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
		stringBuilder.append("TI_LOG_TRADER_PLATFORM_ACCESS_RIGHT::");
		stringBuilder.append("Info(").append(Info.toString()).append(")");
		stringBuilder.append("DeletedFg(").append(DeletedFg).append(")");
		return stringBuilder.toString();
	}
}

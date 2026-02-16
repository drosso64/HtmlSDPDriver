package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_LOG_TRADER extends SMPMessage
{
	public static final long CLASS_ID = 100842;

	private TI_TRADER Info = new TI_TRADER();
	private TI_FLAG_Enum DeletedFg = TI_FLAG_Enum.TI_FLAG_No;

	public TI_LOG_TRADER()
	{
	}

	public TI_TRADER getInfo()
	{
		return Info;
	}
	public void setInfo(TI_TRADER value)
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
		stringBuilder.append("TI_LOG_TRADER::");
		stringBuilder.append("Info(").append(Info.toString()).append(")");
		stringBuilder.append("DeletedFg(").append(DeletedFg).append(")");
		return stringBuilder.toString();
	}
}

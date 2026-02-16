package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_COUPON_PLAN extends SMPMessage
{
	public static final long CLASS_ID = 170035;

	private TI_COUPON_PLAN DF = new TI_COUPON_PLAN();
	private TI_FLAG_Enum DeletedFg = TI_FLAG_Enum.TI_FLAG_No;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public DF_TI_COUPON_PLAN()
	{
	}

	public TI_COUPON_PLAN getDF()
	{
		return DF;
	}
	public void setDF(TI_COUPON_PLAN value)
	{
		DF = value;
	}
	public TI_FLAG_Enum getDeletedFg()
	{
		return DeletedFg;
	}
	public void setDeletedFg(TI_FLAG_Enum value)
	{
		DeletedFg = value;
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
		DF.readXDR(byteBuffer);
		DeletedFg = DeletedFg.getEnum(byteBuffer.readInt());
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DF.writeXDR(byteBuffer);
		byteBuffer.writeInt(DeletedFg.getValue());
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
		stringBuilder.append("DF_TI_COUPON_PLAN::");
		stringBuilder.append("DF(").append(DF.toString()).append(")");
		stringBuilder.append("DeletedFg(").append(DeletedFg).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}

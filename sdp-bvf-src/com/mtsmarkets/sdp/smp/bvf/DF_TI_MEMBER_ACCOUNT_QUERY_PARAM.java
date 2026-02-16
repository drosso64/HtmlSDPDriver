package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_MEMBER_ACCOUNT_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 170023;

	private TI_QUERY_OP_Enum OwnerIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long OwnerId = 0;

	public DF_TI_MEMBER_ACCOUNT_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getOwnerIdOp()
	{
		return OwnerIdOp;
	}
	public void setOwnerIdOp(TI_QUERY_OP_Enum value)
	{
		OwnerIdOp = value;
	}
	public long getOwnerId()
	{
		return OwnerId;
	}
	public void setOwnerId(long value)
	{
		OwnerId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		OwnerIdOp = OwnerIdOp.getEnum(byteBuffer.readInt());
		OwnerId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(OwnerIdOp.getValue());
		byteBuffer.writeInt((int)(OwnerId & 0xFFFFFFFFL));

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
		stringBuilder.append("DF_TI_MEMBER_ACCOUNT_QUERY_PARAM::");
		stringBuilder.append("OwnerIdOp(").append(OwnerIdOp).append(")");
		stringBuilder.append("OwnerId(").append(OwnerId).append(")");
		return stringBuilder.toString();
	}
}

package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_TRADER_GROUPS extends SMPMessage
{
	public static final long CLASS_ID = 100042;

	private long MemberId = 0;
	private long GroupId = 0;
	private String GroupName = "";
	private long ParentGroupId = 0;

	public TI_TRADER_GROUPS()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getGroupId()
	{
		return GroupId;
	}
	public void setGroupId(long value)
	{
		GroupId = value;
	}
	public String getGroupName()
	{
		return GroupName;
	}
	public void setGroupName(String value)
	{
		GroupName = value;
	}
	public long getParentGroupId()
	{
		return ParentGroupId;
	}
	public void setParentGroupId(long value)
	{
		ParentGroupId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		GroupId = (long)byteBuffer.readInt();
		GroupName = byteBuffer.readString();
		ParentGroupId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(GroupId & 0xFFFFFFFFL));
		byteBuffer.writeString(GroupName);
		byteBuffer.writeInt((int)(ParentGroupId & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_TRADER_GROUPS::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		stringBuilder.append("GroupName(").append(GroupName).append(")");
		stringBuilder.append("ParentGroupId(").append(ParentGroupId).append(")");
		return stringBuilder.toString();
	}
}

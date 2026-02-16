package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MKT_AFFILIATION extends SMPMessage
{
	public static final long CLASS_ID = 100222;

	private short MktAffiliationId = 0;
	private short AreaCodeId = 0;
	private String MktAffiliationShortDesc = "";
	private String MktAffiliationDesc = "";

	public BV_MKT_AFFILIATION()
	{
	}

	public short getMktAffiliationId()
	{
		return MktAffiliationId;
	}
	public void setMktAffiliationId(short value)
	{
		MktAffiliationId = value;
	}
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public String getMktAffiliationShortDesc()
	{
		return MktAffiliationShortDesc;
	}
	public void setMktAffiliationShortDesc(String value)
	{
		MktAffiliationShortDesc = value;
	}
	public String getMktAffiliationDesc()
	{
		return MktAffiliationDesc;
	}
	public void setMktAffiliationDesc(String value)
	{
		MktAffiliationDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MktAffiliationId = (short)byteBuffer.readInt();
		AreaCodeId = (short)byteBuffer.readInt();
		MktAffiliationShortDesc = byteBuffer.readString();
		MktAffiliationDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MktAffiliationId & 0xFFFFL));
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeString(MktAffiliationShortDesc);
		byteBuffer.writeString(MktAffiliationDesc);

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
		stringBuilder.append("BV_MKT_AFFILIATION::");
		stringBuilder.append("MktAffiliationId(").append(MktAffiliationId).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("MktAffiliationShortDesc(").append(MktAffiliationShortDesc).append(")");
		stringBuilder.append("MktAffiliationDesc(").append(MktAffiliationDesc).append(")");
		return stringBuilder.toString();
	}
}

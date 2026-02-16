package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RATING_CATEGORY extends SMPMessage
{
	public static final long CLASS_ID = 400103;

	private long RatingCategoryId = 0;
	private String RatingCategoryShortDesc = "";
	private String RatingCategoryDescription = "";

	public BV_RATING_CATEGORY()
	{
	}

	public long getRatingCategoryId()
	{
		return RatingCategoryId;
	}
	public void setRatingCategoryId(long value)
	{
		RatingCategoryId = value;
	}
	public String getRatingCategoryShortDesc()
	{
		return RatingCategoryShortDesc;
	}
	public void setRatingCategoryShortDesc(String value)
	{
		RatingCategoryShortDesc = value;
	}
	public String getRatingCategoryDescription()
	{
		return RatingCategoryDescription;
	}
	public void setRatingCategoryDescription(String value)
	{
		RatingCategoryDescription = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RatingCategoryId = (long)byteBuffer.readInt();
		RatingCategoryShortDesc = byteBuffer.readString();
		RatingCategoryDescription = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RatingCategoryId & 0xFFFFFFFFL));
		byteBuffer.writeString(RatingCategoryShortDesc);
		byteBuffer.writeString(RatingCategoryDescription);

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
		stringBuilder.append("BV_RATING_CATEGORY::");
		stringBuilder.append("RatingCategoryId(").append(RatingCategoryId).append(")");
		stringBuilder.append("RatingCategoryShortDesc(").append(RatingCategoryShortDesc).append(")");
		stringBuilder.append("RatingCategoryDescription(").append(RatingCategoryDescription).append(")");
		return stringBuilder.toString();
	}
}

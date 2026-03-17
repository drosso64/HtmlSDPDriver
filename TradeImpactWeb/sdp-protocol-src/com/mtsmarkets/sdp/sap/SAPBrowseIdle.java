package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPBrowseIdle extends SAPMessage

{

	public static final int  MSG_TYPE = 262;



	private ULong classId = new ULong(0);

	private ULong browseKey = new ULong(0);



	public SAPBrowseIdle(SAPHeader sapHeader)

	{

		super(sapHeader);

	}

	public ULong getClassId()

	{

		return classId;

	}

	public void setClassId(ULong classId)

	{

		this.classId = classId;

	}

	public ULong getBrowseKey()

	{

		return browseKey;

	}

	public void setBrowseKey(ULong browseKey)

	{

		this.browseKey = browseKey;

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception

	{

		classId.setValue(byteBuff.readInt());

		browseKey.setValue(byteBuff.readInt());

	}

	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception

	{

		throw new Exception("SAPBrowseIdle can be only read from client side");

	}

	@Override

	public String toString()

	{

		StringBuilder str = new StringBuilder()

			.append("SAPBrowseIdle::")

			.append("ClassID(").append(classId.getValue()).append(")")

			.append("BrowseKey(").append(browseKey.getValue()).append(")");

		return str.toString();

	}

}


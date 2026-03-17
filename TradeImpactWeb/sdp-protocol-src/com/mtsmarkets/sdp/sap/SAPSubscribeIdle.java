package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPSubscribeIdle extends SAPMessage

{

	public static final int  MSG_TYPE = 225;



	private ULong classId = new ULong(0);

	private ULong subscribeKey = new ULong(0);



	public SAPSubscribeIdle(SAPHeader sapHeader)

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

	public ULong getSubscribeKey()

	{

		return subscribeKey;

	}

	public void setSubscribeKey(ULong subscribeKey)

	{

		this.subscribeKey = subscribeKey;

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception

	{

		classId.setValue(byteBuff.readInt());

		subscribeKey.setValue(byteBuff.readInt());

	}

	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception

	{

		throw new Exception("SAPSubscribeIdle can be only read from client side");

	}

	@Override

	public String toString()

	{

		StringBuilder str = new StringBuilder()

			.append("SAPSubscribeIdle::")

			.append("ClassID(").append(classId.getValue()).append(")")

			.append("SubscribeKey(").append(subscribeKey.getValue()).append(")");

		return str.toString();

	}

}


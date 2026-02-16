package com.mtsmarkets.sdp.sap;



import java.io.Serializable;



import com.mtsmarkets.io.xdr.ULong;

import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPHeader implements Serializable

{

	private ULong msgType = new ULong(0);



	public SAPHeader()

	{

	}

	public SAPHeader(long msgType)

	{

		this.msgType.setValue(msgType);

	}

	public int size()

	{

		return 8;

	}

	public void readXDR(XDRByteBuffer byteBuff) throws Exception

	{

		msgType.setValue(byteBuff.readInt());

	}

	public void writeXDR(XDRByteBuffer byteBuff) throws Exception

	{

		byteBuff.writeInt((int) msgType.getValue());

	}

	public ULong getMsgType()

	{

		return msgType;

	}

	public void setMsgType(ULong msg_type)

	{

		this.msgType = msg_type;

	}

	public void setMsg_type(long msg_type) 

	{

		this.msgType.setValue(msg_type);

	}

}


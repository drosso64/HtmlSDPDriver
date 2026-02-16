package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPErrorMsg extends SAPMessage

{

	public static final int  MSG_TYPE = 214;

	

	public enum ErrorCode

	{

		InvalidRequest(1);

		private int errorCodeValue;

		

		int value() {return errorCodeValue;}

		void setValue(int value) {errorCodeValue = value;}

		ErrorCode(int value)

		{

			errorCodeValue = value;

		}

	}

	

	protected ErrorCode errorCode = ErrorCode.InvalidRequest;

	protected String errorString = "";



	public SAPErrorMsg(SAPHeader sapHeader)

	{

		super(sapHeader);

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {

		errorCode.setValue(byteBuff.readInt());

		errorString = byteBuff.readString();

	}



	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {

		int init = byteBuff.getByteBuff().position();

		// header pdu

		sapHeader.writeXDR(byteBuff);

		// body pdu

		byteBuff.writeInt(errorCode.value());

		byteBuff.writeString(errorString);

		return byteBuff.getByteBuff().position() - init;

	}

	@Override

	public String toString()

	{

		StringBuilder strBd = new StringBuilder()

		.append("SAPBody.SAPErrorMsg-> ")

		.append("errorCode(")

		.append(errorCode)

		.append(")")

		.append("errorString(")

		.append(errorString)

		.append(")");

		return strBd.toString();

	}

}


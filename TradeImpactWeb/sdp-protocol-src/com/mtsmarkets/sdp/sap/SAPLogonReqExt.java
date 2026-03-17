package com.mtsmarkets.sdp.sap;



import com.mtsmarkets.io.xdr.XDRByteBuffer;



public class SAPLogonReqExt extends SAPMessage {

	

	public static final int MSG_TYPE = 248;



	public SAPLogonReqExt()

	{

		super(new SAPHeader(MSG_TYPE));

	}



	@Override

	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {




	}



	@Override

	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {


		return 0;

	}



}


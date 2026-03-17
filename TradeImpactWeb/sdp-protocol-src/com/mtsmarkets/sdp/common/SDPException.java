package com.mtsmarkets.sdp.common;





public class SDPException extends Exception

{

	private SDPResult sdpResult = null;



	public SDPException(SDPResultCode errorCode)

	{

		this.sdpResult = new SDPResult(errorCode);

	}

	

	public SDPException(SDPResultCode errorCode, Throwable cause)

	{

		super(cause);

		this.sdpResult = new SDPResult(errorCode);

	}

	

	public SDPException(SDPResultCode errorCode, String errorDetail)

	{

		this.sdpResult = new SDPResult(errorCode, errorDetail);

	}

	

	public SDPException(SDPResultCode errorCode, String errorDetail, Throwable cause)

	{

		super(cause);

		this.sdpResult = new SDPResult(errorCode, errorDetail);

	}

	

	public SDPException(SDPResult sdpResult)

	{

		this.sdpResult = sdpResult;

	}

	public SDPResult getSDPResult()

	{

		return sdpResult;

	}

	public String getMessage()

	{

		return sdpResult.toString();

	}

}


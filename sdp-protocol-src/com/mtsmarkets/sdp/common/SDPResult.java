package com.mtsmarkets.sdp.common;


public class SDPResult

{

	private SDPResultCode code = null;

	private String detail = null;

	

	public SDPResult(SDPResultCode code)

	{

		this.code = code;

	}

	public SDPResult(SDPResultCode code, String detail)

	{

		this.code = code;

		this.detail = detail;

	}

	public SDPResultCode getCode()

	{

		return code;

	}

	public String getDetail()

	{

		return detail;

	}

	@Override

	public String toString()

	{

		StringBuilder message = new StringBuilder("SDPResult: code(");

		message.append(code.toString());

		message.append(")");

		if (detail != null)

		{

			message.append(",detail(\"");

			message.append(detail);

			message.append("\")");

		}

		return message.toString();

	}

}


package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.UShort;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SSPConOpenRes extends SSPMessage
{
	public static final int  PDU_ID = 102;


	public enum ResultCode
	{
		Success(0),
		NoResource(1),
		WrongProtocolVersion(2);

		ResultCode(int value)
		{
		}
	}
	

	ULong  protocolVersion = new ULong(0);
	ResultCode resultCode = ResultCode.Success;
	ULong  maxBlkLenRes = new ULong(0);
	ULong maxPckLenRes = new ULong(0);
	UShort clientSendAliveIntervalRes = new UShort(0);
	UShort clientReceiveAliveIntervalRes = new UShort(0);
	short  comunicWindowSizeRes = 0;
	ULong  connectionFlags = new ULong(0);


	public SSPConOpenRes()
	{
		super(new SSPHeader(PDU_ID, 0));
	}

	public SSPConOpenRes(SSPHeader sspHeader)
	{
		super(sspHeader);
	}

	public ULong getProtocolVersion()
	{
		return protocolVersion;
	}

	public void setProtocolVersion(ULong protocolVersion)
	{
		this.protocolVersion = protocolVersion;
	}

	public ResultCode getResultCode()
	{
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode)
	{
		this.resultCode = resultCode;
	}

	public ULong getMaxBlkLenRes()
	{
		return maxBlkLenRes;
	}

	public void setMaxBlkLenRes(ULong maxBlkLenRes)
	{
		this.maxBlkLenRes = maxBlkLenRes;
	}

	public ULong getMaxPckLenRes()
	{
		return maxPckLenRes;
	}

	public void setMaxPckLenRes(ULong maxPckLenRes)
	{
		this.maxPckLenRes = maxPckLenRes;
	}

	public UShort getClientSendAliveIntervalRes()
	{
		return clientSendAliveIntervalRes;
	}

	public void setClientSendAliveIntervalRes(UShort clientSendAliveIntervalRes)
	{
		this.clientSendAliveIntervalRes = clientSendAliveIntervalRes;
	}

	public UShort getClientReceiveAliveIntervalRes()
	{
		return clientReceiveAliveIntervalRes;
	}

	public void setClientReceiveAliveIntervalRes(UShort clientReceiveAliveIntervalRes)
	{
		this.clientReceiveAliveIntervalRes = clientReceiveAliveIntervalRes;
	}

	public short getComunicWindowSizeRes()
	{
		return comunicWindowSizeRes;
	}

	public void setComunicWindowSizeRes(short comunicWindowSizeRes)
	{
		this.comunicWindowSizeRes = comunicWindowSizeRes;
	}

	public ULong getConnectionFlags()
	{
		return connectionFlags;
	}

	public void setConnectionFlags(ULong connectionFlags)
	{
		this.connectionFlags = connectionFlags;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuff) throws Exception
	{
		sspHeader.readXDR(byteBuff);
		readBodyXDR(byteBuff);
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		protocolVersion.setValue(byteBuff.readInt());
		resultCode = ResultCode.values()[byteBuff.readInt()];
		maxBlkLenRes.setValue(byteBuff.readInt());
		maxPckLenRes.setValue(byteBuff.readInt());
		clientSendAliveIntervalRes.setValue(byteBuff.readInt());
		clientReceiveAliveIntervalRes.setValue(byteBuff.readInt());
		comunicWindowSizeRes = (short) byteBuff.readInt();
		connectionFlags.setValue(byteBuff.readInt());
	}

	@Override
	public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception

	{
		// body pdu
		int init = byteBuff.position();
	
		byteBuff.writeInt((int)protocolVersion.getValue());
		byteBuff.writeInt((int)resultCode.ordinal());
		byteBuff.writeInt((int)maxBlkLenRes.getValue());
		byteBuff.writeInt((int)maxPckLenRes.getValue());
		byteBuff.writeInt((int)clientSendAliveIntervalRes.getValue());
		byteBuff.writeInt((int)clientReceiveAliveIntervalRes.getValue());
		byteBuff.writeInt((int)comunicWindowSizeRes);
		byteBuff.writeInt((int)connectionFlags.getValue());

		int sizeBody = (byteBuff.position() - init);
		this.sspHeader.setPduLen(sizeBody);
		
		return sizeBody;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()

		.append("SSPConOpenRes::")
		.append(sspHeader.toString())
		.append("ProtocolVersion(").append(protocolVersion.getValue()).append(")")
		.append("ResultCode(").append(resultCode).append(")")
		.append("MaxBlkLenRes(").append(maxBlkLenRes.getValue()).append(")")
		.append("MaxPckLenRes(").append(maxPckLenRes.getValue()).append(")")
		.append("ClientSendAliveIntervalRes(").append(clientSendAliveIntervalRes.getValue()).append(")")
		.append("ClientReceiveAliveIntervalRes(").append(clientReceiveAliveIntervalRes.getValue()).append(")")
		.append("ComunicWindowSizeRes(").append(comunicWindowSizeRes).append(")")
		.append("connectionFlags(").append(connectionFlags.getValue()).append(")");

		return str.toString();
	}
}
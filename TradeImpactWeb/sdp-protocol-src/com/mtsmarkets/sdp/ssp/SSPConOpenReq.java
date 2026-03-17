package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.UShort;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SSPConOpenReq extends SSPMessage
{
	public static final int  PDU_ID = 101;

	
	ULong  protocolVersion = new ULong(0);
    ULong  maxBlkLenRequire = new ULong(0);
    UShort maxPckLenRequired = new UShort(0);
    UShort clientSendAliveIntervalReq = new UShort(0);
    UShort clientReceiveAliveIntervalReq = new UShort(0);
    short  comunicWindowSize = 0;
    ULong  connectionFlags = new ULong(0);


    public SSPConOpenReq()
    {
    	super(new SSPHeader(PDU_ID, 0));
	}

    public SSPConOpenReq(SSPHeader sspHeader)
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

	public ULong getMaxBlkLenRequire()
	{
		return maxBlkLenRequire;
	}

	public void setMaxBlkLenRequire(ULong maxBlkLenRequire)
	{
		this.maxBlkLenRequire = maxBlkLenRequire;
	}

	public UShort getMaxPckLenRequired()
	{
		return maxPckLenRequired;
	}

	public void setMaxPckLenRequired(UShort maxPckLenRequired)
	{
		this.maxPckLenRequired = maxPckLenRequired;
	}

	public UShort getClientSendAliveIntervalReq()

	{
		return clientSendAliveIntervalReq;
	}

	public void setClientSendAliveIntervalReq(UShort clientSendAliveIntervalReq)

	{
		this.clientSendAliveIntervalReq = clientSendAliveIntervalReq;
	}

	public UShort getClientReceiveAliveIntervalReq()
	{
		return clientReceiveAliveIntervalReq;
	}

	public void setClientReceiveAliveIntervalReq(UShort clientReceiveAliveIntervalReq)
	{
		this.clientReceiveAliveIntervalReq = clientReceiveAliveIntervalReq;
	}

	public short getComunicWindowSize()
	{
		return comunicWindowSize;
	}

	public void setComunicWindowSize(short comunicWindowSize)
	{
		this.comunicWindowSize = comunicWindowSize;
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
		maxBlkLenRequire.setValue(byteBuff.readInt());
		maxPckLenRequired.setValue(byteBuff.readInt());
		clientSendAliveIntervalReq.setValue(byteBuff.readInt());
		clientReceiveAliveIntervalReq.setValue(byteBuff.readInt());
		comunicWindowSize = (short) byteBuff.readInt();
		connectionFlags.setValue(byteBuff.readInt());
	}

	@Override
	public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		// body pdu
		int init = byteBuff.position();

		byteBuff.writeInt((int) protocolVersion.getValue());
		byteBuff.writeInt((int) maxBlkLenRequire.getValue());
		byteBuff.writeInt((int) maxPckLenRequired.getValue());
		byteBuff.writeInt((int) clientSendAliveIntervalReq.getValue());
		byteBuff.writeInt((int) clientReceiveAliveIntervalReq.getValue());
		byteBuff.writeInt((int) comunicWindowSize);
		byteBuff.writeInt((int) connectionFlags.getValue());

		int sizeBody = (byteBuff.position() - init);
		this.sspHeader.setPduLen(sizeBody);
		return sizeBody;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SSPConOpenReq::")
		.append(sspHeader.toString())
		.append("ProtocolVersion(").append(protocolVersion.getValue()).append(")")
		.append("MaxBlkLenRequire(").append(maxBlkLenRequire.getValue()).append(")")
		.append("MaxPckLenRequired(").append(maxPckLenRequired.getValue()).append(")")
		.append("ClientSendAliveIntervalReq(").append(clientSendAliveIntervalReq.getValue()).append(")")
		.append("ClientReceiveAliveIntervalReq(").append(clientReceiveAliveIntervalReq.getValue()).append(")")
		.append("ComunicWindowSize(").append(comunicWindowSize).append(")")
		.append("ConnectionFlags(").append(connectionFlags.getValue()).append(")");
		return str.toString();
	}
}


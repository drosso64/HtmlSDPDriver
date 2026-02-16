package com.mtsmarkets.sdp.ssp;


import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SSPConAlive extends SSPMessage{


	public static final int PDU_ID = 107;

	
	public SSPConAlive()
	{
		super(new SSPHeader(PDU_ID, 0));
	}

	public SSPConAlive(SSPHeader sspHeader)
	{
		super(sspHeader);
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuff) throws Exception

	{
		readHeaderXDR(byteBuff);
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
	}

	public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
        // pdu without body!				
		this.sspHeader.setPduLen(0);	                        
        // deve essere ritornata la sola dimensione del body
        // che nel caso dell' SSPConAlive e' pari a 0
		return 0;
        // test per silvano: inviando SSPConalive disallineata
        // la sdp library a livello centrale ritorna errore:
        // "resource temporarily unvailable" non consentendo piu alcun collegamento
        // neanche con un client ats
        // return sspHeader.writeXDR(byteBuff);
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(64)
		.append("SSPConAlive::")
		.append(sspHeader.toString());

		return stringBuilder.toString();
	}
}


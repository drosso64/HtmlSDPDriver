package com.mtsmarkets.sdp.block;

import com.mtsmarkets.components.logging.AbstractLogFactory;
import com.mtsmarkets.components.logging.ILog;
import com.mtsmarkets.sdp.common.FileLogFactorySDP;
import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.common.SDPResultCode;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.ssp.SSPMessage;

import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class InputSDPBlock extends SDPBlock implements Runnable
{
	// attached channel
	protected ProcessableSDPBlock procSdpBlock = null;
	private Inflater decompresser = new Inflater();
	private MarketFactory mktFactory = null;
	private String label;
	private static ILog log = AbstractLogFactory.getLoggerByName(FileLogFactorySDP.TCP);

	public InputSDPBlock(ProcessableSDPBlock procSdpBlock, ByteBuffer byteBuffer)
	{
		super(byteBuffer);
		this.procSdpBlock = procSdpBlock;
		this.mktFactory = procSdpBlock.getMktFactory();
		this.label = procSdpBlock.getKey();
	}
	public void run()
	{
   		procSdpBlock.processBlock(this);
	}
	public void decodeHeader() throws SDPException
	{		
		try
		{
			sdpHeaderBlock.readHeaderXDR(xdrByteBuffer);
		}
		catch (Exception e)
		{
			throw new SDPException(SDPResultCode.XDR_DECODING_FAILED);
		}
	}
            
    
    public void decodeBody(int numPDU) throws SDPException
	{
		try
		{			
			SSPMessage sspMessage = null;

			for (int i = 0; i < numPDU; i++)
			{
				sspMessage = SSPMessage.create(xdrByteBuffer, mktFactory);
				if (sspMessage == null)
				{
					throw new SDPException(SDPResultCode.SSP_RECEIVE_UNEXPECTED_PDU);
				}
				listPDU.add(sspMessage);
			}
		}
		catch (SDPException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			log.error(e, "generic exception ");
			throw new SDPException(SDPResultCode.XDR_DECODING_FAILED, e.getMessage(), e);
		}
	}
    
	// read a body block
	public void decodeBody() throws SDPException
	{		
            int numPDU = sdpHeaderBlock.getNumberOfMessage().getValue();
            decodeBody(numPDU);
	}
    
	public SSPMessage pop()
	{
		try 
		{
			return listPDU.removeFirst();
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	public int uncompress(ByteBuffer uncompressBuffer) throws DataFormatException
	{	
		byte[] compressed = xdrByteBuffer.getByteBuff().array();
		int curPosition = xdrByteBuffer.getByteBuff().position();
		int compressedDataLength = xdrByteBuffer.getByteBuff().remaining();
		decompresser.setInput(compressed, curPosition, compressedDataLength);
		byte[] uncompressed = uncompressBuffer.array();
		int resultLength = decompresser.inflate(uncompressed);
		decompresser.end();
		return resultLength;
	}
	
	public String getLabel()
	{
		return label;		
	}
}

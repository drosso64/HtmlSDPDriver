package com.mtsmarkets.sdp.block;

import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;

import com.mtsmarkets.io.xdr.ULong;



public class OutputSDPBlock extends SDPBlock implements Runnable
{
	private ProcessableSDPBlock procSdpBlock = null;
	private Deflater compresser = new Deflater();
	
	public OutputSDPBlock(ProcessableSDPBlock procSdpBlock, ByteBuffer byteBuffer)
	{
		super(byteBuffer);
		this.procSdpBlock = procSdpBlock;
	}
	
	public OutputSDPBlock(ProcessableSDPBlock procSdpBlock, SDPBlock sdpBlock, ByteBuffer byteBuffer)
	{
		super(sdpBlock, byteBuffer);
		this.procSdpBlock = procSdpBlock;
	}

	public void run()
	{
		try
		{
    		procSdpBlock.processBlock(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int compress(ByteBuffer compressByteBuffer, int headerBlockLen, int dataToCompressLength) throws DataFormatException 
	{
		xdrByteBuffer.getByteBuff().position(headerBlockLen);
		byte[] unCompressed = xdrByteBuffer.getByteBuff().array();
		int compressFrom = xdrByteBuffer.getByteBuff().position();
		compresser.setInput(unCompressed, compressFrom, dataToCompressLength);
		compresser.finish();
		byte[] compressed = compressByteBuffer.array();
		return compresser.deflate(compressed, compressFrom, dataToCompressLength);
	}
	public int codeHeader() throws Exception
	{
		return sdpHeaderBlock.writeHeaderXDR(xdrByteBuffer);
	}
	public int codeBody() throws Exception
	{
		return writeXDR();
	}
	public void setCompression(boolean compressionEnabled)
	{
		ULong flags = (compressionEnabled == true) ? new ULong(1) : new ULong(0);
		sdpHeaderBlock.setFlags(flags);		
	}
}

package com.mtsmarkets.sdp.block;

import java.nio.ByteBuffer;

import javolution.util.FastList;
import com.mtsmarkets.sdp.ssp.SSPMessage;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SDPBlock
{
	// buffer
	protected XDRByteBuffer xdrByteBuffer = null;
	// header
	protected SDPHeaderBlock sdpHeaderBlock = new SDPHeaderBlock();
	// body
	protected FastList<SSPMessage> listPDU = new FastList<SSPMessage>();
	
	public SDPBlock(ByteBuffer byteBuffer)
	{
		this.xdrByteBuffer = new XDRByteBuffer(byteBuffer);
	}
    
	public SDPBlock(SDPHeaderBlock sdpHeaderBlock, FastList<SSPMessage> listPDU , ByteBuffer byteBuffer)
	{
		this.xdrByteBuffer = new XDRByteBuffer(byteBuffer);
                  this.listPDU = listPDU;
	}
	
	public SDPBlock(SDPBlock sdpBlock, ByteBuffer byteBuffer)
	{		
		xdrByteBuffer = new XDRByteBuffer(byteBuffer);
		sdpHeaderBlock = sdpBlock.getSdpHeaderBlock();
		listPDU = sdpBlock.getListPDU();		
	}
	
	public SDPBlock(int capacity)
	{
		this.xdrByteBuffer = new XDRByteBuffer(ByteBuffer.allocate(capacity));
	}

	public void setXDRByteBuffer(ByteBuffer byteBuffer)
	{
		this.xdrByteBuffer = new XDRByteBuffer(byteBuffer);		
	}
	public XDRByteBuffer getXDRByteBuffer()
	{
		return xdrByteBuffer;		
	}
	public void add(SSPMessage sspMessage)
	{
		listPDU.add(sspMessage);
		sdpHeaderBlock.setNumberOfMessage(listPDU.size());
	}
	
	public void setCompressed()
	{
		sdpHeaderBlock.setCompressed();
	}
	
	// write a body block in xdr
	public int writeXDR() throws Exception
	{
		int size = 0;
		
		for (FastList.Node<SSPMessage> n = listPDU.head(), end = listPDU.tail(); (n = n.getNext()) != end;) 
		{	
			size += n.getValue().writeXDR(xdrByteBuffer);
		}		
		return size;
	}

	public void dumpHex(byte[] byteBuff, int size)
	{
		for (int i=0; i< size; i++)
		{
			System.out.printf("%02X ",byteBuff[i]);
			if (((i + 1) % 16) == 0)
			{
				System.out.printf("%n");
			}
		}
		System.out.printf("%n");
	}
	
	public ByteBuffer extractBuffer()
	{
		ByteBuffer tmpBuffer = xdrByteBuffer.getByteBuff();
		xdrByteBuffer = null;
		return tmpBuffer;
	}
	
	public void setBuffer(ByteBuffer buffer) {
		xdrByteBuffer = new XDRByteBuffer(buffer);		
	}
	
	public void writeSizeBlockXDR(int size) throws Exception{
		sdpHeaderBlock.writeSizeBlockXDR(xdrByteBuffer, size);
	}
	
	public boolean isCompress()
	{
		return sdpHeaderBlock.isCompress(); 
	}
	@Override
	public String toString()
	{
		return sdpHeaderBlock.toString();
	}

	public FastList<SSPMessage> getListPDU()
	{
		return listPDU;
	}

	public SDPHeaderBlock getSdpHeaderBlock()
	{
		return sdpHeaderBlock;
	}
	
	
	
}

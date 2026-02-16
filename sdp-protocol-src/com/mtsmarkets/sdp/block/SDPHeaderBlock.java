package com.mtsmarkets.sdp.block;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.UShort;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SDPHeaderBlock
{
	protected ULong  blockNumber = new ULong(0);
	protected UShort numberOfMessage = new UShort(0);
	protected ULong  flags = new ULong(0);
	protected ULong  length = new ULong(0);
	
	private static final int LENGHT_OFFSET = 12;
	private static final int HEADER_LENGHT = 16;
	
	//private static ILog logSSP = AbstractLogFactory.getLoggerByName(FileLogFactorySDP.SSP);
	
	public static AtomicInteger counterBlockNumber = new AtomicInteger (1);
	
	public static int sizeHeader()
	{
		return HEADER_LENGHT;
	}
	public static int offsetLenghtBlock()
	{
		return LENGHT_OFFSET;
	}
	public static int extractLenght(ByteBuffer buffer)
	{
		int position = buffer.position();
		buffer.position(buffer.position() + LENGHT_OFFSET);
		int length = buffer.getInt();
		buffer.position(position);
		return length;
	}
	public int writeHeaderXDR(XDRByteBuffer byteBuff) throws Exception
	{
		int size = byteBuff.position();
		byteBuff.writeInt((int) blockNumber.getValue());
		byteBuff.writeInt((int) numberOfMessage.getValue());
		byteBuff.writeInt((int) flags.getValue());
		byteBuff.writeInt((int) length.getValue());
		size = byteBuff.position() - size;
		return size;
	}
	public void readHeaderXDR(XDRByteBuffer byteBuff) throws Exception
	{		
		blockNumber.setValue(byteBuff.readInt());
		numberOfMessage.setValue(byteBuff.readInt());
		flags.setValue(byteBuff.readInt());
		length.setValue(byteBuff.readInt());
		//logSSP.debug("SDPHeaderBlock.readHeaderXDR() - %s", this);
	}
	public  void readHeaderXDR(ByteBuffer byteBuff) throws Exception
	{		
		blockNumber.setValue(byteBuff.getInt());
		numberOfMessage.setValue(byteBuff.getInt());
		flags.setValue(byteBuff.getInt());
		length.setValue(byteBuff.getInt());
		//logSSP.debug("SDPHeaderBlock.readHeaderXDR() - %s", this);
	}
	public void writeSizeBlockXDR(XDRByteBuffer byteBuff, int size) throws Exception
	{
		byteBuff.writeInt(LENGHT_OFFSET, size);
		length.setValue(size);
	}
	
	public ULong getFlags()
	{
		return flags;
	}
	public void setFlags(ULong flags)
	{
		this.flags = flags;
	}
	public ULong getLength()
	{
		return length;
	}
	public void setLength(ULong length)
	{
		this.length = length;
	}
	public void setCompressed()
	{
		this.flags.setValue(1);
	}
	public ULong getBlockNumber()
	{
		return blockNumber;
	}
	public void setBlockNumber(ULong blockNumber)
	{
		this.blockNumber = blockNumber;
	}
	public UShort getNumberOfMessage()
	{
		return numberOfMessage;
	}
	public void setNumberOfMessage(UShort numberOfMessage)
	{
		this.numberOfMessage = numberOfMessage;
	}
	public void setNumberOfMessage(int numberOfMessage)
	{
		this.numberOfMessage.setValue(numberOfMessage);
	}

	public boolean isCompress()
	{
		return (getFlags().getValue() == 1); 
	}
	
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SDPBlock.Header::")
		.append("BlockNumber(").append(blockNumber.getValue()).append(")")
		.append("NumberOfMessage(").append(numberOfMessage.getValue()).append(")")
		.append("Flags(").append(flags.getValue()).append(")")
		.append("Length(").append(length.getValue()).append(")");
		return str.toString();
	}
}

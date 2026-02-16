/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.deserializer;

import com.mtsmarkets.components.deserializer.Deserializer;
import com.mtsmarkets.components.logging.AbstractLogFactory;
import com.mtsmarkets.components.logging.ILog;
import com.mtsmarkets.components.memory.PoolBuffer;
import com.mtsmarkets.sdp.block.SDPHeaderBlock;
import com.mtsmarkets.sdp.common.FileLogFactorySDP;
import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.ssp.SSPMessage;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import javolution.util.FastList;


public abstract class SDPDeserializer implements Deserializer {

	public static AtomicInteger idCounter = new AtomicInteger(1);
	//private PoolBuffer inputPool; //PoolGenerator.getInstance().get(DEFAULT_POOL_BUFFER_SIZE, 2, 1);
	protected MarketFactory marketFactory;
	protected ILog logSsp;
	protected ILog logSap;
	protected String key;
	private Inflater decompresser = new Inflater();

	public SDPDeserializer(MarketFactory marketFactory) {
		this.marketFactory = marketFactory;
		this.key = String.format("%s-%03d", "DSR", idCounter.getAndIncrement());
		logSap = AbstractLogFactory.getLoggerByName(FileLogFactorySDP.SAP);
		logSsp = AbstractLogFactory.getLoggerByName(FileLogFactorySDP.SSP);

	}

	public SDPDeserializer(MarketFactory marketFactory, String key) {
		this(marketFactory);
		this.key = key;
	}

	public SDPDeserializer(MarketFactory marketFactory, PoolBuffer inputPool) {
		this(marketFactory);
	}

	public SDPDeserializer(MarketFactory marketFactory, PoolBuffer inputPool, String key) {
		this(marketFactory, inputPool);
		this.key = key;
	}

	public abstract FastList<SSPMessage> deserializeBlock(ByteBuffer buffer) throws Exception;

	public SDPHeaderBlock deserializeHeaderBlock(ByteBuffer buffer) throws Exception {
		//logSsp.debug("%s| SDPDeserializer.deserializeHeaderBlock()", key);
		SDPHeaderBlock sdpHeaderBlock = new SDPHeaderBlock();
		XDRByteBuffer xdrByteBuff = new XDRByteBuffer(buffer);
		sdpHeaderBlock.readHeaderXDR(xdrByteBuff);
		return sdpHeaderBlock;
	}

	public abstract FastList<SSPMessage> deserializeBodyBlock(short numPdu, ByteBuffer buffer) throws SDPException;

	public String getKey() {
		return key;
	}

	public MarketFactory getMktFactory() {
		return marketFactory;
	}
	
	public static int remaining(ByteBuffer buffer) throws Exception
	{
		buffer.flip();
		int bytesRead = buffer.limit();
		int sizeHeadBlock = SDPHeaderBlock.sizeHeader();
		
		SDPHeaderBlock sdpHeaderBlock = new SDPHeaderBlock();		
		sdpHeaderBlock.readHeaderXDR(buffer);
		
		if (bytesRead < sizeHeadBlock)
		{
			buffer.position(bytesRead);
			return sizeHeadBlock - bytesRead;
		}
			
		int sizeBodyBlock = (int) sdpHeaderBlock.getLength().value;				
		int nextBlock = buffer.position() + sizeBodyBlock;		
		int numBlocks = 0;
		while (nextBlock < buffer.limit())
		{	
			sdpHeaderBlock.readHeaderXDR(buffer);
			numBlocks++;
			System.out.println("numBlocks " + numBlocks + " position  " + buffer.position() + " limit " + buffer.limit() + sdpHeaderBlock);
			buffer.position(nextBlock);
			sizeBodyBlock = (int) sdpHeaderBlock.getLength().value;					
			nextBlock = buffer.position() + sizeBodyBlock;
		}
		int bytesToRead = nextBlock - bytesRead;
		if (bytesToRead == 0 || nextBlock > buffer.capacity()) {
			buffer.position(bytesRead);
		}
		System.out.println("position  " + buffer.position() + " limit " + buffer.limit() + sdpHeaderBlock);
		return bytesToRead;
	}
	
	public int uncompress(ByteBuffer uncompressBuffer, ByteBuffer compressBuffer) throws DataFormatException
	{			
		byte[] compressed = compressBuffer.array();
		int curPosition = compressBuffer.position();
		int compressedDataLength = compressBuffer.remaining();
		decompresser.setInput(compressed, curPosition, compressedDataLength);
		byte[] uncompressed = uncompressBuffer.array();
		int resultLength = decompresser.inflate(uncompressed);
		decompresser.end();
		return resultLength;
	}
}

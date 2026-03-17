/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.deserializer;

import com.mtsmarkets.components.memory.PoolBuffer;
import com.mtsmarkets.sdp.block.InputSDPBlock;
import com.mtsmarkets.sdp.block.OutputSDPBlock;
import com.mtsmarkets.sdp.block.ProcessableSDPBlock;
import com.mtsmarkets.sdp.block.SDPHeaderBlock;
import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.packet.SDPUnpacking;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.smp.SMPException;
import com.mtsmarkets.sdp.ssp.SSPMessage;

import java.nio.ByteBuffer;
import javolution.util.FastList;


public class SDPDeserializerAsync extends SDPDeserializer implements ProcessableSDPBlock {

	private SDPPublisher sdpPublisher;

	public SDPDeserializerAsync(MarketFactory marketFactory, SDPPublisher sdpPublisher) {
		super(marketFactory);
		this.sdpPublisher = sdpPublisher;
	}

	public SDPDeserializerAsync(MarketFactory marketFactory, SDPPublisher sdpPublisher, String label) {
		super(marketFactory, label);
		this.sdpPublisher = sdpPublisher;
	}

	public SDPDeserializerAsync(MarketFactory marketFactory, SDPPublisher sdpPublisher, PoolBuffer inputPool) {
		super(marketFactory, inputPool);
		this.sdpPublisher = sdpPublisher;
	}

	public SDPDeserializerAsync(MarketFactory marketFactory, SDPPublisher sdpPublisher, PoolBuffer inputPool, String label) {
		super(marketFactory, inputPool, label);
		this.sdpPublisher = sdpPublisher;
	}

	@Override
	public FastList<SSPMessage> deserializeBlock(ByteBuffer buffer) throws Exception {
		//logSsp.debug("%s| SDPDeserializerAsync.deserializeBlock()", key);
		SDPUnpacking.getInstance().execute(new InputSDPBlock(this, buffer));
		return null;
	}

	@Override
	public SDPHeaderBlock deserializeHeaderBlock(ByteBuffer buffer) throws Exception {
		//logSsp.debug("%s| SDPDeserializerAsync.deserializeHeaderBlock()", key);
		return super.deserializeHeaderBlock(buffer);
	}

	@Override
	public FastList<SSPMessage> deserializeBodyBlock(short numPDU, ByteBuffer buffer) throws SDPException {
		//logSsp.debug("%s| SDPDeserializerAsync.deserializeBodyBlock()", key);
		SDPUnpacking.getInstance().execute(new InputSDPBlock(this, buffer));
		return null;
	}

	protected FastList<SSPMessage> processSSPMessage(InputSDPBlock inputSDPBlock) {
		//logSsp.debug("%s| SDPDeserializerAsync.processSSPMessage()", key);
		FastList<SSPMessage> listPdu = null;
		SSPMessage sspMessage = inputSDPBlock.pop();
		while (sspMessage != null) {
			sdpPublisher.onMessage(sspMessage, inputSDPBlock);
			sspMessage = inputSDPBlock.pop();
		}
		return listPdu;
	}

	public FastList<SSPMessage> processBlock(OutputSDPBlock outputSDPBlock) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Richiamata esternamente dal task InputSDPBlock
	 *
	 * @param inputSDPBlock
	 */
	public FastList<SSPMessage> processBlock(InputSDPBlock inputSDPBlock) {
		//logSsp.debug("%s| SDPDeserializerAsync.processBlock()", key);
		FastList<SSPMessage> listSspMsg = null;		
		try {
			inputSDPBlock.decodeHeader();
			int numPDU = inputSDPBlock.getSdpHeaderBlock().getNumberOfMessage().value;
			/*
			 * if (inputSDPBlock.isCompress()) { ByteBuffer uncompressBuffer =
			 * inputPool.pop(); inputSDPBlock.uncompress(uncompressBuffer);
			 * inputPool.push(inputSDPBlock.extractBuffer());
			 * inputSDPBlock.setBuffer(uncompressBuffer); }
			 */
			listSspMsg = processBodyBlock(numPDU, inputSDPBlock);
			return listSspMsg;
		} 
		catch (SMPException e) {
			logSsp.error(e, "%s| SDPDeserializerAsync.processBlock() - %s", key, e.getMessage());
		} 
		catch (SDPException e) {
			logSsp.error(e, "%s| SDPDeserializerAsync.processBlock() - %s", key, e.getMessage());
		}
		return listSspMsg;
	}

	public FastList<SSPMessage> processBodyBlock(int numPDU, InputSDPBlock inputSDPBlock) {
		FastList<SSPMessage> listSspMsg = null;
		//logSsp.debug("%s| SDPDeserializerAsync.processBodyBlock()", key);
		try {
			//logSsp.info("%s| <IN>%s", key, inputSDPBlock);
			inputSDPBlock.decodeBody(numPDU);
			listSspMsg = processSSPMessage(inputSDPBlock);
			inputSDPBlock = null;
		} 
		catch (SMPException e) {
			logSsp.error(e, "%s| SDPDeserializerAsync.processBodyBlock() - %s", key, e.getMessage());
		} 
		catch (SDPException e) {
			logSsp.error(e, "%s| SDPDeserializerAsync.processBodyBlock() - %s", key, e.getMessage());
		}
		return listSspMsg;
	}
}

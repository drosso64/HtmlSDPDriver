/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.deserializer;

import com.mtsmarkets.sdp.block.InputSDPBlock;
import com.mtsmarkets.sdp.block.SDPHeaderBlock;
import com.mtsmarkets.sdp.common.SDPException;
import com.mtsmarkets.sdp.common.SDPResultCode;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.ssp.SSPMessage;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

import java.nio.ByteBuffer;
import javolution.util.FastList;


public class SDPDeserializerSync extends SDPDeserializer {

	public SDPDeserializerSync(MarketFactory marketFactory) {
		super(marketFactory);
	}

	public SDPDeserializerSync(MarketFactory marketFactory, String label) {
		super(marketFactory, label);
	}

	@Override
	public FastList<SSPMessage> deserializeBlock(ByteBuffer buffer) throws Exception {
		//logSsp.debug("%s| SDPDeserializerSync.deserializeBlock()", key);
		SDPHeaderBlock headerBlock = deserializeHeaderBlock(buffer);
		short numPdu = (short) headerBlock.getNumberOfMessage().getValue();
		return deserializeBodyBlock(numPdu, buffer);
	}

	@Override
	public FastList<SSPMessage> deserializeBodyBlock(short numPdu, ByteBuffer buffer) throws SDPException {
		//logSsp.debug("%s| SDPDeserializerSync.deserializeBodyBlock()", key);
		FastList<SSPMessage> listPDU = new FastList<SSPMessage>();
		XDRByteBuffer xdrByteBuffer = new XDRByteBuffer(buffer);

		try {
			SSPMessage sspMessage = null;
			for (int i = 0; i < numPdu; i++) {
				sspMessage = SSPMessage.create(xdrByteBuffer, marketFactory);
				if (sspMessage == null) {
					throw new SDPException(SDPResultCode.SSP_RECEIVE_UNEXPECTED_PDU);
				}
				/*logSsp.debug("%s| SDPDeserializerSync.deserializeBodyBlock():%s", key, sspMessage);
				if (sspMessage.getSapMessage() != null)
					logSap.debug("%s| SDPDeserializerSync.deserializeBodyBlock():%s", key, sspMessage.getSapMessage());
				*/	
				listPDU.add(sspMessage);
			}
		} catch (Exception e) {
			logSsp.error(e, "generic exception ");
			throw new SDPException(SDPResultCode.XDR_DECODING_FAILED, e.getMessage(), e);
		}
		return listPDU;
	}

	public FastList<SSPMessage> processBlock(InputSDPBlock inputSDPBlock) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}

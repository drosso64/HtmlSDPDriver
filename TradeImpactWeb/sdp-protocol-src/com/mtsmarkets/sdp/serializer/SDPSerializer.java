/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.serializer;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.DataFormatException;

import javolution.util.FastList;
import com.mtsmarkets.components.logging.AbstractLogFactory;
import com.mtsmarkets.components.logging.ILog;
import com.mtsmarkets.components.memory.PoolBuffer;
import com.mtsmarkets.components.memory.PoolGenerator;
import com.mtsmarkets.sdp.block.InputSDPBlock;
import com.mtsmarkets.sdp.block.OutputSDPBlock;
import com.mtsmarkets.sdp.block.ProcessableSDPBlock;
import com.mtsmarkets.sdp.block.SDPBlock;
import com.mtsmarkets.sdp.block.SDPHeaderBlock;
import com.mtsmarkets.sdp.common.FileLogFactorySDP;
import com.mtsmarkets.sdp.sap.SAPLogoffReq;
import com.mtsmarkets.sdp.smp.MarketFactory;
import com.mtsmarkets.sdp.ssp.SSPConAlive;
import com.mtsmarkets.sdp.ssp.SSPConCloseReq;
import com.mtsmarkets.sdp.ssp.SSPConModifyRes;
import com.mtsmarkets.sdp.ssp.SSPConOpenReq;
import com.mtsmarkets.sdp.ssp.SSPMessage;
import com.mtsmarkets.sdp.ssp.SSPSendMsg;
import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SDPSerializer implements ProcessableSDPBlock, Serializer {

    private PoolBuffer outputPool;
    private final static int DEFAULT_POOL_BUFFER_SIZE = 1024 * 8;
    private MarketFactory marketFactory;
    private static AtomicInteger idCounter = new AtomicInteger(1);
    private ILog logSsp;
    private String label = "";

    public SDPSerializer(MarketFactory marketFactory) {
        this.marketFactory = marketFactory;
        this.outputPool = PoolGenerator.getInstance().get(DEFAULT_POOL_BUFFER_SIZE, 2, 1);
        this.label = String.format("%s-%03d", "DSR", idCounter.getAndIncrement()/** id   */);
        logSsp = AbstractLogFactory.getLoggerByName(FileLogFactorySDP.SSP);
    }

    public SDPSerializer(MarketFactory marketFactory, PoolBuffer outputPool) {
        this.marketFactory = marketFactory;
        this.outputPool = outputPool;
        this.label = String.format("%s-%03d", "DSR", idCounter.getAndIncrement()/*
                 * id
                 */);
        logSsp = AbstractLogFactory.getLoggerByName(FileLogFactorySDP.SSP);
    }

    public SDPSerializer(MarketFactory marketFactory, PoolBuffer outputPool, String label) {
        this(marketFactory, outputPool);
        this.label = String.format("%s-%03d", "DSR", idCounter.getAndIncrement()/** id*/);
        logSsp = AbstractLogFactory.getLoggerByName(FileLogFactorySDP.SMP);
    }

    public ByteBuffer serialize(SSPMessage sspMessage, boolean compressionEnabled) {
        logSsp.info("%s| <OUT>%s", label, sspMessage);
        logSsp.debug("%s| SDPDeserializer.deserialize():sspMessage<%s>", label, sspMessage);
        OutputSDPBlock outputSDPBlock = new OutputSDPBlock(this, outputPool.pop());

        if (sspMessage.getPduId().value == SSPSendMsg.PDU_ID) {
            SSPSendMsg sspSendMsg = (SSPSendMsg) sspMessage;
            if (sspSendMsg.getSapMessage().getMessageType() == SAPLogoffReq.MSG_TYPE) {
                outputSDPBlock.setCompression(false);
            }
        } else if (sspMessage.getPduId().value == SSPConAlive.PDU_ID
                || sspMessage.getPduId().value == SSPConOpenReq.PDU_ID
                || sspMessage.getPduId().value == SSPConModifyRes.PDU_ID
                || sspMessage.getPduId().value == SSPConCloseReq.PDU_ID) {

            outputSDPBlock.setCompression(false);
        } else {
            outputSDPBlock.setCompression(compressionEnabled);
        }
        outputSDPBlock.add(sspMessage);
        //SDPPacking.getInstance().execute(outputSDPBlock);
        processBlock(outputSDPBlock);
        return outputSDPBlock.getXDRByteBuffer().getByteBuff();

    }

    public ByteBuffer serialize(SDPBlock sdpBlock) {
        logSsp.info("%s| <OUT>%s", label, sdpBlock);
        logSsp.debug("%s| SDPDeserializer.deserialize():outputSDPBlock<%s>", label, sdpBlock);
        OutputSDPBlock outputSDPBlock = new OutputSDPBlock(this, sdpBlock, outputPool.pop());
        //SDPPacking.getInstance().execute(outputSDPBlock);
        processBlock(outputSDPBlock);
        return outputSDPBlock.getXDRByteBuffer().getByteBuff();
    }

    
    public void serializeBlock(SDPHeaderBlock sdpHeaderBlock, FastList<SSPMessage> listPDU, ByteBuffer buffer) throws Exception {
		
		int posHeaderBlock = buffer.position();
		buffer.position(buffer.position() + SDPHeaderBlock.sizeHeader());
		int lengthBlock = serializeBodyBlock(listPDU, buffer);
		int posEndBlock = buffer.position();
		sdpHeaderBlock.setLength(new ULong(lengthBlock));
		buffer.position(posHeaderBlock);
		serializeHeaderBlock(sdpHeaderBlock, buffer);
		buffer.position(posEndBlock);
    }
    
    public int serializeHeaderBlock(SDPHeaderBlock sdpHeaderBlock, ByteBuffer buffer) throws Exception {
        XDRByteBuffer xdrbuffer = new XDRByteBuffer(buffer);
        return sdpHeaderBlock.writeHeaderXDR(xdrbuffer);
    }
    
    
    public int serializeBodyBlock(FastList<SSPMessage> listPDU, ByteBuffer buffer) throws Exception {       
        int size = 0;
        XDRByteBuffer xdrByteBuffer = new XDRByteBuffer(buffer);
        for (FastList.Node<SSPMessage> n = listPDU.head(), end = listPDU.tail(); (n = n.getNext()) != end;) 
        {
            size += n.getValue().writeXDR(xdrByteBuffer);
        }
        return size;
    }
    
    public FastList<SSPMessage> processBlock(OutputSDPBlock outputSDPBlock) {
        logSsp.debug("%s| SSPChannel.processOutputSDPBlock()", label);
        try {
            int headerBlockLen = outputSDPBlock.codeHeader();
            int sizeBodyBlock = outputSDPBlock.codeBody();

            if (outputSDPBlock.isCompress()) {
                ByteBuffer compressBuffer = outputPool.pop();
                compressBuffer.position(headerBlockLen);
                int byteCompressed = outputSDPBlock.compress(compressBuffer, headerBlockLen, sizeBodyBlock);
                outputPool.push(outputSDPBlock.extractBuffer());
                outputSDPBlock.setBuffer(compressBuffer);
                outputSDPBlock.getXDRByteBuffer().getByteBuff().position(0);
                outputSDPBlock.codeHeader();
                outputSDPBlock.getXDRByteBuffer().getByteBuff().limit(headerBlockLen + byteCompressed);
                outputSDPBlock.getXDRByteBuffer().getByteBuff().position(headerBlockLen + byteCompressed);
                sizeBodyBlock = byteCompressed;
            }
            outputSDPBlock.writeSizeBlockXDR(sizeBodyBlock);
            //write(outputSDPBlock);
            //return outputSDPBlock.getXDRByteBuffer().getByteBuff();
        } catch (DataFormatException e) {
            e.printStackTrace();
            logSsp.error("%s| SSPChannel.processOutputSDPBlock() - Compression failed", label);
        } catch (Exception e) {
            e.printStackTrace();
            logSsp.error("%s| SSPChannel.processOutputSDPBlock() - XDR coding failed", label);
        }
        return null;
    }

    public FastList<SSPMessage> processBlock(InputSDPBlock inputSDPBlock) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getKey() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public MarketFactory getMktFactory() {
        return marketFactory;
    }
}

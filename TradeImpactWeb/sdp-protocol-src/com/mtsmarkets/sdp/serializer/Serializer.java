/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.serializer;

import java.nio.ByteBuffer;

import com.mtsmarkets.sdp.block.SDPBlock;
import com.mtsmarkets.sdp.block.SDPHeaderBlock;
import com.mtsmarkets.sdp.ssp.SSPMessage;
import javolution.util.FastList;

public interface Serializer {

    void serializeBlock(SDPHeaderBlock sdpHeaderBlock, FastList<SSPMessage> listPDU, ByteBuffer buffer) throws Exception;

    int serializeHeaderBlock(SDPHeaderBlock sdpHeaderBlock, ByteBuffer buffer) throws Exception;
    
    int serializeBodyBlock(FastList<SSPMessage> listPDU, ByteBuffer buffer) throws Exception;
    
    ByteBuffer serialize(SDPBlock sdpBlock);

    ByteBuffer serialize(SSPMessage sspMessage, boolean compressionEnabled);
}

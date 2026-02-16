package com.mtsmarkets.sdp.smp;



import java.io.Serializable;



import com.mtsmarkets.io.xdr.XDRByteBuffer;

import com.mtsmarkets.io.xdr.XDRable;



@SuppressWarnings("serial")

public abstract class SMPMessage implements XDRable, Serializable

{

	public abstract void readXDR(XDRByteBuffer byteBuffer) throws Exception;

	public abstract int writeXDR(XDRByteBuffer byteBuffer) throws Exception;

        public abstract long getSMPClassId();



}


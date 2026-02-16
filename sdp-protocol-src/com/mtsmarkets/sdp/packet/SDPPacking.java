package com.mtsmarkets.sdp.packet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mtsmarkets.sdp.block.OutputSDPBlock;
import com.mtsmarkets.sdp.common.SDPParameters;

public class SDPPacking
{
	private final static SDPPacking instance = new SDPPacking();
	
	private SDPPacking(){}
	
	public static SDPPacking getInstance()
	{		
		return instance;
	}
	
	ExecutorService executor = Executors.newFixedThreadPool(SDPParameters.packingThreadPool);
	
	public void execute(OutputSDPBlock outputSDPBlock)
	{
        try
        {
        	executor.execute(outputSDPBlock);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
	public void shutdown()
	{
		executor.shutdown();
	}
}


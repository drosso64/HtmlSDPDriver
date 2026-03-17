package com.mtsmarkets.sdp.packet;

import com.mtsmarkets.components.exception.ComponentsException;
import com.mtsmarkets.components.parallel.DynamicWorkLoadManager;
import com.mtsmarkets.sdp.block.InputSDPBlock;
import com.mtsmarkets.sdp.common.SDPParameters;



public class SDPUnpacking
{
	private final static SDPUnpacking instance = new SDPUnpacking();
	//private ExecutorService executor = Executors.newFixedThreadPool(1);
	private InputBlockSwitcher switcher = null;
	
	private SDPUnpacking()
	{
		switcher = new InputBlockSwitcher("InputBlockSwitcher", new DynamicWorkLoadManager());
		try {
			switcher.addChannels(SDPParameters.unpackingChannels);
		} catch (ComponentsException e) {
			e.printStackTrace();
		} 
	}
	
	public static SDPUnpacking getInstance()
	{
		return instance;
	}
	public void execute(InputSDPBlock inputSDPBlock)
	{
        try
        {
        	//executor.execute(inputSDPBlock);
        	switcher.addGenericWorkLoad(inputSDPBlock);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
	public void shutdown()
	{
		switcher.stop();
	}
}

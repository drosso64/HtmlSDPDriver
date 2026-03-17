package com.mtsmarkets.sdp.packet;

import com.mtsmarkets.components.parallel.generic.GenericAction;
import com.mtsmarkets.sdp.block.InputSDPBlock;


public class UnpackingAction extends GenericAction<InputSDPBlock> {
	

	@Override
	protected void actionGenericImpl(InputSDPBlock workLoadType, int currentPos, int totalPos) {
		try
        {
        	workLoadType.run();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
		
	}

}

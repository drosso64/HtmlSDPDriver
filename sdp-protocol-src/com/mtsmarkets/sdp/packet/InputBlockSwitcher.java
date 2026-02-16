package com.mtsmarkets.sdp.packet;


import com.mtsmarkets.components.parallel.WorkLoadManagerInterface;
import com.mtsmarkets.components.parallel.generic.GenericAction;
import com.mtsmarkets.components.parallel.generic.GenericSwitcher;
import com.mtsmarkets.components.parallel.generic.concreteKeys.SwitcherKeyString;
import com.mtsmarkets.sdp.block.InputSDPBlock;

public class InputBlockSwitcher extends
GenericSwitcher<SwitcherKeyString, InputSDPBlock> {

	

	public InputBlockSwitcher(String switcherName,
			WorkLoadManagerInterface workLoadManager) {
		super(switcherName, workLoadManager);
	}


	@Override
	protected GenericAction<InputSDPBlock> createGenericAction(int channelID) {
		GenericAction<InputSDPBlock> unpackingAction = new UnpackingAction();
		return unpackingAction;
	}

	@Override
	protected SwitcherKeyString getGenericKey(InputSDPBlock workLoadItem) {
		return new SwitcherKeyString(workLoadItem.getLabel());
	}

}

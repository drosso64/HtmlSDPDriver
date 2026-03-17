package com.mtsmarkets.sdp.ssp;


public class SSPWindow
{
	private int size = 0;
	private int current = 0;


	public SSPWindow(int size)
	{
		this.size = size;
	}

	public void increment()
	{
		if (size != -1)
		{
			++current;
		}
	}

	public boolean decrement()
	{
		if (size != -1)
		{
			if (current == 0)
				return false;
			--current;
		}
		return true;
	}

	public void resize(int size)
	{
		this.size = size;
		this.current = size;
	}

	public int size()
	{
		return size;
	}

	public int getSize() 
	{
		return size;
	}
}


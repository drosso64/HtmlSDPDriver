package com.mtsmarkets.sdp.common;

import java.io.IOException;

import au.com.terabit.jproactor.Demultiplexor;


public class SDPDemultiplexor
{
	private static SDPDemultiplexor instance = null;
	private static Object lock = new Object();
	private static boolean allocated = false;
	private Demultiplexor demultiplexor =  null;
	
	private SDPDemultiplexor() throws IOException
	{
		demultiplexor =  new Demultiplexor();
    	demultiplexor.start(1);
	}
	public Demultiplexor getDemultiplexor()
	{
		return demultiplexor;
	}
	// double check in java non e' trade safe, pertanto e' da richiamare almeno la prima volta in modo non concorrente
	// ad esempio nel main thread durante fase di start-up
	public static SDPDemultiplexor getInstance() throws IOException
	{		
		if (allocated == false)
		{
			synchronized (lock)
			{
				if (allocated == false)
				{
					if(instance == null)
						instance = new SDPDemultiplexor();
					allocated = true;
				}
			}
		}
		return instance;
	}
}

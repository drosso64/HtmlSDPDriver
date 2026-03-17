package com.mtsmarkets.sdp.common;

import java.util.Timer;
import java.util.TimerTask;

public class SDPScheduler
{
	private static final SDPScheduler instance = new SDPScheduler();
	private Timer timer = new Timer();
	
	private SDPScheduler(){}
	
	public static SDPScheduler getInstance()
	{
		return instance;
	}

	public void schedule(TimerTask timerTask, long delay)
	{
        try
        {
        	timer.schedule(timerTask, delay);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
	public void schedule(TimerTask timerTask, long delay, long period)
	{
        try
        {
        	timer.schedule(timerTask, delay, period);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
	public void shutdown()
	{
		timer.cancel();
	}
}

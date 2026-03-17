package com.mtsmarkets.sdp.common;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.mtsmarkets.components.logging.AbstractLogFactory;
import com.mtsmarkets.components.logging.FileLog;
import com.mtsmarkets.components.logging.ILog;



public class FileLogFactorySDP extends AbstractLogFactory
{
	
	private final static LogSDPParams logSdpParams = new LogSDPParams();
    
    private static FileLogFactorySDP fileLogFactorySDP = null;
    
	
	public final static String SDP = "sdp";
    public final static String APP = "sdp.app";
    public final static String SMP = "sdp.smp";
    public final static String SAP = "sdp.sap";
    public final static String SSP = "sdp.ssp";
    public final static String TCP = "sdp.tcp";

	private static ILog logSDP;
    private static ILog logAPP;
	private static ILog logSMP;
	private static ILog logSAP;
	private static ILog logSSP;
	private static ILog logTCP;
	
	private static final long serialVersionUID = 1L;
	private static final String factoryName = "FileLogFactorySDP";
	private ArrayList<String> logNames;
 
	
	
    private FileLogFactorySDP(LogSDPParams logSdpParams)
    {
        logSDP = new FileLog(SDP, logSdpParams, true);
        logSDP.setUseParentHandlers(false);
        logSDP.setLevel(Level.ALL);
        Object[] labelAPP = {"APP"};
        logAPP = new FileLog(APP, logSdpParams, false, labelAPP);

        Object[] labelSMP = {"SMP"};
        logSMP = new FileLog(SMP, logSdpParams, false, labelSMP);

        Object[] labelSAP = {"SAP"};
        logSAP = new FileLog(SAP, logSdpParams, false, labelSAP);

        Object[] labelSSP = {"SSP"};
        logSSP = new FileLog(SSP, logSdpParams, false, labelSSP);

        Object[] labelTCP = {"TCP"};
        logTCP = new FileLog(TCP, logSdpParams, false, labelTCP);
        logAPP.setLevel(logSdpParams.getLevelAPP());
        logSMP.setLevel(logSdpParams.getLevelSMP());
        logSAP.setLevel(logSdpParams.getLevelSAP());
        logSSP.setLevel(logSdpParams.getLevelSSP());
        logTCP.setLevel(logSdpParams.getLevelTCP());

        logNames = new ArrayList<String>();
        logNames.add(APP);
        logNames.add(SMP);
        logNames.add(SAP);
        logNames.add(SSP);
        logNames.add(TCP);
        logSDP.info(logSdpParams.toString());
    }

	@Override
    public ILog getLog(String logName) 
    {
        if (logName.compareTo(APP) == 0)
        	return logAPP;
        else if (logName.compareTo(SMP) == 0)
        	return logSMP;
		else if (logName.compareTo(SAP) == 0)
        	return logSAP;
		else if (logName.compareTo(SSP) == 0)
        	return logSSP;
		else if (logName.compareTo(TCP) == 0)
        	return logTCP;
        else
        	return null;
    }
	
	@Override
	public List<String> getLogNames()
	{		
		return logNames;
	}

	@Override
	public String getFactoryName()
	{
		return factoryName;
	}
	
	public static String getName()
	{
		return factoryName;
	}
	
	public static FileLogFactorySDP getInstance()
	{
         if (fileLogFactorySDP == null)
            fileLogFactorySDP = new FileLogFactorySDP(logSdpParams);
		return fileLogFactorySDP;
	}

	public static FileLogFactorySDP getInstance(String propertiesFileName) 
	{
		if (fileLogFactorySDP == null) {
			if (propertiesFileName != null) {
				SDPPropertiesFile properties = new SDPPropertiesFile(propertiesFileName);
				logSdpParams.setParams(properties);
				
	            fileLogFactorySDP = new FileLogFactorySDP(logSdpParams);
			}
			else
				fileLogFactorySDP = new FileLogFactorySDP(logSdpParams);
		}
		return fileLogFactorySDP;
	}
	
    public static LogSDPParams getLogSdpParams() {       
        return logSdpParams;
    }
}


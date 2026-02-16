/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.common;

import java.util.logging.Level;

import com.mtsmarkets.components.logging.LogParams;



public class LogSDPParams extends LogParams implements ILogSDPParams {
    
    /** specify log level of layer Application */
	private Level levelAPP = LEVEL_APP; 

	/** specify log level of layer SMP */
	private Level levelSMP = LEVEL_SMP;
	
	/** specify log level of layer SAP */
	private Level levelSAP = LEVEL_SAP;
	
	/** specify log level of layer SSP */
	private Level levelSSP = LEVEL_APP;
	
	/** specify log level of layer TCP */
	private Level levelTCP = LEVEL_APP;
    
	private String prefixParams = "";
	
    public Level getLevelAPP() {
        return levelAPP;
    }

    public void setLevelAPP(Level levelAPP) {
        this.levelAPP = levelAPP;
    }

    public Level getLevelSAP() {
        return levelSAP;
    }

    public void setLevelSAP(Level levelSAP) {
        this.levelSAP = levelSAP;
    }

    public Level getLevelSMP() {
        return levelSMP;
    }

    public void setLevelSMP(Level levelSMP) {
        this.levelSMP = levelSMP;
    }

    public Level getLevelSSP() {
        return levelSSP;
    }

    public void setLevelSSP(Level levelSSP) {
        this.levelSSP = levelSSP;
    }

    public Level getLevelTCP() {
        return levelTCP;
    }

    public void setLevelTCP(Level levelTCP) {
        this.levelTCP = levelTCP;
    }
    
	protected String getPrefixParams() {
		return prefixParams;
	}
	
	public void setPrefixParams(String prefixParams) {
		this.prefixParams = prefixParams;
	}

	@Override
    public String toString()
    {
        StringBuilder strBld = new StringBuilder();
        strBld.append(super.toString());
        strBld.append("LOG SDP Levels:\n")
                .append("\tlevelAPP <").append(levelAPP).append(">\n")
                .append("\tlevelSMP <").append(levelSMP).append(">\n")
                .append("\tlevelSAP <").append(levelSAP).append(">\n")
                .append("\tlevelSSP <").append(levelSSP).append(">\n")
                .append("\tlevelTCP <").append(levelTCP).append(">\n")              
                ;
        return strBld.toString();
    }
    
	public void setParams(SDPPropertiesFile properties) {
		String value = null;
		Object param = null;
		
		//LOG params:
		value = properties.getProperty(new StringBuilder(prefixParams).append("path").toString());
		if (value != null)
			setPath(value);
		
		value = properties.getProperty(new StringBuilder(prefixParams).append("pattern").toString());
		if (value != null)
			setPattern(value);
		
		value = properties.getProperty(new StringBuilder(prefixParams).append("numRotate").toString());
		if (value != null) { 
			param = convertValue(value, Integer.class);
			if (param != null)
				setNumRotate((Integer)param);
		}
		
		value = properties.getProperty(new StringBuilder(prefixParams).append("inAppend").toString());
		if (value != null) {
			param = convertValue(value, Boolean.class);
			if (param != null)
				setInAppend((Boolean)param);
		}
		
		value = properties.getProperty(new StringBuilder(prefixParams).append("limitSize").toString());
		if (value != null) {
			param = convertValue(value, Integer.class);
			if (param != null)
				setLimitSize((Integer)param);
		}
	
		//LOG Caching params:
		value = properties.getProperty(new StringBuilder(prefixParams).append("enabled").toString());
		if (value != null) {
			param = convertValue(value, Boolean.class);
			if (param != null)
				getCaching().setEnabled((Boolean)param);
		}

		value = properties.getProperty(new StringBuilder(prefixParams).append("numRecords").toString());
		if (value != null) {
			param = convertValue(value, Integer.class);
			if (param != null)
				getCaching().setNumRecords((Integer)param);
		}

		value = properties.getProperty(new StringBuilder(prefixParams).append("dumpEveryNumRec").toString());
		if (value != null) {
			param = convertValue(value, Integer.class);
			if (param != null)
				getCaching().setDumpEveryNumRec((Integer)param);
		}

		//LOG SDP Levels:			
		String level = ".level";
		value = properties.getProperty(new StringBuilder(prefixParams).append(FileLogFactorySDP.APP).append(level).toString());
		if (value != null) {
			param = convertValue(value, Level.class);
			setLevelAPP((Level)param);
		}
		
		value = properties.getProperty(new StringBuilder(prefixParams).append(FileLogFactorySDP.SMP).append(level).toString());
		if (value != null) {
			param = convertValue(value, Level.class);
			setLevelSMP((Level)param);
		}
		
		value = properties.getProperty(new StringBuilder(prefixParams).append(FileLogFactorySDP.SAP).append(level).toString());
		if (value != null) {
			param = convertValue(value, Level.class);
			setLevelSAP((Level)param);
		}
		
		value = properties.getProperty(new StringBuilder(prefixParams).append(FileLogFactorySDP.SSP).append(level).toString());
		if (value != null) {
			param = convertValue(value, Level.class);
			setLevelSSP((Level)param);
		}
		
		value = properties.getProperty(new StringBuilder(prefixParams).append(FileLogFactorySDP.TCP).append(level).toString());
		if (value != null) {
			param = convertValue(value, Level.class);
			setLevelTCP((Level)param);
		}
	}
		
	private Object convertValue(String value, Object classType) {
		
		Object result = null;
		try { 
			if (classType.equals(Integer.class)) {
				result = Integer.valueOf(value);
			}
			else
			if (classType.equals(Boolean.class)) {
				result = Boolean.valueOf(value);
			}
			else
			if (classType.equals(Level.class)) {
				result = Level.parse(value);
			}
		}
		catch(Exception ex) {
			//Nothing to do!! Use default
		}
		
		return result;
	}
}

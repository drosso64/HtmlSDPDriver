/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.common;

import java.util.logging.Level;



public interface ILogSDPParams {
    /** specify default log level of layer Application */
	public final static Level LEVEL_APP = Level.INFO;

	/** specify default log level of layer SMP */
	public final static Level LEVEL_SMP = Level.OFF;
	
	/** specify default log level of layer SAP */
	public final static Level LEVEL_SAP = Level.INFO;
	
	/** specify default log level of layer SSP */
	public final static Level LEVEL_SSP = Level.OFF;
	
	/** specify default log level of layer TCP */
	public final static Level LEVEL_TCP = Level.OFF;
    
    public Level getLevelAPP();
    public void setLevelAPP(Level levelAPP);

    public Level getLevelSAP();
    public void setLevelSAP(Level levelSAP);

    public Level getLevelSMP();
    public void setLevelSMP(Level levelSMP);

    public Level getLevelSSP();
    public void setLevelSSP(Level levelSSP);

    public Level getLevelTCP();
    public void setLevelTCP(Level levelTCP);
}

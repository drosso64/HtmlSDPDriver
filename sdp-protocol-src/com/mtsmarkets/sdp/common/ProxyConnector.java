package com.mtsmarkets.sdp.common;

import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

import au.com.terabit.jproactor.AsynchChannel;
import au.com.terabit.jproactor.AsynchChannelHandler;
import au.com.terabit.jproactor.AsynchChannelHandlerFactory;
import au.com.terabit.jproactor.AsynchConnectHandler;
import au.com.terabit.jproactor.Demultiplexor;
import au.com.terabit.jproactor.OpConnect;
import au.com.terabit.jproactor.TCPAsynchChannel;

public class ProxyConnector implements AsynchConnectHandler
{
	
	/**
     * Procotol factory assigned for this socket address 
     */
    AsynchChannelHandlerFactory m_factory = null;
    
    /**
     * Demultiplexor instance 
     */
    Demultiplexor m_multiplexor = null;
    
    
    public ProxyConnector(Demultiplexor m, 
    		AsynchChannelHandlerFactory factory)
    {
    	this.m_factory = factory;
    	this.m_multiplexor = m;

    }

	
	public void connectCompleted(OpConnect op) throws Exception {
		AsynchChannel asynchChannel = op.getChannel();

		if ( op.getError() != null )
		{    
			System.out.println( op.getError().toString());
			asynchChannel.close();
			return;

		}
		// now handle new connection
		AsynchChannelHandler protocol = m_factory.createChannelHandler ();

		asynchChannel.setChannelHandler (protocol);

	}
	
	public void start(SocketAddress address ) throws Exception
    {
        TCPAsynchChannel achannel = new TCPAsynchChannel (m_multiplexor, SocketChannel.open());
        achannel.connect (address, this);
    }
	
	/**
     * 
     */
    public void declareInterest(SocketChannel socketChannel ) throws Exception
    {
    	socketChannel.configureBlocking(false);
    	TCPAsynchChannel achannel = new TCPAsynchChannel (m_multiplexor, socketChannel);
        //gia fatto nel costruttore di TCPAsyncChannel
        //m_multiplexor.declareInterest(achannel);
        
        AsynchChannelHandler protocol = m_factory.createChannelHandler ();
        achannel.setChannelHandler(protocol);
        
    }

}

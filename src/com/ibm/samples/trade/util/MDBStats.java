//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade.util;


/**
 * @author stancox
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class MDBStats extends java.util.HashMap {
	
	
	//Singleton class
	private static MDBStats mdbStats = null;
	private MDBStats()
	{
	}
	
	public static synchronized MDBStats getInstance()
	{
		if (mdbStats == null)
			mdbStats = new MDBStats();
		return mdbStats;
	}
	
	public TimerStat addTiming(String type, long sendTime, long recvTime)
	{
		TimerStat stats = null;
		synchronized (type)
		{

			stats = (TimerStat) get(type);
			if (stats == null) stats = new TimerStat();

			long time =  recvTime - sendTime;	        					
			if ( time > stats.getMax() ) stats.setMax(time);
			if ( time < stats.getMin() ) stats.setMin(time);
	        stats.setCount(stats.getCount()+1);
			stats.setTotalTime(stats.getTotalTime() + time);
			
			put(type, stats);
		}
		return stats;
	}



	public synchronized void reset()
	{
		clear();
	}	
	


}

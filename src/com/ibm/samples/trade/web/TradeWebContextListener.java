//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade.web;

import javax.servlet.*;

import com.ibm.samples.trade.direct.*;
import com.ibm.samples.trade.util.*;
public class TradeWebContextListener
	implements ServletContextListener 
{

	//receieve trade web app startup/shutown events to start(initialized)/stop TradeDirect
	public void contextInitialized(ServletContextEvent event)
	{
		Log.trace("TradeWebContextListener contextInitialized -- initializing TradeDirect");
		TradeDirect.init();		
	}
	public void contextDestroyed(ServletContextEvent event)
	{
		Log.trace("TradeWebContextListener  contextDestroy calling TradeDirect:destroy()");		
		TradeDirect.destroy();
	}

    

}


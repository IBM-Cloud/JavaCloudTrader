//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade.web;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ibm.samples.trade.*;
import com.ibm.samples.trade.direct.TradeDirect;
import com.ibm.samples.trade.util.*;

public class OrdersAlertFilter implements Filter {

	/**
	 * Constructor for CompletedOrdersAlertFilter
	 */
	public OrdersAlertFilter() {
		super();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	private FilterConfig filterConfig = null;
	public void init(FilterConfig filterConfig) throws ServletException {
	      this.filterConfig = filterConfig;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(
		ServletRequest req,
		ServletResponse resp,
		FilterChain chain)
		throws IOException, ServletException {
		if (filterConfig == null)
			return;
		
		try
		{
			String action = req.getParameter("action");
			if ( action != null ) 
			{
				action = action.trim();
				if ( (action.length() > 0) && (!action.equals("logout")) )
				{
					String userID;
					if ( action.equals("login") )
						userID = req.getParameter("uid");
					else
						userID = (String) ((HttpServletRequest) req).getSession().getAttribute("uidBean");
					if ( (userID != null) && (userID.trim().length()>0) )
					{	
						TradeServices tAction=null;
						if(TradeConfig.getAccessMode() == TradeConfig.STANDARD)
							tAction = new TradeDirect();
															
						java.util.Collection closedOrders = tAction.getClosedOrders(userID);
						if ( (closedOrders!=null) && (closedOrders.size() > 0) )
							req.setAttribute("closedOrders", closedOrders);
						if (Log.doTrace()) Log.printCollection("OrderAlertFilter: userID="+userID+" closedOrders=", closedOrders);
					}
				}	
			}
		}
		catch (Exception e)
		{
			Log.error(e, "OrdersAlertFilter - Error checking for closedOrders");
		}

        ServletContext sc = filterConfig.getServletContext();
        //String xyz = (String) sc.getAttribute("hitCounter");
		chain.doFilter(req, resp/*wrapper*/);        

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig = null;	
	}

}


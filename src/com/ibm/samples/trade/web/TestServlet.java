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
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

import com.ibm.samples.trade.*;
import com.ibm.samples.trade.direct.TradeDirect;
import com.ibm.samples.trade.util.*;

public class TestServlet extends HttpServlet {


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	
   /**
	* Process incoming HTTP GET requests
	*
	* @param request Object that encapsulates the request to the servlet
	* @param response Object that encapsulates the response from the servlet
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		performTask(request,response);
	}

   /**
	* Process incoming HTTP POST requests
	*
	* @param request Object that encapsulates the request to the servlet
	* @param response Object that encapsulates the response from the servlet
	*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		performTask(request,response);
	}	

   /**
	* Main service method for TradeAppServlet
	*
	* @param request Object that encapsulates the request to the servlet
	* @param response Object that encapsulates the response from the servlet
	*/    	
	public void performTask(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
	{
		try {
			Log.debug("Enter TestServlet doGet");
			TradeConfig.runTimeMode = TradeConfig.DIRECT;
			for (int i=0; i<10; i++) 
			{
				new TradeDirect().createQuote("s:"+i, "Company " + i, new BigDecimal(i*1.1));
			}
			/*
			
			AccountDataBean accountData = new TradeAction().register("user1", "password", "fullname", "address", 
											"email", "creditCard", new BigDecimal(123.45), false);

			OrderDataBean orderData = new TradeAction().buy("user1", "s:1", 100.0);
			orderData = new TradeAction().buy("user1", "s:2", 200.0);
			Thread.sleep(5000);
			accountData = new TradeAction().getAccountData("user1");
			Collection holdingDataBeans = new TradeAction().getHoldings("user1");
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.write("<HEAD></HEAD><BODY><BR><BR>");
			out.write(accountData.toString());
			Log.printCollection("user1 Holdings", holdingDataBeans);
			ServletContext sc  = getServletContext();
			req.setAttribute("results", "Success");
			req.setAttribute("accountData", accountData);
			req.setAttribute("holdingDataBeans", holdingDataBeans);
			getServletContext().getRequestDispatcher("/tradehome.jsp").include(req, resp);
			out.write("<BR><BR>done.</BODY>");
			*/
		}
		catch (Exception e)
		{
			Log.error("TestServletException", e);
		}
	}
}


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

public class GenerateOOM extends HttpServlet {


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
		int iteratorValue = 20;
				System.out.println("\n=================> OOM test started..\n");
				for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
					resp.getOutputStream().println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
					int loop1 = 2;
					int[] memoryFillIntVar = new int[iteratorValue];
					// feel memoryFillIntVar array in loop..
					do {
						memoryFillIntVar[loop1] = 0;
						loop1--;
					} while (loop1 > 0);
					iteratorValue = iteratorValue * 5;
					resp.getOutputStream().println("\nRequired Memory for next loop: " + iteratorValue);
					resp.getOutputStream().flush();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}
}


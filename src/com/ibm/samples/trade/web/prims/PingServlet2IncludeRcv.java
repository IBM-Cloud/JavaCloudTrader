//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade.web.prims;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * PingServlet2Include tests servlet to servlet request dispatching. Servlet 1,
 * the controller, creates a new JavaBean object forwards the servlet request with
 * the JavaBean added to Servlet 2. Servlet 2 obtains access to the JavaBean through
 * the Servlet request object and provides the dynamic HTML output based on the JavaBean
 * data.
 * PingServlet2Servlet is the initial servlet that sends a request to {@link PingServlet2ServletRcv}
 *
 */
public class PingServlet2IncludeRcv extends HttpServlet {

	/**
	 * forwards post requests to the doGet method
	 * Creation date: (11/6/2000 10:52:39 AM)
	 * @param res javax.servlet.http.HttpServletRequest
	 * @param res2 javax.servlet.http.HttpServletResponse
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		doGet(req, res);
	}
	/**
	* this is the main method of the servlet that will service all get requests.
	* @param request HttpServletRequest
	* @param responce HttpServletResponce
	**/
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		// do nothing but get included by PingServlet2Include
	}
}
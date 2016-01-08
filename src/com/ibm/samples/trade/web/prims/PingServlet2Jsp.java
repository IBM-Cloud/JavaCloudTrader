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

import com.ibm.samples.trade.util.*;

/**
 *
 * PingServlet2JSP tests a call from a servlet to a JavaServer Page providing server-side dynamic
 * HTML through JSP scripting.
 *
 */
public class PingServlet2Jsp extends HttpServlet {
	private static int hitCount = 0;

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
	PingBean ab;
	try
	{
		ab = new PingBean();
                hitCount++;
		ab.setMsg("Hit Count: " + hitCount);
		req.setAttribute("ab", ab);
		
		getServletConfig().getServletContext().getRequestDispatcher("/PingServlet2Jsp.jsp").forward(req, res);
	}
	catch (Exception ex)
	{
		Log.error(
			ex,"PingServlet2Jsp.doGet(...): request error"); 
		res.sendError(
			500, 
			"PingServlet2Jsp.doGet(...): request error"
				+ ex.toString()); 

	}
}
}
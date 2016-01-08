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
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ibm.samples.trade.*;
import com.ibm.samples.trade.util.*;

/**
 * 
 * PingServlet2JNDI performs a basic JNDI lookup of a JDBC DataSource
 * 
 */

public class PingServlet2JNDI extends HttpServlet
{

	private static String initTime;
	private static int hitCount;
	
	/**
	 * forwards post requests to the doGet method
	 * Creation date: (11/6/2000 10:52:39 AM)
	 * @param res javax.servlet.http.HttpServletRequest
	 * @param res2 javax.servlet.http.HttpServletResponse
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
	{
		doGet(req, res);
	}
	/**
	* this is the main method of the servlet that will service all get requests.
	* @param request HttpServletRequest
	* @param responce HttpServletResponce
	**/
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
	{
		res.setContentType("text/html");
		java.io.PrintWriter out = res.getWriter();

		StringBuffer output = new StringBuffer(100);

		try
			{

			int iter = TradeConfig.getPrimIterations();
			for (int ii = 0; ii < iter; ii++) {
				InitialContext context = new InitialContext();
				DataSource datasource = (DataSource) context.lookup(TradeConfig.DS_NAME);
			}			

			output.append(
				"<html><head><title>Ping JNDI -- lookup of JDBC DataSource</title></head>"
					+ "<body><HR><FONT size=\"+2\" color=\"#000066\">Ping JNDI -- lookup of JDBC DataSource</FONT><HR><FONT size=\"-1\" color=\"#000066\">Init time : "
					+ initTime);
			hitCount++;
			output.append("</FONT><BR>Hit Count: " + hitCount);
			output.append("<HR></body></html>");
			out.println(output.toString());
		}
		catch (Exception e)
		{
			Log.error(e, "PingServlet2JNDI -- error look up of a JDBC DataSource");
			res.sendError(500, "PingServlet2JNDI Exception caught: " + e.toString());
		}

	}
	/** 
	 * returns a string of information about the servlet
	 * @return info String: contains info about the servlet
	 **/
	public String getServletInfo()
	{
		return "Basic JNDI look up of a JDBC DataSource";
	}
	/**
	* called when the class is loaded to initialize the servlet
	* @param config ServletConfig:
	**/
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		hitCount = 0;
		initTime = new java.util.Date().toString();
	}
}
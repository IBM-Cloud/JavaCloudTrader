//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade.web;

import java.math.BigDecimal;

import com.ibm.samples.trade.*;
import com.ibm.samples.trade.direct.TradeDirect;
import com.ibm.samples.trade.util.*;

/**
 * TradeBuildDB uses operations provided by the TradeApplication to initially populate a Trade
 * database. Specifically, a new Trade User population is created using UserIDs of the form "uid:xxx" 
 * where xxx is a sequential number (e.g. uid:0, uid:1, etc.). New stocks are also created of the 
 * form "s:xxx", again where xxx represents sequential numbers (e.g. s:1, s:2, etc.)
 */
public class TradeBuildDB {

	private boolean verbose = true;
	private TradeConfig t = new TradeConfig();

	/**
	  * Populate a Trade DB using standard out as a log
	  */
	public TradeBuildDB() throws Exception {
		this(new java.io.PrintWriter(System.out));
	}

	/**
		* Populate a Trade DB, logging to the provided output stream
		*/
	public TradeBuildDB(java.io.PrintWriter out) throws Exception {
		String symbol, companyName;
		int errorCount = 0; // Give up gracefully after 10 errors
		TradeServices tradeAction = new TradeDirect();

		//  TradeStatistics.statisticsEnabled=false;  // disable statistics
		out.println(
			"<HEAD><BR><EM> TradeBuildDB: Building Trade Database...</EM><BR> This operation will take several minutes. Please wait...</HEAD>");

		out.println("<BODY>");
		out.println(
			"<BR>TradeBuildDB: **** Creating " + TradeConfig.getMAX_QUOTES() + " Quotes ****</BR>");
		//Attempt to delete all of the Trade users and Trade Quotes first
		try
		{
			tradeAction.resetTrade(true);
		}
		catch (Exception e)
		{
			Log.error(e, "TradeBuildDB: Unable to delete Trade users (uid:0, uid:1, ...) and Trade Quotes (s:0, s:1, ...)");
		}
		for (int i = 0; i < TradeConfig.getMAX_QUOTES(); i++) {
			symbol = "s:" + i;
			companyName = "S" + i + " Incorporated";
			try {
				QuoteDataBean quoteData =
					tradeAction.createQuote(
						symbol,
						companyName,
						new java.math.BigDecimal(TradeConfig.rndPrice()));
				if (i % 10 == 0) {
					out.print("....." + symbol);
					if (i % 100 == 0) {
						out.println(" -<BR>");
						out.flush();
					}
				}
			} catch (Exception e) {
				if (errorCount++ >= 10) {
					String error = "Populate Trade DB aborting after 10 create quote errors. Check the EJB datasource configuration. Check the log for details <BR><BR> Exception is: <BR> " + e.toString();						
					Log.error(e, error);
					throw e;
				}	
			}
		}
		out.println("<BR>");
		out.println("<BR>**** Registering " + TradeConfig.getMAX_USERS() + " Users ****. ");
		errorCount = 0; //reset for user registrations

		// Registration is a formal operation in Trade 2. 
		for (int i = 0; i < TradeConfig.getMAX_USERS(); i++) {
			String userID = "uid:" + i;
			String fullname = TradeConfig.rndFullName();
			String email = TradeConfig.rndEmail(userID);
			String address = TradeConfig.rndAddress();
			String creditcard = TradeConfig.rndCreditCard();
			double initialBalance = (double) (TradeConfig.rndInt(100000)) + 200000;
			if (i == 0) {
				initialBalance = 1000000; // uid:0 starts with a cool million.
			}
			try {
				AccountDataBean accountData =
					tradeAction.register(
						userID,
						"xxx",
						fullname,
						address,
						email,
						creditcard,
						new BigDecimal(initialBalance));
				String results;
				if (accountData != null) {
					if (i % 50 == 0) {
						out.print("<BR>Account# " +accountData.getAccountID() + " userID=" + userID);
					} // end-if

					int holdings = TradeConfig.rndInt(TradeConfig.getMAX_HOLDINGS()+1); // 0-MAX_HOLDING (inclusive), avg holdings per user = (MAX-0)/2
					double quantity = 0;
					OrderDataBean orderData;
					for (int j = 0; j < holdings; j++) {
						symbol = TradeConfig.rndSymbol();
						quantity = TradeConfig.rndQuantity();
						orderData = tradeAction.buy(userID, symbol, quantity, TradeConfig.orderProcessingMode);
					} // end-for
					if (i % 50 == 0) {
						out.println(" has " + holdings + " holdings.");
						out.flush();
					} // end-if
				} else {
					out.println("<BR>UID " + userID + " already registered.</BR>");
					out.flush();
				} // end-if

			} catch (Exception e) {
				if (errorCount++ >= 10) {
					AccountProfileDataBean accountProfileData = null;

					String error = "Populate Trade DB aborting after 10 user registration errors. Check the log for details. <BR><BR> Exception is: <BR>"	+ e.toString();
					Log.error(e, error);
					throw e;					
				}
			}
		} // end-for
		out.println("</BODY>");
	}
	public static void main(String args[]) throws Exception {
		new TradeBuildDB();

	}
}
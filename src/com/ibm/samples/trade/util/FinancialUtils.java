//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade.util;

import java.util.Collection;
import java.util.Iterator;
import java.math.BigDecimal;

import com.ibm.samples.trade.*;

public class FinancialUtils {
	//TODO -- FinancialUtils should have parts reimplemented as JSPTaglibs 

	public final static int ROUND = BigDecimal.ROUND_HALF_UP;
	public final static int SCALE = 2;	
	public final static BigDecimal ZERO = (new BigDecimal(0.00)).setScale(SCALE);
	public final static BigDecimal ONE = (new BigDecimal(1.00)).setScale(SCALE);
	public final static BigDecimal HUNDRED = (new BigDecimal(100.00)).setScale(SCALE);

	public static BigDecimal computeGain(BigDecimal currentBalance,
											BigDecimal openBalance) 
	{
		return currentBalance.subtract(openBalance).setScale(SCALE);
	}
	
	public static BigDecimal computeGainPercent(BigDecimal currentBalance,
												BigDecimal openBalance) 
	{
		if (openBalance.doubleValue() == 0.0) return ZERO;
		BigDecimal gainPercent =
			currentBalance.divide(openBalance, ROUND).subtract(ONE).multiply(HUNDRED);
		return gainPercent;
	}

	public static BigDecimal computeHoldingsTotal(Collection holdingDataBeans) {
		BigDecimal holdingsTotal = new BigDecimal(0.0).setScale(SCALE);
		if (holdingDataBeans == null)
			return holdingsTotal;
		Iterator it = holdingDataBeans.iterator();
		while (it.hasNext()) {
			HoldingDataBean holdingData = (HoldingDataBean) it.next();
			BigDecimal total =
				holdingData.getPurchasePrice().multiply(new BigDecimal(holdingData.getQuantity()));
			holdingsTotal = holdingsTotal.add(total);
		}
		return holdingsTotal.setScale(SCALE);
	}

	public static String printGainHTML(BigDecimal gain) {
		String htmlString, arrow;
		if (gain.doubleValue() < 0.0) {
			htmlString = "<FONT color=\"#ff0000\">";
			arrow = "arrowdown.gif";
		} else {
			htmlString = "<FONT color=\"#009900\">";
			arrow = "arrowup.gif";			
		}

		htmlString += gain.setScale(SCALE, ROUND) + "</FONT><IMG src=\"images/" + arrow + "\" width=\"10\" height=\"10\" border=\"0\"></IMG>";
		return htmlString;
	}

	public static String printChangeHTML(double change) {
		String htmlString, arrow;
		if (change < 0.0) {
			htmlString = "<FONT color=\"#ff0000\">";
			arrow = "arrowdown.gif";						
		} else {
			htmlString = "<FONT color=\"#009900\">";
			arrow = "arrowup.gif";						
		}


		htmlString += change + "</FONT><IMG src=\"images/" + arrow + "\" width=\"10\" height=\"10\" border=\"0\"></IMG>";
		return htmlString;
	}

	public static String printGainPercentHTML(BigDecimal gain) {
		String htmlString, arrow;
		if (gain.doubleValue() < 0.0) {
			htmlString = "(<B><FONT color=\"#ff0000\">";
			arrow = "arrowdown.gif";									
		} else {
			htmlString = "(<B><FONT color=\"#009900\">+";
			arrow = "arrowup.gif";									
		}

		htmlString += gain.setScale(SCALE, ROUND);
		htmlString += "%</FONT></B>)<IMG src=\"images/" + arrow + "\" width=\"10\" height=\"10\" border=\"0\"></IMG>";
		return htmlString;
	}
	
    public static String printQuoteLink(String symbol)	
    {
    	String htmlString;
    	return "<A href=\"app?action=quotes&symbols="+ symbol+"\">" + symbol + "</A>";
    }
	

}
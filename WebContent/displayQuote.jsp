<%@ page import="java.util.Collection, java.util.Iterator, java.math.BigDecimal,com.ibm.samples.trade.*,com.ibm.samples.trade.util.*,com.ibm.samples.trade.direct.*" session="true" isThreadSafe="true" isErrorPage="false"%>
<% 
    String symbol = request.getParameter("symbol");
    TradeServices tAction=null;
	if(TradeConfig.getAccessMode() == TradeConfig.STANDARD)
		tAction = new TradeDirect();
	try { 
		QuoteDataBean quoteData = tAction.getQuote(symbol);

 %>
	<TR align="center" bgcolor="">
		<TD><%= FinancialUtils.printQuoteLink(quoteData.getSymbol()) %></TD>
		<TD><%= quoteData.getCompanyName()%></TD>
		<TD><%= quoteData.getVolume()%></TD>  
		<TD><%= quoteData.getLow() + " - " + quoteData.getHigh()%></TD>                                                                      
		<TD nowrap><%= quoteData.getOpen()%></TD>                                    
		<TD>$ <%= quoteData.getPrice()%></TD>
		<TD><%= FinancialUtils.printGainHTML(new BigDecimal(quoteData.getChange())) %> <%= FinancialUtils.printGainPercentHTML( FinancialUtils.computeGainPercent(quoteData.getPrice(), quoteData.getOpen())) %></TD>
		<TD>
			<FORM><INPUT type="submit" name="action" value="buy"><INPUT type="hidden" name="symbol" value="<%= quoteData.getSymbol().replace(":", "")%>"><INPUT size="4" type="text" name="quantity" value="100"></FORM>
		</TD>
	</TR>

<%
	}
	catch (Exception e)
	{
		Log.error("displayQuote.jsp  exception", e);
	}
%>

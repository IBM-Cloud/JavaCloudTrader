<%@ page import="java.util.Collection, java.util.Iterator, java.math.BigDecimal,com.ibm.samples.trade.*,com.ibm.samples.trade.util.*,com.ibm.samples.trade.direct.*" session="true" isThreadSafe="true" isErrorPage="false"%>

<%
TradeServices tAction=null;
if(TradeConfig.getAccessMode() == TradeConfig.STANDARD)
	tAction = new TradeDirect();
MarketSummaryDataBean marketSummaryData = tAction.getMarketSummary();
%>
            <TABLE border="0" bgcolor="#ffffff" width="383" style=""  class = "simpleBorder" >
                <TBODY>
                    <TR>
                        <TD colspan="2"align="center" height="15"><FONT color=""><B>Market Summary</B></FONT></TD>
                    </TR>
                    <TR>
                        <TD align="right" bgcolor="" height="47" width="100"> <A href="docs/glossary.html"><b>Trade Stock Index (TSIA)</A></TD>
                        <TD align="center" valign="middle" bgcolor="#ffffff" height="47" width="141"><%= marketSummaryData.getTSIA() %> <%= FinancialUtils.printGainPercentHTML(marketSummaryData.getGainPercent()) %></TD>
                    </TR>
                    <TR>
                        <TD align="right" bgcolor=""><A href="docs/glossary.html"><b>Trading Volume</A></TD>
                        <TD align="center" valign="middle"><%= marketSummaryData.getVolume() %></TD>
                    </TR>
                    <TR>
                        <TD align="right" bgcolor="" width="74"><A href="docs/glossary.html"><b>Top Gainers</b></A></TD>
                        <TD bgcolor="#ffffff">
                        <TABLE width="100%"  height="100%" style="">
                            <TBODY>
                                <TR align="center">
                                    <TD><A href="docs/glossary.html"><b>symbol<b></A></TD>
                                    <TD><A href="docs/glossary.html"><b>price<b></A></TD>
                                    <TD><A href="docs/glossary.html"><b>change<b></A></TD>
                                </TR>
                                <%                              
Collection topGainers = marketSummaryData.getTopGainers();
Iterator gainers = topGainers.iterator();
int count=0;
while (gainers.hasNext() && (count++ < 5))
{
	QuoteDataBean quoteData = (QuoteDataBean) gainers.next();
%>
                                <TR align="center">
                                    <TD width="24"><%= FinancialUtils.printQuoteLink(quoteData.getSymbol()) %> </TD>
                                    <TD><%= quoteData.getPrice() %> </TD>
                                    <TD width="52" nowrap><%= FinancialUtils.printGainHTML(quoteData.getPrice().subtract(quoteData.getOpen())) /*FinancialUtils.printGainPercentHTML(FinancialUtils.computeGainPercent(quoteData.getPrice(), quoteData.getOpen()))*/ %></TD>
                                </TR>
                                <%
}
%>
                            </TBODY>
                        </TABLE>
                        </TD>
                    </TR>
                    <TR>
                        <TD align="right" height="55" bgcolor="" width="74"> <A href="docs/glossary.html"><b>Top Losers</b></A></TD>
                        <TD height="55" bgcolor="#ffffff" width="141">
                        <TABLE width="100%" border="0" height="100%" >
                            <TBODY>
                                <TR align="center">
                                    <TD><A href="docs/glossary.html">symbol</A></TD>
                                    <TD><A href="docs/glossary.html">price</A></TD>
                                    <TD><A href="docs/glossary.html">change</A></TD>
                                </TR>
<%
Collection topLosers = marketSummaryData.getTopLosers();
Iterator losers  = topLosers.iterator();
count=0;
while (losers.hasNext() && (count++ < 5))

{
	QuoteDataBean quoteData = (QuoteDataBean) losers.next();
%>
                                <TR align="center">
                                    <TD width="24" nowrap> <%= FinancialUtils.printQuoteLink(quoteData.getSymbol()) %> </TD>
                                    <TD> <%= quoteData.getPrice() %> </TD>
                                    <TD width="52" nowrap> <%= FinancialUtils.printGainHTML(quoteData.getPrice().subtract(quoteData.getOpen())) /* FinancialUtils.printGainPercentHTML(FinancialUtils.computeGainPercent(quoteData.getPrice(), quoteData.getOpen())) */%></TD>
                                </TR>
                                <%
}
%>
                            </TBODY>
                        </TABLE>
                        </TD>
                    </TR>
                </TBODY>
            </TABLE>

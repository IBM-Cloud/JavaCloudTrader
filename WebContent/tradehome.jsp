<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Page Designer V3.5.1 for Windows">
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>Welcome to Trade</TITLE>
<LINK rel="stylesheet" href="style.css" type="text/css" />
</HEAD>
<BODY bgcolor="#ffffff" link="#000099" vlink="#000099">
<div style=" height:100%; overflow-y: scroll;">
<%@ page import="java.util.Collection, java.util.Iterator, java.math.BigDecimal,com.ibm.samples.trade.*,com.ibm.samples.trade.util.*,com.ibm.json.java.*" session="true" isThreadSafe="true" isErrorPage="false"%>
<jsp:useBean id="results" scope="request" type="java.lang.String" />
<jsp:useBean id="accountData" type="com.ibm.samples.trade.AccountDataBean" scope="request" />
<jsp:useBean id="holdingDataBeans" type="java.util.Collection" scope="request"/>
<TABLE height="54"  width = "100%">
	<TBODY>

		<TR align="left">
            <TD><B><A href="app?action=home">Home</A></B><B> </B></TD>
            <TD><B><A href="app?action=account">Account</A></B><B> </B></TD>
            <TD><B><A href="app?action=portfolio">Portfolio</A></B><B> </B></TD>
            <TD><B><A href="app?action=quotes&symbols=s:0,s:1,s:2,s:3,s:4">Quotes/Trade</A></B></TD>
            <TD><B><A href="app?action=logout">Logoff</A></B></TD>
            <TD></TD>
        </TR>
        <TR>
			<TD  colspan="6" align = "right">
            <HR>
            <FONT color="blue"><%= new java.util.Date() %></FONT></TD>
        </TR>

    </TBODY>
</TABLE>
					<%
					 
					 String vcap = System.getenv("VCAP_APPLICATION");	
					 String instance_id = "unknown";
					 String port = "unknown";

					  if (vcap == null) {
					   //System.out.println("No VCAP_SERVICES found");
					  }    
					  else {
						try {
							JSONObject obj = (JSONObject)JSON.parse(vcap);
							System.out.println(obj.toString());
							port = ((Long)obj.get("port")).toString();
							instance_id = obj.get("instance_id").toString();

					      } catch (Exception e) {
					    	  e.printStackTrace();
					    	  
					   }
					 }		
					
					%>
<TABLE width="100%">
    <TBODY>
                    <TBODY>
                    <TR>
                        <TD colspan="3"><B>Welcome &nbsp;<%= accountData.getProfileID() %>,</B></TD>
                    </TR>
        <TR>
            <TD valign="top" width="377">
           <table class = "simpleBorder">

				<% if (vcap != null) { %>
					<TR>
						<TD colspan="3"> Running on port <%=port %> , instance ID : <%= instance_id %></TD>
					</TR>
				<% } %>
                    <TR>
                        <TD width="133"></TD>
                        <TD width="22"></TD>
                        <TD width="212"></TD>
                    </TR>
                    <TR>
                        <TD colspan="3" align="center" ><B><FONT color=""> User Statistics </B></TD>
                    </TR>
                    <TR>
                        <TD align="right" valign="top" width="133"> <A href="docs/glossary.html">account ID:<BR>
                        </A><A href="docs/glossary.html">account created:</A><BR>
                         <A href="docs/glossary.html">total logins:</A><BR>
                        <A href="docs/glossary.html">session created:</A><BR>
                        </TD>
                        <TD width="22"></TD>
                        <TD align="left" width="212"> <%= accountData.getAccountID()
%><BR>
                        <%= accountData.getCreationDate()
%><BR>
                        <%= accountData.getLoginCount()
%><BR>
                        <%= (java.util.Date) session.getAttribute("sessionCreationDate")
%><BR>
                        </TD>
                    </TR>
                    <TR>
                        <TD width="133"></TD>
                        <TD width="22"></TD>
                        <TD width="212"></TD>
                    </TR>
                  </table>
                  <table class = "simpleBorder">
                    <TR>
                        <TD colspan="3" bgcolor="" align="center"> <B><FONT color=""> Account Summary </B></TD>
                    </TR>
                    <TR>
                        <TD align="right" valign="top" width="133"><A href="docs/glossary.html"> cash balance:</A><BR>
                        <A href="docs/glossary.html">number of holdings:</A><BR>
                        <A href="docs/glossary.html">total of holdings:<BR>
                        sum of cash/holdings<BR>
                        opening balance:<BR>
                        </A>
                        <HR>
                        </TD>
                        <TD width="22"></TD>
                        <TD align="left" valign="top" width="212"> 
                        <% 
                        	BigDecimal openBalance = accountData.getOpenBalance();
                        	BigDecimal balance = accountData.getBalance();
                        	BigDecimal holdingsTotal = FinancialUtils.computeHoldingsTotal(holdingDataBeans);
                        	BigDecimal sumOfCashHoldings = balance.add(holdingsTotal);
                        	BigDecimal gain = FinancialUtils.computeGain(sumOfCashHoldings, openBalance);
							BigDecimal gainPercent = FinancialUtils.computeGainPercent(sumOfCashHoldings, openBalance);
                         %>$ <%= balance %><BR>
                        <%= holdingDataBeans.size()%><BR>
                        $ <%= holdingsTotal %><BR>
                        $ <%= sumOfCashHoldings %><BR>
                        $ <%= openBalance%><BR>
                        
                        <HR>
                        </TD>
                    </TR>
                    <TR>
                        <TD valign="top" align="right"><A href="docs/glossary.html">current gain/(loss):</A></TD>
                        <TD></TD>
                        <TD valign="top">
                         $
						<B><%= FinancialUtils.printGainHTML(gain) %> <%= FinancialUtils.printGainPercentHTML(gainPercent) %></B></TD>
                    </TR>
                </TBODY>
            </TABLE>
            			<jsp:include page="marketSummary.jsp" />
            </TD>
            <TD align="center" valign="top" bgcolor="#ffffff" width="290">

			<jsp:include page="socialFeed.html" />

            <BR>
            </TD>
        </TR>
    </TBODY>
</TABLE>
<TABLE height="54" style="">
  <TBODY>
        <TR>
            <TD colspan="2">
            <HR>
            </TD>
        </TR>
        <TR>
            <TD colspan="2">
            <TABLE width="100%" style="font-size: smaller">
                <TBODY>
                    <TR>
                        <TD>Note: Click any <A href="docs/glossary.html">symbol</A> for a quote or to trade.</TD>
                        <TD align="right"><FORM><INPUT type="submit" name="action" value="quotes"> <INPUT size="20" type="text" name="symbols" value="s:0, s:1, s:2, s:3, s:4"></FORM></TD>
                    </TR>
                </TBODY>
            </TABLE>
            </TD>
        </TR>
					</TR>
				</TBODY>

    </TBODY>
</TABLE>
</div>
</BODY>
</HTML>

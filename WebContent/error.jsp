<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.io.*, java.lang.reflect.*" %>
<LINK rel="stylesheet" href="style.css" type="text/css" />
<BODY bgcolor="#ffffff" link="#000099" vlink="#000099">

<DIV align="left"></DIV>
<TABLE width="100%">
  <TBODY>
    <TR>
            <TD width="3"></TD>
            <TD>
      <HR>
      </TD>
            <TD width="3"></TD>
        </TR>
    <TR>
            <TD bgcolor="#e7e4e7" rowspan="4" width="3"></TD>
            <TD><B><FONT color="#000000">An Error has occured during Trade processing</FONT><FONT size="-2">.</FONT></B><BR>
            The stack trace detailing the error follows.
            <p><b>Please consult the application server error logs (SystemOut.log/SystemErr.log/FFDC) for further details.</b></p>
            </TD>
            <TD bgcolor="#e7e4e7" width="3" rowspan="4"></TD>
        </TR>
    <TR>
            <TD><FONT size="-1">

<%
  String message = null;
  int status_code = -1;
  String exception_info = null;
  String url = null;

  try {
    Exception theException = null;
    Integer status = null;

    //these attribute names are specified by Servlet 2.2
    message = (String) request.getAttribute("javax.servlet.error.message");
    status = ((Integer) request.getAttribute("javax.servlet.error.status_code"));
    theException = (Exception) request.getAttribute("javax.servlet.error.exception");
    url = (String) request.getAttribute("javax.servlet.error.request_uri");

    // convert the stack trace to a string
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    theException.printStackTrace(pw);
    pw.flush();
    pw.close();

    if (message == null) {
      message = "not available";
    }

    if (status == null) {
      status_code = -1;             
    }
    else {
      status_code = status.intValue();
    }
    if (theException == null) {
      exception_info = "not available";
    }
    else {
      exception_info = theException.toString();
      exception_info = exception_info + "<br>" + sw.toString();
      sw.close();
    }
  } catch (Exception e) {
     e.printStackTrace();
  }

  out.println("<br><br><b>Processing request:</b>" +  url);      
  out.println("<br><b>StatusCode:</b> " +  status_code);
  out.println("<br><b>Message:</b>" + message);
  out.println("<br><b>Exception:</b>" + exception_info);

%>
</FONT><FONT size="-1">
     </FONT></TD>
        </TR>
    <TR>
            <TD align="left"></TD>
        </TR>
    <TR>
            <TD>
      <HR>
      </TD>
        </TR>
  </TBODY>
</TABLE>

</BODY>

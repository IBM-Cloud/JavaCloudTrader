<!--
 Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>CloudTrader Login</TITLE>

<link href="css/bootstrap.min.css" rel="stylesheet">
<LINK rel="stylesheet" href="style.css" type="text/css" />
</HEAD>
<BODY bgcolor="#ffffff" link="#000099">
<%@ page session="false"%>

<TABLE width="100%" height="30">
	<TBODY>
		<TR>
			<TD></TD>
			<TD><FONT color="#ff0033"><FONT color="#ff0033"><FONT color="#ff0033"><% String results;
results = (String) request.getAttribute("results");
if ( results != null )out.print(results);
%></FONT></FONT></FONT></TD>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">

     <div class="modal-body">
     <h3 class="text-center">Login</h3>
          <form class="form col-md-12 center-block" action="app" method="POST">
            <div class="form-group">
              <input type="text" name = "uid" class="form-control input-lg"  value = "uid:0">
            </div>
            <div class="form-group">
              <input type="password" name = "passwd"  class="form-control input-lg" value = "xxx">
            </div>
            <div class="form-group">
            <INPUT type="hidden" name="action"	value="login">
              <input class="btn btn-primary btn-lg btn-block" type = "submit"/>
            </div>
          </form>
      </div>
</DIV>
<span class="pull-right"><A href="register.jsp">First time user?</A></span>
</BODY>
</HTML>

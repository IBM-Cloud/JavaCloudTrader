<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
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
<HTML>
<HEAD>
    <META http-equiv="Content-Style-Type" content="text/css">
    <link rel="stylesheet" type="text/css" href="style.css" media="screen" />
    <TITLE>Configuration and utilities</TITLE>
</HEAD>

<BODY BGCOLOR="#FFFFFF">
<div class = "container">
<%@ page import="java.util.Collection, java.util.Iterator,com.ibm.json.java.*" isThreadSafe="true" isErrorPage="false"%>



<TABLE>
    <TBODY>
        <TR>
            <TD align="center" colspan="2">
                <H3>Configuration Utilities</H3>
Running on port <%=port %> , instance ID : <%= instance_id %>
<br>
            </TD>
        </TR>
        <TR>
            <TD align="center" width = "25%"><B><FONT size="-1">Configuration Tools</FONT></B></TD>
            <TD align="center"><B><FONT size="-1"></FONT>Description
            </B></TD>
        </TR><!-- 
        <TR>
            <TD><A href="config?action=resetTrade"><FONT face="Times New Roman"
                                                         size="-1">Reset<BR>
                (to be done before each run)</FONT></A></TD>
            <TD>Reset the runtime to a clean starting point by logging
                off all users, removing new registrations and other general cleanup.
                For consistent results this URL should be run <B>before each </B>Trade
                run.</TD>
        </TR>
        <TR>
            <TD><A href="config" target="_self"><FONT face="Times New Roman"
                                                      size="-1">Configure run-time parameters</FONT></A></TD>
            <TD>This link provides an interface to set configuration parameters
                that control run-time characteristics such as using EJBs or
                JDBC. This link also provides utilities such as setting the UID and
                Password for a remote or protected database when using JDBC.</TD>
        </TR>
        <TR>
            <TD><A href="config?action=buildDBTables" target="_blank"><FONT
                    face="Times New Roman" size="-1">(Re)-create
                &nbsp;&nbsp;Database Tables and Indexes</FONT></A></TD>
            <TD>This link is used to (a) initially create or (b) drop and re-create the
                 tables. <b>A  database should exist before doing this action</b>, 
                the existing tables, if any, are dropped, then new
                tables and indexes are created. <b>Please stop and re-start the application 
                (or your application server) after this action and then use the "Repopulate 
                Database" link below to repopulate the new database tables.</b></TD>
        </TR>  -->
        <TR>
            <TD><A href="config?action=buildDB">(Re)-populate Database</A></TD>
            <TD>This link is used to initially populate or re-populate the
                database with fictitious users (uid:0, uid:1, ...) and
                stocks (s:0, s:1, ...). First all existing users and stocks are
                deleted (if any). The database is then populated with a new set of
                users and stocks. This option does not drop and recreate the 
                db tables.</TD>
        </TR>
        <TR>
            <TD><a href = "generateOOM" target = "_blank" onclick="return confirm('Are you sure? This will kill one of the application instances')">Generate Out Of Memory failure</a></TD>
            <TD>This link will cause an OOM and kill the server of one (not necessarily this) application instance. If you have multiple instances, re-visit the application immediately after the OOM to get redirected to another instance. The killed instance should restart in a few minutes. </TD>
        </TR>
        <TR>
            <TD><a href = "stress.jsp">Stress test</a></TD>
            <TD>Run a script which will generate mock load on the server by logging in with multiple users and issuing trades. </TD>
        </TR>
        <TR>
            <TD>VCAP_SERVICES</TD>
            <TD>					<textarea rows="20" cols="80" style = "    display: block;margin-left: auto;    margin-right: auto;" id = "vcap_services"></textarea>
					<script>
					myjson = <%=System.getenv("VCAP_SERVICES")%>;
					if(myjson!=null)
						document.getElementById("vcap_services").value = JSON.stringify(myjson, undefined, 2);
					
					</script></TD>
        </TR>
    </TBODY>
</TABLE>


					
				
</div>
</BODY>
</HTML>


					

<%@ page import="java.util.Collection, java.util.Iterator, java.math.BigDecimal,com.ibm.samples.trade.*,com.ibm.samples.trade.util.*,com.ibm.json.java.*" session="true" isThreadSafe="true" isErrorPage="false"%>

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
<%=port %>
//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//
	
package com.ibm.samples.trade.web.prims;

 /**
 *
 * Simple bean to get and set messages
 */
 

public class PingBean {
	  
  private String msg;
  
/**
 * returns the message contained in the bean
 * @return message String
 **/
public String getMsg()
{
	return msg;
}      
/**
* sets the message contained in the bean 
* param message String
**/
public void setMsg(String s)
{
	msg = s;
}      
}
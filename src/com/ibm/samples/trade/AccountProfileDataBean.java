//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade;

import com.ibm.samples.trade.util.*;

public class AccountProfileDataBean
		implements java.io.Serializable 
{

    /* Accessor methods for persistent fields */

	private String	userID;				/* userID */
    private String	password;			/* password */
    private String	fullName;			/* fullName */
    private String	address;			/* address */
    private String	email;				/* email */
    private String	creditCard;			/* creditCard */

    public AccountProfileDataBean(){ }
    public AccountProfileDataBean(String userID,
									String	password,
									String	fullName,
									String	address,
									String	email,
									String	creditCard)
	{
		setUserID(userID);      
		setPassword(password);    
		setFullName(fullName);      
		setAddress(address);  
		setEmail(email);          
		setCreditCard(creditCard);      
	}
	
	public static AccountProfileDataBean getRandomInstance() {
		return new AccountProfileDataBean(
			TradeConfig.rndUserID(),			// userID
			TradeConfig.rndUserID(),			// password
			TradeConfig.rndFullName(),			// fullname
			TradeConfig.rndAddress(),			// address
			TradeConfig.rndEmail(TradeConfig.rndUserID()), //email
			TradeConfig.rndCreditCard()  		// creditCard
		);
	}
	
	public String toString()
	{
		return "\n\tAccount Profile Data for userID:" + getUserID()
			+ "\n\t\t   password:" + getPassword()
			+ "\n\t\t   fullName:" + getFullName()
			+ "\n\t\t    address:" + getAddress()
			+ "\n\t\t      email:" + getEmail()
			+ "\n\t\t creditCard:" + getCreditCard()
			;
	}
	public String toHTML()
	{
		return "<BR>Account Profile Data for userID: <B>" + getUserID() + "</B>"
			+ "<LI>   password:" + getPassword() + "</LI>"
			+ "<LI>   fullName:" + getFullName() + "</LI>"
			+ "<LI>    address:" + getAddress() + "</LI>"
			+ "<LI>      email:" + getEmail() + "</LI>"
			+ "<LI> creditCard:" + getCreditCard() + "</LI>"
			;
	}
	public void print()
	{
		Log.log( this.toString() );
	}	

	/**
	 * Gets the userID
	 * @return Returns a String
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * Sets the userID
	 * @param userID The userID to set
	 */
	public void setUserID(String userID)
	{
		this.userID = userID;
	}

	/**
	 * Gets the password
	 * @return Returns a String
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Sets the password
	 * @param password The password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * Gets the fullName
	 * @return Returns a String
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * Sets the fullName
	 * @param fullName The fullName to set
	 */
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	/**
	 * Gets the address
	 * @return Returns a String
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Sets the address
	 * @param address The address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * Gets the email
	 * @return Returns a String
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets the email
	 * @param email The email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Gets the creditCard
	 * @return Returns a String
	 */
	public String getCreditCard() {
		return creditCard;
	}
	/**
	 * Sets the creditCard
	 * @param creditCard The creditCard to set
	 */
	public void setCreditCard(String creditCard)
	{
		this.creditCard = creditCard;
	}

}

//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade.web.prims;

import java.io.*;

/**
 * 
 * An object that contains approximately 1024 bits of information.  This is used by
 * {@link PingSession3}
 *
 */
public class PingSession3Object implements Serializable {
	// PingSession3Object represents a BLOB of session data of various. 
	// Each instantiation of this class is approximately 1K in size (not including overhead for arrays and Strings)
	// Using different datatype exercises the various serialization algorithms for each type

	byte[] byteVal = new byte[16]; // 8 * 16 = 128 bits
	char[] charVal = new char[8]; // 16 * 8 = 128 bits
	int a, b, c, d; // 4 * 32 = 128 bits
	float e, f, g, h; // 4 * 32 = 128 bits
	double i, j; // 2 * 64 = 128 bits
	// Primitive type size = ~5*128=   640

	String s1 = new String("123456789012");	 
	String s2 = new String("abcdefghijkl");
//										 String type size = ~2*12*16 =   384
//										 Total blob size (w/o overhead) =  1024


//	 The Session blob must be filled with data to avoid compression of the blob during serialization
	PingSession3Object()
	{
		int index;
		byte b = 0x8;
		for (index=0; index<16; index++)
		{
			byteVal[index] = (byte) (b+2);
		}

		char c = 'a';
		for (index=0; index<8; index++)
		{
			charVal[index] = (char) (c+2);
		}

		a=1; b=2; c=3; d=5;
		e = (float)7.0; f=(float)11.0; g=(float)13.0; h=(float)17.0;
		i=(double)19.0; j=(double)23.0;
	}
/**
 * Main method to test the serialization of the Session Data blob object
 * Creation date: (4/3/2000 3:07:34 PM)
 * @param args java.lang.String[]
 */

/** Since the following main method were written for testing purpose, we comment them out
*public static void main(String[] args) {
*	try {
*		PingSession3Object data = new PingSession3Object();
*
*		FileOutputStream ostream = new FileOutputStream("c:\\temp\\datablob.xxx");
*		ObjectOutputStream p = new ObjectOutputStream(ostream);
*		p.writeObject(data);
*		p.flush();
*		ostream.close();
*	}
*	catch (Exception e)
*	{
*		System.out.println("Exception: " + e.toString());
*	}
*}
*/

}
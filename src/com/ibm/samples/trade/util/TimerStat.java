//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade.util;

/**
 * @author stancox
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class TimerStat {

		private double min=1000000000.0, max=0.0, totalTime=0.0;
		private int count;
		/**
		 * Returns the count.
		 * @return int
		 */
		public int getCount() {
			return count;
		}

		/**
		 * Returns the max.
		 * @return double
		 */
		public double getMax() {
			return max;
		}

		/**
		 * Returns the min.
		 * @return double
		 */
		public double getMin() {
			return min;
		}

		/**
		 * Sets the count.
		 * @param count The count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}

		/**
		 * Sets the max.
		 * @param max The max to set
		 */
		public void setMax(double max) {
			this.max = max;
		}

		/**
		 * Sets the min.
		 * @param min The min to set
		 */
		public void setMin(double min) {
			this.min = min;
		}

		/**
		 * Returns the totalTime.
		 * @return double
		 */
		public double getTotalTime() {
			return totalTime;
		}

		/**
		 * Sets the totalTime.
		 * @param totalTime The totalTime to set
		 */
		public void setTotalTime(double totalTime) {
			this.totalTime = totalTime;
		}

		/**
		 * Returns the max in Secs
		 * @return double
		 */
		public double getMaxSecs() {
			return max/1000.0;
		}

		/**
		 * Returns the min in Secs
		 * @return double
		 */
		public double getMinSecs() {
			return min/1000.0;
		}
		
		/**
		 * Returns the average time in Secs
		 * @return double
		 */
		public double getAvgSecs() {
			
			double avg =  (double)getTotalTime() / (double)getCount();
			return avg / 1000.0;
		}		
		

}

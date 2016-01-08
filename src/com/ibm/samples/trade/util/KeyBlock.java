//
// "This sample program is provided AS IS and may be used, executed, copied and modified without royalty payment by customer (a) for its own
// instruction and study, (b) in order to develop applications designed to run with an IBM WebSphere product, either for customer's own internal use 
// or for redistribution by customer, as part of such an application, in customer's own products. " 
//
// (C) COPYRIGHT International Business Machines Corp., 2005
// All Rights Reserved * Licensed Materials - Property of IBM
//

package com.ibm.samples.trade.util;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
public class KeyBlock extends AbstractSequentialList 
{

	// min and max provide range of valid primary keys for this KeyBlock
	private int min = 0;
	private int max = 0;
	private int index = 0;

	/**
	 * Constructor for KeyBlock
	 */
	public KeyBlock() {
		super();
		min = 0;
		max = 0;
		index = min;
	}

	/**
	 * Constructor for KeyBlock 
	 */
	public KeyBlock(int min, int max) {
		super();
		this.min = min;
		this.max = max;
		index = min;
	}

	/**
	 * @see AbstractCollection#size()
	 */
	public int size() {
		return (max - min) + 1;
	}

	/**
	 * @see AbstractSequentialList#listIterator(int)
	 */
	public ListIterator listIterator(int arg0) {
		return new KeyBlockIterator();
	}

	class KeyBlockIterator implements ListIterator {

		/**
		 * @see ListIterator#hasNext()
		 */
		public boolean hasNext() {
			return index <= max;
		}

		/**
		 * @see ListIterator#next()
		 */
		public synchronized Object next() {
			if (index > max)
				throw new java.lang.RuntimeException("KeyBlock:next() -- Error KeyBlock depleted");
			return new Integer(index++);
		}

		/**
		 * @see ListIterator#hasPrevious()
		 */
		public boolean hasPrevious() {
			return index > min;
		}

		/**
		 * @see ListIterator#previous()
		 */
		public Object previous() {
			return new Integer(--index);
		}

		/**
		 * @see ListIterator#nextIndex()
		 */
		public int nextIndex() {
			return index-min;
		}

		/**
		 * @see ListIterator#previousIndex()
		 */
		public int previousIndex() {
			throw new UnsupportedOperationException("KeyBlock: previousIndex() not supported");
		}

		/**
		 * @see ListIterator#add()
		 */
		public void add(Object o) {
			throw new UnsupportedOperationException("KeyBlock: add() not supported");
		}

		/**
		 * @see ListIterator#remove()
		 */
		public void remove() {
			throw new UnsupportedOperationException("KeyBlock: remove() not supported");
		}

		/**
		 * @see ListIterator#set(Object)
		 */
		public void set(Object arg0) {
		}
	}
}
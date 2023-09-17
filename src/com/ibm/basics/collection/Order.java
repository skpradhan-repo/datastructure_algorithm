/**
 * 
 */
package com.ibm.basics.collection;

import java.util.Date;

/**
 * @author 004ISA744
 *
 */
public class Order {
	private int order_id;
	private int customer_id;
	private Date order_date;

	public Order(int order_id, int customer_id, Date order_date) {
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.order_date = order_date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
}

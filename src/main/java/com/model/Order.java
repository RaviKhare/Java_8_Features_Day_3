/**
 * 
 */
package main.java.com.model;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author rk
 *
 */


public class Order implements Callable<Order>{

   private Long orderId;
   private String orderName;
   private int orderQuantity;
   private Date orderDate;
   private String orderFlavour;
   private double orderBillAmount;
   
   
	@Override
	public Order call() throws Exception {
		Thread.sleep(100);
		return this;
	}

	public Order() {
		super();
	}

	public Order(Long orderId, String orderName, int orderQuantity, Date orderDate, String orderFlavour, double orderBillAmount) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
		this.orderFlavour =orderFlavour;
		this.orderBillAmount =orderBillAmount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderFlavour() {
		return orderFlavour;
	}

	public void setOrderFlavour(String orderFlavour) {
		this.orderFlavour = orderFlavour;
	}

	public double getOrderBillAmount() {
		return orderBillAmount;
	}

	public void setOrderBillAmount(double orderBillAmount) {
		this.orderBillAmount = orderBillAmount;
	}
	
	
	
}

package restaurantapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
	static int nextNo = 1;
    private int orderNo;
    private LocalDateTime orderTime;
    private String status;
    private int numPax;
    private Table theTable;
    private List<OrderItem> orderItems;

    public Order(Table theTable, int numPax) {
    	setOrderNo(nextNo++);
        this.numPax = numPax;
        this.theTable = theTable;
        this.orderTime = LocalDateTime.now();
        this.status = "new";
        setOrderItems(new ArrayList<OrderItem>());
    }

	// adding an order item to the order
	public OrderItem addItem(MenuItem mi, int quantity, String request)
    {
        OrderItem oi = new OrderItem(this, mi, quantity, request);
        if (orderItems.contains(oi))	// already ordered
        	return null;
        orderItems.add(oi);
        return oi;
    }

	
	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * @return the orderNo
	 */
	public int getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the orderTime
	 */
	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the numPax
	 */
	public int getNumPax() {
		return numPax;
	}

	/**
	 * @param numPax the numPax to set
	 */
	public void setNumPax(int numPax) {
		this.numPax = numPax;
	}

	/**
	 * @return the theTable
	 */
	public Table getTheTable() {
		return theTable;
	}

	/**
	 * @param theTable the theTable to set
	 */
	public void setTheTable(Table theTable) {
		this.theTable = theTable;
	}

	@Override
	public String toString() {
		return "Order No=" + orderNo + ", orderTime=" + orderTime + 
				", status=" + status + ", num of diners=" + numPax
				+ ", Table no=" + theTable.getTableNo();
	}

    public boolean removeItem(OrderItem unwanted)
    {
     	 return orderItems.remove(unwanted);
 						// use ArrayList method
    }

	// a method to calculate the total for the order 
	// (all ordered items) 
	public double getTotal()
   	 {
     	   double total = 0.0;
      	  for (OrderItem oi:orderItems)
       	 {
        	    total += oi.getTotal();	// total for each ordered item
       	 }
      	  return total;
   	 }

}

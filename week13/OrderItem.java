package restaurantapp;

public class OrderItem {
    
    private Order theOrder;
    private MenuItem theMenuItem;
    private int quantity;
    private String specialRequest;
    private String status;

    
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

	public OrderItem(Order theOrder, MenuItem mi, int qty, String req) {
        this.theOrder = theOrder;
        this.theMenuItem = mi;
        this.quantity = qty;
        this.specialRequest = req;
        setStatus("outstanding");
    }

    @Override
    public boolean equals(Object obj) {	
        if (obj == null)			// based on same order and item
            return false;
        if (getClass() != obj.getClass())
             return false; 
       final OrderItem other = (OrderItem) obj;
       if (!this.theOrder.equals(other.theOrder))
    	   return false;
       if (!this.theMenuItem.equals(other.theMenuItem))
    	   return false;
        return true;
    }

    // A method to calculate the total ordered
    public double getTotal()
    {
        return theMenuItem.getPrice() * quantity;
    }
    
    // toString() method to show info about the order item
    public String toString()
    {
        return "Item: " + theMenuItem.getItemNo() + " "+
        	theMenuItem.getDescription() + " Quantity Required :" + 
        	quantity + " Special Req: " + specialRequest + 
        	" Total price " + getTotal(); 
    }

	/**
	 * @return the theOrder
	 */
	public Order getTheOrder() {
		return theOrder;
	}

	/**
	 * @param theOrder the theOrder to set
	 */
	public void setTheOrder(Order theOrder) {
		this.theOrder = theOrder;
	}

	/**
	 * @return the theMenuItem
	 */
	public MenuItem getTheMenuItem() {
		return theMenuItem;
	}

	/**
	 * @param theMenuItem the theMenuItem to set
	 */
	public void setTheMenuItem(MenuItem theMenuItem) {
		this.theMenuItem = theMenuItem;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the specialRequest
	 */
	public String getSpecialRequest() {
		return specialRequest;
	}

	/**
	 * @param specialRequest the specialRequest to set
	 */
	public void setSpecialRequest(String specialRequest) {
		this.specialRequest = specialRequest;
	}

}

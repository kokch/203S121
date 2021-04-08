package restaurantapp;

import java.util.ArrayList;

public class Table {
    private int tableNo;
    private int seatingCapacity;
    private String currentStatus;
    private int xPos;		// each table has a location
    private int yPos;
    private ArrayList<Order> tableOrders;

    public Table(int tableNo, int seatingCapacity, int xPos, int yPos) {
        setTableNo(tableNo);
        this.seatingCapacity = seatingCapacity;
        this.xPos = xPos;
        this.yPos = yPos;
        this.currentStatus="available";
        tableOrders = new ArrayList<>();
    }

	// add the method createNewOrder()
	public Order addOrderToTable (int numPax) {
		Order newOrder = new Order(this, numPax);
		tableOrders.add(newOrder);
  		setCurrentStatus("occupied"); 	// table is occupied
		return newOrder;
   	 }

	/**
	 * @return the tableNo
	 */
	public int getTableNo() {
		return tableNo;
	}

	/**
	 * @param tableNo the tableNo to set
	 */
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	/**
	 * @return the seatingCapacity
	 */
	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	/**
	 * @param seatingCapacity the seatingCapacity to set
	 */
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	/**
	 * @return the currentStatus
	 */
	public String getCurrentStatus() {
		return currentStatus;
	}

	/**
	 * @param currentStatus the currentStatus to set
	 */
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return the tableOrders
	 */
	public ArrayList<Order> getTableOrders() {
		return tableOrders;
	}

	/**
	 * @param tableOrders the tableOrders to set
	 */
	public void setTableOrders(ArrayList<Order> tableOrders) {
		this.tableOrders = tableOrders;
	}

    
}

package restaurantapp;

import java.util.ArrayList;

public class Restaurant {
    
    private ArrayList<MenuItem> menuItems;
    private ArrayList<Table> tables;
    private ArrayList<Order> orders;
    
    public Restaurant()
    {
        menuItems = new ArrayList<MenuItem>();
        setTables(new ArrayList<Table>());
        setupTables();
    }
    
    public ArrayList<Order> allOrders() {
    	ArrayList<Order> orderList = new ArrayList<>();
    	for (Table table: getTables())
    		orderList.addAll(table.getTableOrders());
    	return orderList;
    }
    public MenuItem findMenuItem(int itemNo)
    {
        for(MenuItem mi : menuItems)
            if(mi.getItemNo()==itemNo)
                return mi;
        return null;
    }   
    
    public boolean addMenuItem(String description, double price)
    {
        MenuItem mi = new MenuItem(description, price);
        return menuItems.add(mi);
    }
    
    public void addTable(int tableNo, int seatingCapacity, int xPos, int yPos)
    {
        Table t = new Table(tableNo, seatingCapacity, xPos, yPos);
        getTables().add(t);
    }

    public void updateItem(MenuItem theItem, String description, double price)
    {
        theItem.setDescription(description);
        theItem.setPrice(price);
    }
 
    public void setupTables()
    {
        // create 16 tables in positions x = 10, 20, 30, 40, y = 10, 20, 30, 40
        int tableNo = 1;
        for (int y = 10; y <=250; y+=70 )
        {
            for (int x = 10; x<=250; x+=70)
            {
                int cap = (int) ((Math.random() * 6) + 2); // generate random capacity
                addTable(tableNo++, cap, x, y);
  
            }
        }
    }
    
    // add a method to find a table from the arraylist
	public Table getTable(int tableNo)
	{
	    for (Table t:tables)
	    {
	        if (t.getTableNo()==tableNo)
	            return t;
	    }
	    return null;
	}
	
	//add the CreateNewOrder method
	public Order createNewOrder(int tableNo, int numPax)
	{
	    Table theTable = getTable(tableNo);
	    if (theTable==null)
	        return null;
	    return theTable.addOrderToTable(numPax);	// return the order created
	}

    /**
	 * @return the menuItems
	 */
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

	/**
	 * @param menuItems the menuItems to set
	 */
	public void setMenuItems(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	
	/**
	 * @return the tables
	 */
	public ArrayList<Table> getTables() {
		return tables;
	}

	/**
	 * @param tables the tables to set
	 */
	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}

	/**
	 * @return the orders
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public int numOfItems() {
    	return getMenuItems().size();
    }
}


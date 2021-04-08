package restaurantapp;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class OrderTableModel extends AbstractTableModel {
	static String[] headers = {"Order No", "Table No", "Order Date", 
		"Order Time", "Status"};
	private Restaurant restaurant;
	private ArrayList<Order> orders;
	
	public OrderTableModel(ArrayList<Order> orders) { //Restaurant rest) {
		//setRestaurant(rest);
		setOrders(orders);
	}

	public int getRowCount() {
		return getOrders().size();
	}
	
	public int getColumnCount() {
		return headers.length;
	}

	public Object getValueAt(int row, int col) {
		Order order = getOrders().get(row);
		switch (col) {
		case 0:
			return order.getOrderNo();
		case 1:
			return order.getTheTable().getTableNo();
		case 2:
			return order.getOrderTime().toLocalDate();
		case 3:
			return order.getOrderTime().toLocalTime();
		default:
			return order.getStatus();
		}
	}
	
	public String getColumnName(int col) {
		return headers[col];
	}
	
	// to return the Order object at a specified row    
	public Order getOrderAt(int row) {
        return getOrders().get(row);
    }

	/**
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * @param restaurant the restaurant to set
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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
	
}

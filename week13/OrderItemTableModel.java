package restaurantapp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class OrderItemTableModel extends AbstractTableModel {
	private List<OrderItem> orderItems;

	public OrderItemTableModel() {
		setOrderItems(new ArrayList<>());
	}
	
	public int getRowCount() {
		return getOrderItems().size();
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public Object getValueAt(int row, int col) {
		OrderItem oi = getOrderItems().get(row);
		MenuItem mi = oi.getTheMenuItem();
		switch (col) {
		case 0: return mi.getItemNo() + " - " + mi.getDescription();
		case 1: return oi.getQuantity();
		case 2: return oi.getSpecialRequest();
		default: return oi.getStatus();
		}
	}
	
	
	
	public String getColumnName(int col) {
		switch (col) {
		case 0: return "Menu Item";
		case 1: return "Quantity";
		case 2: return "Specail Request";
		default: return "Status";
		}
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
		fireTableDataChanged();
	}
	
}

package restaurantapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.GridLayout;

public class OrderStatusWindow extends JDialog {

	private JPanel contentPane;
	private JTable ordersTable;
	private Restaurant restaurant;
	private OrderTableModel otm;
	private OrderItemTableModel oitm;
	private JScrollPane scrollPane_1;
	private JTable orderItemTable;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderStatusWindow frame = new OrderStatusWindow(
						new Restaurant());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderStatusWindow(Restaurant rest) {
		restaurant = rest;

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		ordersTable = new JTable();
		scrollPane.setViewportView(ordersTable);
		
		scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1);
		
		orderItemTable = new JTable();
		scrollPane_1.setViewportView(orderItemTable);
		
		setupTableModel();
	}

	   // add a method to manage the table views and table models
    public void setupTableModel() {
    	otm = new OrderTableModel(restaurant.allOrders());
    	ordersTable.setModel(otm); 	// put the data in the Jtable
    	oitm = new OrderItemTableModel();
    	orderItemTable.setModel(oitm);
    	
        // add: set up to allow only one Order to be selected
        ordersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // add a listener to the selection for if the selection has changed
        ordersTable.getSelectionModel().addListSelectionListener(
        	new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateItemsTable();
            }
        });

    }
    
    public void updateItemsTable() {
        int row = ordersTable.getSelectedRow();	// determine which row was selected
        Order theOrder = otm.getOrderAt(row);	// get the Order at that row of the table
	
        // update the order items table model to show the order items
        oitm.setOrderItems(theOrder.getOrderItems());
        //oitm.fireTableDataChanged();		// update the view
    }


}

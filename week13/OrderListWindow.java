package restaurantapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderListWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField itemNoTF;
	private JTextField requestTF;
	private JLabel lblTableNo;
	private JLabel lblOrderNo;
	private JComboBox qtyCB;
	private JLabel totalL;
	
	private Restaurant theRestaurant;
	private Order theOrder;
	private DefaultListModel listModel;
	private JList<OrderItem> orderList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderListWindow dialog = new OrderListWindow(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderListWindow(Restaurant restaurant, Order order) {
		theRestaurant = restaurant;
		theOrder = order;
		setModal(true);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblTableNo = new JLabel("Table No");
			GridBagConstraints gbc_lblTableNo = new GridBagConstraints();
			gbc_lblTableNo.anchor = GridBagConstraints.WEST;
			gbc_lblTableNo.gridwidth = 2;
			gbc_lblTableNo.insets = new Insets(0, 0, 5, 5);
			gbc_lblTableNo.gridx = 0;
			gbc_lblTableNo.gridy = 0;
			contentPanel.add(lblTableNo, gbc_lblTableNo);
		}
		{
			 lblOrderNo = new JLabel("Order No");
			GridBagConstraints gbc_lblOrderNo = new GridBagConstraints();
			gbc_lblOrderNo.anchor = GridBagConstraints.WEST;
			gbc_lblOrderNo.gridwidth = 2;
			gbc_lblOrderNo.insets = new Insets(0, 0, 5, 5);
			gbc_lblOrderNo.gridx = 3;
			gbc_lblOrderNo.gridy = 0;
			contentPanel.add(lblOrderNo, gbc_lblOrderNo);
		}
		{
			JLabel lblItemNo = new JLabel("Item No:");
			GridBagConstraints gbc_lblItemNo = new GridBagConstraints();
			gbc_lblItemNo.anchor = GridBagConstraints.WEST;
			gbc_lblItemNo.insets = new Insets(0, 0, 5, 5);
			gbc_lblItemNo.gridx = 0;
			gbc_lblItemNo.gridy = 1;
			contentPanel.add(lblItemNo, gbc_lblItemNo);
		}
		{
			itemNoTF = new JTextField();
			GridBagConstraints gbc_itemNoTF = new GridBagConstraints();
			gbc_itemNoTF.insets = new Insets(0, 0, 5, 5);
			gbc_itemNoTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_itemNoTF.gridx = 1;
			gbc_itemNoTF.gridy = 1;
			contentPanel.add(itemNoTF, gbc_itemNoTF);
			itemNoTF.setColumns(5);
		}
		{
			JLabel lblMenuItemDescription = new JLabel("Menu Item Description");
			GridBagConstraints gbc_lblMenuItemDescription = new GridBagConstraints();
			gbc_lblMenuItemDescription.insets = new Insets(0, 0, 5, 5);
			gbc_lblMenuItemDescription.gridx = 2;
			gbc_lblMenuItemDescription.gridy = 1;
			contentPanel.add(lblMenuItemDescription, gbc_lblMenuItemDescription);
		}
		{
			JLabel lblQuantity = new JLabel("Quantity:");
			GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
			gbc_lblQuantity.anchor = GridBagConstraints.WEST;
			gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
			gbc_lblQuantity.gridx = 0;
			gbc_lblQuantity.gridy = 2;
			contentPanel.add(lblQuantity, gbc_lblQuantity);
		}
		{
			 qtyCB = new JComboBox();
			qtyCB.setEditable(true);
			qtyCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
			GridBagConstraints gbc_qtyCB = new GridBagConstraints();
			gbc_qtyCB.insets = new Insets(0, 0, 5, 5);
			gbc_qtyCB.fill = GridBagConstraints.HORIZONTAL;
			gbc_qtyCB.gridx = 1;
			gbc_qtyCB.gridy = 2;
			contentPanel.add(qtyCB, gbc_qtyCB);
		}
		{
			JLabel lblSpecialRequest = new JLabel("Special Request:");
			GridBagConstraints gbc_lblSpecialRequest = new GridBagConstraints();
			gbc_lblSpecialRequest.anchor = GridBagConstraints.EAST;
			gbc_lblSpecialRequest.insets = new Insets(0, 0, 5, 5);
			gbc_lblSpecialRequest.gridx = 0;
			gbc_lblSpecialRequest.gridy = 3;
			contentPanel.add(lblSpecialRequest, gbc_lblSpecialRequest);
		}
		{
			requestTF = new JTextField();
			GridBagConstraints gbc_requesttF = new GridBagConstraints();
			gbc_requesttF.gridwidth = 2;
			gbc_requesttF.insets = new Insets(0, 0, 5, 5);
			gbc_requesttF.fill = GridBagConstraints.HORIZONTAL;
			gbc_requesttF.gridx = 1;
			gbc_requesttF.gridy = 3;
			contentPanel.add(requestTF, gbc_requesttF);
			requestTF.setColumns(10);
		}
		{
			JButton addItemBtn = new JButton("Add Item");
			addItemBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int itemNo = Integer.parseInt(itemNoTF.getText());
					MenuItem theMenuItem = restaurant.findMenuItem(itemNo);
					if (theMenuItem == null) {
						JOptionPane.showMessageDialog(OrderListWindow.this, 
							"Invalid item number");
						return ;
					}
						
			        int qty = Integer.parseInt((String) qtyCB.getSelectedItem());
			        String req = requestTF.getText();
			        OrderItem oi = theOrder.addItem(theMenuItem, qty, req);
			        if (oi==null)		// item exists in order
			            JOptionPane.showMessageDialog(OrderListWindow.this, 
			            	"Item already ordered. Delete to change", "Error", JOptionPane.ERROR_MESSAGE);
			        else {
			            listModel.addElement(oi);
			         	theMenuItem = null;     // reset the order item input field
			        	itemNoTF.setText("");
			        	qtyCB.setSelectedIndex(0);
			        	requestTF.setText("");
			        	updateOrderTotal(); // call this method after the item is added 

			        }

				}
			});
			GridBagConstraints gbc_addItemBtn = new GridBagConstraints();
			gbc_addItemBtn.insets = new Insets(0, 0, 5, 5);
			gbc_addItemBtn.gridx = 3;
			gbc_addItemBtn.gridy = 3;
			contentPanel.add(addItemBtn, gbc_addItemBtn);
		}
		{
			JLabel lblOrderedItems = new JLabel("Ordered Items:");
			GridBagConstraints gbc_lblOrderedItems = new GridBagConstraints();
			gbc_lblOrderedItems.insets = new Insets(0, 0, 5, 5);
			gbc_lblOrderedItems.anchor = GridBagConstraints.WEST;
			gbc_lblOrderedItems.gridwidth = 5;
			gbc_lblOrderedItems.gridx = 0;
			gbc_lblOrderedItems.gridy = 4;
			contentPanel.add(lblOrderedItems, gbc_lblOrderedItems);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 5;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 5;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				orderList = new JList<OrderItem>();

				scrollPane.setViewportView(orderList);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm Order");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				        theOrder.setStatus("Confirmed");
				        JOptionPane.showMessageDialog(OrderListWindow.this, 
				        	"Order Number:" + theOrder.getOrderNo() + " is confirmed");
				        OrderListWindow.this.getParent().setVisible(true);
				        OrderListWindow.this.dispose();

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int opt = JOptionPane.showConfirmDialog(
							OrderListWindow.this, "Confirm cancel order#" + 
							theOrder.getOrderNo() + "?",
							"Cancel Order", JOptionPane.YES_NO_OPTION);
						if (opt == JOptionPane.YES_OPTION) {
							theOrder.setStatus("Cancelled");
							OrderListWindow.this.dispose();
							OrderListWindow.this.getParent().setVisible(true);
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		lblTableNo.setText("Table No "+ theOrder.getTheTable().getTableNo());
		lblOrderNo.setText("Order No "+ theOrder.getOrderNo());

		listModel = new DefaultListModel();
		orderList.setModel(listModel);
		{
			 totalL = new JLabel("Order Total:");
			GridBagConstraints gbc_totalL = new GridBagConstraints();
			gbc_totalL.anchor = GridBagConstraints.WEST;
			gbc_totalL.insets = new Insets(0, 0, 0, 5);
			gbc_totalL.gridwidth = 3;
			gbc_totalL.gridx = 0;
			gbc_totalL.gridy = 6;
			contentPanel.add(totalL, gbc_totalL);
		}
		{
			JButton btnNewButton = new JButton("Delete Selected Item");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        java.util.List<OrderItem> unwanted;
			        unwanted = orderList.getSelectedValuesList();
			        for (OrderItem ui:unwanted)
			        {
			            theOrder.removeItem(ui);    // delete from order
			            listModel.removeElement(ui);// remove from view
			        }
			        updateOrderTotal();     // call the method to upate label
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 3;
			gbc_btnNewButton.gridy = 6;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
		}
		
	}
    // a method to update the label
    private void updateOrderTotal()
    {
        double totalPrice = theOrder.getTotal();
        String result = String.format("Order Total : $%.2f", totalPrice);
        totalL.setText(result);  
    }


}

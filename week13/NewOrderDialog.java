package restaurantapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewOrderDialog extends JDialog {
	private Restaurant restaurant;
	private TablesPanel tablesPanel;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField tableNoTF;
	private JTextField noOfDinersTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewOrderDialog dialog = new NewOrderDialog(new Restaurant());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewOrderDialog(Restaurant restaurant) {
		this.restaurant = restaurant;
		setModal(true);
		
		setBounds(100, 100, 600, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			tablesPanel = new TablesPanel(restaurant.getTables());
			tablesPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent evt) {
			        int x = evt.getX();
			        int y = evt.getY();
			        int tableNo = ((TablesPanel) tablesPanel).getTableNo(x, y);  
			                                                                                // must downcast
			        if (tableNo == -1)				// didn't click within table
			        	tableNoTF.setText("");
			        else
			            tableNoTF.setText("" + tableNo);

				}
			});
			contentPanel.add(tablesPanel);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JLabel lblTableNo = new JLabel("Table No:");
				panel.add(lblTableNo);
			}
			{
				tableNoTF = new JTextField();
				panel.add(tableNoTF);
				tableNoTF.setColumns(10);
			}
			{
				JLabel lblNumberOfDiners = new JLabel("No. of Diners:");
				panel.add(lblNumberOfDiners);
			}
			{
				noOfDinersTF = new JTextField();
				panel.add(noOfDinersTF);
				noOfDinersTF.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				        // get the values entered in the text fields
				        try{
				            int tableNo = Integer.parseInt(tableNoTF.getText());
				            int numPax = Integer.parseInt(noOfDinersTF.getText());
				            Order theOrder = restaurant.createNewOrder(tableNo, numPax);
				            
				            OrderListWindow olWin = new OrderListWindow(restaurant, theOrder);
				            NewOrderDialog.this.setVisible(false);
				            olWin.setVisible(true);
				            
				            //JOptionPane.showMessageDialog(NewOrderDialog.this, "Order created :" +theOrder.toString());
				        }
				        catch(NumberFormatException nfe)
				        {
				            JOptionPane.showMessageDialog(NewOrderDialog.this,"Please enter numeric values");
				        }
				        NewOrderDialog.this.dispose();
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
						NewOrderDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

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
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuItemDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField itemTF;
	private JTextField descriptionTF;
	private JTextField priceTF;
	
	private Restaurant res;
	private MenuItem item;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuItemDialog dialog = new MenuItemDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuItemDialog(Restaurant res) {
		this.res = res;
		setModal(true);
		setBounds(100, 100, 500, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel lblItemNo = new JLabel("Item No:");
			contentPanel.add(lblItemNo);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				itemTF = new JTextField();
				panel.add(itemTF);
				itemTF.setColumns(10);
			}
			{
				JButton btnSearch = new JButton("Search");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String itemNoStr = itemTF.getText();
						int itemNo = Integer.parseInt(itemNoStr);
						item = res.findMenuItem(itemNo);
						if (item == null) {
							int opt = JOptionPane.showConfirmDialog(
								MenuItemDialog.this, 
								"Item Not Found. Create new item?", 
								"Not Found", JOptionPane.YES_NO_OPTION);
							if (opt == JOptionPane.YES_OPTION) {
			             		itemTF.setText(""+MenuItem.getNextNo());
			            		itemTF.setEnabled(false);
			             		descriptionTF.setEnabled(true);
			             		priceTF.setEnabled(true);
			            		//okButton.setEnabled(true);
			            		btnSearch.setEnabled(false);								
							}
						}
						else {

					// read description and price into text boxes  
				       	   descriptionTF.setText(item.getDescription());
				           priceTF.setText(""+item.getPrice());

					// enable for editing
				           descriptionTF.setEnabled(true);
				           priceTF.setEnabled(true);
				           //okButton.setEnabled(true);
									itemTF.setEnabled(false);
									btnSearch.setEnabled(false);

						}
					}
				});
				panel.add(btnSearch);
			}
		}
		{
			JLabel lblDescription = new JLabel("Description:");
			contentPanel.add(lblDescription);
		}
		{
			descriptionTF = new JTextField();
			contentPanel.add(descriptionTF);
			descriptionTF.setColumns(10);
		}
		{
			JLabel lblPrcie = new JLabel("Prcie:");
			contentPanel.add(lblPrcie);
		}
		{
			priceTF = new JTextField();
			contentPanel.add(priceTF);
			priceTF.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				        // get the values from the text fields
				        String description = descriptionTF.getText();
				        double price = Double.parseDouble(priceTF.getText());
				        
				        // item exists – use the instance variable referencing the Controller
				        if (item != null)
				            res.updateItem(item, description, price);  
				        else    // item does not exist, create new item
				           res.addMenuItem(description, price);
				       
				        // close the dialog
				        MenuItemDialog.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						MenuItemDialog.this.dispose();
					}	
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblMaintainMenuItem = new JLabel("Maintain Menu Item");
			lblMaintainMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(lblMaintainMenuItem, BorderLayout.NORTH);
		}
	}

}

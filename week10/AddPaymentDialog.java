package finalassign;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPaymentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfAmount;
	private JTextField tfName;
	private JTextField tfExpiredDate;
	private JTextField tfNumber;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JRadioButton rdbtnCash;
	JLabel lblName, lblExpiredDate, lblNumber;
	private Payment payment;
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddPaymentDialog dialog = new AddPaymentDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPaymentDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel lblType = new JLabel("Type:");
			contentPanel.add(lblType);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				rdbtnCash = new JRadioButton("Cash");
				rdbtnCash.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (rdbtnCash.isSelected()) {
							System.out.println(rdbtnCash + "<<");
							System.out.println(lblName + " <<<");
							lblName.setVisible(false);
							tfName.setVisible(false);
							lblExpiredDate.setVisible(false);
							tfExpiredDate.setVisible(false);
							lblNumber.setVisible(false);
							//tfNumber.setVisible(false);
							tfNumber.setEditable(false);
						} else {
							lblName.setVisible(true);
							lblExpiredDate.setVisible(true);
							lblNumber.setVisible(true);
							tfName.setVisible(true);
							tfExpiredDate.setVisible(true);
							//tfNumber.setVisible(true);
							
							tfNumber.setEditable(true);
						}
					}
				});
				buttonGroup.add(rdbtnCash);
				panel.add(rdbtnCash);
			}
			{
				JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
				rdbtnCreditCard.setSelected(true);
				buttonGroup.add(rdbtnCreditCard);
				panel.add(rdbtnCreditCard);
			}
		}
		{
			JLabel lblAmount = new JLabel("Amount:");
			contentPanel.add(lblAmount);
		}
		{
			tfAmount = new JTextField();
			contentPanel.add(tfAmount);
			tfAmount.setColumns(10);
		}
		{
			lblName = new JLabel("Name:");
			contentPanel.add(lblName);
		}
		{
			tfName = new JTextField();
			contentPanel.add(tfName);
			tfName.setColumns(10);
		}
		{
			lblExpiredDate = new JLabel("Expired Date:");
			contentPanel.add(lblExpiredDate);
		}
		{
			tfExpiredDate = new JTextField();
			contentPanel.add(tfExpiredDate);
			tfExpiredDate.setColumns(10);
		}
		{
			lblNumber = new JLabel("Number:");
			contentPanel.add(lblNumber);
		}
		{
			tfNumber = new JTextField();
			contentPanel.add(tfNumber);
			tfNumber.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String amountStr = tfAmount.getText();
						
						if (amountStr.equals("")) {
							JOptionPane.showMessageDialog(null, "Please enter amount");
							tfAmount.requestFocus();
							return ;
						}
						try {
							double amount = Double.parseDouble(amountStr);
							
							if (!rdbtnCash.isSelected()) {
								String name = tfName.getText();
								String expDate = tfExpiredDate.getText();
								String number = tfNumber.getText();
								if (name.isEmpty() || expDate.isEmpty() || number.isEmpty()) {
									JOptionPane.showMessageDialog(AddPaymentDialog.this, "Enter all fields!");
									return ;
								}
								payment = new CreditCardPayment(amount, name, expDate, number);
							}
							else
								payment = new CashPayment(amount);
							//System.out.println(payment + " <<<<<<<<<");
							//clearAllFields();
							setVisible(false);
							
						} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(AddPaymentDialog.this, "Please enter numeric value" );
							tfAmount.setText("");
							tfAmount.requestFocus();
							return ;
						}
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
						payment = null;
						setVisible(false);
						// clear all fields
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void clearFields() {
		// do all clearing the text here
		// and set the default radio button selected is CreditCard
		
	}
}

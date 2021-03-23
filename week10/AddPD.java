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
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup typeRBG = new ButtonGroup();
	private JLabel lblType;
	private JLabel lblAmount;
	private JLabel lblHolderName;
	private JLabel lblExpiredDate;
	private JLabel lblCardNumber;
	private JTextField amountTF;
	private JTextField nameTF;
	private JTextField expiredDateTF;
	private JTextField numberTF;
	private JRadioButton rdbtnCreditCard, rdbtnCash;
	
	private Payment p;
	private Expenses expenses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddPD dialog = new AddPD(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPD(Expenses expenses) {
		setModal(true);
		this.expenses = expenses;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			lblType = new JLabel("Type:");
			contentPanel.add(lblType);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				rdbtnCash = new JRadioButton("Cash");
				rdbtnCash.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (!rdbtnCash.isSelected()) {
							//lblType.setVisible(true);
							lblHolderName.setVisible(true);
							nameTF.setVisible(true);
							lblExpiredDate.setVisible(true);
							expiredDateTF.setEditable(true);
							lblCardNumber.setEnabled(true);
							//tfNumber.setVisible(true);
							numberTF.setEditable(true);
						} else {
							lblExpiredDate.setVisible(false);
							lblCardNumber.setEnabled(false);
							lblHolderName.setVisible(false);
							nameTF.setVisible(false);
							expiredDateTF.setEditable(false);
							//tfNumber.setVisible(true);
							numberTF.setEditable(false);
						}
					}					
				});
				typeRBG.add(rdbtnCash);
				panel.add(rdbtnCash);
			}
			{
				rdbtnCreditCard = new JRadioButton("Credit Card");
				typeRBG.add(rdbtnCreditCard);
				rdbtnCreditCard.setSelected(true);
				panel.add(rdbtnCreditCard);
			}
		}
		{
			lblAmount = new JLabel("Amount:");
			contentPanel.add(lblAmount);
		}
		{
			amountTF = new JTextField();
			contentPanel.add(amountTF);
			amountTF.setColumns(10);
		}
		{
			lblHolderName = new JLabel("Holder Name:");
			contentPanel.add(lblHolderName);
		}
		{
			nameTF = new JTextField();
			contentPanel.add(nameTF);
			nameTF.setColumns(10);
		}
		{
			lblExpiredDate = new JLabel("Expired Date (mm/yy):");
			contentPanel.add(lblExpiredDate);
		}
		{
			expiredDateTF = new JTextField();
			contentPanel.add(expiredDateTF);
			expiredDateTF.setColumns(10);
		}
		{
			lblCardNumber = new JLabel("Card Number:");
			contentPanel.add(lblCardNumber);
		}
		{
			numberTF = new JTextField();
			contentPanel.add(numberTF);
			numberTF.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String amountStr = amountTF.getText();
						double amount = Double.parseDouble(amountStr);
						if (rdbtnCreditCard.isSelected()) {
							String name = nameTF.getText();
							String expiredDate = expiredDateTF.getText();
							String number = numberTF.getText();
							p = new CreditCardPayment(amount, name, expiredDate, number); 
						}
						else
							p = new CashPayment(amount);
						expenses.add(p);
						// clear text from all fields
						nameTF.setText(null);
						setVisible(false);
						
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
						JOptionPane.showMessageDialog(AddPD.this, 
							"Addition Aborted.");
						p = null;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

package expenses;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddCCJD extends JDialog {
	private JLabel amountL, nameL, expDateL, numberL;
	private JTextField amountTF, nameTF, expDateTF, numberTF;
	private JButton okBtn, resetBtn, cancelBtn;
	
	private Payment pay;
	
	public AddCCJD(JFrame frame)
	{
		super(frame, true);
		setTitle("Add Credit Card Payment");
		setBounds(100, 100, 200, 300);
		
		// set up the components
		JPanel p = new JPanel(new GridLayout(4,2,8,8));
		amountL = new JLabel("Amount:");
		nameL = new JLabel("Name:");
		expDateL = new JLabel("Expired Date:");
		numberL = new JLabel("Number");
		
		amountTF = new JTextField(10);
		nameTF = new JTextField(10);
		expDateTF = new JTextField(10);
		numberTF = new JTextField(10);
		
		p.add(amountL);		p.add(amountTF);
		p.add(nameL);		p.add(nameTF);
		p.add(expDateL);	p.add(expDateTF);
		p.add(numberL);		p.add(numberTF);
		
		okBtn = new JButton("OK");
		resetBtn = new JButton("Reset");
		cancelBtn = new JButton("Cancel");
		
		okBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String amountStr = amountTF.getText().trim();
				String name = nameTF.getText().trim();
				String expDate = expDateTF.getText().trim();
				String number = numberTF.getText().trim();
				
				pay = new CreditCardPayment(Double.parseDouble(amountStr),
					name, expDate, number);
				
				amountTF.setText("");
				nameTF.setText("");
				expDateTF.setText("");
				numberTF.setText("");
				
				setVisible(false);
			}
		});
		
		cancelBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				amountTF.setText("");
				nameTF.setText("");
				expDateTF.setText("");
				numberTF.setText("");
				
				pay = null;
				
				setVisible(false);				
			}
		});

		resetBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				amountTF.setText("");
				nameTF.setText("");
				expDateTF.setText("");
				numberTF.setText("");				
			}
		});
		
		JPanel btnP = new JPanel();
		btnP.add(okBtn);
		btnP.add(resetBtn);
		btnP.add(cancelBtn);
		
		getContentPane().add(new JLabel("Lists of payments"), "North");
		getContentPane().add(p, "Center");
		getContentPane().add(btnP, "South");
		
	}
	
	public Payment getPayment()
	{
		return pay;
	}
	
	public static void main(String[] args)
	{
		JDialog j = new AddCCJD(new JFrame());
		j.pack();
		j.setVisible(true);
		System.out.println(((AddCCJD) j).getPayment());
	}
	
}

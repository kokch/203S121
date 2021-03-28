package expenses;
import javax.swing.table.AbstractTableModel;


public class PaymentTM extends AbstractTableModel {
	private Expenses expenses;
	private String[] title = {"TYPE", "Amount", "Name", "Expired Date", "Number"};
	
	public PaymentTM(Expenses e)
	{
		expenses = e;
	}
	
	public void add(Payment p)
	{
		expenses.add(p);
		fireTableDataChanged();
	}
	
	public int getColumnCount()
	{
		// return 5;
		return title.length;
	}
	
	public int getRowCount()
	{
		return expenses.numOfCashPayment() + expenses.numOfCreditCardPayment();
		// return expenses.getPayments().size();
	}
	
	public Object getValueAt(int row, int col)
	{
		Payment p = expenses.getPayments().get(row);
		switch (col)
		{
		case 0:
			if (p instanceof CashPayment)
				return "Cash";
			else
				return "CreditCard";
		case 1:
			return p.getAmount(); // return new Double(p.getAmount());
		case 2:
			if (p instanceof CashPayment)
				return "-";
			else
				return ((CreditCardPayment) p).getName();
		case 3:
			if (p instanceof CashPayment)
				return "-";
			else
				return ((CreditCardPayment) p).getExpireDate();
		case 4:
			if (p instanceof CashPayment)
				return "-";
			else
				return ((CreditCardPayment) p).getNumber();
		default:
			return "";
		}
	}
	
	// ADDED FOR EXTRA delete function
	public void remove(int row) {
		expenses.getPayments().remove(row);
		fireTableDataChanged();
	}
	
	public Payment get(int i)			
	{
		return expenses.getPayments().get(i);
	}
	
	public void setExpenses(Expenses e)
	{
		expenses = e;
	}
	public String getColumnName(int col)
	{
		return title[col];
		
		/*
		switch (col)
		{
		case 0:
			return "Type";
		case 1:
			return "Amount";
		case 2:
			return "Name";
		case 3:
			return "Expired Date";
		case 4:
			return "Number";
		default:
			return "";
		}
		*/
	}
}

package finalassign;

import javax.swing.table.AbstractTableModel;

public class PaymentTableModel extends AbstractTableModel {
	private Expenses expenses;
	
	public PaymentTableModel(Expenses expenses) {
		setExpenses(expenses);
	}
	
	public int getRowCount() {
		return getExpenses().numOfPayments();
		// return getExpenses().getPayments().size();
	}

	public int getColumnCount() {
		return 7;
	}
	
	public Object getValueAt(int row, int col) {
		Payment p = getExpenses().getPayments().get(row);
		switch (col) {
		case 0: return row + 1;
		case 1: return p.getPaymentID();
		case 2: if (p instanceof CashPayment)
					return "Cash";
				else
					return "CreditCard";
		case 3: return p.getAmount();
		case 4: if (p instanceof CashPayment)
					return "N/A";
				else
					return ((CreditCardPayment) p).getName();
		case 5: if (p instanceof CashPayment)
					return "N/A";
				else
					return ((CreditCardPayment) p).getExpireDate();
		case 6: if (p instanceof CreditCardPayment)
					return((CreditCardPayment) p).getNumber();
				else
					return "N/A";
		default: return null;
		}
	}
	/*
	public String getColumnName(int col) {
		switch (col) {
		case 0: return "No";
		case 1: return "ID";
		case 2: return "Type";
		case 3: return "Amount";
		case 4: return "Name";
		case 5: return "Expired Date";
		default: return "Number";
		
		}
	}
	*/
	public Expenses getExpenses() {
		return expenses;
	}

	public void setExpenses(Expenses expenses) {
		this.expenses = expenses;
	}
	
	public void add(Payment p) {
		expenses.add(p);
		fireTableDataChanged();
	}
	
	public void delPayment(int row) {
		expenses.getPayments().remove(row);
		fireTableDataChanged();
	}
}

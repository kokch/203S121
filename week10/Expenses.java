package finalassign;

import java.util.ArrayList;

public class Expenses implements java.io.Serializable {
	private String name;
	private ArrayList<Payment> payments;
	
	public Expenses(String name) {
		setName(name);
		setPayments(new ArrayList<Payment>());
	}
	
	public void add(Payment p) {
		getPayments().add(p);
	}
	
	public Payment findPayment(int paymentID) {
		for (Payment p: getPayments())
			if (p.getPaymentID() == paymentID)
				return p;
		
		return null;
	}
	
	public int numOfPayments() {
		return getPayments().size();
	}
	
	public int numOfCashPayment() {
		int count = 0;
		for (Payment p: getPayments())
			if (p instanceof CashPayment)
				count ++;
		return count;
	}
	
	public int numOfCreditCardPayment() {
		return numOfPayments() - numOfCashPayment();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Payment> getPayments() {
		return payments;
	}
	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}
	
	

}

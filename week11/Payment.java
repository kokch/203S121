package finalassign;

import java.io.Serializable;

public abstract class Payment extends Object implements Serializable   {
	static int autoGN = 1;
	private int paymentID;
	private double amount;
	
	public Payment(double amount) {
		setAmount(amount);
		setPaymentID(autoGN++);
	}
	
	public Payment() {
		//setAmount(0.0);
		//setPaymentID(autoGN++);
		
		this(0.0);
	}
	
	public static int getAutoGN() {
		return autoGN;
	}
	public static void setAutoGN(int autoGN) {
		Payment.autoGN = autoGN;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return String.format("amount paid is %1.2f", getAmount());
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Payment)
			return this.getAmount() == ((Payment) obj).getAmount();
		return false;
	}
}

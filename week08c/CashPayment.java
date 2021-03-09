package second;

public class CashPayment extends Payment {
	
	public CashPayment(double amount) {
		super(amount);
		//setAmount(amount);
	}
	
	public String toString() {
		return "Cash payment, " + super.toString();
	}
}

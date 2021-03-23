package finalassign;

public class CashPayment extends Payment {

	public CashPayment(double amount) {
		super(amount);
	}

	public CashPayment() {
		this(0.0);
		//super();
	}
	public String toString() {
		return "Cash payment, " + super.toString();
	}
}

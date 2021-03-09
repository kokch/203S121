package first;

public class CashPayment extends Payment {
	
	public CashPayment(double amount) {
		super(amount); //Super has to come first line
	}
	
	public String toString() {
		return "Cash payment, " + super.toString(); //Calling the super
													//class toString()
	}
}

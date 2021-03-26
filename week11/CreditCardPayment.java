package finalassign;

public class CreditCardPayment extends Payment {
	private String name;
	private String expireDate;
	private String number;
	
	public CreditCardPayment(double amount, String name, 
		String expireDate, String number) {
		super(amount);
		setName(name);
		setExpireDate(expireDate);
		setNumber(number);
	}
	
	public CreditCardPayment() {
		this(0.0, "not set", "not set", "not set");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toString( ) {
		return "Using card (" + getName() + " [" + getNumber() + 
			"] exp: (" + getExpireDate() + "\n" +
			"for credit-card payment, " + super.toString();
	}
}

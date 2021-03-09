package first;

public class CreditCardPayment extends Payment {
	private String name;
	private String expireDate;
	private String number;
	
	public CreditCardPayment(double amount, String name, 
		String expireDate, String number) {
		super(amount); //Super has to come first line
		setName(name);
		setExpireDate(expireDate);
		setNumber(number);
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
	
	public String toString() {
		return "Using card (" + getName() + " [" + getNumber() +
			"] exp: " + getExpireDate() + ")\n for credit-card " +
			"payment, " + super.toString();  
	}
}

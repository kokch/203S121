package first;

public abstract class Payment implements Comparable<Payment>, java.io.Serializable {
	private double amount;
	private int paymentNum;
	private static int genPayNum = 100;

	public Payment(double amount) {
		setAmount(amount);
		setPaymentNum(genPayNum ++);
	}
	
	public int getPaymentNum() {
		return paymentNum;
	}

	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
	}

	public static int getGenPayNum() {
		return Payment.genPayNum;
	}

	public static void setGenPayNum(int genPayNum) {
		Payment.genPayNum = genPayNum;
	}

	public int compareTo(Payment rhs) {
		if (this.getAmount() > rhs.getAmount())
			return 1;
		else if (this.getAmount() < rhs.getAmount())
			return -1;
		else
			return 0;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return String.format("%d amount paid is %.2f", getPaymentNum(), getAmount());
								//%.2f control 2 decimal places
	}
}

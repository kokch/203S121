package first;

import java.util.Comparator;

public class PaymentType_Amount implements Comparator<Payment> {
	public int compare(Payment lhs, Payment rhs) {
		int typeStatus = lhs.getClass().getName().compareToIgnoreCase(
			rhs.getClass().getName());
		if (typeStatus != 0)
			return typeStatus;
		if (lhs.getAmount() > rhs.getAmount())
			return 1;
		else if (lhs.getAmount() < rhs.getAmount())
			return -1;
		else
			return 0;
	}
	
	public static void main(String[] args) {
		Payment p1 = new CashPayment(100);
		Payment p3 = new CashPayment(100);
		Payment p4 = new CashPayment(50);
		Payment p5 = new CashPayment(300);
		
		Payment p2 = new CreditCardPayment(50, "James", "11/21", "123");
		Payment p6 = new CreditCardPayment(150, "James", "11/21", "123");
		Payment p7 = new CreditCardPayment(5, "James", "11/21", "123");
		
		System.out.println(p1.compareTo(p2));
		PaymentType_Amount pta = new PaymentType_Amount();
		System.out.println(pta.compare(p1,  p3));
		System.out.println(pta.compare(p1,  p4));
		System.out.println(pta.compare(p1,  p5));
		System.out.println(pta.compare(p2,  p6));
		System.out.println(pta.compare(p2,  p7));
		System.out.println(pta.compare(p4,  p2));
		System.out.println(pta.compare(p2,  p4));	
	}
}

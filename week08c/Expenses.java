package second;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Expenses implements java.io.Serializable {
	private String name;
	private List<Payment> payments;


	public Expenses(String name) {
		this(name, new ArrayList<>());
	}
	
	public Expenses(String name, List<Payment> payments) {
		setName(name);
		setPayments(payments);
	}
	
	public void add(Payment p) {
		getPayments().add(p);
	}
	
	public String allPayments() {
		return getPayments().stream()
			.map(Payment::toString)
			.collect(Collectors.joining("\n"));
		
		/* Conventional
		String str = "";
		for (Payment p: getPayments())
			str += p.toString() + "\n";
		return str;
		*/
	}
	
	public List<Payment> sortedPayment() {
		return getPayments().stream()
			.sorted(//(p1,p2) -> Double.compare(
					//p2.getAmount(), p1.getAmount()))
				Comparator.comparing(Payment::getAmount)
				) //.reversed())
			.collect(Collectors.toList());
	}
	
	public String sortedPayments(Comparator<Payment> comp) {
		return getPayments().stream()
			.sorted(comp)
			.map(Payment::toString)
			.collect(Collectors.joining("\n"));
	}
	
	public String toString() {
		return getPayments().stream()
			.sorted() // sort according to natural order
			.map(Payment::toString)
			.collect(Collectors.joining("\n"));
	}
	
	public Payment highestPayment() {
		return getPayments().stream()
			.max(//(p1,p2) -> Double.compare(
					//p1.getAmount(), p2.getAmount()))
					Comparator.comparing(Payment::getAmount))
			.get();
	}
	
	public double total() {
		return getPayments().stream()
			.mapToDouble(Payment::getAmount)
			.sum();
		
		/* Not preferred since we can directly convert to double
		return getPayments().stream()
			.map(Payment::getAmount)
			.mapToDouble(x -> x) //Double::doubleValue)
			.sum();
		*/
	}
	
	public int numOfCashPayments() {
		return (int) getPayments().stream()
				.filter(x -> x instanceof CashPayment)
				.count();
	}
	
	public int numOfCreditCardPaymets() {
		return getPayments().size() - numOfCashPayments();
	}
	
	public List<CashPayment> allCashPaymentsAsList() {
		return getPayments().stream()
				.filter(x -> x instanceof CashPayment)
				.map(x -> (CashPayment) x)
				.collect(Collectors.toList());		
	}

	public String creditCardPaymentBy(String name) {
		return getPayments().stream()
			.filter(x -> x instanceof CreditCardPayment &&
					((CreditCardPayment) x).getName().
					equalsIgnoreCase(name))
			.map(Payment::toString)
			.collect(Collectors.joining("\n"));
	}
	
	public String allPaymentsOfType(String type) {
		return getPayments().stream()
				.filter(x -> type.equalsIgnoreCase("Cash")?
						x instanceof CashPayment:
						x instanceof CreditCardPayment)
				.map(Payment::toString)
				.collect(Collectors.joining("\n"));
	}
	
	public String findPayments(String type) {
		return getPayments().stream()
			.filter(x -> type.equalsIgnoreCase("Cash")?
					x instanceof CashPayment:
					x instanceof CreditCardPayment)
			.map(Payment::toString)
			.collect(Collectors.joining("\n"));
	}
	
	public String findPayments(double amount) {
		return getPayments().stream()
			.filter(x -> x.getAmount() >= amount)
			.map(Payment::toString)
			.collect(Collectors.joining("\n"));	
	}
	
	public String allCashPayments() {
		return getPayments().stream()
			.filter(x -> x instanceof CashPayment)
			.map(Payment::toString)
			.collect(Collectors.joining("\n"));		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the payments
	 */
	public List<Payment> getPayments() {
		return payments;
	}

	/**
	 * @param payments the payments to set
	 */
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}

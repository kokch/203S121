package first;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Expenses implements Serializable {
	private String name;
	private ArrayList<Payment> payments;
	
	public Expenses(String name) {
		setName(name);
		setPayments(new ArrayList<>());
	}
	
	public Expenses() {
		this("not set");
	}
	
	public int numOfCreditCardPayments() {
		return getPayments().size() - numOfCashPayments();
	}
	
	public String allPayments() {
		String result = "";
		for (Payment p: getPayments())
			result += p + "\n";
		return result;
	}
	
	public String sortedPayments(Comparator<Payment> comp) {
		// Making a shallow copy
		ArrayList<Payment> copy = new ArrayList<>(getPayments());
		Collections.sort(copy, comp);
		
		String result = "";
		for (Payment p: copy)
			result += p + "\n";
		return result;
	}


	public Payment highestPayment() {
		Payment highest = getPayments().get(0);
		for (Payment p: getPayments())
			if (p.getAmount() > highest.getAmount())
				highest = p;
		return highest;
	}
	
	public String toString() {
		// Making a shallow copy
		ArrayList<Payment> copy = new ArrayList<>(getPayments());
		Collections.sort(copy);
		
		String result = "";
		for (Payment p: copy)
			result += p + "\n";
		
		return result;
	}
	
	public int numOfCashPayments() {
		int count = 0;
		for (Payment p: getPayments())
			if (p instanceof CashPayment)
				count ++;
		
		return count;
	}
	
	public double total() {
		double total = 0;
		for (Payment p: getPayments()) 
			total += p.getAmount();
		
		return total;
	}
	
	public String findPayments(String type) {
		String result = "";
		for (Payment p: getPayments())
			if (type.equalsIgnoreCase("CASH")) {
				if (p instanceof CashPayment)
					result += p + "\n";
			} else if (type.equalsIgnoreCase("CREDIT")) {
				if (p instanceof CreditCardPayment)
					result += p + "\n";
			}
		return result;
	}
	
	public String findPayments(double amount) {
		String result = "";
		
		for (int i = 0; i < getPayments().size(); i++) {
			Payment p = getPayments().get(i);
			if (p.getAmount() >= amount)
				result += p + "\n";
		}
		return result;
		
		/*
		for (int i = 0; i < getPayments().size(); i++)
			if (getPayments().get(i).getAmount() >= amount)
				result += getPayments().get(i) + "\n";
		*/	
	}
	
	public void add(Payment p) {
		getPayments().add(p);
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

package first;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExpensesConsole {
	static Scanner kbd;
	static Expenses expenses;
	
	public static void main(String[] args) {
        kbd = new Scanner(System.in);
        System.out.print("Name? ");
        String name = kbd.nextLine();

        expenses = new Expenses(name);

        System.out.println();
        char options;
        do {
            options = menu();
            switch (options) {
                case '1':
                    addNewPayment();
                    break;
                case '2':
                	displayPaymentGreaterOrEq();
                    break;
                case '3':
                	displayPayments();
                    break;
                case '4':
                	displaySummary();
                    break;
                case '5':
                	displayAllPayments();
                    break;
                case '6':
                	writeToFile();
                	break;
                case '7':
                	readFromFile();
                	break;
                case 'Q': case 'q':
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid choice! Enter again: ");
                    break;
            }
            System.out.println();
        } while (options != 'Q' && options != 'q');
    }

	public static void readFromFile() {
		System.out.println("Reading from file...");
		System.out.print("File name? ");
		String fileName = kbd.nextLine();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(fileName + ".txt"));
			Payment.setGenPayNum(Integer.parseInt(br.readLine()));
			
			fis = new FileInputStream(fileName + ".dat");
			ois = new ObjectInputStream(fis);
			expenses = (Expenses) ois.readObject();
			
			br.close();
			ois.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("'" + fileName + "' does not exist.");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("Error in reading....");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error in casting...");
		}
	}
	
	public static void writeToFile() {
		System.out.println("Saving to file....");
		System.out.print("File name? ");
		String fileName = kbd.nextLine();
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(fileName + ".txt"));
			pw.println(Payment.getGenPayNum());
			
			fos = new FileOutputStream(fileName + ".dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(expenses);
			
			pw.close();
			fos.close();
			oos.close();
			
		} catch (IOException fnfe) {
			System.out.println("Errors in writing to file");
			fnfe.printStackTrace();
			return ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Data saved... ");
	}
	
    public static char menu() {
        System.out.println("Expenses for " + expenses.getName());
        System.out.println("1. Add Payment");
        System.out.println("2. Display Payments, >= amounts entered");
        System.out.println("3. Display Payments, of specific type");
        System.out.println("4. Display Summary Information");
        System.out.println("5. Display Payment");
        System.out.println("6. Write to file");
        System.out.println("7. Read from file");
        System.out.println("Q. Quit");
        System.out.println();
        System.out.print("Your Choice: ");

        char choice = kbd.nextLine().charAt(0);
        return choice;
    }

    public static void addNewPayment() {
        System.out.println("Adding new payment");

        System.out.print("Sales amount? ");
        double amount = kbd.nextDouble();

        Payment p = null;
        kbd.nextLine();
        System.out.print("Payment type? <Cash> or <Credit> ");
        String type = kbd.nextLine();

        if (type.equalsIgnoreCase("cash")) {
            p = new CashPayment(amount);
        } else {
            System.out.print("Credit Card Holder: ");
            String name = kbd.nextLine();
            System.out.print("Expire On: (mm/yy) ");
            String expireDate = kbd.nextLine();
            System.out.print("Credit Card Number: ");
            String number = kbd.nextLine();
            p = new CreditCardPayment(amount, name, expireDate, number);
        }
        expenses.add(p);
        System.out.println("Addition Success");

    }

    public static void displayAllPayments() {
    	System.out.println("Display all payments...");
    	System.out.print("In <O>riginal order, \nSorted according to " + 
    		"<A>amount, or \nSorted according to payment " + 
    		"<T>ype then amount: ");
    	String choice = kbd.nextLine();
    	System.out.println();
    	if (choice.equalsIgnoreCase("O"))
    		System.out.println(expenses.allPayments());
    	else if (choice.equalsIgnoreCase("A"))
    		System.out.println(expenses);
    	else if (choice.equalsIgnoreCase("T"))
    		System.out.println(expenses.sortedPayments(
    			new PaymentType_Amount()));
    	else
    		System.out.println("Invalid choice!");
    }

    public static void displaySummary() {
        System.out.println("Summary Information");
        System.out.println("Number of cash payments: " +
        	expenses.numOfCashPayments());
        System.out.println("Number of credit card payments: " + 
        	expenses.numOfCreditCardPayments());
        System.out.println("Total Payments: RM" + expenses.total());
    }

    public static void displayPaymentGreaterOrEq() {
        System.out.print("Amount: ");
        double amount = kbd.nextDouble();

        kbd.nextLine();
        String result = expenses.findPayments(amount);
        if (result.equals("")) {
            System.out.println("No payment greater than or " + 
            	"equal to amount " + amount);
        } else {
            System.out.println(result);
        }
    }

    public static void displayPayments() {
    	System.out.print("Display <Cash> or <Credit> Card Payments? ");
        String type = kbd.nextLine();

        String result = expenses.findPayments(type);
        if (result.equals("")) {
            System.out.println("No payment of type: " + type);
        } else {
        	System.out.println((type.equalsIgnoreCase("Cash")? 
        		"Cash":"Credit Card") + " Payments:" );
            System.out.println(result);
        }
    }

}

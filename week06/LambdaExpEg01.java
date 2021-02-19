package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaExpEg01 {

	public static void main(String[] args) {
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student("Jenny", 19, 90.0)); 
		stuList.add(new Student("James", 25, 70.5)); 
		stuList.add(new Student("Jimmy", 18, 85.0));
		
		// Using Comparable - Natural order
		System.out.println("Student with 'largest' alphabetic name: " + 
			Collections.max(stuList));
		
		// Using instance of Comparator - specify 'customize' order
		System.out.println("Oldest student: " + 
			Collections.max(stuList, new AgeComparator()));
		
		// Using anonymous class - specify 'customize' order
		System.out.println("Student with highest mark: " +
			Collections.max(stuList, new Comparator<Student>() {
				public int compare(Student lhs, Student rhs) {
					return Double.compare(lhs.getMark(), rhs.getMark());
				}
			})
		);
		
		// Using lambda expression - specify 'customize' order
		System.out.println("Youngest student: " + Collections.min(stuList, 
			(lhs, rhs) -> Integer.compare(lhs.getAge(), rhs.getAge())));

		System.out.println(stuList);
		stuList.sort(null); // Using natural order - Comparable interface
		System.out.println("After sorted according to names:\n" + stuList);
		stuList.sort((s1, s2) -> Double.compare(s1.getMark(), s2.getMark()));
		System.out.println("After sorted according to marks, ascending:\n" + stuList);
		stuList.sort((s1, s2) -> Double.compare(s2.getMark(), s1.getMark()));
		System.out.println("After sorted according to marks, descending:\n" + stuList);
		
		System.out.println("\n~~~~~~~~~~~~");
		ArrayList<Item> itemList = new ArrayList<>();
		itemList.add(new Item("Pen", 1.25));
		itemList.add(new Item("Eraser", 0.45));
		itemList.add(new Item("Scissors", 2.35));
		itemList.add(new Item("Pencil", 0.55));

		System.out.println("Item with 'largest' alphabetical name: " + 
			Collections.max(itemList));
		System.out.println("Item with 'smallest' alphabetical name: " +
			Collections.min(itemList));
		System.out.println("Most expensive item: " + Collections.max(itemList,
			(lhs, rhs) -> Double.compare(lhs.getPrice(), rhs.getPrice())));
		System.out.println("Cheapest item: " + Collections.min(itemList,
			(lhs, rhs) -> Double.compare(lhs.getPrice(), rhs.getPrice())));

	}

}

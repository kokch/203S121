package streams;

import java.util.Comparator;

public class MaxMin {

	public static void main(String[] args) {
		Student[] s = new Student[3];
		s[0] = new Student("Jenny", 19, 90.0); 
		s[1] = new Student("James", 25, 70.5); 
		s[2] = new Student("Jimmy", 18, 85.0);
		/*
		System.out.println(s[0].compareTo(s[0])); // 0
		System.out.println(s[0].compareTo(s[1])); // +4
		System.out.println(s[1].compareTo(s[0])); // -4
		*/
		// Using Comparable - Natural order
		System.out.println("Student with 'largest' alphabetic name: " + 
			Utility.largest(s));
		System.out.println("Student with 'smallest' alphabetic name: " + 
			Utility.smallest(s));
		System.out.println();
		
		// Using Comparable - Natural order
		Item[] items = {new Item("Pen", 1.25), new Item("Eraser", 0.45),
			new Item("Scissors", 2.35), new Item("Pencil", 0.35)};
		System.out.println("Most expensive item: " + Utility.largest(items));
		System.out.println("Cheapest item: " + Utility.smallest(items));
		
		System.out.println();
		// Using instance of Comparator - specify 'customize' order
		System.out.println("Oldest student: " + 
			Utility.largest(s, new AgeComparator()));
		System.out.println("Item with 'largest' name: " + 
			Utility.largest(items, new ItemNameComparator()));
		
		System.out.println();
		// Using anonymous class - specify 'customize' order
		System.out.println("Student with highest mark: " +
			Utility.largest(s, new Comparator<Student>() {
				public int compare(Student lhs, Student rhs) {
					return Double.compare(lhs.getMark(), rhs.getMark());
				}
			})
		);
		
		System.out.println("Oldest student: " +
			Utility.largest(s, new Comparator<Student>() {
				public int compare(Student s1, Student s2) {
					return Integer.compare(s1.getAge(), s2.getAge());
				}
			})
		);
		
		Item cheapestItem = Utility.smallest(items, new Comparator<Item>() {
			public int compare(Item lhs, Item rhs) {
				return Double.compare(lhs.getPrice(), rhs.getPrice());
			}
		});
		System.out.println("Cheapest item: " + cheapestItem);
		
		System.out.println();
		// Using lambda expression - specify 'customize' order
		Student youngest = Utility.smallest(s, 
			(Student lhs, Student rhs) -> Integer.compare(lhs.getAge(), rhs.getAge()) );
		System.out.println("Youngest student: " + youngest);
		
		System.out.println("Student with lowest mark: " + Utility.smallest(s,
			(lhs, rhs) -> Double.compare(lhs.getMark(), rhs.getMark())));
	}

}

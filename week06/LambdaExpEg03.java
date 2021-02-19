package streams;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LambdaExpEg03 {

	public static void main(String[] args) {
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student("Jenny", 19, 90.0)); 
		stuList.add(new Student("James", 25, 70.5)); 
		stuList.add(new Student("John", 20, 35.0));
		stuList.add(new Student("Jacky", 39, 40.0)); 
		stuList.add(new Student("Jane", 32, 68.0)); 
		stuList.add(new Student("Jimmy", 18, 85.0));
		
		// Passing method as parameter
		System.out.println("All students:");
		stuList.forEach(System.out::println);

		System.out.println();
		stuList.sort((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
		// Using lambda expression
		System.out.println("All students, sorted according to age");
		stuList.forEach(x -> System.out.println(x));

		System.out.println();
		// Using lambda expression
		System.out.println("All students, sorted according to ??");
		stuList.sort(null);
		stuList.forEach(x -> System.out.println(x));
		
		System.out.println();
		System.out.println(stuList.stream()
			.sorted((Student x, Student y) -> Double.compare(x.getMark(), y.getMark()))
			.map(x -> x.toString())
			.collect(Collectors.joining("\n")));
		System.out.println();
		System.out.println(stuList);

	}

}

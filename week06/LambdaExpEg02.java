package streams;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExpEg02 {
	public static void main(String[] args) {
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student("Jenny", 19, 90.0)); 
		stuList.add(new Student("James", 25, 70.5)); 
		stuList.add(new Student("John", 20, 35.0));
		stuList.add(new Student("Jacky", 39, 40.0)); 
		stuList.add(new Student("Jane", 32, 68.0)); 
		stuList.add(new Student("Jimmy", 18, 85.0));
		
		System.out.println("Students who passed:\n" + filterPassStudent(stuList));
		System.out.println("Mature students:\n" + filterMatureStudent(stuList));
		System.out.println();
		// Passing methods as arguments
		System.out.println("Students who failed:\n" + 
			filterStudent(stuList, Student::isFailedStudent));
		System.out.println("Teen students:\n" + 
			filterStudent(stuList, Student::isTeenStudent));
		System.out.println();
		// Using lambda expression (anonymous function)
		System.out.println("Students whose names begins with 'Ja':\n" +
			filterStudent(stuList, (Student s) -> s.getName().startsWith("Ja")));
		System.out.println("Students whose marks is between 70 to 90:\n" +
			filterStudent(stuList, (s) -> s.getMark() >= 70 && s.getMark() <= 90));

		System.out.println();
		// Using stream method...
		System.out.println("Students whose names ended with 'y':\n" +
			stuList.stream().filter((s) -> s.getName().endsWith("y")).
			map(Student::toString).collect(Collectors.joining("\n")));
		System.out.println("Students in their 20s are:\n" +
			stuList.stream().filter((s) -> s.getAge() / 10 == 2).
			map(Student::toString).collect(Collectors.joining("\n")));
		
		System.out.println(stuList.stream().map((s) -> s.getAge()+1).
			map((s) -> Integer.toString(s)).collect(Collectors.joining("\n")));
	}
	
	public static ArrayList<Student> filterPassStudent(ArrayList<Student> stuList) {
		ArrayList<Student> result = new ArrayList<>();
		for (Student s: stuList)
			if (s.getMark() >= 50)
				result.add(s);
		return result;
	}

	public static ArrayList<Student> filterMatureStudent(ArrayList<Student> stuList) {
		ArrayList<Student> result = new ArrayList<>();
		for (Student s: stuList)
			if (s.getAge() >= 30)
				result.add(s);
		return result;
	}
	
	public static ArrayList<Student> filterStudent(ArrayList<Student> stuList,
		Predicate<Student> p) {
		ArrayList<Student> result = new ArrayList<>();
		for (Student s: stuList)
			if (p.test(s))
				result.add(s);
		return result;		
	}
}

package streams;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
	public int compare(Student lhs, Student rhs) {
		return lhs.getAge() - rhs.getAge();
		
		//return Integer.compare(lhs.getAge(), rhs.getAge());
	}
}

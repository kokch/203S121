package streams;

public class Student implements Comparable<Student> {
	private String name;
	private int age;
	private double mark;
	
	public Student(String nameIn, int ageIn, double markIn) {
	   setName(nameIn);
	   setAge(ageIn);
	   setMark(markIn);
	}
	
	public Student() {
		this("not assigned", 1, 0.0);
	}
	
	public void setName(String nameIn) {
	   name = nameIn;
	}
	
	public void setAge(int ageIn) {
		age = ageIn;
	}
	
	public String getName() {
	   return name;
	}
	
	public void setMark(double markIn) {
	   mark = markIn;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getMark() {
	   return mark;
	}
	
	public String toString() {
		return getName() + " aged " + getAge() + " with mark " + getMark();
	}
	
	public int compareTo(Student rhs) {
		return this.getName().compareTo(rhs.getName());
		
		// return Integer.compare(this.getAge(), rhs.getAge());
		
		// return this.getAge() - rhs.getAge();
	}
	
	public static boolean isFailedStudent(Student s) {
		return s.getMark() < 50;
	}
	
	public static boolean isTeenStudent(Student s) {
		return s.getAge() < 20;
	}
}
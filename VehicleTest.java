package reuse;

public class VehicleTest {

	public static void main(String[] args) {
		/*
		Vehicle v = new Vehicle(); // default constructor
		System.out.println(v.getRegNo() + " " + v.getOwner());
		v.setOwner("James");
		v.setRegNo("ABC123");
		System.out.println(v.getRegNo() + " " + v.getOwner());
		
		Vehicle v2 = new Vehicle("Jane", "ABC1");
		System.out.println(v2.getRegNo() + " " + v2.getOwner());
		System.out.println(v2.toString());
		System.out.println(v); // v.toString()
		*/
		Car c1 = new Car();
		Car c2 = new Car("James", "A1", 2);
		System.out.println(c1);
		System.out.println(c2);
		

	}

}

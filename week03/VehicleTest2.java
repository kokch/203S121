package reuse;

public class VehicleTest2 {

	public static void main(String[] args) {
		
		double price = 1.25;
		int dollar = (int) price;
		int cents = (int) (price * 100) % 100;
		
		//Vehicle v = new Vehicle("James", "A1");
		Car c = new Car("Jane", "B1", 2);
		Bus b = new Bus("John", "A2", 20, 10);
		
		//System.out.println(v + "\n" + c + "\n" + b);
		
		Vehicle c2 = new Car("Alex", "C1", 4);
		System.out.println(c2.getOwner());
		System.out.println(c2.getRegNo());
			
		System.out.println(((Car) c2).getSeatCapacity());
		System.out.println(c.getOwner());
		System.out.println(c.getSeatCapacity());
		System.out.println(c2.toString());
		
		Vehicle b2 = new Bus("Anthony", "ABC1", 21, 20);
		// Reference of subclass type CANNOT refer to superclass object
		// Bus b4 = new Vehicle("", "");
		System.out.println(((Bus) b2).getSittingCapacity());
		
		Bus b3 = (Bus) b2;
		System.out.println(b3.getSittingCapacity());
		
		// Car c3 = (Car) b2; // Compilation okay, but caused Runtime error

		if (b2 instanceof Car) {
			Car c3 = (Car) b2;
			System.out.println(c3.getSeatCapacity());
		}
		else
			System.out.println("Sorry, wrong class!");
	}

}

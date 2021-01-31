package reuse;

import java.util.Scanner;

public class VehicleTest3 {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		Vehicle v = null;
		System.out.print("<C>ar or <B>us? ");
		String type = kbd.nextLine();
		
		System.out.print("Owner's name: ");
		String name = kbd.nextLine();
		System.out.print("Registration number: ");
		String number = kbd.nextLine();	
		if (type.equalsIgnoreCase("C")) {
			System.out.print("Seat capacity: ");
			int seatCapacity = kbd.nextInt();
			v = new Car(name, number, seatCapacity);
		}
		else if (type.equalsIgnoreCase("B")) {
			System.out.print("Sitting capacity: ");
			int sittingCapacity = kbd.nextInt();
			System.out.print("Standing capacity: ");
			int standingCapacity = kbd.nextInt();
			v = new Bus(name, number, sittingCapacity, 
				standingCapacity);
		}
		else
			System.out.println("Wrong vehicle type");
			
		if (v instanceof Car) {
			System.out.println(((Car) v).getSeatCapacity());
		}
		else if (v instanceof Bus) {
			Bus b = (Bus) v;
			System.out.println(b.getSittingCapacity() + " sitting " +
				"and " + b.getStandingCapacity() + " standing");
			
			System.out.println(((Bus) v).getSittingCapacity() + " sitting " +
					"and " + ((Bus) v).getStandingCapacity() + " standing");
		}
		else
			System.out.println("You did not enter proper vehicle type");
	
	
		Vehicle[] veh = {new Car("Me", "BBB1", 4), v, new Bus("You", "V1",
			11, 20), new Bus("Alex", "C1", 12, 20)};
		
		// using foreach loop to display details of all vehicles
		for (Vehicle aV: veh)
			System.out.println(aV);
		
		// counting how many bus and car are there
		int count = 0;
		for (Vehicle aV: veh)
			if (aV instanceof Bus)
				count += 1;
		System.out.println(count + " bus(es)" + 
			(veh.length - count) + " car(s)");
		
		// count the total sitting capacity of all buses
		int sitCap = 0;
		for (Vehicle aV: veh)
			if (aV instanceof Bus)
				sitCap += ((Bus) aV).getSittingCapacity();
		System.out.println("Total sitting capacity: " + sitCap);
		
		// display owner of all buses
		System.out.println("Owners of buses");
		for (Vehicle aV: veh)
			if (aV instanceof Bus)	
				System.out.println(aV.getOwner());
	
		kbd.close();
	}
	

}

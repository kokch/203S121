package inputoutput;

import java.util.ArrayList;

public class ItemTest {

	public static void main(String[] args) {
		ArrayList<Item> items = new ArrayList<>();
		
		items.add(new Item("Pen", 2.05));
		
		
		Item i1 = new Item("Pen", 1.95);
		System.out.println(items.contains(i1)); // true

		System.out.println(i1 == items.get(0)); // false
		System.out.println(i1.equals(items.get(0))); // true
		System.out.println(items.get(0).equals(i1)); // true
		
	}

}

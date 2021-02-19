package streams;

import java.util.Comparator;

public class ItemNameComparator implements Comparator<Item> {
	public int compare(Item lhs, Item rhs) {
		return lhs.getName().compareToIgnoreCase(rhs.getName());
	}
}

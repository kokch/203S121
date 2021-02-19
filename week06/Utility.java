package streams;

import java.util.Comparator;

public class Utility {
	public static <T extends Comparable<T>> T  largest(T[] arrays) {
		T largest = arrays[0];
		for (T obj: arrays)
			if (obj.compareTo(largest) > 0)
				largest = obj;
		return largest;
	}

	public static <T extends Comparable<T>> T  smallest(T[] arrays) {
		T smallest = arrays[0];
		for (T obj: arrays)
			if (obj.compareTo(smallest) < 0)
				smallest = obj;
		return smallest;
	}

	public static <T> T  largest(T[] arrays, Comparator<T> comp) {
		T largest = arrays[0];
		for (T obj: arrays)
			if (comp.compare(obj, largest) > 0)
				largest = obj;
		return largest;
	}
	
	public static <T> T  smallest(T[] arrays, Comparator<T> comp) {
		T smallest = arrays[0];
		for (T obj: arrays)
			if (comp.compare(obj, smallest) < 0)
				smallest = obj;
		return smallest;
	}
}
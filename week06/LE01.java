package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LE01 {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 5, 2, 0, -7, 5);
		// NOTE: NOT List<int> nums;

		List<String> strs = Arrays.asList("Jimmy", "Jacky", 
				"Jane", "James");

		
		nums.stream()
		   .map(x -> x * x) // transform
		   .forEach(aNum -> System.out.println(aNum));

		System.out.println("Positive integers:");
		nums.stream()
		   .filter(num -> num > 0)
		   .forEach(System.out::println);

		nums.stream().map(x -> x + 2)
		   .collect(Collectors.toList())
		   .forEach(System.out::println);

		/*
		Set<Integer> set = 
		   nums.stream().collect(Collectors.toSet());
		System.out.println(set);

		Integer[] intA = nums.stream().toArray(Integer[]::new);
		Arrays.stream(intA).forEach(System.out::println);

		//nums = Arrays.asList();
		
		Optional<Integer> result = nums.stream().findFirst();
		System.out.println(" xx " + result.get());
		System.out.println(result.orElse(null));
		if (!result.isPresent())
			System.out.println("No value");
		else
			System.out.println(result.get());
		/*
		boolean status = nums.stream().anyMatch(x -> x ==5);
		System.out.println(status);
		status = nums.stream().anyMatch(x -> x ==-5);
		System.out.println(status);

		/*
		System.out.println(nums.stream()
		   .count());
		System.out.println(nums.stream()
		   .max((x,y) -> x-y));
		System.out.println(nums.stream()
		   .max(Comparator.comparingInt(x -> x)));
		System.out.println(nums.stream()
		   .min((x,y) -> x-y));
		System.out.println(nums.stream()
		   .reduce(0, (x,y) -> x+y));
		System.out.println(nums.stream()
		   .mapToInt(x -> x.intValue()).sum());
		System.out.println(nums.stream()
		   .mapToInt(Integer::intValue).sum());

		System.out.println();
		System.out.println(nums.stream()
		   .mapToInt(x -> x.intValue()));
		System.out.println(nums.stream()
			.filter(x -> x > 0).count());
		
		System.out.println(nums.stream().mapToInt(x -> x.intValue()).sum());
		/*
		strs.forEach(x -> System.out.println(x));
		System.out.println();
		strs.forEach(System.out::println);

		
		// Using lambda expression
		Consumer<Integer> consumer = x -> System.out.println(x);
		//nums.forEach(consumer);
		
		Predicate<Integer> even = x -> x % 2 == 0;
		nums.stream()
		   .filter(even)
		   .forEach(consumer);
		
		System.out.println();
		nums.stream()
			.filter(x -> x < 0)
			.forEach(consumer);

		System.out.println(nums.stream().mapToInt(x -> x).sum());
		
		/*

		
		System.out.println();
		Consumer<Object> cr = x -> System.out.println(x);
		strs.forEach(cr);
		System.out.println();
		nums.forEach(cr);
		/*
		nums.forEach(x -> {
		   x = x + 5;
		   System.out.println(x);
		});
		System.out.println("Original: " + nums);
		
		System.out.println();
		nums.forEach(x -> {
		   int y = x + 5;
		   System.out.println(y);
		});
		System.out.println();
		int increment = 10;
		nums.forEach(x -> System.out.println(x + increment));

		/*
		nums.forEach((Integer aNum) -> System.out.println(aNum));
		System.out.println();
		nums.forEach((aNum) -> System.out.println(aNum));
		System.out.println();
		nums.forEach(aNum -> System.out.println(aNum));
*/

	}

}

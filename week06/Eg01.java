package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Eg01 {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 5, 2, 5, 0, -7);
	
		nums.stream().map(x -> x + 2)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		/*
		Optional<Integer> result = nums.stream().findFirst();
		System.out.println(result.get());
		
		boolean status = nums.stream().anyMatch(x -> x ==5);
		System.out.println(status);
		status = nums.stream().anyMatch(x -> x ==-5);
		System.out.println(status);
		
		result = nums.stream().findAny();
		System.out.println(result.get());
		/*
		Set<Integer> set = nums.stream().collect(Collectors.toSet());
		System.out.println(set);
		System.out.println();
		Integer[] intA = nums.stream().toArray(Integer[]::new);
		Arrays.stream(intA).forEach(System.out::println);
		
		/*
		
		System.out.println(nums.stream().
			mapToInt(x -> x.intValue()).sum());
		System.out.println(nums.stream().
			mapToInt(Integer::intValue).sum());
		/*	
		System.out.println(nums.stream().count());
		System.out.println(nums.stream().max((x,y) -> x-y));
		System.out.println(nums.stream().max(Comparator.comparingInt(x -> x)));
		System.out.println(nums.stream().min((x,y) -> x-y));
		System.out.println(nums.stream().reduce(0, (x,y) -> x+y));
		
		/*
		Consumer<Integer> consumer = x -> System.out.println(x);
		nums.forEach(consumer);
		
		Predicate<Integer> even = x -> x % 2 == 0;
		nums.stream()
			.filter(even)
			.forEach(consumer);
		
		/*
		int increment = 10;
		nums.forEach(x -> System.out.println(x + increment));
		System.out.println(nums);
		/*
		Optional<Integer> negative = nums.stream()
			.filter(x -> x < 0)
			.findFirst();
		System.out.println("Negative: " + negative.orElse(null));
		
		// Using lambda expression
		nums.stream()
			.map(x -> x * x)
			.forEach(aNum -> System.out.println(aNum));
		
		System.out.println("Positive integers:");
		nums.stream()
		.filter(num -> num > 0)
		.forEach(System.out::println);
		*/
	}

}

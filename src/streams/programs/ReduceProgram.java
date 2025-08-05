package streams.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReduceProgram {

	public static void main(String[] args) {

		// Find the sum of all elements in a list.
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer sum = list.stream().reduce(0, Integer::sum);
		System.out.println("Sum of All The Numbers is " + sum);

		// Find the sum of all even elements in a list.
		Integer evenNumSum = list.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
		System.out.println("Sum of All Even The Numbers is " + evenNumSum);
		System.out.println("********************");
		
		
		// find the Product of all the numbers by another overLoaded method
		// we can calculate the factorial as well by this 
		Optional<Integer> product2 = list.stream().reduce((a,b)->a*b);
		System.out.println("Product of All  The Numbers is By method 2" + product2.get());
		

		// Find the longest string in a list.
		List<String> names = Arrays.asList("Nikhil", "Aditi", "Nikita", "Sanket", "manjiri", "Prajwal", "Krushna",
				"Sagar", "Rajeshwari");
		// TRY 1
		Map<String, Integer> nameLengthMap = names.stream().collect(Collectors.toMap(name -> name, String::length));
		/*
		 * Can Be Written as 
		 * Map<String, Integer> nameLengthMap = names.stream()
		 * .collect(Collectors.toMap(name -> name, String::length));
		 */

		String name = names.get(0);
		int maxlength = 0;
		for (Map.Entry<String, Integer> entry : nameLengthMap.entrySet()) {
			if (entry.getValue() > maxlength) {
				name = entry.getKey();
				maxlength = entry.getValue();
			}
		}
		System.out.println("The Name with the max length in list is " + name + " with length is " + maxlength);
		System.out.println("********************");

		
		// By Using reduce finding the String with max length
		List<String> strings = Arrays.asList("apple", "banana", "cherry", "watermelon", "kiwi");

		Optional<String> maxlengthhname = strings.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
		maxlengthhname.ifPresent(System.out::print);
		System.out.println("********************");
	}

}

package streams.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapFunction {

	public static void main(String[] args) {

		// We Use Map in stream when we have to perform a action on each element in
		// stream

		// getting the squares of each number in list
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> numSquares = list.stream().map(num -> num * num).toList();
		numSquares.forEach(System.out::println);
        System.out.println("****************");
		
		// converting integer into the map if key value pairs with key as  number and value as square of number
		Map<Integer, Integer> map = numSquares.stream()
				.collect(Collectors.toMap(number -> number, number -> number * number));
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Square of "+ entry.getKey()+ " is : "+entry.getValue());
		}
		System.out.println("****************");
		
		// converting all the names into uppercase
		List<String> names = Arrays.asList("Nikhil", "Aditi", "Nikita", "Sanket", "manjiri", "Prajwal", "Krushna",
				"Sagar", "Rajeshwari");
		
		List<String> upperCaseList = names.stream().map(name->name.toUpperCase()).toList();
		upperCaseList.forEach(System.out::println);

	}

}

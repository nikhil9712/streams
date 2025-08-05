package streams.programs;

import java.util.Arrays;
import java.util.List;

public class Filter {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// To get all the even numbers

		List<Integer> evenNumList = list.stream().filter(x -> x % 2 == 0).toList();
		evenNumList.forEach(System.out::
			println);

		List<String> names = Arrays.asList("Nikhil", "Aditi", "Nikita", "Sanket", "manjiri", "Prajwal", "Krushna",
				"Sagar", "Rajeshwari");
		
		// logic to collect names starts with N
		List<String> filteredNames = names.stream().filter(name-> name.startsWith("N")).toList();
		filteredNames.forEach(System.out::println);

	}
}

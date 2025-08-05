package streams.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flatmaps {

	public static void main(String[] args) {

		// Flatten a list of lists of integers into a single list.
		List<String> girls = Arrays.asList("Aditi", "Nikita", "Rajeshwari", "manjiri");
		List<String> boys = Arrays.asList("Nikhil", "Krushna", "Sanket", "Sagar");

		List<List<String>> lists = Arrays.asList(girls, boys);
		List<String> group = lists.stream().flatMap(x -> x.stream()).toList();
		System.out.println("The Group Members are :" + group);

		// Split a list of sentences into individual words.
		String string1 = "Concurrency improves performance in large applications.";
		String string2 = "Spring Security simplifies authentication and authorization.";

		List<String> list = new ArrayList<>();
		list.add(string1);
		list.add(string2);

		List<String> words = list.stream().flatMap(sentence -> Arrays.stream(sentence.split("\\+")))
				.collect(Collectors.toList());
		System.out.println(words);

	}
}

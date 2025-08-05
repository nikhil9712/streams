package streams.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectResults {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,1, 2, 3, 4, 5);
		
		// Convert a list of strings to a Set.
		Set<Integer> listToSet = list.stream().collect(Collectors.toSet());
		System.out.println("The List of element in list was "+list.size()+" and list of element in set are : "+listToSet.size());
        System.out.println(listToSet);
        System.out.println("***************");
        
        //Convert a list of strings to a comma-separated single string.
        List<String> names = Arrays.asList("Nikhil", "Aditi", "Nikita", "Sanket", "manjiri", "Prajwal", "Krushna",
				"Sagar", "Rajeshwari");
        //String.join(", ", names);
        String collect = names.stream().collect(Collectors.joining(","));
        System.out.println(collect);
	}
	
	
	

}

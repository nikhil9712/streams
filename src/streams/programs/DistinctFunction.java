package streams.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import streams.model.Student;

public class DistinctFunction {
	
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10,1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		//  Find duplicate elements from a list of integers.

		List<Integer> evenNumList = list.stream().distinct().toList();
		evenNumList.forEach(System.out::println);

		//  Remove duplicates from a list of strings.
		List<String> names = Arrays.asList("Nikhil", "Aditi", "Nikita", "Sanket", "manjiri", "Prajwal", "Krushna",
				"Sagar", "Rajeshwari","Nikhil", "Aditi", "Nikita", "Sanket", "manjiri", "Prajwal", "Krushna",
				"Sagar", "Rajeshwari");

		List<String> filteredNames = names.stream().distinct().toList();
		filteredNames.forEach(System.out::println);
		
		//  Getting student with unique names
				List<Student> students = new ArrayList<>();
				students.add(new Student(101, "Nikita", "Bangalore"));
		        students.add(new Student(102, "Nikhil", "Pune"));
		        students.add(new Student(103, "Krushna", "Hyderabad"));
		        students.add(new Student(104, "Sagar", "Delhi"));
		        students.add(new Student(105, "Aditi", "Mumbai"));
		        students.add(new Student(106, "Aditi", "Mumbai"));
		        students.add(new Student(106, "Aditi", "Mumbai"));
		        students.add(new Student(106, "Aditi", "Mumbai"));
		        students.add(new Student(106, "Aditi", "Mumbai"));
		        students.add(new Student(106, "Aditi", "Mumbai"));
		        students.add(new Student(106, "Aditi", "Mumbai"));
		        students.add(new Student(106, "Aditi", "Mumbai"));
		        students.add(new Student(106, "Aditi", "Mumbai"));
		        students.add(new Student(106, "Aditi", "Mumbai"));

		        /*
		        Comparator<Student>  comparator=(obj1,obj2)->{
		        	Student s1=(Student) obj1;
		        	Student s2=(Student) obj2;
		        	return s1.getName().compareTo(s2.getName());
		        	
		        	// No casting needed
		        	Comparator<Student> comparator = (s1, s2) -> s1.getName().compareTo(s2.getName());

                    Comparator<Student> comparator = Comparator.comparing(Student::getName);

		        };
		        */
		        
		        List<Student> list2 = students.stream().distinct().toList();
		        System.out.println(list2.size());

	}
}

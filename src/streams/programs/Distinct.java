package streams.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import streams.model.Student;

public class Distinct {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		List<Integer> uniqueNumbers = list.stream().distinct().toList();
		System.out.println(uniqueNumbers);

		List<String> names = Arrays.asList("Nikhil", "Aditi", "Nikita", "Sanket", "manjiri", "Prajwal", "Krushna",
				"Sagar", "Rajeshwari", "Nikhil", "Aditi", "Nikita", "Sanket", "manjiri", "Prajwal", "Krushna", "Sagar",
				"Rajeshwari");
		
		List<String> uniqueNames = names.stream().distinct().toList();
		System.out.println(uniqueNames);

		List<Student> students = new ArrayList<>();
		students.add(new Student(104, "Nikita", "Bangalore"));
		students.add(new Student(104, "Nikita", "Bangalore"));
		students.add(new Student(101, "Nikhil", "Pune"));
		students.add(new Student(101, "Nikhil", "Pune"));
		students.add(new Student(105, "Krushna", "Hyderabad"));
		students.add(new Student(105, "Krushna", "Hyderabad"));
		students.add(new Student(103, "Sagar", "Delhi"));
		students.add(new Student(103, "Sagar", "Delhi"));
		students.add(new Student(102, "Aditi", "Mumbai"));
		students.add(new Student(102, "Aditi", "Mumbai"));

		List<Student> uniqueStudents = students.stream()
				.collect(Collectors.collectingAndThen(
						Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getRollNo))),
						ArrayList::new));
		System.out.println(uniqueStudents);
		System.out.println();
		
	}
}

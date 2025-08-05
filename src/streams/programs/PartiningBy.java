package streams.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import streams.model.Student;

public class PartiningBy {
	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();
		students.add(new Student(104, "Nikita", "Pune"));
		students.add(new Student(101, "Nikhil", "Pune"));
		students.add(new Student(105, "Krushna", "Delhi"));
		students.add(new Student(103, "Sagar", "Delhi"));
		students.add(new Student(102, "Aditi", "Mumbai"));
		students.add(new Student(106, "Sanket", "Mumbai"));
		students.add(new Student(107, "Payal", "Vimannagar"));
		students.add(new Student(108, "Bonya", "Novillex"));
		
		/*
		 * partitioningBy takes predicate (Condition) similar to filter converts into 2
		 * partitions in map with 2 keys where 1st key is true which contains elements
		 * which was satisfied with given predicate condition 2nd is false which
		 * contains the elements which was not satisfied with given predicate condition
		 */

		// Partition a list of integers into even and odd numbers.
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
		System.out.println(map);

	}
}

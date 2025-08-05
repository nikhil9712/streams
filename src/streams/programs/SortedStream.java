package streams.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import streams.model.Student;

public class SortedStream {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Sort natural Sorting order which is of Comparable type
		List<Integer> sortedListAsc = list.stream().sorted().toList();
		System.out.println(sortedListAsc);
		System.out.println("****************");

		// Sort Descending Sorting order which is of Comparable type
		List<Integer> sortedListDesc = list.stream().sorted(((a, b) -> b.compareTo(a))).toList();
		System.out.println(sortedListDesc);
		System.out.println("****************");

		// Sort Descending Sorting order which is of Comparable type Way2
		List<Integer> sortedListDesc2 = list.stream().sorted(
				(a, b) -> b - a).toList();
		System.out.println(sortedListDesc2);
		System.out.println("****************");
		
		// Sorting in ascending order for custom object list according to roll no
		List<Student> students = new ArrayList<>();
		students.add(new Student(104, "Nikita", "Bangalore"));
        students.add(new Student(101, "Nikhil", "Pune"));
        students.add(new Student(105, "Krushna", "Hyderabad"));
        students.add(new Student(103, "Sagar", "Delhi"));
        students.add(new Student(102, "Aditi", "Mumbai"));

        
        //782 sony sports 3
        List<Student> sortedAscStudents = students.stream().sorted((a,b)->a.getRollNo()-b.getRollNo()).toList();
        System.out.println(sortedAscStudents);
        System.out.println("****************");
        
        List<Student> sortedAscStudents1 = students.stream().sorted((a,b)->Integer.compare(a.getRollNo(), Integer.valueOf(b.getRollNo()))).toList();
        System.out.println(sortedAscStudents1);
        System.out.println("****************");
        
        
        List<Student> sortedDescStudents = students.stream().sorted((a,b)->b.getRollNo()-a.getRollNo()).toList();
        System.out.println(sortedDescStudents);
        System.out.println("****************");
        
        List<Student> sortedDescStudents1 = students.stream().sorted((a,b)->Integer.compare(b.getRollNo(), a.getRollNo())).toList();
        System.out.println(sortedDescStudents1);
        System.out.println("****************");

	}

}

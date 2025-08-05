package streams.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import streams.model.Employee;
import streams.model.Student;

public class Grouping {

	public static void main(String[] args) {

		/*
		 * groupingBy -> returns the map of type key as a type on which we have two
		 * group in this case city means String and value as List of initial type
		 * List<T> in this case List<Student>
		 * 
		 * partitioningBy --> returns the map of type Map<Boolean, List<T>> in this case
		 * Map<Boolean, List<Student>>
		 */

		List<Student> students = new ArrayList<>();
		students.add(new Student(104, "Nikita", "Pune"));
		students.add(new Student(101, "Nikhil", "Pune"));
		students.add(new Student(105, "Krushna", "Delhi"));
		students.add(new Student(103, "Sagar", "Delhi"));
		students.add(new Student(102, "Aditi", "Mumbai"));
		students.add(new Student(106, "Sanket", "Mumbai"));
		students.add(new Student(107, "Payal", "Vimannagar"));
		students.add(new Student(108, "Bonya", "Novillex"));

		// Grouping a Student object by city
		Map<String, List<Student>> studentsgroup = students.stream()
				.collect(Collectors.groupingBy(Student::getAddress));
		System.out.println(studentsgroup);
		System.out.println("***********");

		for (Map.Entry<String, List<Student>> entry : studentsgroup.entrySet()) {
			String names = entry.getValue().stream().map(Student::getName).collect(Collectors.joining(","));
			System.out.println("Students belonging to Location  " + entry.getKey() + " are  " + names);
		}
		System.out.println("**************");

		// Count Number of Employees in Each Department
		List<Employee> employeeList = Arrays.asList(new Employee(101, "Alice", "HR", 50000),
				new Employee(102, "Bob", "Finance", 60000), new Employee(103, "Charlie", "HR", 52000),
				new Employee(104, "David", "IT", 70000), new Employee(105, "Eva", "Finance", 65000),
				new Employee(106, "Frank", "IT", 72000), new Employee(107, "Grace", "HR", 48000),
				new Employee(108, "Henry", "Sales", 55000), new Employee(109, "Ivy", "Sales", 57000));

		Map<String, List<Employee>> employeeListMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		for (Map.Entry<String, List<Employee>> entry : employeeListMap.entrySet()) {
			System.out
					.println("The Count of " + entry.getKey() + " Department employee is : " + entry.getValue().size());
		}
		System.out.println("**************");
		
		
		//Find the Highest Salary Employee in Each Department Way 1
		
		Map<String, List<Employee>> salaryMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		
		for (Map.Entry<String, List<Employee>> entry : salaryMap.entrySet()) {
			Optional<Double> maxSalary = entry.getValue().stream().map(Employee::getSalary)
					.max(Comparable::compareTo);
			/*
			 * Optional<Double> maxSalary = entry.getValue().stream().map(Employee::getSalary)
					.max((a, b) -> a.compareTo(b));
			 * */
			System.out.println("The Max Salary of " + entry.getKey() + " is " + maxSalary.get());
		}
		System.out.println("**************");


		//Find the Highest Salary Employee in Each Department Way 2
		Map<String, Optional<Employee>> maxSalaryByDept = employeeList.stream().collect(Collectors.groupingBy(
				Employee::getDepartment,
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		
		for (Map.Entry<String, Optional<Employee>> entry : maxSalaryByDept.entrySet()) {
			Optional<Double> maxSalary = entry.getValue().stream().map(Employee::getSalary)
					.max(Comparable::compareTo);
			/*
			 * Optional<Double> maxSalary = entry.getValue().stream().map(Employee::getSalary)
					.max((a, b) -> a.compareTo(b));
			 * */
			System.out.println("The Max Salary of " + entry.getKey() + " is " + maxSalary.get());
		}
		System.out.println("**************");


		
		
	}

}

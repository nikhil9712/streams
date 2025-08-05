package StreamInterviewPractise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import streams.model.Employee;

public class PractiseSet1 {

	public static void main(String[] args) {

		// Employees whose salary is greater then 40000

		List<Employee> employees = List.of(new Employee(101, "Alice", "HR", 20000.0),
				new Employee(102, "Bob", "Finance", 6200000.0), new Employee(103, "Charlie", "IT", 75000.0),
				new Employee(104, "Diana", "Marketing", 58000.0), new Employee(105, "Ethan", "IT", 80000.0));

		List<Employee> listofHigherSalryEmpl = employees.stream().filter(x -> x.getSalary() > 40000).toList();
		System.out.println("The Higher salary empllyees are " + listofHigherSalryEmpl.size());
		System.out.println(listofHigherSalryEmpl);
		System.out.println("**************");

		// Group employees based on their department
		Map<String, List<Employee>> collect = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(collect);

		for (Map.Entry<String, List<Employee>> entry : collect.entrySet()) {
			String key = entry.getKey();
			List<Employee> value = entry.getValue();
			List<String> names = value.stream().map(x -> x.getName()).toList();
			System.out.println("Employees from " + key + " are " + names);

		}
		System.out.println("**************");

		// Converting Employee names to UpperCase
		List<String> names = employees.stream().map(x -> x.getName().toUpperCase()).toList();
		System.out.println(names);

		// highest Salary Among all the employees

		Optional<Employee> max = employees.stream().max(Comparator.comparing(Employee::getSalary));
		if (max.isPresent()) {
			System.out.println(
					"Employee with max salary is " + max.get().getName() + " With salary of " + max.get().getSalary());
		}
		System.out.println("**************");

		// To Count the Employees in each department
		Map<String, Long> map1 = employees.stream().collect(Collectors.groupingBy(
				Employee::getDepartment,
				Collectors.counting()
				));
		 for (Map.Entry<String, Long> entry : map1.entrySet()) {
			String key = entry.getKey();
			Long val = entry.getValue();
			System.out.println("The Employee count in "+key +"Department is "+val);
		}
		
	    System.out.println("**************");
		Map<String, Employee> map2 = employees.stream()
				.collect(Collectors.toMap(Employee::getDepartment, Function.identity(), (adr1, adr2) -> adr1));
		Map<String, String> map3 = employees.stream()
				.collect(Collectors.toMap(Employee::getDepartment, Employee::getName, (adr1, adr2) -> adr2));
		System.out.println(map2);
		System.out.println(map3);
	}
}

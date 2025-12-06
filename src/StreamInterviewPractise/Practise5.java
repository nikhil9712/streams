package StreamInterviewPractise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import streams.model.Employee;

public class Practise5 {

	public static void main(String[] args) {
		
		List<Employee> employees = List.of(new Employee(101, "Alice", "HR", 20000.0),
				new Employee(102, "Bob", "Finance", 6200000.0), new Employee(103, "Charlie", "IT", 75000.0),
				new Employee(104, "Diana", "Marketing", 58000.0), new Employee(105, "Ethan", "IT", 80000.0));

		//Group employees by department
		//For each department, find the employee with the highest salary
		
		Map<String, Employee> result =
			    employees.stream()
			        .collect(Collectors.groupingBy(
			            Employee::getName,
			            Collectors.collectingAndThen(
			                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
			                Optional::get
			            )
			        ));
		
		
		Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	}
}

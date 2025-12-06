package StreamInterviewPractise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import streams.model.Account;
import streams.model.Employee;

public class PractiseSet4 {

	public static void main(String[] args) {

		List<Employee> employeeList = Arrays.asList(new Employee(101, "Alice", "HR", 50000),
				new Employee(102, "Bob", "Finance", 60000), new Employee(103, "Charlie", "HR", 52000),
				new Employee(104, "David", "IT", 70000), new Employee(105, "Eva", "Finance", 65000),
				new Employee(106, "Frank", "IT", 72000), new Employee(107, "Grace", "HR", 48000),
				new Employee(108, "Henry", "Sales", 55000), new Employee(109, "Ivy", "Sales", 57000));

		// 1️⃣ Group by department
		Map<String, List<Employee>> map1 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		// 2️⃣ Filter employees with salary > 5000
		Map<String, List<Employee>> map2 = map1.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),
				e -> e.getValue().stream().filter(x -> x.getSalary() > 5000).toList()));

		// 3️⃣ Map to employee names
		Map<String, List<String>> map3 = map2.entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().stream().map(Employee::getName).toList()));

		// 4️⃣ Combined in one chain
		Map<String, List<String>> map4 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment))
				.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),
						e -> e.getValue().stream().filter(x -> x.getSalary() > 5000).map(Employee::getName).toList()));

		System.out.println(map1);
		System.out.println("*****************");
		System.out.println(map2);
		System.out.println("*****************");
		System.out.println(map3);
		System.out.println("*****************");
		System.out.println(map4);
		System.out.println("*****************");

		// 5️⃣ Average salary by department
		Map<String, Double> avgSalaryByDept = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(avgSalaryByDept);
		System.out.println("*****************");

		// 6️⃣ Reducing example
		List<Integer> integers = Arrays.asList(8, 2, 3, 4, 5, 6, 7, 8, 9);
		Integer sum = integers.stream().collect(Collectors.reducing(0, Integer::sum));
		Optional<Integer> max = integers.stream().max(Integer::compareTo);

		System.out.println(sum);
		System.out.println("*****************");
		System.out.println(max.orElse(null));
		System.out.println("*****************");

		// 7️⃣ Minimum sum of consecutive elements
		int minSum = IntStream.range(0, integers.size() - 1).map(i -> integers.get(i) + integers.get(i + 1)).min()
				.orElseThrow();
		System.out.println("Minimum sum of consecutive elements: " + minSum);
		System.out.println("*****************");

		// count of characters in a string

		// String name="Nikhil";
		// Arrays.stream(name.chars().toArray()).map(c->(char)
		// c).collect(Collectors.toMap(Function.identity(), Collectors.counting()));

		// 1A. Get the names of employees whose salary is greater than 50,000 and sort
		// them alphabetically.
		List<Employee> list1 = employeeList.stream().filter(employee -> employee.getSalary() > 50000)
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).toList();
		System.out.println(list1);
		System.out.println("*****************");

		// 1B. Get the names of employees whose salary is less than 30,000 and sort them
		// in reverse order.
		List<Employee> list2 = employeeList.stream().filter(employee -> employee.getSalary() > 30000)
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).toList();
		System.out.println(list2);
		System.out.println("*****************");

		// 2A. Group employees by department and count how many are in each department.
		Map<String, Long> map5 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(map5);
		System.out.println("*****************");

		// 3A. Find the employee with the maximum salary in each department.
		Map<String, Optional<Employee>> map6 = employeeList.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))));
		System.out.println(map6);
		System.out.println("*****************");

		// 3B. Find the employee with the minimum salary in each department.
		Map<String, Optional<Employee>> map7 = employeeList.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.minBy((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))));
		System.out.println(map7);
		System.out.println("*****************");

		// 4A. Partition employees into two groups: salary >= 50,000 and salary <
		// 50,000.
		Map<Boolean, List<Employee>> map8 = employeeList.stream()
				.collect(Collectors.partitioningBy(x -> x.getSalary() < 50000));
		System.out.println("Map8 : " + map8);
		System.out.println("*****************");

		// 4B. Partition employees into two groups: department = "IT" and others.
		Map<Boolean, List<Employee>> map9 = employeeList.stream()
				.collect(Collectors.partitioningBy(x -> x.getDepartment().equalsIgnoreCase("IT")));
		System.out.println("Map9 : " + map9);
		System.out.println("*****************");

		// 5A. Get all transactions from all accounts into a single list.
		List<List<Account>> lists = new ArrayList<>();
		List<Account> accounts1 = Arrays.asList(new Account(101, "Savings", Arrays.asList(2500, 7000, 12000, 450)),
				new Account(102, "Current", Arrays.asList(9999, 15000, 500, 8600)));
		List<Account> accounts2 = Arrays.asList(new Account(103, "Loan", Arrays.asList(30000, 10500, 11250, 20000)),
				new Account(104, "Salary", Arrays.asList(10000, 14500, 7200)),
				new Account(105, "Fixed Deposit", Arrays.asList(27500, 9500, 18000, 40000)));
		lists.add(accounts1);
		lists.add(accounts2);

		List<Account> finalList = lists.stream().flatMap(x -> x.stream()).toList();
		System.out.println("FlatMap Final list :" + finalList);
		System.out.println("*****************");

		// 5B. Get all transaction amounts greater than 10,000.
		List<Integer> transactionAmounts = Arrays.asList(2500, 7800, 12000, 450, 9999, 15000, 10500, 30000, 8600, 11250,
				500, 20000, 10000, 14500, 7200, 27500, 9500, 18000, 6500, 40000);
		
		List<Integer> higherTransactionAmounts = transactionAmounts.stream().filter(x->x.compareTo(10000)>0).toList();
        System.out.println(higherTransactionAmounts);
		System.out.println("*****************");

		//6A. Find total salary of all employees.
		double totalSalarySum1 = employeeList.stream().mapToDouble(x->x.getSalary()).sum();
		System.out.println("The Totak Salary of all employees : "+totalSalarySum1);
		System.out.println("*****************");
		
		Optional<Double> totalSalarySum2 = employeeList.stream().map(x->x.getSalary()).reduce((a,b)->a+b);
		System.out.println("The Totak Salary of all employees Way2: "+totalSalarySum2);
		System.out.println("*****************");
		//6B. Find total salary of only IT department employees.
		double totalSalaryItDeptSum = employeeList.stream().filter(x->x.getDepartment().equalsIgnoreCase("IT")).mapToDouble(x->x.getSalary()).sum();
		System.out.println("The Totak Salary of all It Department employees : "+totalSalaryItDeptSum);
		System.out.println("*****************");


	}
}

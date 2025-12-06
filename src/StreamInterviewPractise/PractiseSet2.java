package StreamInterviewPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import streams.model.Employee;

public class PractiseSet2 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// Employee whose id >105 and increate salary by 10% and order by salary desc
		List<Employee> employeeList = Arrays.asList(new Employee(101, "Alice", "HR", 50000),
				new Employee(102, "Bob", "Finance", 60000), new Employee(103, "Charlie", "HR", 52000),
				new Employee(104, "David", "IT", 70000), new Employee(105, "Eva", "Finance", 65000),
				new Employee(106, "Frank", "IT", 72000), new Employee(107, "Grace", "HR", 48000),
				new Employee(108, "Henry", "Sales", 55000), new Employee(109, "Ivy", "Sales", 57000));

		List<Employee> list = employeeList.stream().filter(x -> x.getId() > 105)
				.map(x -> new Employee(x.getId(), x.getName(), x.getDepartment(), x.getSalary() * 1.1))
				.sorted((obj1, obj2) -> Double.valueOf(obj2.getSalary()).compareTo(Double.valueOf(obj1.getSalary())))
				.toList();
		
		list.forEach(System.out::println);
		
		/*
		 * Map<String, Double> of departments with average salary, but only include
		 * departments with at least 2. employees.
		 */
		
		Map<String, Double> result = employeeList.stream()
			    .collect(Collectors.groupingBy(Employee::getDepartment)) 
			    .entrySet().stream()
			    .filter(e -> e.getValue().size() > 2) 
			    .collect(Collectors.toMap(
			        Map.Entry::getKey,
			        e -> e.getValue().stream()
			            .mapToDouble(Employee::getSalary) 
			            .average()
			            .orElse(0.0) 
			    ));
		
		System.out.println(result);
		
		Map<String, Integer> hashMap=new HashMap<>();
		hashMap.put("Nikhil", 1);
		hashMap.put("Krushna", 2);
		hashMap.put("Sanket", 3);
		
	//	hashMap=hashMap.entrySet().stream().collect(Map.Entry<String,Integer>comparingByValue().reversed());
		
		/*
		Map<String, Integer> sortedDesc = unsortedMap.entrySet()
	    .stream()
	    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // 👈 Descending sort.collect(Collectors.toMap(
	        Map.Entry::getKey,
	        Map.Entry::getValue,
	        (e1, e2) -> e1,
	        LinkedHashMap::new // preserves order));
		*/
		
		
		
		
		
		
		
		
		
		
		
		int n = 4; // number of threads
        ExecutorService executor = Executors.newFixedThreadPool(n);

/*        for (int i = 1; i <= 20; i++) {
            final int num = i; // effectively final for lambda
            
            executor.submit(() -> 
                System.out.println(Thread.currentThread().getName() + " -> " + num));
        }*/
        System.out.println("**************");

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            final int num = i;
            futures.add(executor.submit(() -> Thread.currentThread().getName() + " -> " + num));
        }

        // print in order of submission
        for (Future<String> f : futures) {
            System.out.println(f.get());  // waits for completion
        }
        
        executor.shutdown();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
;


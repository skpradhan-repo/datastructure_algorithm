/**
 * 
 */
package com.ibm.basics.stream;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 004ISA744
 *
 */
public class EmployeeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Count the number of employee at each age
		EmployeeUtil.getEmployee.get().stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
		System.out.println("====================================================");
		
		//  Departmentwise highest salary
		EmployeeUtil.getEmployee.get().stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
								emp -> emp.map(Employee::getSalary).orElse(null))))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
		System.out.println("====================================================");
		
		//	Departmentwise highest salary
		EmployeeUtil.getEmployee.get().stream().collect(Collectors.groupingBy(Employee::getDept)).entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						e -> e.getValue().stream().max(Comparator.comparing(Employee::getSalary)).orElse(null)))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
		System.out.println("====================================================");
		
		//	Agewise highest salary
		EmployeeUtil.getEmployee.get().stream().collect(Collectors.groupingBy(Employee::getAge)).entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						emp -> emp.getValue().stream().map(Employee::getSalary)
								.max(Comparator.comparingDouble(e -> e.doubleValue()))))
				.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
		System.out.println("====================================================");
		
		//	Departmentwise highest salary
		EmployeeUtil.getEmployee.get().stream().collect(Collectors.groupingBy(Employee::getDept)).entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						emp -> emp.getValue().stream().mapToDouble(Employee::getSalary).max()))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue().getAsDouble()));
		System.out.println("====================================================");
		
		//	Departmentwise highest salary
		EmployeeUtil.getEmployee.get().stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
								Function.identity())))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue().get()));
		System.out.println("====================================================");
		
		//	Departmentwise 2nd highest salary
		EmployeeUtil.getEmployee.get().stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.collectingAndThen(Collectors.mapping(Employee::getSalary, Collectors.toSet()),
								sal -> sal.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst())))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
		System.out.println("====================================================");
		
		// Departmentwise 2nd highest salary, skip(0) for highest salary, skip(1) for 2nd highest salary and so on
		EmployeeUtil.getEmployee.get().stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.collectingAndThen(Collectors.mapping(Employee::getSalary, Collectors.toSet()),
								sal -> sal.stream()
										.sorted(Comparator.comparingDouble(e -> ((Double) e).doubleValue()).reversed())
										.skip(1).findFirst())))
				.entrySet().stream().filter(e -> e.getValue().isPresent())
				.forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue().get()));
		System.out.println("====================================================");
		
		//	Departmentwise 2nd highest salary
		EmployeeUtil.getEmployee.get().stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.collectingAndThen(Collectors.toList(),
								list -> list.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1)
										.findFirst().map(Employee::getSalary))))
				.entrySet().forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));
	}

}

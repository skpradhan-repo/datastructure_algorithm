/**
 * 
 */
package com.ibm.basics.collection;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 004ISA744
 *
 */
public class ModifiedEmployeeBySalary {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "John", 50000.0));
		employees.add(new Employee(2, "Alice", 60000.0));
		employees.add(new Employee(3, "Bob", 50000.0));
		employees.add(new Employee(4, "Eve", 70000.0));
		employees.add(new Employee(5, "Charlie", 60000.0));
		employees.add(new Employee(6, "David", 70000.0));

		Map<Double, Integer> salaryToTeamId = new HashMap<>();
		AtomicInteger teamId = new AtomicInteger(1);

		employees.stream().filter(
				employee -> salaryToTeamId.computeIfAbsent(employee.getSalary(), k -> teamId.getAndIncrement()) != null)
				.sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(employee -> {
					double salary = employee.getSalary();
					int teamIdForSalary = salaryToTeamId.get(salary);
					System.out.println("Employee ID: " + employee.getEmployee_id() + ", Name: " + employee.getName()
							+ ", Salary: " + salary + ", Team ID: " + teamIdForSalary);
				});
	}
}

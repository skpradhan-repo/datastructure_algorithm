/**
 * 
 */
package com.ibm.basics.collection;

/**
 * @author 004ISA744
 *
 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeBySalary {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(); // Replace with your employee data

        employees.add(new Employee(1, "John", 50000.0));
        employees.add(new Employee(2, "Alice", 60000.0));
        employees.add(new Employee(3, "Bob", 50000.0));
        employees.add(new Employee(4, "Eve", 70000.0));
        employees.add(new Employee(5, "Charlie", 60000.0));
        employees.add(new Employee(6, "David", 70000.0));

        Map<Double, Long> salaryCounts = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));

        List<Employee> selectedEmployees = employees.stream()
                .filter(employee -> salaryCounts.getOrDefault(employee.getSalary(), 0L) >= 2)
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());

        Map<Double, Integer> salaryToTeamId = new HashMap<>();
        AtomicInteger teamId = new AtomicInteger(1);

        selectedEmployees.forEach(employee -> {
            double salary = employee.getSalary();
            salaryToTeamId.putIfAbsent(salary, teamId.getAndIncrement());
        });

        selectedEmployees.forEach(employee -> {
            double salary = employee.getSalary();
            int teamIdForSalary = salaryToTeamId.get(salary);
            System.out.println("Employee ID: " + employee.getEmployee_id() +
                    ", Name: " + employee.getName() +
                    ", Salary: " + salary +
                    ", Team ID: " + teamIdForSalary);
        });
    }
}

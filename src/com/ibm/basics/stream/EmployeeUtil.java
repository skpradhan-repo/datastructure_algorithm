/**
 * 
 */
package com.ibm.basics.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author 004ISA744
 *
 */
public class EmployeeUtil {

	public static Supplier<List<Employee>> getEmployee = ()-> {
		Employee e1 = new Employee(1001, "Tommy", 25, "IT", "XXXX", 20000.0);
		Employee e2 = new Employee(1002, "Sunny", 25, "IT", "XXXX", 20000.0);
		Employee e3 = new Employee(1003, "Pommy", 20, "Admin", "YYYY", 20000.0);
		Employee e4 = new Employee(1004, "Nemmy", 22, "IT", "ZZZZ", 40000.0);
		Employee e5 = new Employee(1005, "Jemmy", 22, "IT", "ZZZZ", 40000.0);
		return Arrays.asList(e1, e2, e3, e4, e5);
	};

}

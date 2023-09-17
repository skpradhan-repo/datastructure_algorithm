/**
 * 
 */
package com.ibm.basics.collection;

/**
 * @author 004ISA744
 *
 */
class Employee {
    private int employee_id;
    private String name;
    private double salary;

    public Employee(int employee_id, String name, double salary) {
        this.employee_id = employee_id;
        this.name = name;
        this.salary = salary;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
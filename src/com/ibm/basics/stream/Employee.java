/**
 * 
 */
package com.ibm.basics.stream;

/**
 * @author 004ISA744
 *
 */
public class Employee {

	/**
	 * @param args
	 */
	private int id;
	private String name;
	private int age;
	private String dept;
	private String address;
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, int age, String dept, String address, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.address = address;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + ", address=" + address
				+ ", salary=" + salary + "]";
	}

}

package com.oops;

//Encapsulation
public class Employee {
	// STATIC Keyword [Use of static keyword should be less]
	/*
	 * static deal memory!! stack, heap ---- new, static memory block
	 * 
	 */
	private String name; // non static --- INSTANCE VARIABLE
	private double salary; // binding of variables and method together!!
	private int empId;
	public static String companyName; // No more an instance 1 memory

	// static block: Intialize the Static Variables
	static {
		System.out.println("Static Blockkkkk 1");
		companyName = "Google";
	}

	static {
		System.out.println("Static Blockkkkk 2");
		companyName = "Google";
	}

	static {
		System.out.println("Static Blockkkkk 3");
		companyName = "Google";
	}
	// Constructor just a method inside the class and name is same as that of the
	// class
	//

	public void setName(String name) {
		this.name = name;
	}

	public Employee(String name, double salary, int empId) {
		// Constructor ----- Intializing the Instance Variable!!1
		super();
		System.out.println("Employee Constructor");
		this.name = name;
		this.salary = salary;
		this.empId = empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setSalary(double salary) {
		if (salary > 1000) { // validation logic
			this.salary = salary;
		}
	}

	public static boolean work() {
		System.out.println("Doing some work");
		System.out.println("work done!");
		return true;
	}

	public double getSalary() {
		return salary;
	}

	public int getEmpId() {
		return empId;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", empId=" + empId + ", CompanyName = " + companyName
				+ "]";
	}

}

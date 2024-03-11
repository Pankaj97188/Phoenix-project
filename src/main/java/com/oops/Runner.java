package com.oops;

import static com.oops.Employee.*; // Static Import ------m Improve Readbility of program 
// All the static variables and methods can be accessed without taking the name of the class

public class Runner {
// CLASS which going the main method!!!
	public static void main(String[] args) {
		int x; // 0 ?? GD
		x = 10;

		int a[]; // memory address of the array created in heraap!!
		a = new int[5];
		a[0] = 20;
		// Heap !!
		// Any vars created in heap!! are intialized Default Values!!

		System.out.println(companyName);
		work();
		
		/*
		 * static method are reusables methods!!!
		 * Utility Methods!!
		 * 
		 * 
		 */
		Employee e = new Employee("Karishma", 4000, 1001); // Called Once!!
		Employee e1 = new Employee("Ali", 3000, 1002); // Called Once!!
		Employee e2 = new Employee("Shivalli", 4400, 1003); // Called Once!!
		Employee e3 = new Employee("Bhagya", 4050, 1004); // Called Once!!
		Employee e4 = new Employee("Sharadha", 2300, 1005); // Called Once!!
		Employee e5 = new Employee("Kiran", 5000, 1006); // Called Once!!
		Employee e6 = new Employee("Renuka", 1000, 1007); // Called Once!!
		Employee e7 = new Employee("Jaya", 40550, 1008); // Called Once!!
		Employee e8 = new Employee("Priyanka", 000, 1009); // Called Once!!

		// Update the values!!
		e.setEmpId(2001);
		e.setName("Karishma");
		e.setSalary(-4000);

//		System.out.println(e.getEmpId());
//		System.out.println(e.getName());
//		System.out.println(e.getSalary());

		System.out.println(e1);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);
		System.out.println(e5);
		System.out.println(e6);
		System.out.println(e7);
		System.out.println(e8);

	}
};
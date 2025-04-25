/**
* File: Lab11Prob02.java
* Class: CSCI 1302
* Author: Seantyler Doyon, Jacob Mccartney, Nidhi Patel
* Created on: April 25th, 2025
* Last Modified: April 25th, 2025
* Description: Lab11Prob02
*/
//package ch17;

public class Person implements Comparable<Person> {
	private int age;
	private String name;
	private String address;
	private int zip;
	private double salary;

	public Person(int age, String name, String address, int zip, double salary) {
		this.age = age;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.salary = salary;
	}

	// Accessors and mutators (getters and setters)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
	    return String.format("%d %s %s %d $%,.2f", age, name, address, zip, salary);
	}

	@Override
	public int compareTo(Person other) {
		// Sort by salary descending
		return Double.compare(other.salary, this.salary);
	}
}
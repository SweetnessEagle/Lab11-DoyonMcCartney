/*
* File: Lab11Prob01.java
* Class: CSCI 1302
* Author: Seantyler Doyon, Jacob Mccartney
* Created on: April 25th, 2025
* Last Modified: April 25th, 2025
* Description: Lab11Prob01
*/
//package ch17;


import java.io.*;

public class Lab11Prob01 {
	public static void main(String args[]) {
		
		int age;
		String fullName;
		String address;
		int zip;
		double salary;

		try (
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat")); //removed src/ for github
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat")); //here too
				) {
			while (true) {
				age = input.readInt();
				fullName = input.readUTF();
				address = input.readUTF();
				zip = input.readInt();
				salary = input.readDouble();

				System.out.printf("%d %s %s %d %.2f%n",
                        age, fullName, address, zip, salary);
				
				// people-copy.dat
				output.writeInt(age);
                output.writeUTF(fullName);
                output.writeUTF(address);
                output.writeInt(zip);
                output.writeDouble(salary);
			}
		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Error reading the file:");
			e.printStackTrace();
		}
	}
}

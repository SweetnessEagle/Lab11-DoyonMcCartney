/**
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

		try (
				DataInputStream input = new DataInputStream(new FileInputStream("people.dat")); //removed src/ for github
				DataOutputStream output = new DataOutputStream(new FileOutputStream("people-copy.dat")); //here too
				) {
			while (true) {
				int age = input.readInt();
				String fullName = input.readUTF();
				String address = input.readUTF();
				int zip = input.readInt();
				double salary = input.readDouble();

				System.out.printf("Age: %d, Name: %s, Address: %s, Zip: %d, Salary: %.2f%n", age, fullName, address,
						zip, salary);
				
				// people-copy.dat
				output.writeInt(age);
                output.writeUTF(fullName);
                output.writeUTF(address);
                output.writeInt(zip);
                output.writeDouble(salary);
			}
		} catch (EOFException e) {
			System.out.println("End of file reached.");
		} catch (IOException e) {
			System.out.println("Error reading the file:");
			e.printStackTrace();
		}
	}
}
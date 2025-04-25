/**
* File: Lab11Prob02.java
* Class: CSCI 1302
* Author: Seantyler Doyon, Jacob Mccartney, Nidhi Patel
* Created on: April 25th, 2025
* Last Modified: April 25th, 2025
* Description: Lab11Prob02
*/
//package ch17;

import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob02 {
    public static void main(String[] args) {
    	
    	int age;
		String fullName;
		String address;
		int zip;
		double salary;
    	
        ArrayList<Person> people = new ArrayList<>();

        // Store in new array list
        try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"))) {
            while (true) {
                age = input.readInt();
                fullName = input.readUTF();
                address = input.readUTF();
                zip = input.readInt();
                salary = input.readDouble();

                Person p = new Person(age, fullName, address, zip, salary);
                people.add(p);
            }
        } catch (EOFException e) {
            // Silent end of file
        } catch (IOException e) {
            System.out.println("Error reading the file:");
            e.printStackTrace();
        }

        // sort
        Collections.sort(people);

        // outside loop for handled data
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-salary-sorted.dat"))) {
            for (Person p : people) {
                output.writeUTF(p.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing the file:");
            e.printStackTrace();
        }
    }
}
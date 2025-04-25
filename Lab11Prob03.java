/**
* File: Lab11Prob03.java
* Class: CSCI 1302
* Author: Seantyler Doyon, Jacob Mccartney
* Created on: April 25th, 2025
* Last Modified: April 25th, 2025
* Description: Lab11Prob03
*/
import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob03 {
    public static void main(String[] args) {
    	
    	int age;
		String fullName;
		String address;
		int zip;
		double salary;
    	
        ArrayList<Person> people = new ArrayList<>();

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
            
        } catch (IOException e) {
            System.out.println("Error reading the file:");
            e.printStackTrace();
        }

        Collections.sort(people);

        // outside loop ]
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/people-salary-sorted-objects.dat"))) {
            for (Person p : people) {
                output.writeObject(p);
            }
 
        } catch (IOException e) {
            System.out.println("Error writing the file:");
            e.printStackTrace();
        }
    }
}
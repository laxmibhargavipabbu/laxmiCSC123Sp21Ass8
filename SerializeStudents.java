package Assignment8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class SerializeStudents 
{
	public static void main(String [] args) throws IOException
	{
		String name;
		int seed;
		int id, numStudents, numGrades;
		int [] gradeList;
		Random randy;
		Scanner keyboard = new Scanner(System.in);
		Student stud;
		System.out.printf("Please enter a Seed for the random number generator: ");
		seed = keyboard.nextInt();
		randy = new Random(seed);
		
		System.out.printf("Please enter the name of the output file: ");
		String outputFileName = keyboard.next();
		
		FileOutputStream outputFileStream = new FileOutputStream(outputFileName);
		ObjectOutputStream objOutputStream = new ObjectOutputStream(outputFileStream);
		
		numStudents = randy.nextInt(6)+3;
		for(int i=0; i<numStudents;i++)
		{
			System.out.printf("Please enter the Student's last name: ");
			name = keyboard.next();
			
			id = randy.nextInt(10001)+10000;
			numGrades = randy.nextInt(4)+3;
			gradeList = new int[numGrades];
			for(int j=0; j<gradeList.length;j++)
			{
				gradeList[j] = randy.nextInt(41) + 60;
			}
			stud = new Student(name,id,gradeList);
			objOutputStream.writeObject(stud);
		}
		objOutputStream.close();
		keyboard.close();
		
		System.out.printf("The serialized objects were written to the file %s", outputFileName);
	}

}

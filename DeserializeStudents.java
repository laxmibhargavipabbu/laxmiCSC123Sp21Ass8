package Assignment8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DeserializeStudents 
{
	public static void main(String [] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		String fileName = null;
		boolean endOfFile =false;
		boolean flag = false;
		Student stud;
		FileInputStream inputFileStream = null;
		System.out.printf("Please enter the name of the input file of Student Objects: ");
		while(!flag)
		{
			try
			{
				fileName = keyboard.next();
				inputFileStream = new FileInputStream(fileName);
				flag = true;
			}
			catch(Exception e)
			{
				System.out.printf("File %s wasn't found\nPlease renter the file name: ", fileName);
			}
		}
		ObjectInputStream objInputStream = new ObjectInputStream(inputFileStream);
		System.out.printf("%-11s%-8s%s\n","Name", "ID","GPA");
		while(!endOfFile)
		{
			try
			{
				
				stud = (Student) objInputStream.readObject();
				System.out.printf("%s", stud);
			}
			catch(Exception ex)
			{
				endOfFile = true;
			}
		}
		System.out.printf("File reading complete\n");
	}
}

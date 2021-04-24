package Assignment8;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class WriteCharacters 
{
	public static void main(String args[]) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		Random randy = new Random(5);
		char[] arrChar = new char[15];
		for(int i=0; i<arrChar.length;i++)
		{
			arrChar[i] = (char) (randy.nextInt(26)+(int)'A');
		}
		for(int i=0;i<arrChar.length;i++)
		{
			System.out.printf("%d\t%c\n", i+1,arrChar[i]);
		}
		System.out.printf("Please enter the name of the Random Access output file: ");
		String inputFileNmae = keyboard.nextLine();
		System.out.printf("Opening the file...\n");
		RandomAccessFile randomFile = new RandomAccessFile(inputFileNmae, "rw");
		System.out.printf("Writing data to the file...\n");
		for(int i=0; i<arrChar.length;i++)
		{
			randomFile.writeChar(arrChar[i]);
		}
		System.out.printf("Done.\n");
		randomFile.close();
		keyboard.close();
	}

}

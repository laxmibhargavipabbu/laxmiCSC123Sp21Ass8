package Assignment8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ReadRandomCharacters 
{
	public static void main(String [] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		boolean flag = false;
		RandomAccessFile randomFile = null;
		String inputFileNmae = null;
		final int CHAR_SIZE = 2;
	    long byteNum;
	    char ch; 
		System.out.printf("Please enter the name of the Random Access output file: ");
		
		while(!flag)
		{
			try
			{
				inputFileNmae = keyboard.next();
				randomFile = new RandomAccessFile(inputFileNmae,"r");
				flag = true;
			}
			catch(FileNotFoundException ex)
			{
				System.out.printf("File %s wasn't found\nPlease renter the file name: ", inputFileNmae);
			}
		}
		
		byteNum = CHAR_SIZE * 5;
	    randomFile.seek(byteNum);
	    ch = randomFile.readChar();
	    System.out.printf("Sixth entry is %c\n", ch);
	    
	    byteNum = CHAR_SIZE * 7;
	    randomFile.seek(byteNum);
	    ch = randomFile.readChar();
	    System.out.printf("Eight Entry is %c\n", ch);
	    
	    byteNum= CHAR_SIZE * 2;
	    randomFile.seek(byteNum);
	    ch = randomFile.readChar();
	    System.out.printf("Third Entry is %c\n", ch);
	    
	    randomFile.close();
	    keyboard.close();
	}

}

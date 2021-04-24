package Assignment8;

import java.io.Serializable;

public class Student implements Serializable
{
	private String name;
	private int id;
	private int[] grades;
	
	public Student(String name, int id, int[] grades)
	{
		this.setName(name);
		this.setId(id);
		this.setGrades(grades);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setGrades(int[] arrGrades)
	{
		grades = arrGrades;
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public int[] getGrades()
	{
		return this.grades;
	}
	
	public double getGPA()
	{
		double total = 0.0;
		
		for(int i=0; i< this.getGrades().length ;i++)
		{
			total = total + grades[i];
		}
		
		return (total / (double)grades.length);
	}
	
	public String toString()
	{
		return String.format("%-11s%-8d%.2f\n", this.getName(), this.getId(), this.getGPA());
	}

}

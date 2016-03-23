package main;

import uva.*;


//The view class which asks for the names and prints the result
	
public class View
{

	public String askLastname()
	{
		System.out.print("Lastname>");
		String last=Lue.rivi();
		System.out.println();
		return last;
	}
	public String askFirstname()
	{
		System.out.print("Firstname>");
		String first=Lue.rivi();
		System.out.println();
		return first;
	}
	
	public int askAge()
	{
		System.out.print("Age>");
		int age = Lue.kluku();
		System.out.println();
		return age;
	}


	//prints person
	public void printInfo()
	{
		
	}	
}
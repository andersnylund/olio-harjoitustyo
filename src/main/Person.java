package main;

public class Person 
{
	private String lastName, firstName;
	private int age;
	
	public void setFirstname(String firstName)
	{
		this.firstName = firstName;
	}
	
	
	public void setLastname(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	//returns the first name
	public String getFirstname()
	{
		return firstName;
	}
	
	//returns the last name
	public String getLastname()
	{
		return lastName;
	}
	
	//returns the age as a integer
	public int getAge()
	{
		return age;
	}
}

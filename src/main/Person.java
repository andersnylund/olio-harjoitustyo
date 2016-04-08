//Anders Nylund w101302
//Jeremias Snellman w101318

package main;

public class Person 
{
	public static final int NAME_MAX_LENGTH = 64;
	public static final int NAME_MIN_LENGTH = 1;
	
	private String lastName, firstName;
	private int age;
	private char gender;
	
	public static final char MAN = 'M';
	public static final char WOMAN = 'W';
	public static final char OTHER = 'O';
	
	private static boolean checkName(String name){
		
		if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH)
			return false;
		
		for (int i = 0; i < name.length (); ++i)
		{
			int character = name.codePointAt (i);
			if (!Character.isLetter (character) && character != '-')
				return false;
		}

		return true;
		
	}
	
	public void setFirstname(String firstName){
		this.firstName = firstName;
	}
	
	
	public void setLastname(String lastName){
		this.lastName = lastName;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setGender(int gender){
		switch (gender){
		case 1: this.gender = MAN; break;
		case 2: this.gender = WOMAN; break;
		case 3: this.gender = OTHER; break;
		}
	}
	
	//returns the first name
	public String getFirstname(){
		return firstName;
	}
	
	//returns the last name
	public String getLastname(){
		return lastName;
	}
	
	//returns the age as a integer
	public int getAge(){
		return age;
	}
	
	public char getGender(){
		return gender;
	}
	
	//returns the first and last name as a string
	@Override
	public String toString(){
		return firstName + " " + lastName +", "+age+", "+gender ;
	}
}

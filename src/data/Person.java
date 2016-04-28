/*
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package data;

public class Person 
{
	public static final int NAME_MAX_LENGTH = 64;
	public static final int NAME_MIN_LENGTH = 1;
	
	private String lastName, firstName;
	private int age;
	private String gender;
	
	public static final String MAN = "Man";
	public static final String WOMAN = "Woman";
	public static final String OTHER = "Other";
	
	/*
	 * This method is used to check user's name input if it is valid for both first-name and last-name.
	 * Name must be between 1-64 characters long and include only letters or "-" symbol
	 * @param name The name to check it
	 * @return boolean True if name was OK, false if 
	 */
	public boolean checkName(String name)
	{
		
		if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH)
		{
			System.out.println("Name can't contain symbols and must be 1-64 characters long!");
			return false;
		}
		
		for (int i = 0; i < name.length (); ++i)
		{
			int character = name.codePointAt (i);
			if (!Character.isLetter (character) && character != '-')
			{
				System.out.println("Name can't contain symbols and must be 1-64 characters long!");
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Sets first name for person
	 * @param fistName 
	 */
	public void setFirstname(String firstName){
		this.firstName = firstName;
	}
	
	/*
	 * Sets last name for person
	 * @param lastName 
	 */
	public void setLastname(String lastName){
		this.lastName = lastName;
	}
	/*
	 * Sets age for person
	 * @param age 
	 */
	public void setAge(int age){
		this.age = age;
	}
	/*
	 * Sets gender for person
	 * @param gender
	 */
	public void setGender(int gender){
		switch (gender){
		case 1: this.gender = MAN; break;
		case 2: this.gender = WOMAN; break;
		case 3: this.gender = OTHER; break;
		}
	}
	
	/*
	 * Returns the first name of person
	 * @return String Returns first-name
	 */
	public String getFirstname(){
		return firstName;
	}
	
	/*
	 * Returns the name of person
	 * @return String Returns first name of person
	 */
	public String getLastname(){
		return lastName;
	}
	
	/*
	 * Returns the age of person
	 * @return int Returns the age of person
	 */
	public int getAge(){
		return age;
	}
	/*
	 * Returns the gender of person
	 * @return char Returns the gender of person
	 */
	public String getGender(){
		return gender;
	}
	
	/*
	 * Returns all information of person as a String, is used to 
	 * @return String Returns all information of person as a String
	 */
	@Override
	public String toString(){
		return "Name: " + firstName + " " + lastName +"\tAge: "+Integer.toString(age)+"\tGender: "+gender;
	}
}

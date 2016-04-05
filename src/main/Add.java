package main;

import uva.Lue;
import java.util.Vector;

public class Add 
{	
	private View view = new View();
	
	public Vector<Person> addEditPerson(Vector <Person> persons)
	{
		
		System.out.println("List of all persons: ");
		for(int i = 0; i < persons.size();i++)
			System.out.println(persons.elementAt(i));
		
		System.out.print("Add (A) or edit (E) competitor or official");
		
		char set;
		while(true)
		{
			set = Lue.merkki();
			if(set == 'A')
			{
				Person person = new Person();
				person.setLastname(view.askLastname());
				break;
			}
			else if(set == 'E'){
				teamSport = false;
				break;
			}
			else
				System.out.println("Wrong character input");
			}
		
		return persons;
	}
	
	private Sport sport;
	private League league;
	private boolean teamSport, leagueSport;
	
	public void addSport()
	{
		char set;
		//Ask the user to say if the new sport is a team sport
		System.out.println("Is it a team sport? (Y/N)");
	
		//waits for the user to insert either Y or N 
		while(true){
		set = Lue.merkki();
		if(set == 'Y'){
			teamSport = true;
			break;
		}
		else if(set == 'N'){
			teamSport = false;
			break;
		}
		else
			System.out.println("Wrong character input");
		}
		
		//Ask the user to say if the new sport is a league sport
		System.out.println("Does the sport contain leagues? (Y/N)");
	
		//waits for the user to insert either Y or N 
		while(true){
		set = Lue.merkki();
		if(set == 'Y'){
			leagueSport = true;
			break;
		}
		else if(set == 'N'){
			leagueSport = false;
			break;
		}
		else
			System.out.println("Wrong character input!");
		}
		
		sport = new Sport(teamSport, leagueSport);
	}
	
	public void addTeam()
	{
		
	}
	
}

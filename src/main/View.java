//Anders Nylund w101302
//Jeremias Snellman w101318

package main;

import java.util.Vector;

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
	
	//Ask user to either start new competition or load an existing competition
	//Return users input (1 or 2)
	public int printStart()
	{
		while(true)
		{
			System.out.println("1. Create new competition");
			System.out.print("2. Load existing competition\n> ");
			int select = Lue.kluku();
			if(select == 1 || select == 2)
				return select;
		}
	}
	
	//sets name for the created competition and return it
	public String setCompetitionName()
	{
		System.out.print("Enter name of competition> ");
		return Lue.rivi();
	}
	
	public int printMainMenu()
	{
		System.out.println("\n1. Add/edit competitors or officials");
		System.out.println("2. Add sport");
		System.out.println("3. Add teams");
		System.out.println("4. Add/edit points");
		System.out.println("5. Show results/save current results in competition");
		System.out.println("6. Quit program");
		System.out.print("> ");
		return Lue.kluku();
	}
	
	public String setSportName()
	{
		System.out.print("Name of the sport\n>");
		String name = Lue.rivi();
		return name;
	}
	
	public String setTeamName()
	{
		System.out.print("Name of the team\n>");
		String name = Lue.rivi();
		return name;
	}
	

	//prints person
	public void printInfo()
	{
		
	}	
	
	public void printCompetitors(Vector<Competitor> competitors)
	{
		System.out.println("List of all competitors: ");
		for(int i = 0; i < competitors.size(); i++)
		{
			System.out.println(competitors.elementAt(i));
		}
	}
	
	public Competitor selectCompetitor(Vector<Competitor> competitors)
	{
		System.out.println("List of all competitors: ");
		for(int i = 0; i < competitors.size(); i++)
		{
			System.out.println(competitors.elementAt(i));
		}
		
		System.out.println("Select a competitor.");
		int index= Lue.kluku();
		
		if(competitors.elementAt(index - 1)!=null)
		{
			return competitors.elementAt(index - 1);
		}
		System.out.println("Competitor not found.");
		return null;
		
	}
	
}
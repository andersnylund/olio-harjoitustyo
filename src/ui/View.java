//Anders Nylund w101302
//Jeremias Snellman w101318

package ui;

import java.util.Vector;

import data.*;
import uva.*;


//The view class which asks for the names and prints the result
	
public class View
{

	public String askLastname()
	{
		System.out.print("Lastname\n>");
		String last=Lue.rivi();
		System.out.println();
		return last;
	}
	public String askFirstname()
	{
		System.out.print("Firstname\n>");
		String first=Lue.rivi();
		System.out.println();
		return first;
	}
	
	public int askAge()
	{
		System.out.print("Age\n>");
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
		System.out.print("Enter name of competition\n>");
		return Lue.rivi();
	}
	
	public int printMainMenu()
	{
		System.out.println("\n1. AddSport/edit competitors or officials");
		System.out.println("2. AddSport sport and add participants to sport");
		System.out.println("3. AddSport teams");
		System.out.println("4. AddSport/edit points");
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
	
	public Competitor selectCompetitor(Vector<Competitor> competitors, String message)
	{	
		listCompetitors(competitors);
		
		while(true)
		{
			System.out.print("Select a competitor " + message + "\n>");
			int index= Lue.kluku();
			
			if(competitors.elementAt(index - 1)!=null)
			{
				return competitors.elementAt(index - 1);
			}
			System.out.println("Competitor not found. Choose an existing competitor.");
		}
		
	}
	
	public Team selectTeam(Vector<Team> teams)
	{
		listTeams(teams);
		
		while(true)
		{
			System.out.print("Select a team\n>");
			int index = Lue.kluku();
			
			if(teams.elementAt(index - 1)!= null)
			{
				return teams.elementAt(index - 1);
			}
			System.out.println("Team not found. Choose an existing team.");
		}
	}
	
	public Sport selectSport(Vector<Sport> sports)
	{
		listSports(sports);
		
		while (true)
		{	
			System.out.print("Select a sport\n>");
			int index = Lue.kluku();
			
			if(sports.elementAt(index - 1)!= null)
			{
				return sports.elementAt(index - 1);
			}
			System.out.println("Sport not found. Choose an existing sport.");
		}
	}
	
	public void listCompetitors(Vector<Competitor> competitors)
	{
		System.out.println("List of all competitors: ");
		for(int i = 0; i < competitors.size(); i++)
		{
			System.out.println(competitors.elementAt(i));
		}
	}
	
	public void listTeams(Vector<Team> teams)
	{
		System.out.println("List of all teams: ");
		for(int i = 0; i < teams.size(); i++)
		{
			System.out.println(teams.elementAt(i));
		}
	}
	
	public void listSports(Vector<Sport> sports)
	{
		System.out.println("List of all sports:");
		for(int i = 0; i < sports.size(); i++)
		{
			System.out.print((i+1) + ". " + sports.elementAt(i) + ", Teamsport: ");
			if(sports.elementAt(i).ifTeamSport())
			{
				System.out.print("Yes ");
			}
			else
				System.out.print("No ");
			System.out.print("Leaguesport: ");
			if(sports.elementAt(i).ifLeagueSport())
			{
				System.out.println("Yes ");
			}
			else
				System.out.println("No ");
		}
	}
	
}
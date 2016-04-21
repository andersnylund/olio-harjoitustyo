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
		return last;
	}
	public String askFirstname()
	{
		System.out.print("Firstname\n>");
		String first=Lue.rivi();
		return first;
	}
	
	public int askAge()
	{
		System.out.print("Age\n>");
		int age = Lue.kluku();
		return age;
	}
	
	public int askGender()
	{
		System.out.print("Gender (Man = 1, Woman = 2, Other = 3)\n>");
		int gender = Lue.kluku();
		return gender;
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
		System.out.println("\n1. Add sport and add participants to sport");
		System.out.println("2. Add teams");
		System.out.println("3. Add/edit competitors or officials");
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
	


	
	public Competitor selectCompetitor(Vector<Competitor> competitors, String message)
	{	
		//lists the competitors and returns null if no competitors was found
		if(!listCompetitors(competitors))
			return null;
		
		while(true)
		{
			System.out.print("Select a competitor " + message + "\n>");
			int index= Lue.kluku();
			
			//checks if the number is bigger than the size of the array.
			//returns null if true.
			if(index > competitors.size()){
				System.out.println("Index out of bounds. ");
				return null;
			}
			
			//Checks if the chosen object is null.
			//if not, returns the object.
			if(competitors.elementAt(index - 1)!=null)
			{
				return competitors.elementAt(index - 1);
			}
			System.out.println("Competitor not found. Choose an existing competitor.");
		}
		
	}
	
	public Team selectTeam(Vector<Team> teams)
	{	
		//lists all teams and returns null if no teams were found.
		if(!listTeams(teams)){
			return null;
		}
		
		while(true)
		{
			System.out.print("Select a team\n>");
			int index = Lue.kluku();
			
			//checks if the number is bigger than the size of the array.
			//returns null if true.
			if(index > teams.size()){
				System.out.println("Index out of bounds. ");
				return null;
			}
			
			//Checks if the chosen object is null.
			//if not, returns the object.
			if(teams.elementAt(index - 1)!= null)
			{
				return teams.elementAt(index - 1);
			}
			System.out.println("Team not found. Choose an existing team.");
		}
	}
	
	public Sport selectSport(Vector<Sport> sports)
	{	
		//lists all sports and returns null if no sports were found.
		if(!listSports(sports))
			return null;
		
		while (true)
		{	
			System.out.print("Select a sport\n>");
			int index = Lue.kluku();
			
			//checks if the number is bigger than the size of the array.
			//returns null if true.
			if(index > sports.size()){
				System.out.println("Index out of bounds. ");
				return null;
			}
			
			//Checks if the chosen object is null.
			//if not, returns the object.
			if(sports.elementAt(index - 1)!= null)
			{
				return sports.elementAt(index - 1);
			}
			System.out.println("Sport not found. Choose an existing sport.");
		}
	}
	
	public boolean listParticipants(Sport sport)
	{
		//sport.getParticipant(index)
		
		return false;
	}
	
	public boolean listCompetitors(Vector<Competitor> competitors)
	{	
		if(competitors.isEmpty()){
			System.out.println("No competitors found.");
			return false;
		}
		System.out.println("List of all competitors: ");
		for(int i = 0; i < competitors.size(); i++)
		{
			System.out.println(competitors.elementAt(i));
		}
		return true;
	}
	
	public boolean listTeams(Vector<Team> teams)
	{
		if(teams.isEmpty()){
			System.out.println("No teams found.");
			return false;
		}
		System.out.println("List of all teams: ");
		for(int i = 0; i < teams.size(); i++)
		{
			System.out.println(teams.elementAt(i));
		}
		return true;
	}
	
	public boolean listTeams(Sport sport)
	{
		if(sport == null)
			return false;
		System.out.println("Sport: " + sport.getName());
		System.out.println("\tTeams: ");
		
		for(int i = 0; i < sport.nroOfTeams(); i++)
		{
			System.out.println("\t" + sport.getTeam(i).getName());
		}
		return true;
	}
	
	//prints a team
	public void listTeamAndMembers(Team team)
	{
		System.out.println("\tTeam: " + team.getName());
		System.out.println("\tScore: " + String.format("%.1f)", team.getScoreTeam()));
		System.out.println("\t\tTeam members:");
		
		for(int i = 0; i < team.nroOfMembers(); i++){
			System.out.println("\t\t" + team.getMember(i).toString());
		}
	}	
	
	public boolean listSports(Vector<Sport> sports)
	{	
		if(sports.isEmpty()){
			System.out.println("No sports found.");
			return false;
		}
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
		return true;
	}
	
}
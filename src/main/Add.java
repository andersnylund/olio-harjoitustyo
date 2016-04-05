package main;

import uva.Lue;
import java.util.Vector;

public class Add 
{	
	private View view = new View();
	
	//method to add competitors (persons) to the competition. These competitors are used both as competitors and officials
	//in different sports 
	public Vector<Competitor> addEditCompetitor(Vector <Competitor> competitors)
	{
		//lists all the competitors saved in the program
		//when printed the number in front of the name is the competitor-number
		System.out.println("List of all persons: ");
		for(int i = 0; i < competitors.size();i++)
			System.out.println(competitors.elementAt(i));
		
		//ask user to add or edit competitors
		System.out.println("\nAdd (A) or edit (E) competitor or official");
		System.out.print(">");
		
		char set;
		while(true)
		{
			set = Lue.merkki();
			//adding new competitor to the "competitor-vector" in Main-class
			if(set == 'A')
			{
				Competitor competitor = new Competitor();
				competitor.setLastname(view.askLastname());
				competitor.setFirstname(view.askFirstname());
				competitors.add(competitor);
				break;
			}
			//editing competitor in the "competitor-vector" in Main-class
			else if(set == 'E')
			{
				System.out.println("Enter number of person to edit");
				System.out.print(">");
				int num = Lue.kluku();
				
				while(num>competitors.size())
				{
					System.out.print("Entered number of person not found. Please enter new number\n>");
					num = Lue.kluku();
				}
				competitors.elementAt(num-1).setLastname(view.askLastname());
				competitors.elementAt(num-1).setFirstname(view.askFirstname());
				break;
			}
			else
				System.out.println("Wrong character input");
			}
		//returns the vector of competitors to the Main-class
		return competitors;
	}
	
	private Sport sport;
	private League league;
	private boolean teamSport, leagueSport;
	
	public Sport addSport()
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
		
		String name = view.setSportName();
		
		sport = new Sport(teamSport, leagueSport, name);
		
		return sport;
	}
	
	private Team team;
	
	public boolean addTeam(Vector<Sport> sports)
	{
		//printing out all sports and if they are a team sport
		for(int i = 0; i < sports.size(); i++)
		{
			System.out.print("\n" + (i+1) + ". " + sports.elementAt(i) + ", teamsport: ");
			if(sports.elementAt(i).ifTeamSport())
			{
				System.out.println("yes");
			}
			else
				System.out.println("no");
		}
		
		int number;
		
		if(!sports.isEmpty())
			{
			System.out.print("Select sport to add team to> ");
			number = Lue.kluku();
			}
		else
			{
			System.out.println("No sports found. Create new sport.");
			number = 0;
			return true;
			}
		
		
		
		if(sports.elementAt(number).ifTeamSport())
		{
			team = new Team();
			
			char set;
			
			while(true){
				System.out.println("Add member (Y/N)");
				set = Lue.merkki();
				if(set == 'Y'){
					//team.addMember();
					break;
				}
				else if(set == 'N'){
					System.out.println("Team complete.");
					break;
				}
				else
					System.out.println("Wrong character input!");
				}
			
			sport.addTeam(team);
		}
		else
			System.out.println("The sport is not a team sport.\nReturning backto main menu.");
		
		return true;
	}
	
}

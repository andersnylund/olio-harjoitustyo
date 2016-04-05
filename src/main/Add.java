package main;

import uva.Lue;
import java.util.Vector;

public class Add 
{	
	private View view = new View();
	
	public Vector<Competitor> addEditCompetitor(Vector <Competitor> competitors)
	{
		
		System.out.println("List of all persons: ");
		for(int i = 0; i < competitors.size();i++)
			System.out.println(competitors.elementAt(i));
		
		System.out.println("\nAdd (A) or edit (E) competitor or official");
		System.out.print(">");
		
		char set;
		while(true)
		{
			set = Lue.merkki();
			if(set == 'A')
			{
				Competitor competitor = new Competitor();
				competitor.setLastname(view.askLastname());
				competitor.setFirstname(view.askFirstname());
				competitors.add(competitor);
				break;
			}
			else if(set == 'E')
			{
				System.out.println("Enter number of person to edit");
				System.out.print(">");
				int num = Lue.kluku();
				
				while(num>competitors.size())
				{
					System.out.print("Entered number not found. Please enter new number\n>");
					num = Lue.kluku();
				}
				competitors.elementAt(num-1).setLastname(view.askLastname());
				competitors.elementAt(num-1).setFirstname(view.askFirstname());
				break;
			}
			else
				System.out.println("Wrong character input");
			}
		
		return competitors;
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

/*
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package ui;

import uva.Lue;

import java.util.Vector;

import data.*;

public class AddSport 
{	
	private View view = new View();
	
	private Sport sport;
	private Competitor competitor;
	
	private boolean teamSport, leagueSport;
	
	
	public void addSportAndParticipants(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		view.listSports(sports);
		
		System.out.println("\n1. Add sport");
		System.out.println("2. Add participants to sport");
		System.out.println("3. Back to main menu");
		System.out.print(">");
		
		
		char a;
		//waits for the user to input either S or P
		while(true)
		{
			a = Lue.merkki();
			if(a == '1')
			{
				addSport(sports);
				break;
			}
			//lets user add participant to sport
			else if(a == '2')
			{
				addParticipantsToSport(sports, competitors);
				break;
			}
			else if(a == '3'){
				break;
			}
			else
				System.out.println("Wrong character input!");
		}
	}
	
	public void addSport(Vector<Sport> sports)
	{
		char set;
		//Ask the user to say if the new sport is a team sport
		System.out.println("Is it a team sport? (Y/N)");
	
		//waits for the user to insert either Y or N 
		while(true)
		{
			set = Lue.merkki();
			if(set == 'Y')
			{
				teamSport = true;
				break;
			}
			else if(set == 'N')
			{
				teamSport = false;
				break;
			}
			else
				System.out.println("Wrong character input");
		}
		
		//Ask the user to say if the new sport is a league sport
		System.out.println("Does the sport contain leagues? (Y/N)");
	
		//waits for the user to insert either Y or N 
		while(true)
		{
			set = Lue.merkki();
			if(set == 'Y')
			{
				leagueSport = true;
				break;
			}
			else if(set == 'N')
			{
				leagueSport = false;
				break;
			}
			else
				System.out.println("Wrong character input!");
		}
		
		String name = view.setSportName();
		
		sports.addElement(new Sport(teamSport, leagueSport, name)); 
	}
	
	public void addParticipantsToSport(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		if(sports.isEmpty())
		{
			System.out.println("No sports found, add a sport and try again!");
			return;
		}
		while(true)
		{	
			//returns if the selected sport is null
			sport = view.selectSport(sports);
			if(sport == null)
				return;
			
			//returns if the selected competitor is null.
			competitor = view.selectCompetitor(competitors, "");
			
			//add a participant to the sport
			if(competitor!= null){
				sport.addParticipant(competitor);
			}

			break;
		}
	}
	
	public Sport getSport(){ return sport;}
}

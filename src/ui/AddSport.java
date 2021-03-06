/**
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package ui;

import uva.Lue;


import java.util.Vector;

import data.*;
/**
 * For adding sports
 * @author Anders Nylund w101302, Jeremias Snellman w101318
 *
 */
public class AddSport 
{	
	private View view = new View();
	
	private Sport sport;
	private Competitor competitor;
	
	private boolean teamSport;
	
	/**
	 * 
	 * @param sports
	 * @param competitors
	 */
	public void addSportAndParticipants(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		view.listSports(sports);
		
		System.out.println("\n1. Add sport");
		System.out.println("2. Add participants to sport");
		System.out.println("3. Back to main menu");
		System.out.print(">");
		
		
		int a;
		//waits for the user to input either S or P
		while(true)
		{
			a = Lue.kluku();
			if(a == 1)
			{
				addSport(sports);
				break;
			}
			//lets user add participant to sport
			else if(a == 2)
			{
				addParticipantsToSport(sports, competitors);
				break;
			}
			else if(a == 3){
				break;
			}
			else
				System.out.println("Wrong integer input!");
		}
	}
	/**
	 * 
	 * @param sports
	 */
	public void addSport(Vector<Sport> sports)
	{
		int set;
		/**
		 * Ask the user to say if the new sport is a team sport
		 */
		System.out.print("Is it a team sport?\n1. Yes\n2. No\n> ");
	
		/**
		 * waits for the user to insert either Y or N 
		 */
		while(true)
		{
			set = Lue.kluku();
			if(set == 1)
			{
				teamSport = true;
				break;
			}
			else if(set == 2)
			{
				teamSport = false;
				break;
			}
			else
				System.out.println("Wrong integer input");
		}
		
		String name = view.setSportName();
		
		sports.addElement(new Sport(teamSport, false, name)); 
	}
	/**
	 * 
	 * @param sports
	 * @param competitors
	 */
	public void addParticipantsToSport(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		if(sports.isEmpty())
		{
			System.out.println("No sports found, add a sport and try again!");
			return;
		}
		while(true)
		{	
			/**
			 * returns if the selected sport is null
			 */
			sport = view.selectSport(sports);
			if(sport == null)
				return;
			
			/**
			 * returns if the selected competitor is null.
			 */
			competitor = view.selectCompetitor(competitors, "");
			
			/**
			 * add a participant to the sport
			 */
			if(competitor!= null){
				if(sport.checkIfParticipant(competitor))
					System.out.println("Competitor already participating in the sport");
				else	
					sport.addParticipant(competitor);
			}

			break;
		}
	}
	/**
	 * 
	 * @return
	 */
	public Sport getSport()
	{
		return sport;
	}
	
	/**
	 * Deletes the selected sport.
	 * @param sports A vector with all the sport objects for choosing the sport to delete.
	 */
	public void deleteSport(Vector<Sport> sports){
		sport = view.selectSport(sports);
		if(sport!=null){
			if(sports.remove(sport))
				System.out.println("Sport deleted: " + sport.getName());
			else
				System.out.println("Couldn't delete the sport");
		}
	}
}

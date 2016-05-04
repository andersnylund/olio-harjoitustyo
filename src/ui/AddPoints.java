/**
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package ui;

import uva.Lue;

import java.util.Vector;

import data.*;

/**
 * 	For adding points to participants and teams
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */
public class AddPoints 
{
	/**
	 * An interface
	 */
	View view = new View();
	/**
	 * Prompt to user for adding or editing points
	 * @param sports Vector of sports
	 * @return True if user wants to cancel operation
	 */
	public boolean addEditPoints(Vector<Sport>sports)
	{
		while(true)
		{
			System.out.println("1. Add/edit an individuals points");
			System.out.println("2. Add/edit a teams points");
			System.out.println("3. Back to main menu");
			System.out.print("> ");
			
			int set = Lue.kluku();
			
			switch(set)
			{
			case 1:
				addIndividualsPoints(sports);
				break;
			case 2:
				addTeamsPoints(sports);
			case 3:
				return true;
			default:
				System.out.println("Wrong integer input!");
			}
		}
	}
	/**
	 * For adding points to an individual competitor
	 * @param sports Vector of sports
	 * @return True if adding points was successful, false if no sports were found
	 */
	public boolean addIndividualsPoints(Vector<Sport>sports)
	{
		if(sports.isEmpty())
		{
			System.out.println("No sports found. Add a sport and try again");
			return false;
		}	
		Participant part = view.selectParticipant(view.selectSport(sports));
		if(part != null)
			part.setScore(view.askScore());
		else
			System.out.println("Couldn't set the score");
		return true;
	}
	/**
	 * For adding points to a team
	 * @param sports Vector of sports
	 * @return True if adding was successful, false if no teams were found
	 */
	public boolean addTeamsPoints(Vector<Sport>sports)
	{
		if(sports.isEmpty())
		{
			System.out.println("No team found. Add a team and try again");
			return false;
		}
		Team team = view.selectTeam(view.selectSport(sports).getTeamVector());
		if(team!=null)
			team.setScoreTeam(view.askScore());
		else
			System.out.println("The selected sport is not a team sport");
		return true;
	}
	
}

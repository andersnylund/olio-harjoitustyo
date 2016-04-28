/**
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package ui;

import uva.Lue;

import java.util.Vector;

import data.*;

public class AddPoints 
{
	View view = new View();
	/**
	 * 
	 * @param sports
	 * @return
	 */
	public boolean addEditPoints(Vector<Sport>sports)
	{
		while(true)
		{
			System.out.println("1. Add/edit an individuals points");
			System.out.println("2. Add/edit a teams points");
			System.out.println("3. Back to main menu");
			System.out.print(">");
			
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
				System.out.println("Wrong option. Choose a valid option.");
			}
		}
	}
	/**
	 * 
	 * @param sports
	 * @return
	 */
	public boolean addIndividualsPoints(Vector<Sport>sports)
	{
		if(sports.isEmpty())
		{
			System.out.println("No sports found. Add a sport and try again");
			return false;
		}	
		view.selectParticipant(view.selectSport(sports)).setScore(view.askScore());
		return true;
	}
	/**
	 * 
	 * @param sports
	 * @return
	 */
	public boolean addTeamsPoints(Vector<Sport>sports)
	{
		if(sports.isEmpty())
		{
			System.out.println("No team found. Add a team and try again");
			return false;
		}
		view.selectTeam(view.selectSport(sports).getTeamVector()).setScoreTeam(view.askScore());
		return true;
	}
	
}

/*
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package ui;

import java.util.Vector;

import data.*;

public class ShowAndSave 
{
	
	private Sport sport;
	private Team team;
	private League league;
	private Competitor competitor;
	
	private View view = new View();
	
	
	/*
	 * Prints all the info that is saved in the program at the current state
	 */
	public void printAllInfo(Vector<Sport> sports){
		for(int i = 0; i < sports.size(); i++)
		{
			if(sports.elementAt(i).ifTeamSport())
			{
				for(int j = 0; j < sports.elementAt(i).nroOfTeams(); j++)
				{
					view.listTeamAndMembers(sports.elementAt(i).getTeam(j));
				}
			}
			else
				for(int j = 0; j <sports.elementAt(i).nroOfParticipants(); j++)
				{
					view.listSportandParticipants(sports.elementAt(j));
				}
		}
	}

}

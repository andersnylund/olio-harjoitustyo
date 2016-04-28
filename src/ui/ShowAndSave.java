package ui;

import java.util.Vector;

import data.*;

public class ShowAndSave {
	
	private Sport sport;
	private Team team;
	private League league;
	private Competitor competitor;
	
	private View view = new View();
	
	public void printAllInfo(Vector<Sport> sports){
		for(int i = 0; i < sports.size(); i++)
		{	
			sport = sports.elementAt(i);
			
			if(sport.ifTeamSport())
			{	
				System.out.println("Sport: " + sport);
				for(int j = 0; j < sport.nroOfTeams(); j++)
				{
					view.listTeamAndMembers(sport.getTeam(j));
				}
			}
			else
				view.listSportandParticipants(sport);
			
		}
	}

}

package ui;

import java.util.Vector;

import data.*;

public class ShowAndSave {
	
	private Sport sport;
	private Team team;
	private League league;
	private Competitor competitor;
	
	private View view = new View();
	
	public ShowAndSave(Vector<Sport> sports, Vector<Competitor> competitors){
		printAllInfo(sports);
	}
	
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
					
				}
		}
	}

}

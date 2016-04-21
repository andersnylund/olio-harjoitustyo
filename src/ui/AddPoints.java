package ui;

import uva.Lue;

import java.util.Vector;

import data.*;

public class AddPoints 
{
	View view = new View();
	
	public boolean addEditPoints(Vector<Sport>sports)
	{
		while(true)
		{
			System.out.println("1. Add/edit an individuals points");
			System.out.println("2. Add/edit a teams points");
			System.out.println("2. Back to main menu");
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
	
	public boolean addIndividualsPoints(Vector<Sport>sports)
	{
		view.selectParticipant(view.selectSport(sports)).setScore(view.askScore());
		return false;
	}
	
	public boolean addTeamsPoints(Vector<Sport>sports)
	{
		view.selectTeam(view.selectSport(sports).getTeamVector()).setScoreTeam();
		
		return false;
	}
	
}

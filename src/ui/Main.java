package ui;

import java.util.Vector;

import data.*;

public class Main 
{
	//COMPETITION_NAME is set as the name of the file if the user wants to save the recently made competition
	//or it is used as the filename to load to the program
	static private String COMPETITION_NAME;
	//an object of the data menu that is used by the Main-class
	static View mainView = new View();
	
	//vector where all the persons of the competition are stored
	//these persons are used later as competitors or officials
	private static Vector<Competitor> competitors = new Vector<Competitor>();
	
	//Creates a vector of sport objects.
	private static Vector<Sport> sports = new Vector<Sport>();
	
	private static AddTeam addTeam = new AddTeam();
	private static AddCompetitor addCompetitor = new AddCompetitor();
	private static AddSport addSport = new AddSport();
	private static AddPoints addPoints = new AddPoints();
	
	
	public static void main(String[] args) 
	{
		switch(mainView.printStart())
		{
			case 1:
				COMPETITION_NAME = mainView.setCompetitionName();
				break;
			case 2:
				COMPETITION_NAME = mainView.setCompetitionName();
				//here the programs searches for a file with name COMPETITION_NAME and loads it
				break;
			default:
				break;
		}
		
		while(true)
			mainMenu();
	}	
	
	//the data method that is run every time user has done a task
	//different cases calls different methods to create or modify data
	public static void mainMenu()
	{	
		
		switch(mainView.printMainMenu())
		{
			//Add sport
			case 1:	
				addSport.addSportAndParticipants(sports, competitors);
				break;	
			//Add team	
			case 2:
				addTeam.addTeamOrMembers(sports, competitors);
				break;
			//Add/edit competitor/official
			case 3:
				addCompetitor.addEditCompetitor(competitors);
				break;
			//Add/edit points
			case 4:
				addPoints.addEditPoints(sports, competitors);
				break;
			//Show results/ save current results in the competition
			case 5:
				break;
			//quit program
			case 6:
				System.out.println("Shutting down program!");
				System.exit(0);
			default:
				break;
		}
	}
	
	public String getCompetitionName()
	{
		return COMPETITION_NAME;
	}
	
	
}


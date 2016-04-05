package main;

import java.util.Vector;

public class Main 
{
	//COMPETITION_NAME is set as the name of the file if the user wants to save the recently made competition
	//or it is used as the filename to load to the program
	static private String COMPETITION_NAME;
	//an object of the main menu that is used by the Main-class
	static View mainView = new View();
	
	//vector where all the persons of the competition are stored
	//these persons are used later as competitors or officials
	private static Vector<Competitor> competitors = new Vector<Competitor>();
	
	private static Vector<Sport> sports = new Vector<Sport>();
	
	
	
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
	
	//the main method that is run every time user has done a task
	//different cases calls different methods to create or modify data
	public static void mainMenu()
	{	
		
		Add add = new Add();
		
		switch(mainView.printMainMenu())
		{
			//Add/edit competitor/official
			case 1:	
				add.addEditCompetitor(competitors);
				break;	
			//Add sport
			case 2:
				add.addSport();
				break;
			//Add team	
			case 3:
				add.addTeam(sports);
				break;
			//Add/edit points
			case 4:
			
			//Show results/ save current results in the competition
			case 5:
				
			//quit program
			case 6:
				System.out.println("Shutting down program");
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


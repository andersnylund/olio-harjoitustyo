package main;

import uva.Lue;

public class Main 
{
	//COMPETITIONNAME is set as the name of the file if the user wants to save the recently made competition
	//or it is used as the filename to load to the program
	static private String COMPETITION_NAME;
	static View mainView = new View();
	
	private Sport sport;
	
	private League league;
	
	private boolean teamSport, leagueSport;
	
	
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
		switch(mainView.printMainMenu())
		{
			//Add/edit competitor/official
			case 1:	
				
			//Add sport
			case 2:
			
			//Add team	
			case 3:
			
			//Add/edit points
			case 4:
			
			//Show results/ save current results in the competition
			case 5:
				
			//quit program
			case 6:
				System.exit(0);
		}
	}
	
	public String getCompetitionName()
	{
		return COMPETITION_NAME;
	}
	
	public void addSport(){
		char set;
		//Ask the user to say if the new sport is a team sport
		System.out.println("Is it a team sport? (Y/N)");
	
		//waits for the user to insert either Y or N 
		while(true){
		set = Lue.merkki();
		if(set == 'Y'){
			teamSport = true;
			break;
		}
		else if(set == 'N'){
			teamSport = false;
			break;
		}
		else
			System.out.println("Wrong character input");
		}
		
		//Ask the user to say if the new sport is a league sport
		System.out.println("Does the sport contain leagues? (Y/N)");
	
		//waits for the user to insert either Y or N 
		while(true){
		set = Lue.merkki();
		if(set == 'Y'){
			leagueSport = true;
			break;
		}
		else if(set == 'N'){
			leagueSport = false;
			break;
		}
		else
			System.out.println("Wrong character input!");
		}
		
		sport = new Sport(teamSport, leagueSport);
	}
}


package main;

public class Main 
{
	//COMPETITIONNAME is set as the name of the file if the user wants to save the recently made competition
	//or it is used as the filename to load to the program
	static private String COMPETITION_NAME;
	static View mainView = new View();
	
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
			case 1:	
			case 2:
			case 3:
			case 4:
			
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
}


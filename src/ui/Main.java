/**
 * @author	Anders Nylund w101302, Jeremias Snellman w101318
 * TODO	Comments to everything
 * 		Fix user interface
 * 		Add option to delete, competitors, teams and sports
 * 		Check exceptions
 */

package ui;
import java.util.Vector;
import data.*;

/**
 * Main menu
 * @author Anders Nylund w101302, Jeremias Snellman w101318
 *
 */
public class Main 
{
	/**
	 * COMPETITION_NAME is set as the name of the file if the user wants to save the recently made competition or it is used as the filename to load to the program
	 */
	static private String COMPETITION_NAME;
	
	/**
	 * Object of the data menu that is used by the Main-class
	 */
	static View mainView = new View();
	
	/**
	 * Vector where all the persons of the competition are stored these persons are used later as competitors or officials
	 */
	private static Vector<Competitor> competitors = new Vector<Competitor>();
	
	/**
	 * Creates a vector of sport objects.
	 */
	private static Vector<Sport> sports = new Vector<Sport>();
	private static AddTeam addTeam = new AddTeam();
	private static AddCompetitor addCompetitor = new AddCompetitor();
	private static AddSport addSport = new AddSport();
	private static AddPoints addPoints = new AddPoints();
	private static ShowAndSave showAndSave = new ShowAndSave();
	
	/**
	 * Main method. Asks user to either create new or load a competition
	 * @param args
	 */
	public static void main(String[] args) 
	{
		switch(mainView.printStart())
		{
			case 1:
				COMPETITION_NAME = mainView.setCompetitionName();
				break;
			case 2:
				COMPETITION_NAME = mainView.setCompetitionName();
				break;
			default:
				break;
		}
		
		while(true)
			mainMenu();
	}	
	
	/**
	 * The data method that is run every time user has done a task
	 * Different cases calls different methods to create or modify data
	 */
	public static void mainMenu()
	{	
		
		switch(mainView.printMainMenu())
		{
			/**
			 * Add sport
			 */
			case 1:	
				addSport.addSportAndParticipants(sports, competitors);
				break;	
			/**
			 * Add team	
			 */
			case 2:
				addTeam.addTeamOrMembers(sports, competitors);
				break;
			/**
			 * Add or edit competitor or official
			 */
			case 3:
				addCompetitor.addEditCompetitor(competitors);
				break;
			/**
			 * Add or edit points
			 */
			case 4:
				addPoints.addEditPoints(sports);
				break;
			/**
			 * Show results or save current results in the competition
			 */
			case 5:
				showAndSave.printAllInfo(sports);
			
				break;
			/**
			 * Quit program
			 */
			case 6:
				System.out.println("Shutting down program!");
				System.exit(0);
			default:
				break;
		}
	}
	
	/**
	 * Returns the name of the competition
	 * @return String Returns the name of the competition
	 */
	public String getCompetitionName()
	{
		return COMPETITION_NAME;
	}
	
	
}


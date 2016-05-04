/**
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package ui;

import java.util.Vector;

import data.*;
import uva.Lue;

/**
 * 	For adding and editing competitors
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */
public class AddCompetitor 
{
	private View view = new View();
	private Competitor competitor;
	 
	/**
	 * Method to add competitors (persons) to the competition. 
	 * These competitors are used both as competitors and officials in different sports
	 * @param competitors
	 * @return The modified vector of Competitors
	 */
	public Vector<Competitor> addEditCompetitor(Vector <Competitor> competitors)
	{
		/**
		 * Aists all the competitors saved in the program
		 * When printed the number in front of the name is the competitor number
		 */
		view.listCompetitors(competitors);
		
		/**
		 * Ask user to add or edit competitors
		 */
		System.out.println("\n1. Add competitor or official");
		System.out.println("2. Edit competitor or official");
		System.out.println("3. Back to main menu");
		System.out.print("> ");
		
		int set;
		while(true)
		{
			set = Lue.kluku();
			/**
			 * adding new competitor to the "competitor-vector" in Main-class
			 */
			if(set == 1)
			{
				addCompetitor(competitors);
				break;
			}
			/**
			 * editing competitor in the "competitor-vector" in Main-class
			 */
			else if(set == 2)
			{
				editCompetitor(competitors);
				break;
			}
			else if(set == 3)
			{
				break;
			}
			else
				System.out.println("Wrong integer input");
			}
		/**
		 * returns the vector of competitors to the Main-class
		 */
		return competitors;
	}
	/**
	 * Adding a new competitor to the competitors Vector
	 * @param competitors Vector of competitors
	 */
	public void addCompetitor(Vector<Competitor> competitors)
	{
		Competitor competitor = new Competitor();
		do
		{
			competitor.setLastname(view.askLastname());
			competitor.setFirstname(view.askFirstname());
		}while(!(competitor.checkName(competitor.getLastname())) && !(competitor.checkName(competitor.getFirstname())));
		competitor.setAge(view.askAge());
		competitor.setGender(view.askGender());
		competitors.add(competitor);
	}
	/**
	 * For editing a competitor already in competitors Vector
	 * @param competitors Vector of competitors
	 */
	public boolean editCompetitor(Vector<Competitor> competitors)
	{
		competitor = view.selectCompetitor(competitors, "to edit");
		if(competitor == null)
			return true;
		do
		{
			competitor.setLastname(view.askLastname());
			competitor.setFirstname(view.askFirstname());
		}while(!(competitor.checkName(competitor.getLastname())) && !(competitor.checkName(competitor.getFirstname())));
		competitor.setAge(view.askAge());
		competitor.setGender(view.askGender());
		return false;
	}
}

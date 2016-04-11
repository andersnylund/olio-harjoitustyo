package ui;

import java.util.Vector;

import data.*;
import uva.Lue;

public class AddCompetitor 
{
	private View view = new View();
	private Competitor competitor;
	
	//method to add competitors (persons) to the competition. These competitors are used both as competitors and officials
	//in different sports 
	public Vector<Competitor> addEditCompetitor(Vector <Competitor> competitors)
	{
		//lists all the competitors saved in the program
		//when printed the number in front of the name is the competitor-number
		view.listCompetitors(competitors);
		
		//ask user to add or edit competitors
		System.out.println("\nAdd (A) or edit (E) competitor or official");
		System.out.print(">");
		
		char set;
		while(true)
		{
			set = Lue.merkki();
			//adding new competitor to the "competitor-vector" in Main-class
			if(set == 'A')
			{
				addCompetitor(competitors);
				break;
			}
			//editing competitor in the "competitor-vector" in Main-class
			else if(set == 'E')
			{
				editCompetitor(competitors);
				break;
			}
			else
				System.out.println("Wrong character input");
			}
		//returns the vector of competitors to the Main-class
		return competitors;
	}
	
	public void addCompetitor(Vector<Competitor> competitors)
	{
		Competitor competitor = new Competitor();
		competitor.setLastname(view.askLastname());
		competitor.setFirstname(view.askFirstname());
		competitors.add(competitor);
	}
	
	public void editCompetitor(Vector<Competitor> competitors)
	{
		competitor = view.selectCompetitor(competitors, "to edit");
		competitor.setLastname(view.askLastname());
		competitor.setFirstname(view.askFirstname());
	}
}

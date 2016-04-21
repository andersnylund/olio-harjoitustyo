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
			System.out.println("1. Add points");
			System.out.println("2. Edit points");
			System.out.println("3. Back to main menu");
			System.out.print(">");
			
			int set = Lue.kluku();
			
			switch(set)
			{
			case 1:
				addPoints(sports);
				break;
			case 2:
				editPoints(sports);
				break;
			case 3:
				return true;
			default:
				System.out.println("Wrong option. Choose an option between 1 and 3.");
			}
		}
	}
	
	public boolean addPoints(Vector<Sport>sports)
	{
		view.listParticipants(view.selectSport(sports));
		return false;
	}
	
	public boolean editPoints(Vector<Sport>sports)
	{
		return false;
	}
}

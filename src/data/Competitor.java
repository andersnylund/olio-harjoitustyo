/*
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package data;

public class Competitor extends Person
{	
	/*
	 * the competitor number, which each competitor will have
	 */
	private int competitorNumber;
	
	private static int nextNumber = 1;
	
	/*
	 * The constructor that sets a competitor-number when creating a new competitor
	 */
	public Competitor(){
		competitorNumber = nextNumber;
		updateNumber();
	}
	
	/*
	 * Called when a new competitor is created
	 * Updates the competition number
	 */
	public static void updateNumber(){
		nextNumber++;
	}
	
	/*
	 * Returns the competitor number
	 * @return int Returns the competitor number
	 */
	public int getNumber()
	{
		return competitorNumber;
	}
	
	/*
	 * Returns the competitor number plus the first and last name as a string
	 * @return String Returns the competitor number plus the first and last name as a string
	 */
	@Override
	public String toString(){
		if(competitorNumber != 0)
			return Integer.toString(competitorNumber) + ": " + super.toString();
		return super.toString();
	}
}

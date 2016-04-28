/**
 * Inherits Person-class and is used to create new competitors
 * @author Anders Nylund w101302, Jeremias Snellman w101318
 * @brief Inherits Person-class. Used to create new competitors
 */
package data;

/**
 * Inherits Person-class and is used to create new competitors
 * @author Anders Nylund w101302, Jeremias Snellman w101318
 * @brief Inherits Person-class. Used to create new competitors
 */
public class Competitor extends Person
{	
	/**
	 * The competitor number, which each competitor will have
	 */
	private int competitorNumber;
	/**
	 * Number used to assign the competitor number
	 */
	private static int nextNumber = 1;
	
	/**
	 * The constructor that sets a competitor-number when creating a new competitor
	 */
	public Competitor(){
		competitorNumber = nextNumber;
		updateNumber();
	}
	
	/**
	 * Called when a new competitor is created
	 * Updates the competition number
	 */
	public static void updateNumber(){
		nextNumber++;
	}
	
	/**
	 * Getter for competitor number
	 * @return int Returns the competitor number
	 */
	public int getNumber()
	{
		return competitorNumber;
	}
	
	/**
	 * Converting competitor information to a String
	 * @return String Returns the competitor number plus the first and last name as a string
	 */
	@Override
	public String toString(){
		if(competitorNumber != 0)
			return Integer.toString(competitorNumber) + ": " + super.toString();
		return super.toString();
	}
}

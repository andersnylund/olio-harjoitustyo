//Anders Nylund w101302
//Jeremias Snellman w101318

package main;

public class Competitor extends Person
{	
	//the score of one competitor
	private int points;
	//the competitor number, which each competitor will have
	private int competitorNumber;
	
	//returns the competitor number
	public int getNumber()
	{
		return competitorNumber;
	}
	
	//returns the competitor number plus the first and last name as a string
	public String toString(){
		return Integer.toString(competitorNumber) + ": " + super.toString();
	}
}

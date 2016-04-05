//Anders Nylund w101302
//Jeremias Snellman w101318

package main;

public class Competitor extends Person
{	
	//the competitor number, which each competitor will have
	private int competitorNumber;
	
	private static int nextNumber = 1;
	
	public Competitor(){
		competitorNumber = nextNumber;
		updateNumber();
	}
	
	public static void updateNumber(){
		nextNumber++;
	}
	
	//returns the competitor number
	public int getNumber()
	{
		return competitorNumber;
	}
	
	//returns the competitor number plus the first and last name as a string
	@Override
	public String toString(){
		if(competitorNumber != 0)
			return Integer.toString(competitorNumber) + ": " + super.toString();
		return super.toString();
	}
}

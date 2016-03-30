//Anders Nylund w101302
//Jeremias Snellman w101318

package main;

import java.util.*;

public class Participant {

	private Competitor competitor;
	
	private double score = 0;
	
	//vector containing either persons or competitors
	private Vector<Competitor> competitors;
	
	public Participant(Competitor competitor){
		
		this.competitor = competitor;
		competitors = new Vector<Competitor>();
	}
	
	public void setScore (double score){ this.score = score;}
	public double getScore(){ return score; }
	public Competitor getCompetitor(){ return competitor;}
	
	public String getLastname () { return competitor.getLastname (); }
	public String getFirstname () { return competitor.getFirstname (); }
	public int getGender () { return competitor.getGender (); }
	public int getAge () { return competitor.getAge(); }
	public int getNumber () { return competitor.getNumber(); }
	
	public String toString(){
		if(score != 0)
			return competitor.toString() + "\t\t\t" + Double.toString(score);
		return competitor.toString();
	}
	
	
}

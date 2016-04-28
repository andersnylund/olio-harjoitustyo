/**
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */
package data;

import java.util.*;
/**
 * Used for creating new participants
 * @author	Anders Nylund w101302, Jeremias Snellman w101318 
 *
 */
public class Participant {

	private Competitor competitor;
	
	private double score = 0;
	
	/**
	 * Vector containing either persons or competitors
	 */
	private Vector<Competitor> competitors;
	
	/**
	 * The constructor that makes a competitor a participant
	 * @param competitor
	 */
	public Participant(Competitor competitor){
		
		this.competitor = competitor;
		competitors = new Vector<Competitor>();
	}
	/**
	 * Setter for participants score
	 * @param score
	 */
	public void setScore (double score){ this.score = score;}
	/**
	 * Getter for participants score
	 * @return
	 */
	public double getScore(){ return score; }
	/**
	 * Getter for competitor
	 * @return competitor Returns the competitor
	 */
	public Competitor getCompetitor(){ return competitor;}
	/**
	 * Getter for competitors last name
	 * @return lastname Returns lastname
	 */
	public String getLastname () { return competitor.getLastname (); }
	/**
	 * Getter for competitors first name
	 * @return firstname Returns firstname
	 */
	public String getFirstname () { return competitor.getFirstname (); }
	/**
	 * Getter for competitors gender
	 * @return gender Returns gender
	 */
	public String getGender () { return competitor.getGender (); }
	/**
	 * Getter for competitors age
	 * @return age Returns age
	 */
	public int getAge () { return competitor.getAge(); }
	/**
	 * Getter for competitors competitor number
	 * @return number Returns cometitor number
	 */
	public int getNumber () { return competitor.getNumber(); }
	/**
	 * Getter for the whole comeptitor Vector
	 * @return competitors Returns competitor vector
	 */
	public Vector<Competitor> getCompetitorVector(){
		return competitors;
	}
	/**
	 * 
	 */
	@Override
	public String toString(){
		if(score != 0)
			return competitor.toString() + "\t\tScore: " + Double.toString(score);
		return competitor.toString();
	}
	
	
}

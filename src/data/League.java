/**
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */
package data;
import java.util.*;

public class League 
{
	/**
	 * limit for which league the competitor should belong to.
	 */
	public static final int JUNIORI_LIMIT = 20;
	/**
	 * name of the league
	 */
	private String name;
	
	/**
	 * age limit of the league
	 */
	private int ageLimit;
	
	/**
	 * Is it only for women?
	 */
	private boolean womenLeague = false;
	
	/**
	 * vector containing all the participants in the league
	 */
	private Vector<Participant> participants;
	
	
	/**
	 * Constructor that creates a new participant-vector upon creation
	 */
	public League(){
		
		//creating the vector
		participants = new Vector<Participant>();
	}
	
	protected League(String name, int ageLimit, boolean womenLeague){
		
		//creating the vector
		participants = new Vector<Participant>();
		
		this.name = name;
		this.ageLimit = ageLimit;
		this.womenLeague = womenLeague;
	}
	
	/**
	 * 
	 * @param name The name of the league
	 * @return Returns League-object
	 */
	public static League buildLeague(String name){
		if(name == null) return null;
		
		boolean womenLeague = false;
		
		int firstChar = name.codePointAt(0);
		if(firstChar == 'N') womenLeague = true;
		else if(firstChar !='Y') return null;
		
		int ageLimit = 0;
		if(name.length() > 1 )
			ageLimit = Integer.parseInt(name.substring(1));
		
		return new League (name , ageLimit, womenLeague);
	}
	
	public boolean addParticipant(Participant participant){
		
		//NOT complete
		//check how it works
		if(participant == null) return false;
		
		//int g = participant.getGender();
		
		//if(g != Competitor.WOMAN && womenLeague) return false;
		
		if(ageLimit != 0){
			if(ageLimit < JUNIORI_LIMIT){
				if (ageLimit < participant.getAge()) return false;
			}
			else if(ageLimit > participant.getAge()) return false;
		}
		
		participants.add(participant);
		return true;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public boolean editParticipant(int index){	
		
		participants.get(index);
		//NOT complete
		//edit the name of the participant
		return true;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public boolean deleteParticipant(int index)
	{
		//NOT complete
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public int nroOfParticipants(){ return participants.size();	}
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Participant getParticipant(int index){ return participants.get(index);}
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean setName(String name)
	{
		this.name = name;
		return true;
	}
	/**
	 * 
	 */
	@Override
	public String toString()
	{
		return name;
	}
	
}

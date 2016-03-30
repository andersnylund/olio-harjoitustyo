
//Anders Nylund w101302
//Jeremias Snellman w101318

package main;
import java.util.*;

public class League 
{
	//name of the league
	private String name;
	
	//age limit of the league
	private int ageLimit;
	
	//Is it only for women?
	private boolean womenLeague = false;
	
	//vector containing all the participants in the league
	private Vector<Participant> participants;
	
	//vector containing all the teams
	private Vector<Team> teams;
	
	//Constructor
	public League(){
		
		//creating the vector
		participants = new Vector<Participant>();
		teams = new Vector<Team>();
	}
	
	protected League(String name, int ageLimit, boolean womenLeague){
		
		//creating the vector
		participants = new Vector<Participant>();
		
		this.name = name;
		this.ageLimit = ageLimit;
		this.womenLeague = womenLeague;
	}
	
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
		
		//NOT complete!
		//still have to set it to the right league
		
		participants.add(participant);
		return true;
	}
	
	public boolean editParticipant(int index){	
		
		participants.get(index);
		//NOT complete
		//edit the name of the participant
		return true;
	}
	
	public boolean deleteParticipant(int index)
	{
		//NOT complete
		return true;
	}
	
	public int nroOfParticipants(){ return participants.size();	}
	
	public Participant getParticipant(int index){ return participants.get(index);}
	
	public String getName()
	{
		return name;
	}
	
	public boolean setName(String name)
	{
		this.name = name;
		return true;
	}
	
}

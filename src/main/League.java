
//Anders Nylund w101302
//Jeremias Snellman w101318

package main;
import java.util.*;

public class League 
{
	//name of the league
	private String name;
	
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
	
	public boolean addParticipant()
	{
		return true;
	}
	
	public boolean editParticipant()
	{
		return true;
	}
	
	public boolean deleteParticipant()
	{
		return true;
	}
	
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

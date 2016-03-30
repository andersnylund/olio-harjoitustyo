//Anders Nylund w101302
//Jeremias Snellman w101318

package main;

import java.util.*;

public class Sport
{
	
	//name of the sport
	private String name;
	
	//vector containing all the leagues for each sport
	private Vector<League> leagues;
	
	
	public Sport(){
		
		leagues = new Vector<League>();
	}
	
	public Sport(String name){
		this();
		this.name = name;
	}
	
	public boolean addLeague(League league){
		
		if(league == null) return false;
		
		leagues.add(league);
		return true;
	}
	
	public boolean addLeague(String name){
		if(name == null) return false;
		League league = League.buildLeague(name);
		leagues.add(league);
		return true;
	}
	
	public int nroOfLeagues() { return leagues.size();}
	public League getLeague(int index){ return leagues.get(index);}
	
	public void setName(String name){ this.name = name; }
	public String getName(){ return name; }
	
	public boolean addParticipant(Competitor competitor){
		Participant participant = new Participant(competitor);
		
		boolean added = false;
		for(int i = 0; i < leagues.size(); i++)
		{
			added |= leagues.get(i).addParticipant(participant);
		}
		return added;
	}
	
}

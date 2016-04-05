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
	
	//vector containing all the teams
	private Vector<Team> teams;
	
	
	public Sport(boolean teamSport, boolean leagueSport){
		if(leagueSport)
			leagues = new Vector<League>();
		if(teamSport)
			teams = new Vector<Team>();
	}
	
	public Sport(String name){
	
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
	
	public boolean addTeam(Team team){
		if(team == null) return false;
		
		teams.add(team);
		
		return true;
	}
	
	public int nroOfLeagues() { return leagues.size();}
	public League getLeague(int index){ return leagues.get(index);}
	
	public int nroOfTeams() { return teams.size();}
	public Team getTeam(int index){ return teams.get(index);}
	
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
	
	@Override
	public String toString(){
		return name;
	}
	
}

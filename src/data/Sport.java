//Anders Nylund w101302
//Jeremias Snellman w101318

package data;

import java.util.*;

public class Sport
{
	
	//name of the sport
	private String name;
	
	//vector containing all the leagues for each sport
	private Vector<League> leagues;
	
	//vector containing all the teams
	private Vector<Team> teams;
	
	//Vector containing participants if the sport is not a team or league sport.
	private Vector<Participant> participants;
	
	//Variables to check if the sport contains teams and leagues
	private boolean teamSport, leagueSport;
	
	
	public Sport(boolean teamSport, boolean leagueSport, String name){
		
		this.teamSport = teamSport;
		this.leagueSport = leagueSport;
		this.name = name;
		
		//creates a league vector if the sport is a league sport
		if(leagueSport)
			leagues = new Vector<League>();
		//creates a team vector if the sport is a team sport
		if(teamSport)
			teams = new Vector<Team>();
		//creates a participant vector if the sport is neither a team or league sport. 
		if(!teamSport && !leagueSport)
		{
			participants = new Vector<Participant>();
		}
		
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
	
	public boolean ifTeamSport(){return teamSport;}
	public boolean ifLeagueSport(){return leagueSport;}
	
	public boolean addParticipant(Competitor competitor){
		Participant participant = new Participant(competitor);
		
		boolean added = false;
		for(int i = 0; i < leagues.size(); i++)
		{
			added |= leagues.get(i).addParticipant(participant);
		}
		return added;
	}
	
	public Vector<Team> getTeamVector()
	{
		return teams;
	}
	

	@Override
	public String toString(){
		return name;
	}
	
}

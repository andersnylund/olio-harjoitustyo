/**
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package data;

import java.util.*;

/**
 * Used for creating new sports
 * @author Anders Nylund w101302, Jeremias Snellman w101318
 *
 */
public class Sport
{
	
	/**
	 * Name of the sport
	 */
	private String name;
	
	/**
	 * Vector containing all the leagues for each sport
	 */
	private Vector<League> leagues;
	
	/**
	 * Vector containing all the teams
	 */
	private Vector<Team> teams;
	
	/**
	 * Vector containing participants if the sport is not a team or league sport.
	 */
	private Vector<Participant> participants;
	
	/**
	 * Variables to check if the sport contains teams and leagues
	 */
	private boolean teamSport, leagueSport;
	
	/**
	 * Constructor of Sport
	 * @param teamSport Checks if new Sport is a teamsport
	 * @param leagueSport Checks if new Sport is a leaguesport
	 * @param name The name of the new Sport
	 */
	public Sport(boolean teamSport, boolean leagueSport, String name){
		
		this.teamSport = teamSport;
		this.leagueSport = leagueSport;
		this.name = name;
		
		/**
		 * Creates a league vector if the sport is a league sport
		 */
		if(leagueSport)
			leagues = new Vector<League>();
		/**
		 * Creates a team vector if the sport is a team sport
		 */
		if(teamSport)
			teams = new Vector<Team>();
		/**
		 * Creates a participant vector if the sport is neither a team or league sport. 
		 */
		if(!teamSport && !leagueSport)
		{
			participants = new Vector<Participant>();
		}
		
	}
	

	/**
	 * Used for adding a league
	 * @param league
	 * @return boolean Returns true if adding a league was successful
	 */
	public boolean addLeague(League league){
		
		if(league == null) return false;
		
		leagues.add(league);
		return true;
	}
	/**
	 * 
	 * @param name
	 * @return boolean Returns true if 
	 */
	public boolean addLeague(String name){
		if(name == null) return false;
		League league = League.buildLeague(name);
		leagues.add(league);
		return true;
	}
	/**
	 * 
	 * @param team
	 * @return
	 */
	public boolean addTeam(Team team){
		if(team == null) return false;
		
		teams.add(team);
		
		return true;
	}
	/**
	 * To check the size of leagues Vector
	 * @return int Returns number of leagues
	 */
	public int nroOfLeagues() { return leagues.size();}
	/**
	 * 
	 * @param index The 
	 * @return
	 */
	public League getLeague(int index){ return leagues.get(index);}
	/**
	 * 
	 * @return
	 */
	public int nroOfTeams() { return teams.size();}
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Team getTeam(int index){ return teams.get(index);}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name){ this.name = name; }
	/**
	 * 
	 * @return
	 */
	public String getName(){ return name; }
	/**
	 * 
	 * @return
	 */
	public boolean ifTeamSport(){return teamSport;}
	/**
	 * 
	 * @return
	 */
	public boolean ifLeagueSport(){return leagueSport;}
	/**
	 * 
	 * @param competitor
	 */
	public void addParticipant(Competitor competitor)
	{
		Participant participant = new Participant(competitor);
		participants.addElement(participant);
	}
	/**
	 * 
	 * @return
	 */
	public Vector<Team> getTeamVector()
	{
		return teams;
	}
	/**
	 * 
	 * @return
	 */
	public Vector<Participant> getParticipantsVector()
	{
		return participants;
	}
	/**
	 * 
	 * @return
	 */
	public int nroOfParticipants(){return participants.size();}
	/**
	 * 
	 * @return
	 */
	public Vector<League> getLeagueVector()
	{
		return leagues;
	}
	/**
	 * 
	 */
	@Override
	public String toString(){
		return name;
	}
	
}

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
	 * For adding a already created league to the league Vector
	 * @param league 
	 * @return Returns true if adding a league was successful
	 */
	public boolean addLeague(League league){
		
		if(league == null) return false;
		
		leagues.add(league);
		return true;
	}
	/**
	 * For making a new league and adding it to the league Vector
	 * @param name The name of the league to add to the leagues Vector
	 * @return Returns True if adding was successful
	 */
	public boolean addLeague(String name){
		if(name == null) return false;
		League league = League.buildLeague(name);
		leagues.add(league);
		return true;
	}
	/**
	 * 
	 * @param team The team to add to the teams Vector
	 * @return Returns True if adding was successful
	 */
	public boolean addTeam(Team team){
		if(team == null) return false;
		
		teams.add(team);
		
		return true;
	}
	/**
	 * To check the size of leagues Vector
	 * @return Returns number of leagues
	 */
	public int nroOfLeagues() { return leagues.size();}
	/**
	 * Getter for league in league Vector
	 * @param index The index of the desired league
	 * @return Returns the league with index of index parameter
	 */
	public League getLeague(int index)
	{ 
		return leagues.get(index);
	}
	/**
	 * Check number of teams
	 * @return Returns the number of teams
	 */
	public int nroOfTeams() 
	{ 
		return teams.size();
	}
	/**
	 * Getter for team in team Vector
	 * @param index
	 * @return Returns the team with index of index parameter
	 */
	public Team getTeam(int index)
	{ 
		return teams.get(index);
		}
	/**
	 * Setter for name of sport
	 * @param name The name of sport
	 */
	public void setName(String name)
	{ 
		this.name = name; 
	}
	/**
	 * Getter for name of sport
	 * @return Returns name of sport
	 */
	public String getName()
	{ 
		return name; 
	}
	/**
	 * Checks if sport is a teamsport
	 * @return Returns true if sport is teamsport, else false
	 */
	public boolean ifTeamSport()
	{
		return teamSport;
	}
	/**
	 * Checks if sport is a leaguesport
	 * @return Returns true if sport is leaguesport, else false
	 */
	public boolean ifLeagueSport()
	{
		return leagueSport;
	}
	/**
	 * Makes competitor a participant
	 * @param competitor The competitor which will be made a participant
	 */
	public void addParticipant(Competitor competitor)
	{
		Participant participant = new Participant(competitor);
		participants.addElement(participant);
	}
	
	/**
	 * Checking if a competitor is found in the paricipant-vector
	 * @param competitor The competitor to check
	 * @return Returns true if participant found in participant-vector, else false
	 */
	public boolean checkIfParticipant(Competitor competitor)
	{
		for(int i = 0; i< participants.size(); i++)
		{
			if(participants.elementAt(i).getNumber() == competitor.getNumber())
				return true;
		}
			return false;
	}
	/**
	 * Getter for the team Vector
	 * @return Returns the team Vector
	 */
	public Vector<Team> getTeamVector()
	{
		return teams;
	}
	/**
	 * Getter for the participant Vector
	 * @return Returns the participant Vector
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
	 * Getter for the league Vector
	 * @return Returns the league Vector
	 */
	public Vector<League> getLeagueVector()
	{
		return leagues;
	}
	/**
	 * Converting sport information to a String
	 * @return Returns the sport name as String
	 */
	@Override
	public String toString()
	{
		return name;
	}
	
}

/**
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */
package data;

import java.util.Vector;
/**
 * Used for creating new teams
 * @author	Anders Nylund w101302, Jeremias Snellman w101318
 *
 */
public class Team {
	
	/**
	 * Name of the team
	 */
	private String name;
	
	/**
	 * The teams' points
	 */
	private double scoreTeam;
	
	/**
	 * Vector containing all team members
	 */
	private Vector<Participant> teamMembers;
	
	/**
	 * 
	 * @param name 
	 */
	public Team(String name)
	{
		teamMembers = new Vector<Participant>();
		this.name = name;
	}
	/**
	 * Add member to team
	 * @param participant Participant to add to team
	 */
	public void addMember(Participant participant)
	{
		teamMembers.add(participant);
	}
	
	/**
	 * Search for member. If member found, the method return 1 else, it returns -1
	 * @param lastName
	 * @param firstName
	 * @return Returns 1 if member is found, else -1
	 */
	public int searchMember(String lastName, String firstName){
		for (int i = 0; i < teamMembers.size (); ++i)
		{
			Participant participant = teamMembers.get (i);
			
			if (participant.getLastname().equals (lastName) &&
				participant.getFirstname().equals (firstName) )
				return i;
		}
		
		return -1;
	}
	
	public boolean checkIfMember(Participant participant){
		for(int i = 0; i < teamMembers.size(); i++){
			if(teamMembers.elementAt(i).getNumber() == participant.getNumber())
				return true;
		}
		return false;
	}
	/**
	 * Setter for the team score
	 * @param score The score to be set ofr the team
	 */
	public void setScoreTeam(double score)
	{
		scoreTeam = score;
	}
	/**
	 * Getter for the team score
	 * @return The score of the team
	 */
	public double getScoreTeam(){ return scoreTeam; }
	/**
	 * 
	 * @param lastName Last name of person to be deleted
	 * @param firstName First name of person to be deleted
	 * @return True if delete was successul, else false
	 */
	public boolean deleteMember(String lastName, String firstName)
	{
		int index = searchMember(lastName, firstName);
		if(index < 0) return false;
		teamMembers.remove(index);
		return true;
	}
	
	/**
	 * 
	 * @param participant The participant to be deleted from team
	 * @return True if deleting was successful, else false
	 */
	public boolean deleteMember(Participant participant)
	{
		return deleteMember(participant.getLastname(), participant.getFirstname());
	}
	/**
	 * 
	 * @return Number of members
	 */
	public int nroOfMembers()
	{ 
		return teamMembers.size(); 
	}
	/**
	 * Getter for member
	 * @param index Index of participant to get
	 * @return Participant with index
	 */
	public Participant getMember(int index)
	{ 
		return teamMembers.get(index); 
	}
	/**
	 * Setter for name of team
	 * @param name Name of team
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Getter for teams name
	 * @return Name of team
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Getter for team Vector
	 * @return Vector of teammembers
	 */
	public Vector<Participant> getTeamMembers()
	{ 
		return teamMembers;
	}

}

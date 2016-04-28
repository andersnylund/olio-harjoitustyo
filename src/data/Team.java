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
	public Team(String name){
		
		teamMembers = new Vector<Participant>();
		this.name = name;
	}
	/**
	 * 
	 * @param participant
	 */
	public void addMember(Participant participant){
		teamMembers.add(participant);
	}
	
	/**
	 * Search for member. If member found, the method return 1 else, it returns -1
	 * 
	 * @param lastName
	 * @param firstName
	 * @return
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
	/**
	 * 
	 * @param score
	 */
	public void setScoreTeam(double score)
	{
		scoreTeam = score;
	}
	/**
	 * 
	 * @return
	 */
	public double getScoreTeam(){ return scoreTeam; }
	/**
	 * 
	 * @param lastName
	 * @param firstName
	 * @return
	 */
	public boolean deleteMember(String lastName, String firstName){
		int index = searchMember(lastName, firstName);
		if(index < 0) return false;
		teamMembers.remove(index);
		return true;
	}
	
	/**
	 * 
	 * @param participant
	 * @return
	 */
	public boolean deleteMember(Participant participant){
		return deleteMember(participant.getLastname(), participant.getFirstname());
	}
	/**
	 * 
	 * @return
	 */
	public int nroOfMembers(){ return teamMembers.size(); }
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Participant getMember(int index){ return teamMembers.get(index); }
	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 
	 * @return
	 */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return
	 */
	public Vector<Participant> getTeamMembers(){ return teamMembers;}

}

//Anders Nylund w101302
//Jeremias Snellman w101318

package data;

import java.util.Vector;

public class Team {
	
	//name of the team
	private String name;
	
	//the teams' points
	private double scoreTeam;
	
	//vector containing all team members
	private Vector<Participant> teamMembers;
	
	//the constructor
	public Team(String name){
		
		teamMembers = new Vector<Participant>();
		this.name = name;
	}
	
	public void addMember(Participant participant){
		teamMembers.add(participant);
	}
	
	
	//search for member
	//if member found, the method return 1
	//else, it returns -1
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
	public void setScoreTeam(){
		//adds all team members' score 
		for(int i = 0; i < teamMembers.size(); i++)
		{
			scoreTeam += getMember(i).getScore();
		}
	}
	
	public double getScoreTeam(){ return scoreTeam; }
	
	public boolean deleteMember(String lastName, String firstName){
		int index = searchMember(lastName, firstName);
		if(index < 0) return false;
		teamMembers.remove(index);
		return true;
	}
	
	
	public boolean deleteMember(Participant participant){
		return deleteMember(participant.getLastname(), participant.getFirstname());
	}
	
	public int nroOfMembers(){ return teamMembers.size(); }
	
	public Participant getMember(int index){ return teamMembers.get(index); }
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public Vector<Participant> getTeamMembers(){ return teamMembers;}

}

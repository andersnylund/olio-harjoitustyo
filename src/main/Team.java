//Anders Nylund w101302
//Jeremias Snellman w101318

package main;

import java.util.Vector;

public class Team {
	
	//name of the team
	private String name;
	
	//the teams' points
	private double points;
	
	//vector containing all team members
	private Vector<Participant> participants;
	
	public Team(){
		
		participants = new Vector<Participant>();
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

}

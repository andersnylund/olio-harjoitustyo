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
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}

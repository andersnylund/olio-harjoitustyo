/**
 * 	@author	Anders Nylund w101302, Jeremias Snellman w101318
 */

package ui;

import java.util.Vector;

import data.*;
import uva.Lue;

/**
 * For adding teams
 * @author Anders Nylund w101302, Jeremias Snellman w101318
 *
 */
public class AddTeam 
{
	private View view = new View();
	private Team team;
	private Sport sport;
	private Participant participant;
	/**
	 * 
	 * @param sports
	 * @param competitors
	 * @return
	 */
	public boolean addTeamOrMembers(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		while(true)
		{
			//Asks the user if he wants to add a team or members to a team
			System.out.println("\n1. Add team\n2. Edit team members\n3. Delete team\n4. Back to main menu");
			int index = Lue.kluku();
			
			switch(index)
			{
			case 1: addTeam(sports, competitors); break;
			case 2: editTeamMembers(sports, competitors); break;
			case 3: deleteTeam(sports);
			case 4: return true;
			default: System.out.println("Wrong integer input!");
			}
		}
	}
	/**
	 * 
	 * @param sports
	 * @param competitors
	 * @return
	 */
	public boolean addTeam(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		//printing out all sports and if they are a team sport
		for(int i = 0; i < sports.size(); i++)
		{
			System.out.print((i+1) + ". " + sports.elementAt(i) + ", teamsport: ");
			if(sports.elementAt(i).ifTeamSport())
			{
				System.out.println("yes");
			}
			else
				System.out.println("no");
		}
		
		int number;
		
		//lets the user select a sport to add a team to.
		if(!sports.isEmpty())
			{
			System.out.print("Select sport to add team to\n> ");
			number = Lue.kluku();
			}
		else
			{
			System.out.println("No sports found. Create new sport first.");
			number = 0;
			return true;
			}
		//checks if the selected team is within bounds.
		if(number > sports.size()){
			System.out.println("Index out of bounds.");
			return false;
		}
		
		//Checks if the selected sport is a team sport.
		if(sports.elementAt(number - 1).ifTeamSport())
		{	
			//creates a new team object.
			team = new Team(view.setTeamName());
			
			sports.elementAt(number -1).addTeam(team);
			
			int set;
			
			//Lets the user add a member if he user wants to 
			while(true)
			{
				System.out.print("Add member\n1. Yes\n2. No\n> ");
				set = Lue.kluku();
				if(set == 1)
				{
					if(!addTeamMember(team,competitors))
						break;
				}
				else if(set == 2)
				{
					System.out.println("Team complete.\n");
					break;
				}
				else
					System.out.println("Wrong integer input!");
			}
				
		}
		else
			System.out.println("The sport is not a team sport.");
		
		return true;
	}
	/**
	 * Sub-menu for adding or deleting team members.
	 * @param sports
	 * @param competitors
	 */
	public void editTeamMembers(Vector<Sport> sports, Vector<Competitor> competitors){
		System.out.println("1. Add member\n2. Delete member");
		int a = Lue.kluku();
		if(a == 1){
			addTeamMember(sports, competitors);
		}
		else if(a == 2){
			deleteTeamMember(sports);
		}
		else
			System.out.println("Wrong integer input");
	}
	/**
	 * Deletes a selected team member.
	 * @param sports
	 */
	public void deleteTeamMember(Vector<Sport> sports){
		sport = view.selectSport(sports);
		if(sport != null){
			team = view.selectTeam(sport.getTeamVector());
			if(team!= null){
				participant = view.selectTeamMember(team);
				if(participant != null){
					if(team.deleteMember(participant))
						System.out.println("Team member deleted: " + participant.toString());
					else
						System.out.println("Couldn't delete the selected member");
				}
			}
		}
	}
	/**
	 * 
	 * @param sports
	 * @param competitors
	 * @return 
	 */
	public boolean addTeamMember(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		//lists all the sports and lets the user select which sport to add a team member to.
		sport = view.selectSport(sports);
		if(sport == null)
			return false;
		
		if(!sport.ifTeamSport())
		{	
			System.out.println("The sport is not a team sport.");
			return false;
		}
		//lists all teams and lets the user select a team to add a member.
		team = view.selectTeam(sport.getTeamVector());
		if(team == null){
			return false;
		}
		
		addMember(team, competitors);
		
		return true;
		
	}
	/**
	 * 
	 * @param team
	 * @param competitors
	 * @return
	 */
	public boolean addTeamMember(Team team, Vector<Competitor> competitors)
	{	
		addMember(team, competitors);
		return true;
	}
	/**
	 * 
	 * @param team
	 * @param competitors
	 */
	public void addMember(Team team, Vector<Competitor> competitors)
	{	
			//Checks if there are any competitors in the competitor vector
			if(!competitors.isEmpty())
			{	
				//lists all the competitors
				//creates  new participant object and lets the user choose
				//which competitor to add to the participant object
				participant = new Participant(view.selectCompetitor(competitors, ""));
				if(participant == null)
					return;
				
				if(team.checkIfMember(participant))
					System.out.println("The selected person is already a member");
				else{
					//adds the participant to the team member vector.
					team.addMember(participant);
					System.out.println("Member added.");
				}
			}
			else
			{
				System.out.println("No competitors found.");
			}	
	}
	
	/**
	 * Deletes the selected team.
	 * @param sports A vector with all the sport objects for choosing the team to delete.
	 */
	public void deleteTeam(Vector<Sport> sports){
		sport = view.selectSport(sports);
		if(sport != null){
			team = view.selectTeam(sport.getTeamVector());
			if(team!= null){
				if(sport.getTeamVector().remove(team))
					System.out.println("Team deleted: " + team.getName());
				else
					System.out.println("Couldn't delete the team");
			}
		}
	}
}

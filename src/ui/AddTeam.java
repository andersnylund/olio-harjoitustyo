package ui;

import java.util.Vector;

import data.*;
import uva.Lue;

public class AddTeam 
{
	private View view = new View();
	private Team team;
	private Sport sport;
	private Participant participant;
	
	public boolean addTeamOrMembers(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		while(true)
		{
			//Asks the user if he wants to add a team or members to a team
			System.out.println("What do you want to do? \n1. Add a team?\n2. Add members to a team?\n3. Back to main menu?");
			int index = Lue.kluku();
			
			switch(index)
			{
			case 1: addTeam(sports, competitors); break;
			case 2: addTeamMember(sports, competitors); break;
			case 3: return true;
			default: System.out.println("Wrong option. Choose an option between 1 and 3.");
			}
		}
		

	}
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
			System.out.print("Select sport to add team to\n>");
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
			
			char set;
			
			//Lets the user add a member if he user wants to 
			while(true){
				System.out.println("Add member (Y/N)");
				set = Lue.merkki();
				if(set == 'Y'){
					if(!addTeamMember(sports,competitors))
						break;
				}
				else if(set == 'N'){
					System.out.println("Team complete.\n");
					break;
				}
				else
					System.out.println("Wrong character input!");
				}
				
		}
		else
			System.out.println("The sport is not a team sport.");
		
		return true;
	}
	
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
		
		addMember(competitors);
		
		return true;
		
	}
	
	public void addMember(Vector<Competitor> competitors)
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
				//adds the participant to the team member vector.
				team.addMember(participant);
				System.out.println("Member added.");
			}
			else
			{
				System.out.print("No competitors found.");
			}	
	}
}

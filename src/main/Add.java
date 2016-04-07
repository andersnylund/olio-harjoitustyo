package main;

import uva.Lue;
import java.util.Vector;

public class Add 
{	
	private View view = new View();
	
	private Team team;
	private Sport sport;
	private League league;
	private Participant participant;
	
	private boolean teamSport, leagueSport;
	
	//method to add competitors (persons) to the competition. These competitors are used both as competitors and officials
	//in different sports 
	public Vector<Competitor> addEditCompetitor(Vector <Competitor> competitors)
	{
		//lists all the competitors saved in the program
		//when printed the number in front of the name is the competitor-number
		view.listCompetitors(competitors);
		
		//ask user to add or edit competitors
		System.out.println("\nAdd (A) or edit (E) competitor or official");
		System.out.print(">");
		
		char set;
		while(true)
		{
			set = Lue.merkki();
			//adding new competitor to the "competitor-vector" in Main-class
			if(set == 'A')
			{
				Competitor competitor = new Competitor();
				competitor.setLastname(view.askLastname());
				competitor.setFirstname(view.askFirstname());
				competitors.add(competitor);
				break;
			}
			//editing competitor in the "competitor-vector" in Main-class
			else if(set == 'E')
			{
				System.out.println("Enter number of person to edit");
				System.out.print(">");
				int num = Lue.kluku();
				
				while(num>competitors.size())
				{
					System.out.print("Entered number of person not found. Please enter new number\n>");
					num = Lue.kluku();
				}
				competitors.elementAt(num-1).setLastname(view.askLastname());
				competitors.elementAt(num-1).setFirstname(view.askFirstname());
				break;
			}
			else
				System.out.println("Wrong character input");
			}
		//returns the vector of competitors to the Main-class
		return competitors;
	}
	

	
	public void addSportAndParticipants(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		view.listSports(sports);
		
		System.out.print("\nAdd sport (S) or add participants to sport (P)\n>");
		
		char a;
		//waits for the user to input either S or P
		while(true)
		{
			a = Lue.merkki();
			if(a == 'S')
			{
				char set;
				//Ask the user to say if the new sport is a team sport
				System.out.println("Is it a team sport? (Y/N)");
			
				//waits for the user to insert either Y or N 
				while(true)
				{
					set = Lue.merkki();
					if(set == 'Y')
					{
						teamSport = true;
						break;
					}
					else if(set == 'N')
					{
						teamSport = false;
						break;
					}
					else
						System.out.println("Wrong character input");
				}
				
				//Ask the user to say if the new sport is a league sport
				System.out.println("Does the sport contain leagues? (Y/N)");
			
				//waits for the user to insert either Y or N 
				while(true)
				{
					set = Lue.merkki();
					if(set == 'Y')
					{
						leagueSport = true;
						break;
					}
					else if(set == 'N')
					{
						leagueSport = false;
						break;
					}
					else
						System.out.println("Wrong character input!");
				}
				
				String name = view.setSportName();
				
				sports.addElement(new Sport(teamSport, leagueSport, name)); 
				break;
			}
			//lets user add participant to sport
			else if(a == 'P')
			{
				if(sports.isEmpty())
				{
					System.out.println("No sports found, add a sport and try again!");
					break;
				}
				while(true)
				{
					view.selectSport(sports).addParticipant(view.selectCompetitor(competitors));
					break;
				}
				
			}
			else
				System.out.println("Wrong character input!");
		}
	}
	
	
	
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
		
		if(!sports.isEmpty())
			{
			System.out.print("Select sport to add team to> ");
			number = Lue.kluku();
			}
		else
			{
			System.out.println("No sports found. Create new sport.");
			number = 0;
			return true;
			}
		/**
		 * Adds a team. Then asks the user if he wants to add team members. If yes, lists all the teams available and lets the 
		 * user select which team to add member to.
		 * 
		 * After that, lists all the competitors and lets the user select which competitor to add.
		 * 
		 */
		
		//Checks if the selected sport is a team sport.
		if(sports.elementAt(number - 1).ifTeamSport())
		{	
			//creates a new team object.
			team = new Team(view.setTeamName());
			
			char set;
			
			while(true){
				System.out.println("Add member (Y/N)");
				set = Lue.merkki();
				if(set == 'Y'){
					
					//Checks if there are any competitors in the competitor vector
					if(!competitors.isEmpty())
					{	
						//lists all the competitors
						//creates  new participant object and lets the user choose
						//which competitor to add to the participant object
						participant = new Participant(view.selectCompetitor(competitors));
						
						//adds the participant to the team member vector.
						team.addMember(participant);
						System.out.println("Member added.");
					}
					else
						System.out.println("No competitors found. \nReturning back to main menu.");
				}
				else if(set == 'N'){
					System.out.println("Team complete.");
					break;
				}
				else
					System.out.println("Wrong character input!");
				}
			if(team!=null)
				sports.elementAt(number -1).addTeam(team);
		}
		else
			System.out.println("The sport is not a team sport.\nReturning back to main menu.");
		
		return true;
	}
	
	public void addTeamMember(Vector<Sport> sports, Vector<Competitor> competitors)
	{
		//lists all the sports and lets the user select which sport to add a team member to.
		sport = view.selectSport(sports);
		//lists all teams and lets the user select a team to add a member.
		team = view.selectTeam(sport.getTeamVector());
		
		char set;
		
		while(true)
		{
			System.out.println("Add member (Y/N)");
			set = Lue.merkki();
			if(set == 'Y'){
				
				//Checks if there are any competitors in the competitor vector
				if(!competitors.isEmpty())
				{	
					//lists all the competitors
					//creates  new participant object and lets the user choose
					//which competitor to add to the participant object
					participant = new Participant(view.selectCompetitor(competitors));
					
					//adds the participant to the team member vector.
					team.addMember(participant);
					System.out.println("Member added.");
				}
				else
					System.out.println("No competitors found. \nReturning back to main menu.");
			}
		}
	}
	
	public void addEditPoints()
	{
		
	}
	
}

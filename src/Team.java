import java.util.ArrayList;

public class Team {
	private String name;
	private String location;
	public ArrayList <Players> topPlayers;
	public static ArrayList <Team> teams;
	public int averageRatingOfTeam;
	
	public Team(String teamName, String teamLocation, ArrayList<Players> teamTopPlayers) {
		name= teamName;
		location= teamLocation;
		topPlayers= teamTopPlayers;
	}
	
	public String getName() {
		return location + " " + name;
	}
	
	public static ArrayList <Team> startLeauge() {
		teams= new ArrayList <Team> ();
		teams.add(new Team("Packers","Green Bay", Players.startPackers()));
		teams.add(new Team("Cowboys","Dallas", Players.startCowboys()));
		teams.add(new Team("Ravens","Baltimore", Players.startRavens()));
		teams.add(new Team("Patriots","New England", Players.startPatriots()));
		teams.add(new Team("Rams","Los Angles", Players.startRams()));
		teams.add(new Team("Bengals","Cincinati", Players.startBengals()));
		teams.add(new Team("Saints","New Orleans",Players.startSaints()));
		teams.add(new Team("Chiefs","Kansas City",Players.startChiefs())); 
		return teams;
	}
	
	public static void printOrigTeamList(ArrayList <Team> teams) {
		int counter= 1;
		for (Team t: teams) {
			System.out.println(counter + ": " + t.location + " " + t.name);
			System.out.println();
			Players.toString(t.topPlayers);
			System.out.println();
			counter++;
		}
	}
	
	public int averageTeamRating() {
		int total= 0;
		for (Players p: topPlayers) {
			total+= p.playerRating;
		}
		
		return total/topPlayers.size();
	}
	
	public static String superbowlChampion(ArrayList<Integer> averageRating) {
		int positionOfHighest= 0;
		for (int i=0; i<averageRating.size(); i++) {
			if (averageRating.get(positionOfHighest)<averageRating.get(i)) {
				positionOfHighest= i;
			}
		}
		
		return teams.get(positionOfHighest).getName();
	}
	
	public static void printTeamOnly(ArrayList <Players> topPlayers) {
		for (Players p: topPlayers) {
			System.out.println(p.name + ": " + p.playerRating + "- " + p.yearsLeftOnContract + " years left");
		}
	}
	
	public static void removeYearOffContract(ArrayList<Team> teams) {
		for (Team t: teams) {
			for (Players p: t.topPlayers) {
				p.yearsLeftOnContract= p.yearsLeftOnContract-1;
			}
		}
	}
	
	public static void addPlayersToFreeAgency(ArrayList<Team> teams) {
		for (Team t: teams) {
			for (int i=0; i<t.topPlayers.size(); i++ ) {
				if (t.topPlayers.get(i).yearsLeftOnContract==0) {
					FreeAgentDatabase.freeAgents.add(t.topPlayers.get(i));
					t.topPlayers.remove(t.topPlayers.get(i));
				}
			}
		}
		/*for (Team t: teams) {
			int counter=0;
			for (Players p: t.topPlayers) {
				if (p.yearsLeftOnContract==0) {
					FreeAgentDatabase.freeAgents.add(p);
					t.topPlayers.remove(p);
				}
			}
		} */
	}
}

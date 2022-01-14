import java.util.ArrayList;

public class FreeAgentDatabase{
	public static ArrayList<Players> freeAgents;
	
	public FreeAgentDatabase() {
		freeAgents= new ArrayList<Players>();
		freeAgents.add(new Players("Jared Cook", 83, 3));
		freeAgents.add(new Players("Allen Robinson", 85, 3));
		freeAgents.add(new Players("Tyrann Mathieu", 86, 3));
		freeAgents.add(new Players("Andrew Norwell", 82, 3));
		freeAgents.add(new Players("Von Miller", 84, 3));
		freeAgents.add(new Players("Brandon Scherff", 81, 3));
		freeAgents.add(new Players("Cam Robinson", 79, 3));
		freeAgents.add(new Players("Terron Armstead", 76, 3));
		freeAgents.add(new Players("Akiem Hicks", 82, 3));
		freeAgents.add(new Players("Will Fuller", 78, 3));
		freeAgents.add(new Players("Duane Brown", 80, 3));
		freeAgents.add(new Players("Marcus Williams", 84, 3));
		freeAgents.add(new Players("Kyle Fuller", 78, 3));
		freeAgents.add(new Players("Mario Addison", 72, 3));
		freeAgents.add(new Players("Jamison Crowder", 81, 3));
		freeAgents.add(new Players("Anthony Barr", 83, 3));
		freeAgents.add(new Players("Zach Ertz", 76, 3));
		freeAgents.add(new Players("Eric Fisher", 76, 3));
		freeAgents.add(new Players("Melvin Gordon", 74, 3));
		freeAgents.add(new Players("JuJu Smith-Schuster", 81, 3));
	}
	
	public static void freeAgentDataBaseDisplay() {
		int counter= 1;
		for (Players p: freeAgents) {
			System.out.println(counter + ": " + p.name + ": " + p.playerRating);
			counter++;
		}
	}
	
	public static void freeAgentsForOtherTeams(ArrayList<Team> teams, int teamNumber) {
		int randomPlayerNumber= (int)(Math.random()*freeAgents.size());
		int counter=1;
		for (Team t: teams) {
			if (counter!=teamNumber) {
			t.topPlayers.add(freeAgents.get(randomPlayerNumber));
			freeAgents.remove(randomPlayerNumber);
			randomPlayerNumber= (int)(Math.random()*freeAgents.size());
			counter++; } 
			else {
				counter++;
			}
		}
	}
}

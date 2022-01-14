import java.util.ArrayList;

public class DraftDatabase {
	public static ArrayList<Players> draftPlayers;
	
	public DraftDatabase() {
		draftPlayers= new ArrayList<Players>();
		draftPlayers.add(new Players("Aidan Hutchinson", 74, 5));
		draftPlayers.add(new Players("Kayvon Thibodeaux", 76, 5));
		draftPlayers.add(new Players("John Metchie III", 81, 5));
		draftPlayers.add(new Players("Dontay Demus", 83, 5));
		draftPlayers.add(new Players("Sam Howell", 68, 5));
		draftPlayers.add(new Players("Sauce Gardner", 73, 5));
		draftPlayers.add(new Players("Kenny Pickett", 71, 5));
		draftPlayers.add(new Players("Matt Corrall", 64, 5));
		draftPlayers.add(new Players("Jameson Williams", 81, 5));
		draftPlayers.add(new Players("Jordan Davis", 77, 5));
		draftPlayers.add(new Players("Kyle Hamilton", 86, 5));
		draftPlayers.add(new Players("Derek Stingley Jr.",81, 5));
		draftPlayers.add(new Players("Evan Neal",69, 5));
		draftPlayers.add(new Players("George Karlaftis",68, 5));
		draftPlayers.add(new Players("Garret Wilson",74, 5));
		draftPlayers.add(new Players("Chris Olave",78, 5));
		draftPlayers.add(new Players("Nakobe Dean",79, 5));
		draftPlayers.add(new Players("Trent McDuffie",65, 5));
		draftPlayers.add(new Players("Kaiir Elam",73, 5));
		draftPlayers.add(new Players("Drake London",75, 5));
	}
	
	public static void draftDataBaseDisplay() {
		int counter= 1;
		for (Players p: draftPlayers) {
			System.out.println(counter + ": " + p.name);
			counter++;
		}
	}
	
	public static void draftForOtherTeams(ArrayList<Team> teams, int teamNumber) {
		int randomPlayerNumber= (int)(Math.random()*draftPlayers.size());
		int counter=1;
		for (Team t: teams) {
			if (counter!=teamNumber) {
			t.topPlayers.add(draftPlayers.get(randomPlayerNumber));
			draftPlayers.remove(randomPlayerNumber);
			randomPlayerNumber= (int)(Math.random()*draftPlayers.size());
			counter++; } 
			else {
				counter++;
			}
		}
	}
}

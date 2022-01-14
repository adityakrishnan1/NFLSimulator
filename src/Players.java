import java.util.ArrayList;

public class Players {
	public String name;
	public int playerRating;
	public static ArrayList <Players> bestPlayers;
	public int yearsLeftOnContract;
	
	public Players(String playerName, int playerRating, int contractLength) {
		name= playerName;
		this.playerRating= playerRating;
		yearsLeftOnContract= contractLength;
	}
	
	public static ArrayList<Players> startPackers() {
		bestPlayers= new ArrayList<Players> ();
		bestPlayers.add(new Players("Aaron Rodgers", 98, 2));
		bestPlayers.add(new Players("Davante Adams", 97, 3));
		bestPlayers.add(new Players("Jaire Alexander", 94, 4));
		return bestPlayers;
	}
	
	public static ArrayList<Players> startCowboys() {
		bestPlayers= new ArrayList<Players> ();
		bestPlayers.add(new Players("Dak Prescott", 95, 3));
		bestPlayers.add(new Players("Ceedee Lamb", 91, 4));
		bestPlayers.add(new Players("Micah Parsons", 90, 5));
		return bestPlayers;
	}
	
	public static ArrayList<Players> startRavens() {
		bestPlayers= new ArrayList<Players> ();
		bestPlayers.add(new Players("Lamar Jackson", 95, 5));
		bestPlayers.add(new Players("Marlon Humphrey", 93, 4));
		bestPlayers.add(new Players("Orlando Brown", 91, 3));
		return bestPlayers;
	}
	
	public static ArrayList<Players> startPatriots() {
		bestPlayers= new ArrayList<Players> ();
		bestPlayers.add(new Players("J.C Jackson", 93, 2));
		bestPlayers.add(new Players("Mac Jones", 86, 5));
		bestPlayers.add(new Players("Dont'a Hightower", 84, 4));
		return bestPlayers;
	}
	
	public static ArrayList<Players> startRams() {
		bestPlayers= new ArrayList<Players> ();
		bestPlayers.add(new Players("Aaron Donald", 99, 2));
		bestPlayers.add(new Players("Jalen Ramsey", 98, 3));
		bestPlayers.add(new Players("Cooper Kupp", 96, 4));
		return bestPlayers;
	}
	
	public static ArrayList<Players> startBengals() {
		bestPlayers= new ArrayList<Players> ();
		bestPlayers.add(new Players("Joe Burrow", 92, 5));
		bestPlayers.add(new Players("Joe Mixon", 91, 4));
		bestPlayers.add(new Players("Ja'Marr Chase", 88, 5));
		return bestPlayers;
	}
	
	public static ArrayList<Players> startSaints() {
		bestPlayers= new ArrayList<Players> ();
		bestPlayers.add(new Players("Alvin Kamara", 94, 3));
		bestPlayers.add(new Players("Cameron Jordan", 91, 2));
		bestPlayers.add(new Players("Marshon Lattimore", 90, 4));
		return bestPlayers;
	}
	
	public static ArrayList<Players> startChiefs() {
		bestPlayers= new ArrayList<Players> ();
		bestPlayers.add(new Players("Patrick Mahomes", 99, 3));
		bestPlayers.add(new Players("Tyreek Hill", 95, 4));
		bestPlayers.add(new Players("Travis Kelce", 93, 3));
		return bestPlayers;
	}
	
	public static void toString(ArrayList <Players> topPlayers) {
		for (Players p: topPlayers) {
			System.out.println(p.name + ": " + p.playerRating + "- " + p.yearsLeftOnContract + " years left");
		}
	}
}

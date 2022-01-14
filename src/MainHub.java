import java.util.ArrayList;
import java.util.Scanner;

public class MainHub {

	public static void main(String[] args) {
		int continueSeason=1;
		Scanner scan= new Scanner(System.in);
		
		System.out.println("Welcome to the NFL. What's your name?");
		String userName= scan.nextLine();
		
		System.out.println( "It's nice to meet you, " + userName);
		ArrayList <Team> listOfTeams= Team.startLeauge();
		Team.printOrigTeamList(listOfTeams);
		
		System.out.println("Which team would you like to manage?");
		int teamNumber= scan.nextInt();
		
		switch(teamNumber) {
		case 1:
			System.out.println("Congrats on being the Packers new GM");
			System.out.println();
			System.out.println("Here are your top players: ");
			Players.toString(listOfTeams.get(0).topPlayers);
			break;
		case 2:
			System.out.println("Congrats on being the Cowboys new GM");
			System.out.println();
			System.out.println("Here are your top players: ");
			Players.toString(listOfTeams.get(1).topPlayers);
			break;
		case 3:
			System.out.println("Congrats on being the Ravens new GM");
			System.out.println();
			System.out.println("Here are your top players: ");
			Players.toString(listOfTeams.get(2).topPlayers);
			break;
		case 4:
			System.out.println("Congrats on being the Patriots new GM");
			System.out.println();
			System.out.println("Here are your top players: ");
			Players.toString(listOfTeams.get(3).topPlayers);
			break;
		case 5:
			System.out.println("Congrats on being the Rams new GM");
			System.out.println();
			System.out.println("Here are your top players: ");
			Players.toString(listOfTeams.get(4).topPlayers);
			break;
		case 6:
			System.out.println("Congrats on being the Bengals new GM");
			System.out.println();
			System.out.println("Here are your top players: ");
			Players.toString(listOfTeams.get(5).topPlayers);
			break;
		case 7:
			System.out.println("Congrats on being the Saints new GM");
			System.out.println();
			System.out.println("Here are your top players: ");
			Players.toString(listOfTeams.get(6).topPlayers);
			break;
		case 8: 
			System.out.println("Congrats on being the Chiefs new GM");
			System.out.println();
			System.out.println("Here are your top players: ");
			Players.toString(listOfTeams.get(7).topPlayers);
			break;
		default: 
			System.out.println("That's not a team!");
		}
		
		DraftDatabase d= new DraftDatabase();
		FreeAgentDatabase f= new FreeAgentDatabase();
		int numOfSeasons= 1;
		
		while (continueSeason==1) {
			if (numOfSeasons>1) {
				System.out.println("Welcome to offseason Year " + numOfSeasons);
				Team.removeYearOffContract(listOfTeams);
				Team.addPlayersToFreeAgency(listOfTeams);
				System.out.println("To remind you, this is what your team looks "
						+ "like before the offseason");
				Players.toString(listOfTeams.get(teamNumber-1).topPlayers);
			}
		System.out.println();
		System.out.println("We're coming towards the offseason here. Would you"
				+ " like to sign any free agents or move on to the draft?");
		System.out.println("1: Free Agents");
		System.out.println("2: Draft");
		int offSeasonAnswer= scan.nextInt();
		
		
		
		if (offSeasonAnswer==1) {
			System.out.println("Here is a list of current free agents:");
			FreeAgentDatabase.freeAgentDataBaseDisplay();
			System.out.println();
			//System.out.println("Would you like to sign any of these players?");
			//System.out.println("1: Yes");
			//System.out.println("2: No");
			//int freeAgentAnswer= scan.nextInt();
			//if (freeAgentAnswer==1) {
				System.out.println("Which player would you like to sign?");
				int numOfFreeAgent= scan.nextInt();
				listOfTeams.get(teamNumber-1).topPlayers.add(FreeAgentDatabase.freeAgents.get(numOfFreeAgent-1));
				System.out.println("Congrats! You have signed this player");
				FreeAgentDatabase.freeAgents.remove(numOfFreeAgent-1);
				System.out.println();
			//}
		}
		
		try {
			FreeAgentDatabase.freeAgentsForOtherTeams(listOfTeams,teamNumber);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No more players avaliable for free agency!");
			System.out.println("Season has been shut down!");
			System.exit(1);
		} 
		
		System.out.println("To remind you, this is what your team looks like before you "
				+ "enter the draft:");
		Players.toString(listOfTeams.get(teamNumber-1).topPlayers);
		
		
		System.out.println();
		System.out.println("Entering the draft.....");
		System.out.println("Here is what the draft board looks like:");
		DraftDatabase.draftDataBaseDisplay();
		System.out.println();
		System.out.println("Who would you like to draft? ");
		int draftPlayerNum= scan.nextInt();
		listOfTeams.get(teamNumber-1).topPlayers.add(DraftDatabase.draftPlayers.get(draftPlayerNum-1));
		if (DraftDatabase.draftPlayers.get(draftPlayerNum-1).playerRating>80) {
			System.out.println("Wow! You drafted a future star!");
		} else if(DraftDatabase.draftPlayers.get(draftPlayerNum-1).playerRating>70) {
			System.out.println("You drafted a good talent, but there were better prospects");
		} else {
			System.out.println("Dang. Missed out on some good talent. Hopefully this kid can develop");
		}
		DraftDatabase.draftPlayers.remove(draftPlayerNum-1);
		
		try {
			DraftDatabase.draftForOtherTeams(listOfTeams,teamNumber);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No more players avaliable for draft!");
			System.out.println("Season has been shut down!");
			System.exit(1);
		} 
		
		System.out.println("To remind you, this is what your team looks like before you "
				+ "enter the new season:");
		Players.toString(listOfTeams.get(teamNumber-1).topPlayers);
		Team.printOrigTeamList(listOfTeams);
		
		ArrayList <Integer> averageRatingOfTeams= new ArrayList<Integer>();
		
		for(Team t: listOfTeams) {
			averageRatingOfTeams.add(t.averageTeamRating());
		}
		
		System.out.println("Simulating to the end of the season....");
		System.out.println();
		System.out.println("The final ratings of every team: ");
		int counter= 0;
		for (Team t: listOfTeams) {
			System.out.println(t.getName() + ": " + averageRatingOfTeams.get(counter));
			counter++;
		}
		System.out.println("**************" + "Super Bowl Champions" + "**************");
		System.out.println("**************" + Team.superbowlChampion(averageRatingOfTeams) +
				"**************");
		
		System.out.println("Would you like to continue as GM? 1: Yes   2: No");
		
		continueSeason= scan.nextInt();
		numOfSeasons++;
		if (continueSeason==2) {
			System.out.println("Thank you for your time as GM. You won't be forgotten!");
			System.exit(1);
		} 
	}

	}
}

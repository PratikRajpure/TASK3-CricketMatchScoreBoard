import java.util.Random;
import java.util.Scanner;

public class MatchScoreBoard {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>Live match between CricketTeam1 & CricketTeam2<<<<<<<<<<<<<<<<");
		System.out.println(">>>>>>>>>>>>Toss win by CricketTeam1 and choose batting<<<<<<<<<<<<<<");
		Scanner Obj = new Scanner(System.in);
		System.out.println("#Enter overs of the tournament is=>");
		int Over = Obj.nextInt();
	   	System.out.println(" is: " + Over);	
		System.out.println(">>>>>>>>>>Match started<<<<<<<<<<<<<<");
		MatchScoreBoard sb = new MatchScoreBoard();
		sb.firstInning(Over, 1);

	}
		
	public void firstInning(int overs, int inning) {
		System.out.println("#Enter the number Of players in each team in the tournament are =>");
		Scanner Obj1 = new Scanner(System.in);
		int numOfPlayer = Obj1.nextInt();
		System.out.println(" is: " + numOfPlayer);	

		int totalBalls = 0;
		int totalRuns = 0;
		int wideBall = 0;
		int noBall = 0;
		int wicket = 0;
		int totalOver = 0;
		double runRate = 0;

		totalBalls = (overs * 6);
		int[] instances = { 0, 1, 2, 3, 4, 6, 5, 7, 8 };

		for (int i = 1; i <= totalBalls; i++) {
			int randomInstances = new Random().nextInt(instances.length);

			if (wicket > (numOfPlayer-2)){
				break;
			}

			if (randomInstances == 0) {
				totalRuns = totalRuns + 0;
			} else if (randomInstances == 1) {
				totalRuns = totalRuns + 1;
			} else if (randomInstances == 2) {
				totalRuns = totalRuns + 2;
			} else if (randomInstances == 3) {
				totalRuns = totalRuns + 3;
			} else if (randomInstances == 4) {
				totalRuns = totalRuns + 4;
			} else if (randomInstances == 5) {
				totalBalls++;
				totalRuns++;
				wideBall++;
			} else if (randomInstances == 6) {
				totalRuns = totalRuns + 6;
			} else if (randomInstances == 7) {
				totalBalls += 1;
				totalRuns++;
				noBall++;
			} else if (randomInstances == 8) {
				wicket++;
			}

			if ((totalBalls % 6) == 0) {
				totalOver++;
			}
		}


		double totalRuns1 = totalRuns;
		double overs1 = overs;
		runRate = (totalRuns1 / overs1);
		System.out.println(">>>>>>>>>>>First Inning End <<<<<<<<<<<");

		CricketTeam1 a = new CricketTeam1(totalRuns, wicket, runRate, wideBall, noBall, totalOver);
		System.out.println("#Target : " + (totalRuns + 1));
		System.out.println("#Wickets : " + wicket ); 
		System.out.println("#Run Rate : " + runRate);

		secondInning(a, overs);

	}

	public void secondInning(CricketTeam1 a1, int overs) {

		int totalBallsToPlay;
		int totalRuns = 0 ;
		int wideBall=0;
		int noBall=0;
		int wicket = 0;
		int totalOver=0;
		double runRate=0;

		int totalOfA = a1.getTotalRuns();

		totalBallsToPlay = (overs * 6);

		int[] instances = { 0, 1, 2, 3, 4, 6, 5, 7, 8 };

		for (int i = 1; i <= totalBallsToPlay; i++) {
			int randomInstances = new Random().nextInt(instances.length);

			if ((wicket > 9) || (totalRuns > totalOfA)) {
				// System.out.println("*** All out at ***");
				break;
			}

			if (randomInstances == 0) {
				totalRuns = totalRuns + 0;
			} else if (randomInstances == 1) {
				totalRuns = totalRuns + 1;
			} else if (randomInstances == 2) {
				totalRuns = totalRuns + 2;
			} else if (randomInstances == 3) {
				totalRuns = totalRuns + 3;
			} else if (randomInstances == 4) {
				totalRuns = totalRuns + 4;
			} else if (randomInstances == 5) {
				totalBallsToPlay++;
				totalRuns++;
				wideBall++;
			} else if (randomInstances == 6) {
				totalRuns = totalRuns + 6;
			} else if (randomInstances == 7) {
				totalBallsToPlay += 1;
				totalRuns++;
				noBall++;
			} else if (randomInstances == 8) {
				wicket++;
			}

			if ((totalBallsToPlay % 6) == 0) {
				totalOver++;
			}
		}


		double totalRuns1 = totalRuns;
		double overs1 = overs;
		runRate = (totalRuns1 / overs1);

		CricketTeam2 b = new CricketTeam2(totalRuns, wicket, runRate, wideBall, noBall, totalOver);
		System.out.println(">>>>>>>>>>> Second Inning End<<<<<<<<<<<");
		System.out.println("#To Win : " + (totalRuns + 1));
		System.out.println("#Wickets : " + wicket);
		System.out.println("#Run Rate : " + runRate);

		new MatchScoreBoard().finalResult(a1, b);
	}

	public void finalResult(CricketTeam1 t1, CricketTeam2 tb) {

		int TR = t1.getTotalRuns(), TR2 = tb.getTotalRuns();
		int TW = t1.getWicket(), TW2 = tb.getWicket();
		double RR = t1.getRunRate(), RR2 = tb.getRunRate();
		int WB = t1.getWideBall(), WB2 = tb.getWideBall();
		int NB = t1.getNoBall(), NB2 = tb.getNoBall();

		if (t1.getTotalRuns() > tb.getTotalRuns()) {
			System.out.println("Team A WIN by " + (TR - TR2) + " Runs");
		} else if (t1.getTotalRuns() < tb.getTotalRuns()) {
			System.out.println("Team B WIN by " + (TR2 - TR) + " Runs");
		} else {
			System.out.println(" Match is *Draw*");
		}

		System.out.println(">>>>>>>>>>>>>>MATCH SCOREBOARD<<<<<<<<<<<<<");
		System.out.println("Total Runs            Team 1 = " + TR + "     "+"CricketTeam2 = " + TR2+ "   ");
		System.out.println("Total Wickets         Team 1 = " + TW + "      " + "CricketTeam2 = " + TW2 + "    ");
		System.out.println("Total RunRate         Team 1 = " + RR + "   " + "CricketTeam2 = " + RR2 + " ");
		System.out.println("Total Wide Balls      Team 1 = " + WB + "      " + "CricketTeam2 = " + WB2 + "    ");
		System.out.println("Total No Balls        Team 1 = " + NB + "      " + "CricketTeam2 = " + NB2 + "    ");

	}

}
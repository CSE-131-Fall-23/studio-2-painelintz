package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter amount of money to gamble in dollars: ");
		int startAmount = in.nextInt();
		System.out.print("Enter percentage chance of a win: ");
		double winChance = in.nextDouble();
		System.out.print("Enter amount of money in dollars it will take you to leave: ");
		int winLimit = in.nextInt();
		System.out.print("Enter the number of days you want to play: ");
		int totalSimulations = in.nextInt();		
		
		int numberOfLosses=0;
		double expectedRuin=0;
		
		for (int i = 0; i < totalSimulations; i++){
			int money = startAmount;
			int numberOfPlays = 0;
			while (0<money && money<winLimit) {
				double game = Math.random();
						if(game<(winChance/100.0)) {
							money++;
						} else {
							money--;
						}
						numberOfPlays++;
						//System.out.println(money);
			}
			System.out.print("Simulation " + (i+1) + ": " + numberOfPlays);
			if(money==0) {
				System.out.println(" LOSE");
				numberOfLosses++;
			} else {
				System.out.println(" WIN");
			}
		}
		
		if (winChance==0.5) {
			expectedRuin=1-((double)startAmount/(double)winLimit);
		} else {
			double alpha=(1-(winChance/100))/(winChance/100);
			expectedRuin=(Math.pow(alpha,(double)startAmount)-Math.pow(alpha,(double)winLimit))/(1-Math.pow(alpha,(double)winLimit));
		}
		
		double ruinRate=(double)numberOfLosses/(double)totalSimulations;
		double roundruinRate=Math.round(ruinRate*100) / 100d;
		System.out.println("Losses: "+numberOfLosses+" Simulation: "+totalSimulations);
		System.out.print("Ruin Rate from Simulation: "+ roundruinRate);
		System.out.print(" Expected Ruin Rate: "+expectedRuin);
	}

}

import java.util.Scanner;
public class BattleshipsProject {
	//This game is supposed to be played by two players
	public static void main(String[] args) {
		System.out.println("Battleships 4th Semester Project");
		System.out.println(" ");
		//How to play:
		//Entering Coordinates with two numbers out of the 5x5 array e.g 2 1
	
		
		//arrays
		char[][] play1 = new char[5][5];
		char[][] play2 = new char[5][5];
		
		char[][] play1play2 = new char[5][5];
		char[][] play2play1 = new char[5][5];
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				play1[i][j] = '-';
				play2[i][j] = '-';
				play1play2[i][j]='-';
				play2play1[i][j]='-';
			}
		}
		
		//Players ships
		System.out.println("Player 1, Please Enter The Ships Coordinates.");
		play1 = enterShips(play1);
		printBattleShip(play1);
		print2Lines();
		System.out.println("^ Player 1's Board");
		print50Lines();
		
		System.out.println("Scroll up to check Player 1's board");
		System.out.println(" ");
		System.out.println("Player 2, Please Enter The Ships Coordinates.");
		play2 = enterShips(play2);
		printBattleShip(play2);
		print2Lines();
		System.out.println("^ Player 2's Board");
		print50Lines();
		System.out.println("Scroll up to check Player 2's board");
		System.out.println(" ");
		
		int[] loca = new int[2];
		int play1hits = 0;
		int play2hits = 0;
		
		while(true) {
			loca = enterShip(1,play1play2);
			if(play2[loca[0]][loca[1]]=='&') {
				System.out.println("Player 1 has Destroyed Player 2's Ship!");
				play1play2[loca[0]][loca[1]] = 'X';
				play2[loca[0]][loca[1]] = 'X';
				play1hits++;
				if(play1hits==5) {
					System.out.println("Player 1 Wins, You Have Destoryed All Player 2's Ships! ");
					break;
				}
			}
			else {
				System.out.println("Missed!");
				play1play2[loca[0]][loca[1]] = 'O';
				play2[loca[0]][loca[1]] = 'O';
			}
			printBattleShip(play1play2);
			
			loca = enterShip(2,play2play1);
			if(play1[loca[0]][loca[1]]=='&') {
				System.out.println("Player 2 has Destroyed Player 1's Ship!");
				play2play1[loca[0]][loca[1]] = 'X';
				play1[loca[0]][loca[1]] = 'X';
				play2hits++;
				if(play2hits==5) {
					System.out.println("Player 2 Wins, You Have Destoryed All Player 1's Ships!");
					break;
				}
			}
			else {
				System.out.println("Missed!");
				play2play1[loca[0]][loca[1]] = 'O';
				play1[loca[0]][loca[1]] = 'O';
			}
			printBattleShip(play2play1);
		}
		System.out.println("Board Outcomes:");
		printBattleShip(play1);
		System.out.println("");
		printBattleShip(play2);
		
		System.out.println("Game Depleted");	
	
	}
	private static void print2Lines() {
		for (int i = 0; i<2; i++) System.out.println("-");
	
	}
	
	private static void print50Lines() {
		for (int i = 0; i<50; i++) System.out.println("-");
	}
	//Validation System for Coordinates
	private static char[][] enterShips(char[][] p){
		Scanner in  = new Scanner(System.in);
		for(int i = 0; i<5; i++) {
			while(true) {
				System.out.println("Enter ship "+(i+1)+" cooridnates:");
				int x = in.nextInt();
				int y = in.nextInt();
				if(x>=5 || x <0 || y>=5 || y<0) {
					System.out.println("Not Valid Coordinate. Please Choose different coordinates.");
					continue;
				}
				else if(p[x][y]=='&') {
					System.out.println("You already have a ship in that coordinate. Please Choose different coordinates.");
					continue;
				}
				else{
					p[x][y] = '&';
					break;
				}
			}
		}
		return p;
	}
	
	private static int[] enterShip(int a, char[][] play1play2){
		int[] loca = new int[2];
		Scanner in  = new Scanner(System.in);
		while(true) {
			System.out.println("Player "+(a)+", enter hit row/column:");
			loca[0] = in.nextInt();
			loca[1] = in.nextInt();
			if(loca[0]>=5 || loca[0] <0 || loca[1]>=5 || loca[1]<0) {
				System.out.println("Not Valid Coordinate. Please Choose different coordinates.");
				continue;
			}
			else if(play1play2[loca[0]][loca[1]]!='-') {
				System.out.println("This Coordinate has already been fired at. Please Choose different coordinates.");
				continue;
			}
			else break;
		}
		return loca;
	}

	// print Game boards to console
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}

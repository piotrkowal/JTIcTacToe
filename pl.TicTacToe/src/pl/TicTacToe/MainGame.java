package pl.TicTacToe;
import java.util.Scanner; 

public class MainGame {

	public static void main(String[] args) {
		String[][] gameBoard = new String[3][3];
		int counter = 1;
		for(int j=0;j<3;j++)
		for(int i=0;i<3;i++) {
			gameBoard[i][j] = String.valueOf(counter);
			counter++;
		}
		
		for(int j=0;j<3;j++) {
			for(int i=0;i<3;i++) {
				System.out.print(gameBoard[i][j]+" ");
			}
			System.out.println("");
		}
		
		boolean endGame = false;
        Scanner reader = new Scanner(System.in); 
        int currentPlayer = 0;
        
		while(!endGame) {
			
			System.out.println("Player's "+(currentPlayer+1)+" turn");
			int next = reader.nextInt();
			currentPlayer = currentPlayer==0?1:0;
		}
		
	}
}

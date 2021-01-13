package pl.TicTacToe;

public class MainGame {

	public static void main(String[] args) {
		String[][] gameBoard = new String[3][3];
		for(int j=0;j<3;j++)
		for(int i=0;i<3;i++) {
			gameBoard[i][j] = "-";
		}
		
		for(int j=0;j<3;j++) {
			for(int i=0;i<3;i++) {
				System.out.print(gameBoard[i][j]+" ");
			}
			System.out.println("");
		}
	}
}

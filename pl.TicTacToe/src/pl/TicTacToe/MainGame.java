package pl.TicTacToe;

public class MainGame {

	public static void main(String[] args) {
		TicTacToeBoard newGameBoard = new TicTacToeBoard();
		newGameBoard.setUpBoard();

		while (!newGameBoard.isEndgame()) {
			newGameBoard.printOutBoard();

			int playerChoice = newGameBoard.getPlayerChoice();

			newGameBoard.filterOutAvailableNums(playerChoice);
			newGameBoard.updateGameBoard(playerChoice);
			newGameBoard.checkIfGameEnded();
			newGameBoard.changePlayer();
		}

		newGameBoard.printOutBoard();
		newGameBoard.showTheWinner();
	}
}

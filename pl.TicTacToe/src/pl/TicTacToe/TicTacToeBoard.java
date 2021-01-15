package pl.TicTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TicTacToeBoard {
	private int gameBoardSize = 3;
	private String[][] gameBoard;
	private Map<Integer, HashMap<String, Integer>> coordsOfNum;
	private List<Integer> availableNums;
	private boolean endGame;
	private int currentPlayer;
	private int whichPlayerWon;
	Map<Integer, String> playerSymbols;
	Scanner playerChoiceReader;

	public TicTacToeBoard() {
		this.currentPlayer = 0;
		this.whichPlayerWon = -1;
		this.endGame = false;
		this.gameBoard = new String[gameBoardSize][gameBoardSize];
		this.coordsOfNum = new HashMap<Integer, HashMap<String, Integer>>();
		this.availableNums = new ArrayList<Integer>();

		this.playerSymbols = new HashMap<Integer, String>();
		this.playerSymbols.put(0, "X");
		this.playerSymbols.put(1, "O");

		this.playerChoiceReader = new Scanner(System.in);
	}

	public void setUpBoard() {
		int counter = 1;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				this.gameBoard[i][j] = String.valueOf(counter);

				HashMap<String, Integer> mapToPutIntoCoords = new HashMap<String, Integer>();
				mapToPutIntoCoords.put("x", i);
				mapToPutIntoCoords.put("y", j);
				this.coordsOfNum.put(counter, mapToPutIntoCoords);

				availableNums.add(counter);
				counter++;
			}
		}
	}

	public void printOutBoard() {
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public int getPlayerChoice() {
		System.out.println("Player's " + (this.currentPlayer + 1) + " turn");

		int playerChoice = this.playerChoiceReader.nextInt();

		if (this.availableNums.indexOf(playerChoice) == -1) {
			do {
				System.out.println("Choose cell that was't already marked!");
				playerChoice = this.playerChoiceReader.nextInt();
			} while (this.availableNums.indexOf(playerChoice) == -1);
		}
		return playerChoice;
	}

	public void filterOutAvailableNums(int playerChoice) {
		this.availableNums = this.availableNums.stream().filter(num -> num != playerChoice)
				.collect(Collectors.toList());
	}

	public void updateGameBoard(int playerChoice) {
		var cellCoordsToUpdate = coordsOfNum.get(playerChoice);
		int xCoord = cellCoordsToUpdate.get("x");
		int yCoord = cellCoordsToUpdate.get("y");
		gameBoard[xCoord][yCoord] = playerSymbols.get(this.currentPlayer);
	}

	public void changePlayer() {
		this.currentPlayer = this.currentPlayer == 0 ? 1 : 0;
	}

	public boolean isEndgame() {
		return this.endGame;
	}

	public void checkIfGameEnded() {
		boolean hasMatch = false;

		for (int j = 0; j < gameBoardSize; j++) {
			hasMatch = hasMatch || (gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j]);
		}

		for (int i = 0; i < gameBoardSize; i++) {
			hasMatch = hasMatch || (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]);
		}

		hasMatch = hasMatch || (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]);
		hasMatch = hasMatch || (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]);

		if (hasMatch || availableNums.isEmpty()) {
			this.endGame = true;
		}

		if (hasMatch && !availableNums.isEmpty()) {
			this.whichPlayerWon = currentPlayer + 1;
		}

	}

	public void showTheWinner() {
		if (this.whichPlayerWon == -1) {
			System.out.println("All cells have been marked; No one wins!");
		} else {
			System.out.println("Player " + this.whichPlayerWon + " wins!");
		}

	}
}

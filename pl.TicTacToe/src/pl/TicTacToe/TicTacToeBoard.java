package pl.TicTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToeBoard {
	private int gameBoardSize = 3;
	private String[][] gameBoard;
	private Map<Integer, HashMap<String, Integer>> coordsOfNum;
	private List<Integer> availableNums;
	private boolean endGame;

	Map<Integer, String> playerSymbols;

	public TicTacToeBoard() {
		this.endGame = false;
		this.gameBoard = new String[gameBoardSize][gameBoardSize];
		this.coordsOfNum = new HashMap<Integer, HashMap<String, Integer>>();
		this.availableNums = new ArrayList<Integer>();

		this.playerSymbols = new HashMap<Integer, String>();
		this.playerSymbols.put(0, "X");
		this.playerSymbols.put(1, "O");
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
	
}

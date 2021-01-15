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


}

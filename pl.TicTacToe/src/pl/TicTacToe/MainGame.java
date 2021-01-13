package pl.TicTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainGame {

	public static void main(String[] args) {
		String[][] gameBoard = new String[3][3];
		Map<Integer, HashMap<String, Integer>> coordsOfNum = new HashMap<Integer, HashMap<String, Integer>>();
		ArrayList<Integer> availableNums = new ArrayList<Integer>();
		int counter = 1;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				gameBoard[i][j] = String.valueOf(counter);
				HashMap<String, Integer> mapToPutIntoCoords = new HashMap<String, Integer>();
				mapToPutIntoCoords.put("x", i);
				mapToPutIntoCoords.put("y", j);
				coordsOfNum.put(counter, mapToPutIntoCoords);
				counter++;
			}
		}
		boolean endGame = false;
		Scanner reader = new Scanner(System.in);

		Map<Integer, String> playerSymbols = new HashMap<Integer, String>();
		playerSymbols.put(0, "X");
		playerSymbols.put(1, "O");
		int currentPlayer = 0;
		int playerChoice;
		while (!endGame) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					System.out.print(gameBoard[i][j] + " ");
				}
				System.out.println("");
			}

			System.out.println("Player's " + (currentPlayer + 1) + " turn");
			playerChoice = reader.nextInt();

			int xCoord = coordsOfNum.get(playerChoice).get("x");
			int yCoord = coordsOfNum.get(playerChoice).get("y");

			gameBoard[xCoord][yCoord] = playerSymbols.get(currentPlayer);
			currentPlayer = currentPlayer == 0 ? 1 : 0;
		}

	}
}

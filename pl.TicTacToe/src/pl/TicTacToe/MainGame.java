package pl.TicTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainGame {

	public static void main(String[] args) {
		int gameBoardSize = 3;
		String[][] gameBoard = new String[gameBoardSize][gameBoardSize];
		Map<Integer, HashMap<String, Integer>> coordsOfNum = new HashMap<Integer, HashMap<String, Integer>>();
		List<Integer> availableNums = new ArrayList<Integer>();
		int counter = 1;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				gameBoard[i][j] = String.valueOf(counter);

				HashMap<String, Integer> mapToPutIntoCoords = new HashMap<String, Integer>();
				mapToPutIntoCoords.put("x", i);
				mapToPutIntoCoords.put("y", j);
				coordsOfNum.put(counter, mapToPutIntoCoords);

				availableNums.add(counter);
				counter++;
			}
		}

		boolean endGame = false;
		Scanner reader = new Scanner(System.in);

		Map<Integer, String> playerSymbols = new HashMap<Integer, String>();
		playerSymbols.put(0, "X");
		playerSymbols.put(1, "O");
		int currentPlayer = 0;
		int playerWon = -1;
		while (!endGame) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					System.out.print(gameBoard[i][j] + " ");
				}
				System.out.println("");
			}
			if (availableNums.isEmpty())
				break;
			System.out.println("Player's " + (currentPlayer + 1) + " turn");
			int playerChoice = reader.nextInt();

			if (availableNums.indexOf(playerChoice) == -1) {
				do {
					System.out.println("Choose cell that was't already marked!");
					playerChoice = reader.nextInt();
				} while (availableNums.indexOf(playerChoice) == -1);
			}

			int numToFilterOut = playerChoice;
			availableNums = availableNums.stream().filter(num -> num != numToFilterOut).collect(Collectors.toList());

			int xCoord = coordsOfNum.get(playerChoice).get("x");
			int yCoord = coordsOfNum.get(playerChoice).get("y");
			gameBoard[xCoord][yCoord] = playerSymbols.get(currentPlayer);
			
			boolean hasMatch = false;
			
				for(int j=0;j<gameBoardSize;j++) {
					hasMatch = hasMatch || (gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j]); 
				}
			
				for(int i=0;i<gameBoardSize;i++) {
					hasMatch = hasMatch || (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]); 
				}
				
				hasMatch = hasMatch || (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1]==gameBoard[2][2]);
				hasMatch = hasMatch || (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1]==gameBoard[2][0]);
			
			if(hasMatch) {
				playerWon = currentPlayer+1;
				endGame = true;
			}
			currentPlayer = currentPlayer == 0 ? 1 : 0;
		}

		if (playerWon == -1) {
			System.out.println("All cells have been marked; No one wins!");
		} else {
			System.out.println("Player " + playerWon + " wins!");
		}

		reader.close();
	}
}

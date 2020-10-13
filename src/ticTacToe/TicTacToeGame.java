package ticTacToe;

import java.util.*;
import java.lang.*;

public class TicTacToeGame {

	private static char[] board;

	public static void main(String[] args) {
		// char[] board;
		board = createBoard();

	}

	private static char[] createBoard() {
		char[] board1 = new char[10];
		for (int i = 0; i < board1.length; i++) {
			board1[i] = ' ';
		}
		System.out.println("Array Created");
		return board1;
	}

}
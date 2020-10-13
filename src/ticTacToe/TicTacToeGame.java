package ticTacToe;

import java.util.*;
import java.lang.*;

public class TicTacToeGame {
	private static char[] board;
	private static char userMark = ' ';
	private static char computerMark = ' ';

	public static void main(String[] args) {
		board = createBoard();
		char userMark = userChoice();
		char computerMark = (userMark == 'X') ? 'O' : 'X';
		System.out.println("Board :");
		showBoard();
	}

	private static char[] createBoard() //// CREATE Array
	{
		char[] board1 = new char[10];
		for (int i = 0; i < board1.length; i++) {
			board1[i] = ' ';
		}
		System.out.println("Array Created");
		return board1;
	}

	private static char userChoice() {
		System.out.println("Input Either 'X' OR 'O' : ");
		Scanner sc1 = new Scanner(System.in);
		char c = sc1.next().toUpperCase().charAt(0);
		return c;
	}

	private static void showBoard() {
		for (int j = 1; j < board.length; j++) {
			System.out.print("[" + board[j] + "]");
			if (j % 3 == 0) {
				System.out.println(" ");
				System.out.println("---------");
			}
		}
	}
}
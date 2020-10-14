package ticTacToe;

import java.util.*;
import java.lang.*;

public class TicTacToeGame {
	private static char[] board;
	private static char userMark = ' ';
	private static char computerMark = ' ';
	private static int Index;
	static Scanner sc = new Scanner(System.in);

	// Main Method
	public static void main(String[] args) {
		board = createBoard();
		char userMark = userChoice();
		char computerMark = (userMark == 'X') ? 'O' : 'X';
		System.out.println("Board :");
		showBoard();
		System.out.println("Enter any Index from 1 to 9 where you want to place the move :");
		selectIndex();
	}

	// Space Validity
	private static boolean checkSpace(char[] board, int Index1) {
		if (board[Index1] == ' ')
			return true;
		else
			return false;
	}

	// Creating Board
	private static char[] createBoard() {
		char[] board1 = new char[10];
		for (int i = 0; i < board1.length; i++) {
			board1[i] = ' ';
		}
		System.out.println("Array Created");
		return board1;
	}

	// Taking User Input
	private static char userChoice() {
		System.out.println("Input Either 'X' OR 'O' : ");
		// Scanner sc1 = new Scanner(System.in);
		char c = sc.next().toUpperCase().charAt(0);
		return c;
	}

	// Displaying Tic Tac Toe Board
	private static void showBoard() {
		for (int j = 1; j < board.length; j++) {
			System.out.print("[" + board[j] + "]");
			if (j % 3 == 0) {
				System.out.println(" ");
				System.out.println("---------");
			}
		}
	}

	// Index Selection For Performing any move.
	public static void selectIndex() {
		while (true) {
			Index = sc.nextInt();
			if (Index <= 9 && Index >= 1) {
				if (checkSpace(board, Index)) {
					System.out.println("This is a valid move");
					board[Index] = userMark;
					break;
				} else {
					System.out.println("Already occupied! Please select another index");
				}
			} else {
				System.out.println("Invalid Choice !!!! , Kindly select Index from 1 to 9 only !");

			}
		}
	}
}
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
		System.out.println("Welcome To Tic Tac Gaming Arena !!");
		createBoard();
		System.out.println("Want to Play Game (Y/N) ?");
		char input = sc.next().toUpperCase().charAt(0);
		if (input == 'Y') {
			System.out.println("Let's Toss !!");
			int res = toss();
			showBoard();
			System.out.println("Enter any Index from 1 to 9 where you want to place the move :");
			selectIndex();
			showBoard(); // Displaying Board After Our Move
		}
	}

	// Space Validity
	private static boolean checkSpace(char[] board, int Index1) {
		if (board[Index1] == ' ')
			return true;
		else
			return false;
	}

	// Creating Board - UC1
	private static void createBoard() {
		board = new char[10];
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
	}

	// Taking User Input - UC2 //Method Name Refactored from userChoice to Choice :
	private static char Choice() {
		System.out.println("Input Either 'X' OR 'O' : ");
		// Scanner sc1 = new Scanner(System.in);
		char c = sc.next().toUpperCase().charAt(0);
		return c;
	}

	// Displaying Tic Tac Toe Board - UC3
	private static void showBoard() {
		for (int j = 1; j < board.length; j++) {
			System.out.print("[" + board[j] + "]");
			if (j % 3 == 0) {
				System.out.println(" ");
				System.out.println("---------");
			}
		}
	}

	// Index Selection For Performing any move. - UC4 & UC5
	public static void selectIndex() {
		while (true) {
			Index = sc.nextInt();
			if (Index <= 9 && Index >= 1) {
				if (checkSpace(board, Index)) {
					System.out.println("This is a valid move");
					board[Index] = userMark; // Making Our Move
					break;
				} else {
					System.out.println("Already occupied! Please select another index");
				}
			} else {
				System.out.println("Invalid Choice !!!! , Kindly select Index from 1 to 9 only !");

			}
		}
	}

	// Tossing to decide who will play first : UC6
	private static int toss() {

		int max = 3;
		int min = 1;
		int range = max - min;
		int rand = (int) (Math.random() * range);
		if (rand == 0) {
			System.out.println("Computer Will Start The Game");
			computerMark = Choice();
			userMark = (computerMark == 'X') ? 'O' : 'X';

		} else if (rand == 1) {
			System.out.println("User Will Start The Game");
			userMark = Choice();
			computerMark = (userMark == 'X') ? 'O' : 'X';
		}
		return rand;

	}

}
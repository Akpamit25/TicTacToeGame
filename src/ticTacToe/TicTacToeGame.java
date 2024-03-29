package ticTacToe;

import java.util.*;
import java.lang.*;

public class TicTacToeGame {
	private static char[] board;
	private static char userMark = ' ';
	private static char computerMark = ' ';
	private static int Index;
	static boolean playerTurn, computerTurn;
	static Scanner sc = new Scanner(System.in);

	// Main Method
	public static void main(String[] args) {
		System.out.println("Welcome To Tic Tac Gaming Arena !!");
		createBoard();
		showBoard();
		System.out.println("Want to Play Game (Y/N) ?");
		char input = sc.next().toUpperCase().charAt(0);
		if (input == 'Y') {
			System.out.println("Let's Toss !!");
			int res = toss();
			// showBoard();
			while (true) {
				selectIndex();
				showBoard(); // Displaying Board After Move
				boolean isWin = IsWin();
				if (isWin == true)
					break;
				boolean isTie = IsFull();
				if (isTie) {
					if (!isWin) {
						System.out.println("Tie!!");
						break;
					}

				}
				// break;
			}
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
			if (playerTurn) {
				System.out.println("Enter any Index from 1 to 9 where you want to place the move :");

				Index = sc.nextInt();
				if (Index <= 9 && Index >= 1) {
					if (checkSpace(board, Index)) {
						System.out.println("This is a valid move");
						if (playerTurn) {
							board[Index] = userMark; // User Making The Move
							playerTurn = false;
							computerTurn = true;
							break;
						}

						// break;
					} else {
						System.out.println("Already occupied! Please select another index");
					}
				} else {
					System.out.println("Invalid Choice !!!! , Kindly select Index from 1 to 9 only !");

				}
			} else {
				int win = canIWin();
				if (win > 0) {
					board[win] = computerMark;
					break;
				} else {
					int block = canIBlock();
					if (block > 0) {
						board[block] = computerMark;
						playerTurn = true;
						computerTurn = false;
						break;
					} else {
						int corner = selectCorner();
						board[corner] = computerMark;
						playerTurn = true;
						computerTurn = false;
						break;
					}
				}
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
			computerTurn = true;
			playerTurn = false;
			computerMark = Choice();
			userMark = (computerMark == 'X') ? 'O' : 'X';

		} else if (rand == 1) {
			computerTurn = false;
			playerTurn = true;
			System.out.println("User Will Start The Game");
			userMark = Choice();
			computerMark = (userMark == 'X') ? 'O' : 'X';
		}
		return rand;

	}

	// UC-7 : As player would expect the Tic Tac Toe App to determine after every
	// move the winner or the tie or change the turn

	public static boolean IsFull() {
		boolean flag = true;
		int count = 0;
		for (int i = 1; i < 10; i++) {
			if (board[i] != ' ') {
				count++;
			}
		}
		if (count == 9) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public static boolean IsWin() {
		if (playerTurn) {
			if ((userMark == board[1] && userMark == board[2] && userMark == board[3])
					|| (userMark == board[4] && userMark == board[5] && userMark == board[6])
					|| (userMark == board[7] && userMark == board[8] && userMark == board[9])
					|| (userMark == board[1] && userMark == board[4] && userMark == board[7])
					|| (userMark == board[2] && userMark == board[5] && userMark == board[8])
					|| (userMark == board[3] && userMark == board[6] && userMark == board[9])
					|| (userMark == board[1] && userMark == board[5] && userMark == board[9])
					|| (userMark == board[3] && userMark == board[5] && userMark == board[7])) {
				System.out.println("Player wins");
				return true;
			}
		} else {
			if ((computerMark == board[1] && computerMark == board[2] && computerMark == board[3])
					|| (computerMark == board[4] && computerMark == board[5] && computerMark == board[6])
					|| (computerMark == board[7] && computerMark == board[8] && computerMark == board[9])
					|| (computerMark == board[1] && computerMark == board[4] && computerMark == board[7])
					|| (computerMark == board[2] && computerMark == board[5] && computerMark == board[8])
					|| (computerMark == board[3] && computerMark == board[6] && computerMark == board[9])
					|| (computerMark == board[1] && computerMark == board[5] && computerMark == board[9])
					|| (computerMark == board[3] && computerMark == board[5] && computerMark == board[7])) {
				System.out.println("Computer wins");
				return true;
			}
		}
		return false;
	}

	// UC8 : Making computer intelligent
	public static int canIWin() {
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				board[i] = computerMark;
				if (IsWin()) {
					return i;
				} else {
					board[i] = ' ';
				}
			}
		}
		return 0;
	}

//UC9 : Computer Move To Block User Move
	public static int canIBlock() {
		playerTurn = true;
		computerTurn = false;
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				board[i] = userMark;
				if (IsWin()) {
					board[i] = ' ';
					playerTurn = false;
					computerTurn = true;
					return i;
				} else {
					board[i] = ' ';
				}
			}
		}
		playerTurn = false;
		computerTurn = true;
		return 0;
	}

	// UC10 : Corner Input
	public static int selectCorner() {
		int corner = 5;
		if (isCornerAvailable()) {
			while (true) {
				corner = (int) (Math.random() * 10) % 10;
				if ((corner != 5) && (checkSpace(board, corner))) {
					return corner;
				}
			}
		}
		return corner;
	}

	// UC11 : Checking whether Corner Is Free Or Not
	public static boolean isCornerAvailable() {
		for (int i = 1; i < 9; i++) {
			if (i == 5) {
				continue;
			} else if (board[i] == ' ') {
				return true;
			}
		}
		return false;
	}
}
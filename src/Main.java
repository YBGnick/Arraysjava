import java.util.Random;

public class Main {

	static boolean checkDiag(char[][] board) {
		String s = "";
		for (int i = 0; i < board.length; i++) {
			s += board[i][i];
		}

		if (s.equals("XXX") || s.equals("OOO")) {
			return true;
		}
		return false;
	}

	static boolean checkAntidiag(char[][] board) {
		String s = "";
		for (int i = 0; i < board.length; i++) {
			s += board[i][3 - 1 - i];
		}

		if (s.equals("XXX") || s.equals("OOO")) {
			return true;
		}
		return false;
	}

	static boolean checkRow(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			String s = "";
			for (int j = 0; j < board[0].length; j++) {
				s += board[i][j];
			}
			if (s.equals("XXX") || s.equals("OOO")) {
				return true;
			}
		}

		return false;
	}

	static boolean checkCol(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			String s = "";
			for (int j = 0; j < board[0].length; j++) {
				s += board[j][i];
			}
			if (s.equals("XXX") || s.equals("OOO")) {
				return true;
			}
		}

		return false;
	}

	public static void main(String args[]) {

		char[][] board = new char[3][3];
		Random rand = new Random();

		for (int i = 0; i < board.length * board[0].length; i++) {
			board[i / 3][i % 3] = rand.nextBoolean() ? 'X' : 'O';
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		if (checkDiag(board) ||
				checkAntidiag(board) ||
				checkRow(board) ||
				checkCol(board)) {
			System.out.println("You Win");
			return;
		}

		System.out.println("You Lose");

	}

}

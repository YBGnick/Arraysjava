import java.util.Random;

public class Main {

	static int checkDiag(char[][] board) {
		String s = "";
		for (int i = 0; i < board.length; i++) {
			s += board[i][i];
		}

		if (s.equals("XXX")) {
			return 2;
		}
		if (s.equals("OOO")) {
			return 1;
		}
		return 0;
	}

	static int checkAntidiag(char[][] board) {
		String s = "";
		for (int i = 0; i < board.length; i++) {
			s += board[i][3 - 1 - i];
		}

		if (s.equals("XXX")) {
			return 2;
		}
		if (s.equals("OOO")) {
			return 1;
		}
		return 0;
	}

	static int checkRow(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			String s = "";
			for (int j = 0; j < board[0].length; j++) {
				s += board[i][j];
			}
			if (s.equals("XXX")) {
				return 2;
			}
			if (s.equals("OOO")) {
				return 1;
			}
		}

		return 0;
	}

	static int checkCol(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			String s = "";
			for (int j = 0; j < board[0].length; j++) {
				s += board[j][i];
			}
			if (s.equals("XXX")) {
				return 2;
			}
			if (s.equals("OOO")) {
				return 1;
			}
		}
		return 0;

	}

	public static void main(String args[]) {

		char[][] board = new char[3][3];
		Random rand = new Random();

		int xamt = 0;
		int oamt = 0;
		boolean done = true;
		while (done) {
			xamt = 0;
			oamt = 0;
			for (int i = 0; i < board.length * board[0].length; i++) {
				char code = rand.nextBoolean() ? 'X' : 'O';
				xamt += (code == 'X') ? 1 : 0;
				oamt += (code == 'X') ? 0 : 1;
				board[i / 3][i % 3] = code;
			}

			if (xamt <= 5 && oamt <= 5) {
				done = false;
			}

		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		if (checkDiag(board) == 2 ||
				checkAntidiag(board) == 2 ||
				checkRow(board) == 2 ||
				checkCol(board) == 2) {
			System.out.println("X Wins");
			return;
		}
		if (checkDiag(board) == 1 ||
				checkAntidiag(board) == 1 ||
				checkRow(board) == 1 ||
				checkCol(board) == 1) {
			System.out.println("O Wins");
			return;

		}

		System.out.println("You Lose");

	}

}

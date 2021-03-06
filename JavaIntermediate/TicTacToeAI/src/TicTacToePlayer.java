import java.util.Random;




public class TicTacToePlayer {
	TicTacToeGame game;
	private final char opponent = 'X';

	public TicTacToePlayer (TicTacToeGame g) {
		game = g;
	}

	public TicTacToeMove getMove() {
		if (getGameSaver() != null) {
			System.out.println("Found game saver!");
			return getGameSaver();
		}
		return getFirstMoveFound();
	}

	public TicTacToeMove getGameSaver() {		
		int col1 = 0;
		int col2 = 0;
		int col3 = 0;
		int row1 = 0;
		int row2 = 0;
		int row3 = 0;
		int x = 0;
		if (game.getPieceAt(x, 0) == opponent) col1++;
		if (game.getPieceAt(x, 1) == opponent) col1++;
		if (game.getPieceAt(x, 2) == opponent) col1++;
		if (col1 == 2) {
			for (int y = 0; y < 3; y++) {
				if (game.canPlacePieceAt(x,y)) {
					return new TicTacToeMove(game, x, y);
				}
			}
		} return null;

	}

	public TicTacToeMove getFirstMoveFound() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (game.canPlacePieceAt(x, y)) {
					return new TicTacToeMove(game, 2 - x, 2 - y);
				}

			}
		}
		return null;

	}
	public TicTacToeMove getRandomMove() {
		Random r = new Random(); 
		int i = r.nextInt(3);
		int j = r.nextInt(3);
		boolean foundMove = false;

		while (foundMove == false) {
			if (game.canPlacePieceAt(i, j))
				return new TicTacToeMove(game, i, j);
			foundMove = true;
		}		

		return null;
	}

}

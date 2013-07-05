import java.util.ArrayList;


public class TicTacToeMove {
	TicTacToeGame game;
	ArrayList <TicTacToeMove> moves;
	int moveX;
	int moveY;	
	
	public TicTacToeMove(TicTacToeGame g, int x, int y) {
		game = g.copy();
		moveX = x;
		moveY = y;
		//game.placePieceAt(x, y);
	}
	
	public void addMove(TicTacToeMove move) {
		moves.add(move);
	}
}

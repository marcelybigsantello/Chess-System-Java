package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public abstract boolean[][] possibleMoves();
	
	//Hook Method - when you call an abstract method within a concrete one
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//Another hook method
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = this.possibleMoves();
		for (int l = 0; l < mat.length; l++) {
			for (int m = 0; m < mat.length; m++ ) {
				if (mat[l][m]) {
					return true;
				}
			}
		}
		return false;
	}
	
}

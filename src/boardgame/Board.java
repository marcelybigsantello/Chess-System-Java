package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: it must contain at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!this.positionExists(row, column)) {
			throw new BoardException("Position does not exist on the board!");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!this.positionExists(position)) {
			throw new BoardException("Position does not exist on the board!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("A piece already exists on this position " + position);
		}
		System.out.print("Piece: " + piece);
		System.out.print("\nIt is going to position: [" + position.getRow() + "][" + position.getColumn() + "]");
		this.pieces[position.getRow()][position.getColumn()] = piece;
		piece.setPosition(position);
		System.out.print("\nNew position: " + position);
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position does not exist on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.setPosition(null);
		pieces[position.getRow()][position.getColumn()] = null;
		
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return this.positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position does not exist on the board");
		}
		return piece(position) != null;
	}
}

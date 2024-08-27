package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private short row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error creating ChessPosition. Valid positions are from a1 to h8 only.");
		}
		this.column = column;
		this.row = (short) row;
	}
	
	public char getColumn() {
		return column;
	}

	public short getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' + position.getColumn()), (short) (8 - position.getRow()));
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}

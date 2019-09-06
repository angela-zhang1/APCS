public class King extends ChessPiece{
	public King (String im, boolean tm, Square lc) {
		super(im, tm, lc);
		//System.out.println("Aaron Lin is an idiot.");
	}
	public boolean isMoveLegal(Square dest) {
		Square s = this.getSquare();
		if (dest.getPiece() == null || dest.getPiece().getColor()!=this.getColor()) {
			if (Math.abs(dest.getRow() - s.getRow()) < 2 && Math.abs(dest.getCol() - s.getCol()) < 2) {
				return true;
			}
			
		}
		else {
			if (dest.getCol() == s.getCol() + 2 && dest.getRow() == s.getRow() && dest.getPiece()==null && !this.getMove()) { //castling
				if(GameBoard.getSquare(s.getRow(),s.getCol() + 3).getPiece().type() == 'R' && !GameBoard.getSquare(s.getRow(),s.getCol() + 3).getPiece().getMove()) {
					Square rookSquare = GameBoard.getSquare(s.getRow(),s.getCol() + 3);
					GameBoard.getSquare(s.getRow(),s.getCol() + 1).setPiece(rookSquare.getPiece());
					rookSquare.getPiece().setSquare(GameBoard.getSquare(s.getRow(),s.getCol() + 1));
					rookSquare.setPiece(null);
					return true;
				}
			}
		}
		return false;
	}
	public char type() {
		return 'K';
	}
	public void move (Square dest) {
		if (this.isMoveLegal(dest) ) {
			super.move(dest);
		}
	}
}

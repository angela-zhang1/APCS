public class King extends ChessPiece{
	private Square s = this.getSquare();
	public King (String im, boolean tm, Square lc) {
		super(im, tm, lc);
		//System.out.println("Aaron Lin is an idiot.");
	}
	public boolean isMoveLegal(Square dest) {

		if (dest.getPiece() == null || dest.getPiece().getColor()!=this.getColor()) {
			if (Math.abs(dest.getRow() - s.getRow()) < 2 && Math.abs(dest.getCol() - s.getCol()) < 2) {
				return true;
			}
			if (dest.getCol() == s.getCol() + 2 && dest.getRow() == s.getRow() && dest.getPiece()==null && !this.getMove()) { //castling
				if(GameBoard.getSquare(s.getRow(),s.getCol() + 3).getPiece().type() == 'R' && 
				!GameBoard.getSquare(s.getRow(),s.getCol() + 3).getPiece().getMove() &&
				GameBoard.getSquare(s.getRow(), s.getCol() + 1).getPiece()== null) {
					return true;
				}
			}
			if (dest.getCol() == s.getCol()-2 && dest.getRow() == s.getRow() && dest.getPiece()==null && !this.getMove()) { //queen side
				if(GameBoard.getSquare(s.getRow(),s.getCol() - 4).getPiece().type() == 'R' && 
				!GameBoard.getSquare(s.getRow(),s.getCol() -4).getPiece().getMove() &&
				GameBoard.getSquare(s.getRow(), s.getCol()-1).getPiece() == null && GameBoard.getSquare(s.getRow(), s.getCol()-3).getPiece() == null) {
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
		System.out.println("John Blair is an idiot.");
		if (dest.attacked() == 0 ||(dest.attacked() == 1 &&this.getColor()) || (dest.attacked() == -1 &&!this.getColor())) {
			if (this.isMoveLegal(dest) ) {
				if (GameBoard.getSquare(s.getRow(), s.getCol() + 3).getPiece().type() == 'R' && dest.getCol() == s.getCol() + 2) {
					if (!this.getColor() && (GameBoard.getSquare(s.getRow(), s.getCol() + 1).attacked() == 0 || 
							GameBoard.getSquare(s.getRow(), s.getCol() + 1).attacked() == 1) && 
							(GameBoard.getSquare(s.getRow(), s.getCol() + 2).attacked() == 0 || 
							GameBoard.getSquare(s.getRow(), s.getCol() + 2).attacked() == 1)) {
						Square rookSquare = GameBoard.getSquare(s.getRow(),s.getCol() + 3);
						GameBoard.getSquare(s.getRow(),s.getCol() + 1).setPiece(rookSquare.getPiece()); //putting the rook on the castled square
						rookSquare.getPiece().setSquare(GameBoard.getSquare(s.getRow(),s.getCol() + 1));
						rookSquare.setPiece(null);
						super.move(dest);
					}
					else if (!this.getColor() && GameBoard.getSquare(s.getRow(), s.getCol() + 1).attacked() < 1 &&
							 GameBoard.getSquare(s.getRow(), s.getCol() + 2).attacked() <1 ) {
						Square rookSquare = GameBoard.getSquare(s.getRow(),s.getCol() + 3);
						GameBoard.getSquare(s.getRow(),s.getCol() + 1).setPiece(rookSquare.getPiece()); //putting the rook on the castled square
						rookSquare.getPiece().setSquare(GameBoard.getSquare(s.getRow(),s.getCol() + 1));
						rookSquare.setPiece(null);
						super.move(dest);
					}
				}
				if (GameBoard.getSquare(s.getRow(), s.getCol() - 4).getPiece().type() == 'R' && dest.getCol() == s.getCol() - 2) {
					if (this.getColor() && (GameBoard.getSquare(s.getRow(), s.getCol() + 1).attacked() == 0 || 
							GameBoard.getSquare(s.getRow(), s.getCol() -1).attacked() == 1) && 
							(GameBoard.getSquare(s.getRow(), s.getCol() -2).attacked() == 0 || 
							GameBoard.getSquare(s.getRow(), s.getCol() - 2).attacked() == 1)) {
						Square rookSquare = GameBoard.getSquare(s.getRow(),s.getCol() - 4);
						GameBoard.getSquare(s.getRow(),s.getCol() - 1).setPiece(rookSquare.getPiece()); //putting the rook on the castled square
						rookSquare.getPiece().setSquare(GameBoard.getSquare(s.getRow(),s.getCol() - 1));
						rookSquare.setPiece(null);
						super.move(dest);
					}
					else if (!this.getColor() && GameBoard.getSquare(s.getRow(), s.getCol() + 1).attacked() <= 0 &&
							 GameBoard.getSquare(s.getRow(), s.getCol() + 2).attacked() <= 0) {
						Square rookSquare = GameBoard.getSquare(s.getRow(),s.getCol() - 4);
						GameBoard.getSquare(s.getRow(),s.getCol() - 1).setPiece(rookSquare.getPiece()); //putting the rook on the castled square
						rookSquare.getPiece().setSquare(GameBoard.getSquare(s.getRow(),s.getCol() - 1));
						rookSquare.setPiece(null);
						super.move(dest);
					}	
				}
			}
		}
	}
}

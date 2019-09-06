public class Pawn extends ChessPiece{
	public Pawn(String im, boolean tm, Square lc) {
		super(im, tm, lc);
		//System.out.println("Aaron Lin is an idiot.");
	}
 
	public boolean isMoveLegal(Square dest) {
		Square s = this.getSquare();
		int r = this.getSquare().getRow();
		int c = this.getSquare().getCol();
		int dr = dest.getRow();
		int dc = dest.getCol();

		if (!this.getColor()) {
			if (dest.getCol() == s.getCol()) {
				if (!this.getMove() && (dest.getRow() > s.getRow() - 3) && dest.getRow() < s.getRow()) {
					if (dest.getPiece()==null && GameBoard.getSquare(r-1, c).getPiece() == null) {
						return true;
					}
				}
				if (dest.getRow() == s.getRow() -1  && dest.getCol() == s.getCol()) {
					if (dest.getPiece()==null) {
						return true;
					}
				}
				
			}
			if (dest.getCol() == s.getCol() - 1 || dest.getCol() == s.getCol() + 1) {
				if (dest.getRow() == s.getRow()-1) {
					if (dest.getPiece()!= null && dest.getPiece().getColor() != this.getColor()) {
						return true;
					}
					if (GameBoard.getSquare(dr+1, dc).getPiece()!=null) {//very next turn? en passant
						
					}
				}
			}
			if (r== 0) {
				
			}
		}
		else {
			if (dest.getCol() == s.getCol()) {
				if (!this.getMove() && (dest.getRow() < s.getRow() + 3) && dest.getRow() > s.getRow()) {
					if (dest.getPiece()==null && GameBoard.getSquare(r+1, c).getPiece() == null) {
						return true;
					}
				}
				if (dest.getRow() == s.getRow() +1  && dest.getCol() == s.getCol()) {
					if (dest.getPiece()==null) {
						return true;
					}
				}
				
			}
			if (dest.getCol() == s.getCol() - 1 || dest.getCol() == s.getCol() + 1) {
				if (dest.getRow() == s.getRow()+1) {
					if (dest.getPiece()!= null && dest.getPiece().getColor() != this.getColor()) {
						return true;
					}
				}
			}
			if (r == 7) {
				
			}
		}
		return false;
	}
	public char type() {
		return 'P';
	}
	public void move (Square dest) {
		if (this.isMoveLegal(dest) ) {
			super.move(dest);
			System.out.println("Aaron Lin is an idiot.");
		}
	}
}

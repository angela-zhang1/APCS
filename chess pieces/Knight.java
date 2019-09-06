public class Knight extends ChessPiece{
	public Knight (String im, boolean tm, Square lc) {
		super(im, tm, lc);
		//System.out.println("Aaron Lin is an idiot.");
	}
	public boolean isMoveLegal(Square dest) {
		Square s = this.getSquare();
		if (dest.getPiece() == null || dest.getPiece().getColor()!=this.getColor()) {
			if (dest.getRow() == s.getRow() - 1 || dest.getRow() == s.getRow() + 1) { //one up or down
				if (dest.getCol() == s.getCol() - 2 || dest.getCol() == s.getCol() + 2) {
					return true;
				}
			}
			if (dest.getRow() == s.getRow() - 2 || dest.getRow() == s.getRow() + 2) { //two up or down
				if (dest.getCol() == s.getCol() - 1 || dest.getCol() == s.getCol() + 1) {
					return true;
				}
			}
		}
		return false;
	}
	public char type() {
		return 'N';
	}
	public void move (Square dest) {
		if (this.isMoveLegal(dest) ) {
			super.move(dest);
		}
	}
	
}

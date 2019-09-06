public class Rook extends ChessPiece{
	public Rook (String im, boolean tm, Square lc) {
		super(im, tm, lc);
		//System.out.println("Aaron Lin is an idiot.");
	}
	public boolean isMoveLegal(Square dest) {
		Square s = this.getSquare();
		int r = s.getRow();
		int c = s.getCol();
		if (dest.getPiece() == null || dest.getPiece().getColor()!=this.getColor()) {
			if (dest.getRow() == s.getRow()) {
				if (dest.getCol() < s.getCol()) {
					for (int i = 1; i < s.getCol()-dest.getCol(); i++) {
						if (GameBoard.getSquare(r, c-i).getPiece()!=null) {
							return false;
						}
					}
					return true;
				}
				else {
					for (int i = 1; i < dest.getCol() - s.getCol(); i++) {
						if (GameBoard.getSquare(r, c+i).getPiece()!=null) {
							return false;
						}
					}
					return true;
				}
			}
			if (dest.getCol() == s.getCol()) {
				if (dest.getRow() < s.getRow()) {
					for (int i = 1; i < s.getRow()-dest.getRow(); i++) {
						if (GameBoard.getSquare(r-i, c).getPiece()!=null) {
							return false;
						}
					}
					return true;
				}
				else {
					for (int i = 1; i < dest.getRow()-s.getRow(); i++) {
						if (GameBoard.getSquare(r+i, c).getPiece()!=null) {
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	public char type() {
		return 'R';
	}
	public void move (Square dest) {
		if (this.isMoveLegal(dest) ) {
			super.move(dest);
		}
	}
}

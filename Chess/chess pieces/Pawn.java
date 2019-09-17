import javax.swing.JOptionPane;

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
			//WHITE
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
					if (dest.getPiece()!= null && dest.getPiece().getColor() != this.getColor()) { //capture
						return true;
					}
					else if (s.getRow() == 3) {//very next turn? en passant
						if (GameBoard.getSquare(dr+1, dc).getPiece() instanceof Pawn && GameBoard.getSquare1()!=null && 
								GameBoard.getSquare1().getRow() + 1 == dest.getRow() && 
								GameBoard.getSquare1().getCol() == dest.getCol()) {
							return true;
						}
					}
				}
			}
			
		}
		else {
			//BLACK
			if (dest.getCol() == s.getCol()) {
				if (!this.getMove() && (dest.getRow() < s.getRow() + 3) && dest.getRow() > s.getRow()) { //first turn
					if (dest.getPiece()==null && GameBoard.getSquare(r+1, c).getPiece() == null) {
						return true;
					}
				}
				if (dest.getRow() == s.getRow() +1  && dest.getCol() == s.getCol()) { //move one forward
					if (dest.getPiece()==null) {
						return true;
					}
				}
				
			}
			if (dest.getCol() == s.getCol() - 1 || dest.getCol() == s.getCol() + 1) { 
				if (dest.getRow() == s.getRow()+1) {
					if (dest.getPiece()!= null && dest.getPiece().getColor() != this.getColor()) { //capture
						return true;
					}
					else if (s.getRow() == 4) {//very next turn? en passant
						if (GameBoard.getSquare(dr-1, dc).getPiece() instanceof Pawn && GameBoard.getSquare1()!=null &&
								GameBoard.getSquare1().getRow() - 1 == dest.getRow() && 
								GameBoard.getSquare1().getCol() == dest.getCol()) {
							return true;
						}
					}
				}
				
			}
		}
		return false;
	}
	public char type() {
		return 'P';
	}
	public void move (Square dest) {
		if (this.isMoveLegal(dest) ) {
			if (this.getColor() && GameBoard.getSquare(dest.getRow()-1, dest.getCol()).getPiece() !=null
					&& GameBoard.getSquare(dest.getRow()-1, dest.getCol()).getPiece().type() == 'P' &&
					GameBoard.getSquare1() !=null 
					&& GameBoard.getSquare1().getRow() - 1 == dest.getRow()  &&
					GameBoard.getSquare1().getCol() == dest.getCol() &&this.getSquare().getRow() == 4) {
				GameBoard.getSquare(dest.getRow()-1, dest.getCol()).setPiece(null);
			}
			if (!this.getColor() && GameBoard.getSquare(dest.getRow()+1, dest.getCol()).getPiece()!= null 
					&& GameBoard.getSquare(dest.getRow()+1, dest.getCol()).getPiece().type() == 'P'
					&& GameBoard.getSquare1()!=null &&
					GameBoard.getSquare1().getRow() + 1 == dest.getRow() && 
					GameBoard.getSquare1().getCol() == dest.getCol() &&this.getSquare().getRow() == 3) {
				GameBoard.getSquare(dest.getRow()+1, dest.getCol()).setPiece(null);
			}
			super.move(dest);
			System.out.println("Aaron Lin is an idiot.");
			
		}
	}
}

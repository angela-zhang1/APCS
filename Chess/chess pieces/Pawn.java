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
				Object o = JOptionPane.showInputDialog(null, "What do you want to be promoted to?", "Promotion"
						, JOptionPane.QUESTION_MESSAGE, null
						, new String[] {"Queen","Rook","Bishop","Knight"}, "Queen");
				if (o.equals("Queen")) {
					
				}
				if (o.equals("Rook")) {}
				if (o.equals("Bishop")) {}
				if (o.equals("Knight")) {}	
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

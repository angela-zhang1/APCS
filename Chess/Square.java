import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Square extends JPanel implements MouseListener{
	//~~~~ Private Member Variables ~~~~
	private static GameBoard board;
	private ChessPiece piece;
	private boolean highlight;
	private int row, col;
	private boolean black;
	
	//~~~~ Constructors ~~~~
	public Square(int r, int c, GameBoard gb, boolean b){
		board = gb;
		row = r;
		col = c;
		black =b;
		if(b)
			this.setBackground(Color.BLACK);
		else
			this.setBackground(Color.WHITE);
		this.addMouseListener(this);
	}
	public Square(int r, int c, GameBoard gb){
		board = gb;
		row = r;
		col = c;
		this.setBackground(Color.BLACK);		
		this.addMouseListener(this);
	}
	
	//~~~~ some functions to specify the color of this square ~~~~
	public void setColor( int c ){//1 means black, 0 means white
		if(c==1)
			this.setBackground(Color.BLACK);
		else
			this.setBackground(Color.WHITE);
	}

	public void setColor( boolean black ){//true means black, false means white
		if(black)
			this.setBackground(Color.BLACK);
		else
			this.setBackground(Color.WHITE);
	}
	public void setColor( Color c ){
		this.setBackground(c);
	}
	
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(piece!=null)
			piece.draw(g);
		if (highlight) {
			if (this.getPiece()!=null) {
				if (black) {
					g.setColor(new Color(255,100,100,100));
				}
				else {
					g.setColor(new Color(100,0,0,100));
				}
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
			}
			else {
				if (black) {
					g.setColor(new Color(255,255,100,100));
				}
				else {
					g.setColor(new Color(100,100,0,100));
				}
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
			}
		}
	}
	
	public ChessPiece getPiece() {
		return piece;
	}
	
	public boolean getHighlight () {
		return highlight;
	}
	
	public void setHighlight (boolean x) {
		highlight = x;
		this.repaint();
	}
	
	public void setPiece(ChessPiece p) {
		piece = p;
		this.repaint();
	}
	//~~~~ MouseListener stuff ~~~~
	public void mousePressed(MouseEvent arg0) {
		//when I am clicked, I will tell the board that I was clicked!
		board.clicked(this);		
	}

	public void mouseClicked(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}


}

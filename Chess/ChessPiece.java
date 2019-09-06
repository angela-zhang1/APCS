import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;
public abstract class ChessPiece { 
	private Image img;
	private Square sqr;
	//variable for what team/color i am
	private boolean bl;
	//variable for what Square I'm sitting on 
	private boolean moveYet = false;
	
	//Constructor :  you will need some more parameters!
	public ChessPiece(String im, boolean color, Square s){
 
		loadImage(im);
		sqr = s;
		bl = color;
		//set up your other variables
		
	}//end constructor
 
	//helper function for loading up your image
	private void loadImage( String im ){
		img = Toolkit.getDefaultToolkit().getImage( getClass().getResource(im) );  
     
		MediaTracker tracker = new MediaTracker (new Component () {});
		tracker.addImage(img, 0);
		//block while reading image
		try { tracker.waitForID (0); }
		catch (InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Error reading file");
		}
	}//end loadImage
	public void draw(Graphics g){
		g.drawImage(img,15,0,60,90,null,null);
	}
	public Square getSquare () {
		return sqr;
	}
	public boolean getColor() {
		return bl;
	}
	public void setSquare (Square s) {
		sqr = s;
	}
	public boolean getMove() {
		return moveYet;
	} 
	public void move (Square dest) {
		sqr.setPiece(null);
		dest.setPiece(this);
		setSquare(dest);
		moveYet = true;
	}
	//public void setPiece(int locX, int locY, int sizeX, int sizeY) {
	// g.drawImage(img,locX,locY,sizeX, sizeY,null,null);
	//}
 
	public abstract boolean isMoveLegal(Square dest);

	public abstract char type();
}


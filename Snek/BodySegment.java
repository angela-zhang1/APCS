import java.awt.Color;
import java.awt.Graphics;

public class BodySegment {
	//this BodySegment will act like a NODE
	//  he will point to the next BodySegment in the Snake
	//  You will need a variable for this
	
	public static final int SIZE=15;
	public Color hue = Color.green;
	public static int nextID = 0;
	public int myID;
	private int xPos, yPos;
	public BodySegment next;
	public BodySegment previous;
	
	public BodySegment(int x, int y, BodySegment n, BodySegment p){
		xPos = x;
		yPos = y;
		next = n;
		previous = p;
		myID = nextID++;
	}
	
	//~~~~~~~~~~~~~~~~accessors and mutators~~~~~~~~~~~~~~~~~~~~~~
	
	
	public int getXPos () {
		return xPos;
	}
	public int getYPos () {
		return yPos;
	}
	public boolean isTouching( BodySegment sp){
	
			return false;		
	}
	public void setNext(BodySegment o) {
		next = o;
	}
	
	//each BodySegment knows how to draw himself :)
	public void draw(Graphics g){
		g.setColor(hue);
		g.fillOval(xPos, yPos, SIZE, SIZE);
		//just for testing purposes, you can take this out later
		g.setColor(Color.BLACK);
		g.drawString(""+myID, xPos+SIZE/4, yPos+SIZE);
	}
}

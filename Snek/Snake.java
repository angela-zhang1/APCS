import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class Snake implements KeyListener{
	public static final int UP=0, RIGHT=1, DOWN=2, LEFT=3;
	private int direction;
	private BodySegment firstNode;
	private BodySegment lastNode;
	int size = 0;
	//variables you will need
	// 1) pointer to the first and/or last piece of the snake
	// 2) a variable to keep track of what direction this snake is facing
	
	public Snake(){
		//go ahead and give him 1 BodySegment
		//tell him what direction he is moving	
		direction = RIGHT;
		this.addFirst();
	}
	
	public int size(){
		return size;
	}
	
	public void addFirst(){
		BodySegment bs = firstNode;
		int x,y;
		if (bs!=null) {
			x = firstNode.getXPos();
			y = firstNode.getYPos();
		}
		else {
			x = 45; 
			y = 45;
		}
		BodySegment secondNode = firstNode;
		if (direction == RIGHT) {firstNode = new BodySegment (x+BodySegment.SIZE, y, secondNode, null);}
		if (direction == LEFT) {firstNode = new BodySegment (x-BodySegment.SIZE, y, secondNode, null);}
		if (direction == UP) {firstNode = new BodySegment (x, y-BodySegment.SIZE, secondNode, null);}
		if (direction == DOWN) {firstNode = new BodySegment (x, y+BodySegment.SIZE, secondNode, null);}
		
		size++;
		if (size == 1) {
			lastNode = firstNode;
		}
	}
	
	public void removeLast(){
		lastNode.previous.setNext(null);
		if (size!=1) {
			lastNode = lastNode.previous;
		}
		else {
			lastNode = null;
			firstNode = null;
		}
		if (size!=0) {
			size--;
		}
	}
	
	public int direction() {
		return direction;
	}
	
	public void draw(Graphics g){
		//tell EACH segment to draw (and pass it g)
		BodySegment n = firstNode;
		while (n!=null) {
			n.draw(g);
			n = n.next;
		}
	}
	
	
	@Override
	//make the snake respond to key presses
	public void keyPressed(KeyEvent e) {	
		if(e.getKeyCode() == KeyEvent.VK_UP)
			System.out.println("User pressed up");
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	
}

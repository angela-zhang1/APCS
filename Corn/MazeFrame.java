//package FORKIDS;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


import javax.swing.*;
public class MazeFrame extends JFrame implements ActionListener{
	private static final int UP = 0, RIGHT = 1, DOWN=2, LEFT = 3;
	private static int ROWS=10, COLS=10;

	private JPanel controls, maze;
	private JButton solve;
	//*** you will need a 2DArray of MazeCells****
	private MazeCell[][] cells = new MazeCell[ROWS][COLS];
	private CellStack cstack = new CellStack();

	/**Constructor**/
	public MazeFrame(){
		super("MAZE");

		setUpControlPanel();//make the buttons & put them in the north
		instantiateCells();//give birth to all the mazeCells & get them onto the screen
		carveALameMaze();//this will knock down walls to create a maze
		//carveARandomMaze();

		//finishing touches
		this.setSize(ROWS*20,COLS*20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(ROWS*40,COLS*40);
		this.setVisible(true);
	}//end constructor


	/* 1111111111111111    PHASE 1 STUFF    1111111111111111111111 */
	private void instantiateCells(){
		maze = new JPanel();
		maze.setBackground(Color.WHITE);
		maze.setLayout(new GridLayout(ROWS, COLS));
		//construct your 2D Array & instantiate EACH MazeCell
		//  be sure to add each MazeCell to the panel
		//            * call maze.add( ?the cell ? );
		/**~~~~  WRITE CODE HERE ~~~~**/
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				cells[i][j] = new MazeCell(i,j);
				maze.add(cells[i][j]);
			}
		}

		/**~~~~  *************** ~~~~**/
		//put the maze on the screen
		this.add(maze, BorderLayout.CENTER);
	}

	private void carveALameMaze(){//"hard code" a maze
		for (int i = 1; i < 8; i++) {
			cells[i][2].clearWallDown();
			cells[i+1][2].clearWallUp();
		}
		cells[5][0].clearWallLeft();
		for (int i = 0; i < 6; i++) {
			cells[5][i].clearWallRight();
			cells[5][i+1].clearWallLeft();
		}
		for (int i = 9; i > 0; i--) {
			cells[i][6].clearWallUp();
			cells[i-1][6].clearWallDown();
		}
		for (int i = 6; i < 8; i++){
			cells[2][i].clearWallRight();
			cells[2][i+1].clearWallLeft();
		}
		for (int i = 2; i < 4; i++){
			cells[i][8].clearWallDown();
			cells[i+1][8].clearWallUp();
		}
		cells[4][8].clearWallRight();
		cells[4][9].clearWallLeft();
		cells[4][9].clearWallRight();
		cells[2][2].clearWallRight();
		cells[2][3].clearWallLeft();
		cells[2][3].clearWallRight();
		cells[2][4].clearWallLeft();
		cells[5][0].setStatus(1);
		cstack.push(cells[5][0]);
	}

	/** 2222222222222222222    PHASE 2 STUFF   22222222222222222222222222 **/
	public boolean isInBounds(int r, int c){
		if (r >= 0 && r < ROWS && c>=0 && c < COLS)
			return true;
		return false;
	}

	public boolean solveStep(){//takes the next step in solving the maze
		return false;
	}


	/* 33333333333333333333    Phase 3 stuff    3333333333333333333333333 */

	public MazeCell getNeighbor(MazeCell mc, int dir){
		return null;
	}
	public ArrayList<MazeCell> blankNeighbors(MazeCell mc){
		return null;
	}

	public int getDirectionFrom(MazeCell orig, MazeCell dest){
		return 0;
	}
	public void stepCarve(){

	}
	public void carveARandomMaze(){

	}

	//4444444444444444444  PHASE 4 STUFF 4444444444444444444444444444
	private void resetMaze(){

	}


	//This gets called any time that you press a button
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==solve)
			this.solveStep();

	}//end action performed


	private void setUpControlPanel(){
		controls = new JPanel();
		solve = new JButton("solve");
		solve.addActionListener(this);
		controls.add(solve);

		this.add(controls, BorderLayout.NORTH);
	}

	public static void main(String[] args){	new MazeFrame();}

}//end class

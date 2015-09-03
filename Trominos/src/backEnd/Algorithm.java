package backEnd;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import frontEnd.Displayer;

public abstract class Algorithm {

	public int[][] board;
	public int n;
	public int blankx;
	public int blanky;
	public int dim;
	public int xOffset;
	public int yOffset;
	public int iteration = 0;
	public ArrayList<Integer> gridlines=new ArrayList<Integer>();

	void setBoardDimension(int n){
		this.n = n;
		int dim = (int) Math.pow(2,n);
		this.dim = dim;
		try{
		this.board = new int[dim][dim];
		for(int i = 0; i<dim;i++){
			for(int j = 0; j<dim;j++){
				board[i][j] = 0;
			}
		}
		setUpGridlines();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	abstract protected void setUpGridlines();

	public void setBlankSpot(int x, int y) {
		blankx=x;
		blanky=y;
		try{
			this.board[x-1][y-1]=2;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Check to ensure that "+e.getMessage()+ " is within the board.", "Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void display() {
		Displayer displayer = new Displayer(this);
		displayer.display();
	}
	
	public void setOffset(int x,int y){
		this.xOffset = x;
		this.yOffset = y;
	}

	public void progress() {
		iteration++;
		if(!(iteration>n)){
			updateGridLines();
			updateSquares();
		}
	}

	abstract protected void updateSquares();

	abstract protected void updateGridLines();

}

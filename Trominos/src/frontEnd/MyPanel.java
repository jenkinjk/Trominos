package frontEnd;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import backEnd.Algorithm;

public class MyPanel extends JPanel {
	
	private Algorithm backEnd;
	
	public MyPanel(Algorithm backEnd) {
		this.backEnd=backEnd;
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = Displayer.DIMENSION/backEnd.dim;
		for(int i =0; i < backEnd.dim; i++){
			for(int j =0; j<backEnd.dim; j++){
				int color = backEnd.board[i][j];
				if(color == 0){
					g.setColor(Color.WHITE);
					g.fillRect(j*size, i*size, size, size);
				}else if(color == 1){
					g.setColor(Color.RED);
					g.fillRect(j*size, i*size, size, size);
				}else{
					g.setColor(Color.BLACK);
					g.fillRect(j*size, i*size, size, size);
				}
			}
		}
		g.setColor(Color.BLACK);
		for(int location: backEnd.gridlines){
			g.drawLine(location*size,  0, location * size, backEnd.dim*size);
			g.drawLine(backEnd.dim*size ,  location * size, 0, location * size);
		}
	}
}

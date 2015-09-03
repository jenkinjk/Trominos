package frontEnd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import backEnd.Algorithm;

public class Displayer {

	public static final int DIMENSION = 950;
	private static final int HEIGHT = 50;
	private Algorithm backEnd;
	private JFrame displayFrame;
	public JPanel panel;

	public Displayer(Algorithm algorithm) {
		this.backEnd = algorithm;
	}
	
	public void display() {
		displayFrame = new JFrame();
		panel = new MyPanel(backEnd);
		panel.setLayout(null);
		JButton next = new JButton("Progress Algorithm");
		int width = 200;
		next.setBounds(DIMENSION/2-width/2,DIMENSION,width,HEIGHT);
		next.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				backEnd.progress();
				displayFrame.repaint();
			}
			
		});
		panel.add(next);
		displayFrame.add(panel);
		displayFrame.setSize(DIMENSION, DIMENSION+2*HEIGHT);
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.setVisible(true);
		displayFrame.setResizable(false);
	}

}

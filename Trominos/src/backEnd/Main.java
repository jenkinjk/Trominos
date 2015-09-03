package backEnd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	
	public static Algorithm algorithm;

	public static void main(String[] args) {
		final JFrame setUpFrame = new JFrame("Set up");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLabel select = new JLabel("Please select the algorithm you wish to use.");
		panel.add(select, BorderLayout.NORTH);
		
		String[] algorithms = {"Johnsonbaugh","Problems 6-7"};
		
		JComboBox<String> AlgorithmBox = new JComboBox<String>(algorithms);
		panel.add(AlgorithmBox, BorderLayout.CENTER);
		
		AlgorithmBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				JComboBox<String> cb = (JComboBox<String>) arg.getSource();
				String algChoice = (String) cb.getSelectedItem();
				if(algChoice.equals("Johnsonbaugh")){
					algorithm = new Johnsonbaugh();
				}else if(algChoice.equals("Problems 6-7")){
					algorithm = new Problems67();
				}
				setUpFrame.dispose();
				getDimensionAndLocation();
			}

			private void getDimensionAndLocation() {
				try{
				String NString = JOptionPane.showInputDialog("Please input the value of N. Note, N is the power of 2 that makes up the dimension of the board.");
				int N = Integer.parseInt(NString);
				String XY = JOptionPane.showInputDialog("Please input the location of the missing square, formatted like x,y:");
				String[] XandY = XY.split(",");
				int X = Integer.parseInt(XandY[0]);
				int Y = Integer.parseInt(XandY[1]);
				algorithm.setBoardDimension(N);
				algorithm.setBlankSpot(X,Y);
				algorithm.setOffset(0, 0);
				algorithm.display();
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Please double check your formatting. "+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

		setUpFrame.add(panel);
		setUpFrame.setSize(300, 150);
		setUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUpFrame.setVisible(true);
		setUpFrame.setResizable(false);

	}

}

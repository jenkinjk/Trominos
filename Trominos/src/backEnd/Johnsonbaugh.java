package backEnd;

import javax.swing.JOptionPane;

public class Johnsonbaugh extends Algorithm {

	@Override
	protected void setUpGridlines() {
		//Starts with none
	}

	@Override
	protected void updateSquares() {
		//Take each 2^(n-(iteration-1)) square
		int size = (int)Math.pow(2, (n-(iteration - 1)));
		for(int i =0; i<Math.pow(2, n);i= (i+size)){
			for(int j =0; j<Math.pow(2, n);j= (j+size)){
				//Find the "full" spot
				int iLocale = -1, jLocale = -1;
				for(int k = i; k<i+size;k++){
					for(int l = j; l<j+size;l++){
						if(board[k][l]!=0){
							iLocale = k-i;
							jLocale = l-j;
							break;
						}
					}
					if(iLocale!=-1)
						break;
				}
				if(iLocale<0){
					JOptionPane.showMessageDialog(null, "There was no full spot in the specified area.", "Error",JOptionPane.ERROR_MESSAGE);
				}
				//Figure out which orientation this dictates, then fill in 1 tromino
				if(iLocale < (size)/2){
					if(jLocale < (size)/2){
						board[i+size/2][j+size/2]=1;
						board[i+size/2-1][j+size/2]=1;
						board[i+size/2][j+size/2-1]=1;
					}else{
						board[i+size/2][j+size/2]=1;
						board[i+size/2-1][j+size/2-1]=1;
						board[i+size/2][j+size/2-1]=1;
					}
				}else{
					if(jLocale < (size)/2){
						board[i+size/2][j+size/2]=1;
						board[i+size/2-1][j+size/2]=1;
						board[i+size/2-1][j+size/2-1]=1;
					}else{
						board[i+size/2-1][j+size/2]=1;
						board[i+size/2-1][j+size/2-1]=1;
						board[i+size/2][j+size/2-1]=1;
					}
				}
			}
		}
	}

	@Override
	protected void updateGridLines() {
		for(int i =1; i < Math.pow(2, iteration);i++){
			int pos = (i*(int)Math.pow(2, n-iteration));
			gridlines.add(pos);
		}
		
	}

}

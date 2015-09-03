package backEnd;

import javax.swing.JOptionPane;

import frontEnd.Displayer;

public class Problems67 extends Algorithm {

	protected void updateSquares() {
		int size = (int) Math.pow(2, iteration);
		for (int i = 0; i <= Math.pow(2, n); i = i + size) {
			for (int j = 0; j <= Math.pow(2, n); j = j + size) {
				if ((blankx - 1 < i + size && i <= blankx - 1)
						&& (blanky - 1 < j + size && j <= blanky - 1)) {
					int orientation = calcOrienation(i, j);
					if (orientation == -1) {
						JOptionPane
								.showMessageDialog(
										null,
										"An error ocurred calculating the initial orientation.",
										"Error", JOptionPane.ERROR_MESSAGE);
					}
					updateSquares(i, j, iteration, orientation);
				}
			}
		}
	}

	private int calcOrienation(int i, int j) {
		int size = (int) Math.pow(2, iteration - 1);
		if (board[i][j] != 0)
			return 1;
		if (board[i + size][j] != 0)
			return 2;
		if (board[i][j + size] != 0)
			return 3;
		if (board[i + size][j + size] != 0)
			return 4;
		return -1;
	}

	private void updateSquares(int i, int j, int iteration, int orientation) {
		if (iteration == 1) {
			drawTromino(i, j, orientation);
		} else {
			int itr = iteration - 1, size = (int) Math.pow(2, itr);
			int newI = i + size, newJ = j + size;
			if (orientation == 1) {
				updateSquares(newI - size / 2, newJ - size / 2, itr, 1);
				updateSquares(i, newJ, itr, 2);
				updateSquares(newI, j, itr, 3);
				updateSquares(newI, newJ, itr, 1);
			} else if (orientation == 2) {
				updateSquares(newI - size / 2, newJ - size / 2, itr, 2);
				updateSquares(i, j, itr, 4);
				updateSquares(i, newJ, itr, 2);
				updateSquares(newI, newJ, itr, 1);
			} else if (orientation == 3) {
				updateSquares(newI - size / 2, newJ - size / 2, itr, 3);
				updateSquares(i, j, itr, 4);
				updateSquares(newI, j, itr, 3);
				updateSquares(newI, newJ, itr, 1);
			} else if (orientation == 4) {
				updateSquares(newI - size / 2, newJ - size / 2, itr, 4);
				updateSquares(i, j, itr, 4);
				updateSquares(newI, j, itr, 3);
				updateSquares(i, newJ, itr, 2);
			}
		}
	}

	private void drawTromino(int i, int j, int orientation) {
		if (orientation == 1) {
			board[i][j + 1] = 1;
			board[i + 1][j] = 1;
			board[i + 1][j + 1] = 1;
		} else if (orientation == 2) {
			board[i][j] = 1;
			board[i][j + 1] = 1;
			board[i + 1][j + 1] = 1;
		} else if (orientation == 3) {
			board[i][j] = 1;
			board[i + 1][j] = 1;
			board[i + 1][j + 1] = 1;
		} else if (orientation == 4) {
			board[i][j] = 1;
			board[i][j + 1] = 1;
			board[i + 1][j] = 1;
		} else {
			JOptionPane.showMessageDialog(null,
					"Tromino drawing orientation not recognized", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void updateGridLines() {
		int size = gridlines.size();
		for (int i = 1; i < size; i = i + 2) {
			gridlines.add(gridlines.get(i));
		}
		for (int i = 0; i < size; i++) {
			gridlines.remove(0);
		}
	}

	@Override
	protected void setUpGridlines() {
		for (int i = 1; i < dim; i++) {
			gridlines.add(i);
		}

	}

}

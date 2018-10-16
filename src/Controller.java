import javax.swing.*;
import java.awt.event.*;

public class Controller {
	public View view;
	public Model model;
	
	public Controller() {
		this.model = new Model();
		this.view = new View();
		
	}
	
	
	//In case an existing model or view needs to be imported for testing
	public Controller(Model model, View view) {

		// initialize Model
		this.model = model;
		//model.reset();

		// initialize View
		this.view = view;
		
		this.view.buttonLis(new ContListener());
	}
	
	//Based on standard java ButtonListener
	class ContListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			//Note to  self: Don't use blocks for both of your names unless you only need to call them once
			JButton[][] gameBoardButtons = view.getButtonBlocks();
			char mark[][] = model.getCharBlocks();

			//guess we'll reuse that reset.
			JButton reset = view.getReset();

			// Updates Model and View
			// Reads game moves from the command line.
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					if (e.getSource() == gameBoardButtons[row][col]) {

						// Make sure the spot is valid with the model
						//Taken from original code and optimized.
						model.updateTurn(row, col, model.getPlayerTurn());
						if (model.getPlayerTurn() == 'X') {
							view.playerturn.setText("'X': Player 1");
							System.out.format("Player 2('O') Marked point(%d,%d). now Player 1('X')'s turn ",row+1,col+1);
							System.out.println();
						} else {
							view.playerturn.setText("'O': Player 2");
							System.out.format("Player 1('X') Marked point(%d,%d). now Player 2('O')'s turn ",row+1,col+1);
							System.out.println();
						}

						// Update View
						//A lot of this is taken from base code.
						view.setBoard(mark);
						view.updateView();
						if (model.movesLeft != 0)
							view.blocks[row][col].setEnabled(false);
						if (model.checkWin() == true)
							if (model.getPlayerTurn() == 'X') {
								view.playerturn.setText("Player 1 wins!");
								System.out.println("Player 1 wins! Click the 'Reset' button to play new game.");
								setEnabled();
							} else {
								view.playerturn.setText("Player 2 wins!");
								System.out.println("Player 2 wins! Click the 'Reset' button to play new game.");
								setEnabled();
							}

						if (model.checkWin() == false && model.getMovesLeft() == 0) {
							view.playerturn.setText("Game ends in a draw");
							System.out.println("Game ends in a draw. Click the 'Reset' button to play new game.");
							setEnabled();
						}
					} 
				}
			}
			
			//If a player selects the reset button at any point... reset the board
			if (e.getSource() == reset) {
				
				model.reset();
				
				//Done once so that if a player resets before making a move, it doesn't cause problems.
				
				view.setBoard(mark);
			
				view.playerturn.setText("Player 1 to play 'X'");
				view.updateView();
				for (int row = 0; row < 3; row++) {
					for (int col = 0; col < 3; col++) {
						view.blocks[row][col].setEnabled(true);
						view.blocks[row][col].setText("");
					}
				}
			}
					
		}

		public void setEnabled() {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					view.blocks[i][j].setEnabled(false);
				}
			}
		}
	}
}





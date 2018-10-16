import java.awt.Dimension;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View {
	
	//Just copy and paste right from the original code. This works nicely for our View module.
	
	public JFrame gui = new JFrame("Tic Tac Toe");
    public JButton[][] blocks = new JButton[3][3];
    public JButton reset = new JButton("Reset");
    public JTextArea playerturn = new JTextArea();
    
    //We are going to add a two-dimensional Char array to manage X's and O's
    private char[][] Board = {};
    
    //Generate the UI view.
    
    View(){
    	
    	
    	
    	//Making life easier for ourselves, this code is taken from the original TicTacToe.java
    	
    	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);
        
        JPanel gamePanel = new JPanel(new FlowLayout());
		JPanel game = new JPanel(new GridLayout(3, 3));
		gamePanel.add(game, BorderLayout.CENTER);
		
		JPanel options = new JPanel(new FlowLayout());
		options.add(reset);
		JPanel messages = new JPanel(new FlowLayout());
		messages.setBackground(Color.white);
		
		gui.add(gamePanel, BorderLayout.NORTH);
		gui.add(options, BorderLayout.CENTER);
		gui.add(messages, BorderLayout.SOUTH);
		
		messages.add(playerturn);
		playerturn.setText("Player 1 to play 'X'");
		
		
		//Generate the blocks to form our code
		//Still using all the same old code, but we're gonna clean it up a bit.
		
		for(int row = 0; row<3 ;row++) {
            for(int col = 0; col<3 ;col++) {
            	blocks[row][col] = new JButton();
                blocks[row][col].setPreferredSize(new Dimension(75,75));
                blocks[row][col].setText("");
                game.add(blocks[row][col]);
			}
		}
    }
    
    //Listen for when a user presses a button
    public void buttonLis(ActionListener actionLis) {
    	
    	//First add a reset button action listener, since that's easy.
    	
    	reset.addActionListener(actionLis);
    	
    	//Next add the listener for every button.
    	
    	for(int row = 0; row < 3;row++) {
            for(int col = 0; col < 3;col++) {
            	blocks[row][col].addActionListener(actionLis);
            }
    	}
    }
    
    void updateView() {
    	for(int row = 0; row < 3;row++) {
            for(int col = 0; col < 3;col++) {
            	blocks[row][col].setText("" + Board[row][col]);
            }
    	}
    }
}

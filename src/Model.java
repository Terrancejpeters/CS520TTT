
public class Model {
	
	private char blocks[][] = new char[3][3];
	private char player = 'X';
	int movesLeft = 9;
	
	public Model() {
		for (int row = 0; row < 3; row++)
			for (int column = 0; column < 3; column++)
				blocks[row][column] = ' ';
	}
	
	public boolean checkWin() {
		
		// Returning a 1 means a win condition
		// Returning a 2 means a draw
		// Returning a 0 means a null condition. Should not occur, indicates bug.
		
		//Check the Rows for a win condition
		
		for (int row = 0; row < 3; row++) {
			if (blocks[row][0] == blocks[row][1] && blocks[row][0] == blocks[row][2] && blocks[row][0] != ' ') {
				playerChecker();
				//movesLeft = 0;
				return true;
			}
		}
		
		//Check the Columns for the win condition
		
		for (int col = 0; col < 3; col++) {
			if (blocks[0][col] == blocks[1][col] && blocks[0][col] == blocks[2][col] && blocks[0][col] != ' ') {
				playerChecker();
				//movesLeft = 0;
				return true;
			}
		}
		
		//Check for a diagonal win condition
		//We don't use a for loop here, we just straight check both of the conditions
		
		if (blocks[0][0] == blocks[1][1] && blocks[0][0] == blocks[2][2] && blocks[0][0] != ' '
				|| blocks[2][0] == blocks[1][1] && blocks[2][0] == blocks[0][2] && blocks[2][0] != ' '){
			playerChecker();
			//movesLeft = 0;
			return true;
		}
		
		/*if (movesLeft == 0) {
			return false;
		}*/
		
		//Reminder to add a test condition flag here. This false SHOULD NOT BE HIT, but method needs a return statement
		return false;

	}
	
	//Avoid repeating unnecessary code. Helper method to switch the player when checking win condition
	void playerChecker() {
		if (player == 'X') {
			player = 'O';
		} 
		//we know the only other option is the player being 'O'. No reason to check again.
		else {
			player = 'X';
		}
	}
	
	//Player's turn
	public void updateTurn(int x, int y, char previousPlayer) {

			if (movesLeft > 0 && blocks[x][y] == ' ') {
				blocks[x][y] = previousPlayer;
				
				//Just check who's turn it becomes
				if (previousPlayer == 'X') {
					blocks[x][y] = player;
					player = 'O';
				} 
				//if not X, then must be O
				else {
					blocks[x][y] = player;
					player = 'X';
				}
				movesLeft--;
			}
		}
	
	//A basic reset of the game. Restore things to how they were before playing
	public void reset() {

		for (int row = 0; row < 3; row++)
			for (int column = 0; column < 3; column++)
				blocks[row][column] = ' ';

		player = 'X';
		movesLeft = 9;
		
		//Only read by players using the command line
		System.out.println("New Game");
		
	}
	
	//Our Getters for the controller

	public char getPlayerTurn() {
		return player;
	}

	public char[][] getCharBlocks() {
		return blocks;
	}
	public int getMovesLeft() {
		return movesLeft;
	}
}

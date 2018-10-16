import org.junit.Test;
import static org.junit.Assert.*;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    @Test
    public void testNewGame() {
    	
    	Model model = new Model();
		View view = new View();
		
		Controller game = new Controller(model,view);
		Controller game2 = new Controller();
		Model model2 = new Model();
		
		
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				assertEquals(game.model.getCharBlocks()[x][y], model2.getCharBlocks()[x][y]);
			}
		}
		
		model2.reset();
		
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				assertEquals(game2.model.getCharBlocks()[x][y], model2.getCharBlocks()[x][y]);
			}
		}
		
		
		//assertEquals(game.model.getCharBlocks()[0][0], model2.getCharBlocks()[0][0]);
    	/*
        TicTacToe game = new TicTacToe();
        assertEquals (1, game.player);
        assertEquals (9, game.movesLeft);
        */
    }
}

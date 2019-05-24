import Piece.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayingFieldTest {
    private class IPieceFactory implements PieceFactory {
        public Piece createPiece() {
            return new IPiece();
        }
        public int   gameId() {
            return 0;
        }
    }
	private class NullResultCollector implements ResultCollector {
		public boolean submitGameResult (int gameId, int score, int lineCount) {
			return true;
		}
	}

    @Test
    void init() {
	    
    }

    @Test
    void getWidth() {
	    PieceFactory factory = new IPieceFactory();
	    PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);
	    
	    assertTrue (theField.getWidth(), 10);
    }

    @Test
    void getHeight() {
	    PieceFactory factory = new IPieceFactory();
	    PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);
	    
	    assertTrue (theField.getWidth(), 20);
    }

    @Test
    void getCurrentPiece() {
        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());

        assertTrue (theField.getNextPiece() instanceof IPiece );
    }

    @Test
    void getNextPiece() {
        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());

        assertTrue (theField.getNextPiece() instanceof IPiece );
    }

    @Test
    void getContents() {
    }

    @Test
    void getLineCount() {
    }

    @Test
    void nextMove() {
    }

    @Test
    void timeout() {
    }

    @Test
    void moveDown() {
    }

    @Test
    void rotateLeft() {
    }

    @Test
    void rotateRight() {
    }

    @Test
    void moveLeft() {
    }

    @Test
    void moveRight() {
    }

    @Test
    void A1PieceTest() {
        String APIURL = "http://seng275.csc.uvic.ca:8080/tetris/games";
        PlayingField pf = new PlayingField(new IPieceFactory(), new RESTAPIResultCollector("auth.txt", APIURL));
        Piece p = new IPiece();
        pf.nextMove(Move.rotateRight);
        for (int i = 0; i < 10; i++){
            pf.nextMove(Move.moveLeft);
        }
        assertTrue(pf.getCurrentPiece().getX() >= -1);
    }

    @Test
    void A1ScoringTest() {
        String APIURL = "http://seng275.csc.uvic.ca:8080/tetris/games";
        PlayingField pf = new PlayingField(new RESTPieceFactory(APIURL), new RESTAPIResultCollector("auth.txt", APIURL));
        for (int i = 0; i < 22; i++){
            pf.nextMove(Move.moveDown);
        }
        assertTrue(pf.getScore() > 0);
    }
}

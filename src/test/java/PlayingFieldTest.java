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
        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);

        //assertTrue();
    }

    @Test
    void getWidth() {
<<<<<<< HEAD
        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);

        assertEquals(theField.getWidth(), 10);
=======
	    PieceFactory factory = new IPieceFactory();
	    PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);
	    
	    assertEquals(theField.getWidth(), 10);
>>>>>>> b56b69ba11b44166185750dc97271f7128ce6227
    }

    @Test
    void getHeight() {
<<<<<<< HEAD
        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);

        assertEquals(theField.getHeight(), 20);
=======
	    PieceFactory factory = new IPieceFactory();
	    PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);
	    
	    assertEquals(theField.getHeight(), 20);
>>>>>>> b56b69ba11b44166185750dc97271f7128ce6227
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
        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);

        Piece.PieceType obp = Piece.PieceType.PIECE_OBSTACLE;
        assertTrue(theField.getContents(0,0) == obp);
    }

    @Test
    void getLineCount() {


    }

    @Test
    void nextMove() {

<<<<<<< HEAD
=======
        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());
        int initialX = theField.getCurrentPiece().getX();
        int initialY = theField.getCurrentPiece().getY();
        theField.nextMove(Move.gravityDown);
        assertEquals(initialY, theField.getCurrentPiece().getY());
        theField.nextMove(Move.moveDown);
        assertEquals(initialY+1, theField.getCurrentPiece().getY());
        theField.nextMove(Move.moveLeft);
        assertEquals(initialX-1, theField.getCurrentPiece().getX());
        theField.nextMove(Move.moveRight);
        assertEquals(initialX, theField.getCurrentPiece().getX());
        theField.nextMove(Move.rotateLeft);
        for (int i = 0; i < 4; i++){
            assertTrue(theField.getCurrentPiece().isCovering(2, i));
        }
        theField.nextMove(Move.rotateRight);
        for (int i = 0; i < 4; i++){
            assertTrue(theField.getCurrentPiece().isCovering(i, 1));
        }
>>>>>>> b56b69ba11b44166185750dc97271f7128ce6227
    }

    @Test
    void timeout() {
    }

    @Test
    void moveDown() {

        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());

        int initialY = theField.getCurrentPiece().getY();
        for (int i = 1; i <= 20; i++){
            theField.moveDown();
            assertEquals(initialY+i, theField.getCurrentPiece().getY());
        }
        theField.moveDown();
            assertEquals(initialY+20, theField.getCurrentPiece().getY());
    }

    @Test
    void rotateLeft() {

        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());

        for (int i = 0; i < 4; i++){
            assertTrue(theField.getCurrentPiece().isCovering(i, 1));
        }
        theField.rotateLeft();
        for (int i = 0; i < 4; i++){
            assertTrue(theField.getCurrentPiece().isCovering(2, i));
        }
    }

    @Test
    void rotateRight() {

        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());

        for (int i = 0; i < 4; i++){
            assertTrue(theField.getCurrentPiece().isCovering(i, 1));
        }
        theField.rotateRight();
        for (int i = 0; i < 4; i++){
            assertTrue(theField.getCurrentPiece().isCovering(1, i));
        }
    }

    @Test
    void moveLeft() {

        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());
        int originalX = theField.getCurrentPiece().getX();
        for (int i = 1; i <= 3; i++){
<<<<<<< HEAD
            theField.nextMove(Move.moveLeft);
=======
            theField.moveLeft();
>>>>>>> b56b69ba11b44166185750dc97271f7128ce6227
            assertTrue(theField.getCurrentPiece().getX() == originalX - i);
        }
    }

    @Test
    void moveRight() {

        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());
        int originalX = theField.getCurrentPiece().getX();
        for (int i = 1; i <= 3; i++){
<<<<<<< HEAD
            theField.nextMove(Move.moveRight);
=======
            theField.moveRight();
>>>>>>> b56b69ba11b44166185750dc97271f7128ce6227
            assertTrue(theField.getCurrentPiece().getX() == originalX + i);
        }
    }

    @Test
    void A1PieceTest() {

        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());
        theField.nextMove(Move.rotateRight);
        for (int i = 0; i < 10; i++){
            theField.nextMove(Move.moveLeft);
        }
        assertTrue(theField.getCurrentPiece().getX() >= 0);
    }

    @Test
    void A1ScoringTest() {

        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());
        for (int i = 0; i < 20; i++){
            theField.nextMove(Move.moveDown);
        }
        assertTrue(theField.getScore() == 20);
        theField.timeout();
        for (int i = 0; i < 10; i++){
            theField.nextMove(Move.moveDown);
        }
        assertTrue(theField.getScore() == 30);
    }
}

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
        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);

        assertEquals(theField.getWidth(), 10);
    }

    @Test
    void getHeight() {
        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector(), 10, 20);

        assertEquals(theField.getHeight(), 20);
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

        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());
        int originalX = theField.getCurrentPiece().getX();
        for (int i = 1; i <= 3; i++){
            theField.nextMove(Move.moveLeft);
            assertTrue(theField.getCurrentPiece().getX() == originalX - i);
        }
    }

    @Test
    void moveRight() {

        PieceFactory factory = new IPieceFactory();
        PlayingField theField = new PlayingField(factory, new NullResultCollector());
        int originalX = theField.getCurrentPiece().getX();
        for (int i = 1; i <= 3; i++){
            theField.nextMove(Move.moveRight);
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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Piece.*;

class PieceTest {

    static Piece p;
    static PlayingField pf;

    @BeforeAll
     static void createPiece () {
        p = new IPiece();
        p.setX(22);
        p.setY(12);
    }

    @Test
    void getTotalPieces() {
        assertEquals(Piece.getTotalPieces(), 7);
    }

    @Test
    void getX() {
        Piece p = new IPiece();
        p.setX(3);
        assertEquals(p.getX(), 3);

    }

    @Test
    void getY() {
        Piece p = new IPiece();
        p.setY(5);
        assertEquals(p.getY(), 5);
    }

    @Test
    void moveLeft() {
        Piece p = new IPiece();
        p.setX(3);

        int x = p.getX();
        p.moveLeft();
        assertEquals (p.getX(), x - 1);
    }

    @Test
    void moveRight() {
        Piece p = new IPiece();
        p.setX(3);

        int x = p.getX();
        p.moveRight();
        assertEquals (p.getX(), x + 1);
    }

    @Test
    void moveDown() {
        Piece p = new IPiece();
        p.setY(3);

        int y = p.getY();
        p.moveDown();
        assertEquals (p.getY(), y + 1);
    }

    @Test
    void moveUp() {
        Piece p = new IPiece();
        p.setY(3);

        int y = p.getY();
        p.moveUp();
        assertEquals (p.getY(), y - 1);
    }

    @Test
    void getType() {
        Piece p;
        p = new IPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_I);
        p = new TPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_T);
        p = new LPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_L);
        p = new JPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_J);
        p = new OPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_O);
        p = new SPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_S);
        p = new ZPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_Z);
    }

    @Test
    void testMoveThreeTimes() {
        Piece p = new IPiece(); 
        p.setY(4);
        p.moveDown();
        p.moveDown(); 
        p.moveDown(); 
        // 4 + 3 = 7
        assertEquals (p.getY(), 7);
    }

    @Test
    void rotateLeft() {
        Piece p = new ZPiece();
        p.rotateLeft();
        assertEquals(p.getRotation(), 3);
    }

    @Test
    void rotateRight() {
        Piece p = new ZPiece();
        p.rotateRight();
        assertEquals(p.getRotation(), 1);
    }

    @Test
    void isCovering() {
        Piece p = new IPiece();
        for (int i = 0; i < 4; i++){
            assertEquals(p.isCovering(i, 1), true);
        }
        p.rotateRight();
        for (int i = 0; i < 4; i++){
            assertEquals(p.isCovering(2, i), true);
        }
        p = new SPiece();
        assertEquals(p.isCovering(0, 1), true);
        assertEquals(p.isCovering(1, 1), true);
        assertEquals(p.isCovering(1, 0), true);
        assertEquals(p.isCovering(2, 0), true);
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

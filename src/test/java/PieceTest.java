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
        Piece p = new IPiece();
        p.rotateLeft();
        assertTrue(p.isCovering(2,0));
		assertTrue(p.isCovering(2,1));
		assertTrue(p.isCovering(2,2));
		assertTrue(p.isCovering(2,3));
		p.rotateLeft();
		assertTrue(p.isCovering(0,2));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(2,2));
		assertTrue(p.isCovering(3,2));
		p.rotateLeft();
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(1,3));
		
		p = new JPiece();
		p.rotateLeft();
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(2,0));
		p.rotateLeft();
		assertTrue(p.isCovering(0,1));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(2,1));
		assertTrue(p.isCovering(2,2));
		p.rotateLeft();
		assertTrue(p.isCovering(0,2));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,0));
		
		p = new LPiece();
		p.rotateLeft();
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(2,2));
		p.rotateLeft();
		assertTrue(p.isCovering(0,2));
		assertTrue(p.isCovering(0,1));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(2,1));
		p.rotateLeft();
		assertTrue(p.isCovering(0,0));
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		
		p = new OPiece();
		p.rotateLeft();
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(2,1));
		assertTrue(p.isCovering(2,0));
		
		p = new SPiece();
		p.rotateLeft();
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(2,1));
		assertTrue(p.isCovering(2,2));
		p.rotateLeft();
		assertTrue(p.isCovering(0,2));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(2,1));
		p.rotateLeft();
		assertTrue(p.isCovering(0,0));
		assertTrue(p.isCovering(0,1));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		
		p = new ZPiece();
		p.rotateLeft();
		assertTrue(p.isCovering(2,0));
		assertTrue(p.isCovering(2,1));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		p.rotateLeft();
		assertTrue(p.isCovering(0,1));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(2,2));
		p.rotateLeft();
		assertTrue(p.isCovering(0,1));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(0,1));
		assertTrue(p.isCovering(0,2));
		
		p = new TPiece();
		p.rotateLeft();
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(2,1));
		p.rotateLeft();
		assertTrue(p.isCovering(0,0));	
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(2,0));
		assertTrue(p.isCovering(1,1));
		p.rotateLeft();
		assertTrue(p.isCovering(0,1));	
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
			
    }

    @Test
    void rotateRight() {
        Piece p = new IPiece();
        p.rotateRight();
        assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(1,3));
		
		p = new JPiece();
		p.rotateRight();
		assertTrue(p.isCovering(0,2));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,0));
		
		p = new LPiece();
		p.rotateRight();
		assertTrue(p.isCovering(0,0));
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		
		p = new OPiece();
		p.rotateRight();
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(2,1));
		assertTrue(p.isCovering(2,0));
		
		p = new SPiece();
		p.rotateRight();
		assertTrue(p.isCovering(0,0));
		assertTrue(p.isCovering(0,1));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		
		p = new ZPiece();
		p.rotateRight();
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(0,1));
		assertTrue(p.isCovering(0,2));
		
		p = new TPiece();
		p.rotateRight();
		assertTrue(p.isCovering(1,0));
		assertTrue(p.isCovering(1,1));
		assertTrue(p.isCovering(1,2));
		assertTrue(p.isCovering(0,1));
    }

    @Test
    void isCovering() {
		Piece p = new IPiece();
        for (int i = 0; i < 4; i++){
            assertFalse(p.isCovering(i, 0));
			assertFalse(p.isCovering(i, 2));
			assertFalse(p.isCovering(i, 3));
        }
		
		p = new JPiece();
		assertFalse(p.isCovering(1, 0));
		assertFalse(p.isCovering(2, 0));
		assertFalse(p.isCovering(3, 0));
		assertFalse(p.isCovering(3, 1));
		for (int i = 0; i < 4; i++){
			assertFalse(p.isCovering(i, 2));
			assertFalse(p.isCovering(i, 3));
        }
		
		p = new LPiece();
		assertFalse(p.isCovering(0, 0));
		assertFalse(p.isCovering(1, 0));
		assertFalse(p.isCovering(3, 0));
		assertFalse(p.isCovering(3, 1));
		for (int i = 0; i < 4; i++){
			assertFalse(p.isCovering(i, 2));
			assertFalse(p.isCovering(i, 3));
        }

        p = new OPiece();
		assertFalse(p.isCovering(0, 0));
		assertFalse(p.isCovering(0, 1));
		assertFalse(p.isCovering(3, 0));
		assertFalse(p.isCovering(3, 1));
		for (int i = 0; i < 4; i++){
			assertFalse(p.isCovering(i, 2));
			assertFalse(p.isCovering(i, 3));
        }
		
		p = new SPiece();
		assertFalse(p.isCovering(0, 0));
		assertFalse(p.isCovering(3, 0));
		assertFalse(p.isCovering(2, 1));
		assertFalse(p.isCovering(3, 1));
		for (int i = 0; i < 4; i++){
			assertFalse(p.isCovering(i, 2));
			assertFalse(p.isCovering(i, 3));
        }
		
		p = new ZPiece();
		assertFalse(p.isCovering(0, 2));
		assertFalse(p.isCovering(0, 3));
		assertFalse(p.isCovering(0, 1));
		assertFalse(p.isCovering(3, 1));
		for (int i = 0; i < 4; i++){
			assertFalse(p.isCovering(i, 2));
			assertFalse(p.isCovering(i, 3));
        }
		
		p = new TPiece();
		assertFalse(p.isCovering(0, 0));
		assertFalse(p.isCovering(0, 2));
		assertFalse(p.isCovering(0, 3));
		assertFalse(p.isCovering(3, 1));
		for (int i = 0; i < 4; i++){
			assertFalse(p.isCovering(i, 2));
			assertFalse(p.isCovering(i, 3));
        }
    }
}

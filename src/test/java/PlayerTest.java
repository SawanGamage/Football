import backend.people.Player;
import org.junit.jupiter.api.Test;
import backend.shared.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {
    // Complete the plusMinus function below.

    @Test
    public void testFirst() {
        System.out.println("success");
        assertTrue(true);
    }
    @Test
    public void testCalcDistance1() {
        Player player = new Player("Kamal");
        Position initPosition = new Position(1, 2);
        Position endPosition = new Position(10, 2);
        double testDistance = player.calcDistance(initPosition, endPosition);
        assertEquals(9, testDistance);
    }
    @Test
    public void testCalcDistance2() {
        Player player = new Player("Kamal");
        Position initPosition = new Position(0, 0);
        Position endPosition = new Position(1, 20);
        double testDistance = player.calcDistance(initPosition, endPosition);
        assertEquals(Math.sqrt(401), testDistance);
    }
    @Test
    public void testCalcDistance3() {
        Player player = new Player("Kamal");
        Position initPosition = new Position(1, 1);
        Position endPosition = new Position(2, 2);
        double testDistance = player.calcDistance(initPosition, endPosition);
        assertEquals(Math.sqrt(2), testDistance);
    }
    @Test
    public void testCalcPosition() {

        Player player = new Player("Kamal");
        Position initPosition = new Position(3, 4);
        Position endPosition = new Position(0, 0);
        Position newPlayerPosition = player.calcPosition(initPosition, endPosition, 2);

    }
    @Test
    public void testCalcDistance4() {
        Player player = new Player("Kamal");
        Position initPosition = new Position(0, 0);
        Position endPosition = new Position(3, 4);
        double testDistance = player.calcDistance(initPosition, endPosition);
        assertEquals(5, testDistance);
    }

    @Test
    public void testCalcPosition6() {

        Player player = new Player("Kamal");
        Position initPosition = new Position(0, 0);
        Position endPosition = new Position(0, 5);
        Position newPlayerPosition = player.calcPosition(initPosition, endPosition, 2);
        assertEquals(0, newPlayerPosition.getX());
        assertEquals(2, newPlayerPosition.getY());
    }

    @Test
    public void testCalcPosition7() {

        Player player = new Player("Kamal");
        Position initPosition = new Position(0, 5);
        Position endPosition = new Position(0, 0);
        Position newPlayerPosition = player.calcPosition(initPosition, endPosition, 2);
        assertEquals(0, newPlayerPosition.getX());
        assertEquals(3, newPlayerPosition.getY());
    }

    @Test
    public void testCalcPosition8() {

        Player player = new Player("Kamal");
        Position initPosition = new Position(0, 0);
        Position endPosition = new Position(5, 0);
        Position newPlayerPosition = player.calcPosition(initPosition, endPosition, 2);
        assertEquals(2, newPlayerPosition.getX());
        assertEquals(0, newPlayerPosition.getY());
    }

    @Test
    public void testCalcPosition9() {

        Player player = new Player("Kamal");
        Position initPosition = new Position(5, 0);
        Position endPosition = new Position(0, 0);
        Position newPlayerPosition = player.calcPosition(initPosition, endPosition, 2);
        assertEquals(3, newPlayerPosition.getX());
        assertEquals(0, newPlayerPosition.getY());
    }
    @Test //1. (x1 > x3 && y1 > y3)
    public void testCalcPosition10() {

        Player player = new Player("Kamal");
        Position initPosition = new Position(2, 3);
        Position endPosition = new Position(-1, -1);
        Position newPlayerPosition = player.calcPosition(initPosition, endPosition, 2);

    }

    @Test //2. (x1 < x3 && y1 > y3)
    public void testCalcPosition11() {

        Player player = new Player("Kamal");
        Position initPosition = new Position(-2, -1);
        Position endPosition = new Position(1, -5);
        Position newPlayerPosition = player.calcPosition(initPosition, endPosition, 2);

    }

    @Test //2. (x1 > x3 && y1 < y3)
    public void testCalcPosition12() {

        Player player = new Player("Kamal");
        Position initPosition = new Position(1, -5);
        Position endPosition = new Position(-2, -1);
        Position newPlayerPosition = player.calcPosition(initPosition, endPosition, 2);

    }

    @Test
    public void testRandom(){
        Player player = new Player("Kamal");
        int x = player.getRandomDoubleBetweenRange(1,9);
        System.out.println(x);

    }

}




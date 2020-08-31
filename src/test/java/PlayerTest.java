import backend.people.Player;
import org.junit.jupiter.api.Test;
import sample.Position;

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
        assertEquals(18, testDistance);
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
        Position initPosition = new Position(0, 0);
        Position endPosition = new Position(3, 4);
        Position newPlayerPosition = player.calcPosition(initPosition, endPosition,2.5);
        assertEquals(2, newPlayerPosition.getY());
        assertEquals(1.5, newPlayerPosition.getX());
    }

    @Test
    public void testCalcDistance4() {
        Player player = new Player("Kamal");
        Position initPosition = new Position(0, 0);
        Position endPosition = new Position(3, 4);
        double testDistance = player.calcDistance(initPosition, endPosition);
        assertEquals(5, testDistance);
    }






}




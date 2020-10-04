package datatransfer;

public class PositionData {
    private Coordinate ballCoordinate;
    private Coordinate redPlayerCoordinate;
    private Coordinate bluePlayerCoordinate;

    public PositionData(Coordinate ballCoordinate, Coordinate redPlayerCoordinate, Coordinate bluePlayerCoordinate) {
        this.ballCoordinate = ballCoordinate;
        this.redPlayerCoordinate = redPlayerCoordinate;
        this.bluePlayerCoordinate = bluePlayerCoordinate;
    }

    public Coordinate getBallCoordinate() {
        return ballCoordinate;
    }

    public Coordinate getRedPlayerCoordinate() {
        return redPlayerCoordinate;
    }

    public Coordinate getBluePlayerCoordinate() {
        return bluePlayerCoordinate;
    }
}

package sample;

public class GallCourt {
    private int length;
    private int width;
    private Position gcPosition;

    public Position getgcPosition() {
        return gcPosition;
    }

    public void setGCPosition(Position gcPosition) {
        this.gcPosition = gcPosition;
    }

    public GallCourt(int length, int width, Position gcPosition) {
        this.length = length;
        this.width = width;
        this.gcPosition = gcPosition;
    }
}

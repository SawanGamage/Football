package backend.objects;

import backend.shared.Position;

public class GallCourt {
    private Position gcPosition;

    public Position getgcPosition() {
        return gcPosition;
    }

    public void setGCPosition(Position gcPosition) {
        this.gcPosition = gcPosition;
    }

    public GallCourt(Position gcPosition) {
        this.gcPosition = gcPosition;
    }
}

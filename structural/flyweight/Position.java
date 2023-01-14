package structural.flyweight;

public class Position {
    public float longitude;
    public float latitude;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }

        Position position = (Position) obj;
        if (position.latitude != latitude) {
            return false;
        }
        if (position.longitude != longitude) {
            return false;
        }
        return true;
    }
}

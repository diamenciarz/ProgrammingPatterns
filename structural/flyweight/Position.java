package structural.flyweight;

public class Position {
    public float longitude;
    public float latitude;

    public Position(float longitude, float latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void moveBy(Position deltaPosition){
        longitude += deltaPosition.longitude;
        latitude += deltaPosition.latitude;
    }
    
    public void moveTo(Position targetPosition){
        longitude = targetPosition.longitude;
        latitude = targetPosition.latitude;
    }
    @Override
    public String toString(){
        return "(Longitude: " + longitude + " latitude: " + latitude + ")";
    }

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

public class Apartment {
    private int no;
    private double square;
    private int floor;
    private int roomNumber;
    private String buildingType;
    private double lifetime;

    public Apartment() {
        buildingType = "";
    }

    public Apartment(int no, double square, int floor, int roomNumber, String buildingType, double lifetime) {
        this.no = no;
        this.square = square;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.buildingType = buildingType;
        this.lifetime = lifetime;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public double getLifetime() {
        return lifetime;
    }

    public void setLifetime(double lifetime) {
        this.lifetime = lifetime;
    }

    @Override
    public String toString() {
        return String.format("| %4d | %8.2f | %5d | %12d | %20s | %8.2f", no, square, floor, roomNumber, buildingType, lifetime);
    }
}

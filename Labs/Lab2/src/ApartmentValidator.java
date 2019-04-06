public class ApartmentValidator {
    public boolean isValidRoomNumber(int roomNumber) {
        return roomNumber > 0;
    }

    public boolean isValidFloor(int floor) {
        return floor > 0;
    }

    public boolean isValidSquare(double square) {
        return square > 0;
    }
}
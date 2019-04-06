public interface ApartmentsModel {
    void addApartment(Apartment apartment);
    void removeAtApartment(int index);
    Apartment[] getApartments() throws EmptyDataException;
    Apartment[] getApartments(int roomNumber) throws EmptyDataException, IncorrectRoomNumberException;
    Apartment[] getApartments(double moreThanSquare, int higherThanFloor) throws EmptyDataException, IncorrectSquareException, IncorrectFloorException;
}

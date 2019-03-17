public interface ApartmentsModel {
    void addApartment(Apartment apartment);
    void removeAtApartment(int index);
    Apartment[] getApartments();
    Apartment[] getApartments(int roomNumber);
    Apartment[] getApartments(double moreThanSquare, int higherThanFloor);
}

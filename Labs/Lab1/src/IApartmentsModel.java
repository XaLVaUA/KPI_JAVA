public interface IApartmentsModel {
    public void recreateAppartments(int len);
    public void addApartment(Apartment apartment);
    public int getLastApartmentIndex();
    public Apartment[] getApartments();
    public Apartment[] getApartments(int roomNumber);
    public Apartment[] getApartments(double moreThanSquare, int higherThanFloor);
}

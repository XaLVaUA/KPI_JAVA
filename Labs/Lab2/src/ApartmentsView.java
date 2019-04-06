public interface ApartmentsView {
    void showMessage(String message);
    void showMessageLine(String message);
    void showErrorMessage(String message);
    void showEmpty();
    void drawDivisionLine(int len);
    void showApartment(Apartment apartment);
    void showApartments(Apartment[] apartments);
}

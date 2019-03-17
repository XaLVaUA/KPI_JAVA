public interface ApartmentsView {
    void showApartment(Apartment apartment);
    void showApartments(Apartment[] apartments);
    void showMessage(String message);
    void showErrorMessage(String message);
    void showEmpty();
    void drawDivisionLine(int len);
}

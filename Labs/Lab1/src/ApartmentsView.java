public class ApartmentsView implements IApartmentView {
    public void showApartment(Apartment apartment) {
        System.out.println(apartment.toString());
    }

    public void showApartments(Apartment[] apartments) {
        for (int i = 0; i < apartments.length; ++i) {
            System.out.println(apartments[i].toString());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showErrorMessage(String message) {
        System.err.println(message);
    }
}

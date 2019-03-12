public class ApartmentsModel implements IApartmentsModel {
    private Apartment[] apartments;
    private int lastApartmentIndex;

    public ApartmentsModel() {
        apartments = null;
        lastApartmentIndex = 0;
    }

    public ApartmentsModel(int len) {
        recreateAppartments(len);
    }

    public void recreateAppartments(int len) {
        apartments = new Apartment[len];
        lastApartmentIndex = 0;
    }

    private boolean checkIndex(int index) {
        return index < apartments.length;
    }

    public void addApartment(Apartment apartment) {
        if(!checkIndex(lastApartmentIndex)) return;
        apartments[lastApartmentIndex++] = apartment;
    }

    public Apartment[] getApartments(int roomNumber) {
        int lastCorIndex = 0;
        int[] indexes = new int[apartments.length];

        for(int i = 0; i < lastApartmentIndex; ++i) {
            if(apartments[i].getRoomNumber() == roomNumber) {
                indexes[lastCorIndex++] = i;
            }
        }

        if(!(indexes.length > 0)) return null;
        Apartment[] aparts = new Apartment[lastCorIndex];

        for (int i = 0; i < lastCorIndex; ++i) {
            aparts[i] = apartments[indexes[i]];
        }

        return aparts;
    }

    public Apartment[] getApartments(double moreThanSquare, int higherThanFloor) {
        int lastCorIndex = 0;
        int[] indexes = new int[apartments.length];

        for(int i = 0; i < lastApartmentIndex; ++i) {
            if(apartments[i].getSquare() > moreThanSquare && apartments[i].getFloor() > higherThanFloor) {
                indexes[lastCorIndex++] = i;
            }
        }

        if(!(indexes.length > 0)) return null;
        Apartment[] aparts = new Apartment[lastCorIndex];

        for (int i = 0; i < lastCorIndex; ++i) {
            aparts[i] = apartments[indexes[i]];
        }

        return aparts;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }

    public int getLastApartmentIndex() {
        return lastApartmentIndex;
    }

    public void setLastApartmentIndex(int lastApartmentIndex) {
        this.lastApartmentIndex = lastApartmentIndex;
    }
}
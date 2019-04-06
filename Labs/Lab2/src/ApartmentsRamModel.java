public class ApartmentsRamModel implements ApartmentsModel {
    private final int CAPACITY_MULTIPLIER = 2;
    private final int DEFAULT_CAPACITY = 4;
    private Apartment[] apartments;
    private int lastApartmentIndex;

    public ApartmentsRamModel() { createAppartments(DEFAULT_CAPACITY); }
    public ApartmentsRamModel(int len) {
        createAppartments(len);
    }

    private void createAppartments(int len) {
        apartments = new Apartment[len];
        lastApartmentIndex = 0;
    }

    private void addCapacity() {
        Apartment[] aps = new Apartment[apartments.length * CAPACITY_MULTIPLIER];
        System.arraycopy(apartments, 0, aps, 0, apartments.length);
        apartments = aps;
    }

    private void optimizeMemory() {
        if(!(apartments.length - lastApartmentIndex > CAPACITY_MULTIPLIER * lastApartmentIndex)) return;
        int size = lastApartmentIndex + DEFAULT_CAPACITY * CAPACITY_MULTIPLIER;
        Apartment[] aps = new Apartment[size];
        System.arraycopy(apartments, 0, aps, 0, apartments.length);
        apartments = aps;
    }

    private boolean checkIndex(int index) {
        return index < apartments.length;
    }

    @Override
    public void addApartment(Apartment apartment) {
        if(!checkIndex(lastApartmentIndex)) {
            addCapacity();
        }
        apartments[lastApartmentIndex++] = apartment;
    }

    @Override
    public void removeAtApartment(int index) {
        System.arraycopy(apartments, index + 1, apartments, index, apartments.length - index - 1);
        --lastApartmentIndex;
    }

    @Override
    public Apartment[] getApartments(int roomNumber) throws EmptyDataException, IncorrectRoomNumberException {
        if(lastApartmentIndex == 0) {
            throw new EmptyDataException();
        }

        if(!(roomNumber > 0)) {
            throw new IncorrectRoomNumberException(roomNumber);
        }

        int lastCorIndex = 0;
        Apartment[] aps = new Apartment[apartments.length];

        for(int i = 0; i < lastApartmentIndex; ++i) {
            if(apartments[i].getRoomNumber() == roomNumber) {
                aps[lastCorIndex++] = apartments[i];
            }
        }

        Apartment[] aparts = new Apartment[lastCorIndex];
        System.arraycopy(aps, 0, aparts, 0, lastCorIndex);

        return aparts;
    }

    @Override
    public Apartment[] getApartments(double moreThanSquare, int higherThanFloor) throws EmptyDataException, IncorrectSquareException, IncorrectFloorException {
        if(lastApartmentIndex == 0) {
            throw new EmptyDataException();
        }

        if(!(moreThanSquare > 0)) {
            throw new IncorrectSquareException(moreThanSquare);
        }

        if(!(higherThanFloor > 0)) {
            throw new IncorrectFloorException(higherThanFloor);
        }

        int lastCorIndex = 0;
        Apartment[] aps = new Apartment[apartments.length];

        for(int i = 0; i < lastApartmentIndex; ++i) {
            if(apartments[i].getSquare() > moreThanSquare && apartments[i].getFloor() > higherThanFloor) {
                aps[lastCorIndex++] = apartments[i];
            }
        }

        Apartment[] aparts = new Apartment[lastCorIndex];
        System.arraycopy(aps, 0, aparts, 0, lastCorIndex);

        return aparts;
    }

    @Override
    public Apartment[] getApartments() throws EmptyDataException {
        if(lastApartmentIndex == 0) {
            throw new EmptyDataException();
        }

        Apartment[] aps = new Apartment[lastApartmentIndex];
        System.arraycopy(apartments, 0, aps, 0, lastApartmentIndex);
        return aps;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }
}
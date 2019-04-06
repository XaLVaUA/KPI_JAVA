import org.jetbrains.annotations.NotNull;

public class ApartmentsController {
    private final int DIVISION_LINE_LEN = 10;
    private ApartmentsModel model;
    private ApartmentsView view;
    private InputReader inputReader;
    private ApartmentValidator validator;

    public ApartmentsController() {
        model = new ApartmentsRamModel();
        view = new ApartmentsConsoleView();
        inputReader = new InputConsoleReader();
        validator = new ApartmentValidator();
    }

    public void run() {
        taskMenu();
    }

    private void printTaskMenu() {
        view.drawDivisionLine(DIVISION_LINE_LEN);
        view.showMessageLine("1. Fill test data");
        view.showMessageLine("2. Show all apartments");
        view.showMessageLine("3. Number of rooms");
        view.showMessageLine("4. More than square and higher than floor");
        view.showMessageLine("5. Exit");
    }

    private void taskMenu() {
        int choice = -1;
        boolean inMenu = true;

        while (inMenu) {
            printTaskMenu();
            view.showMessage("> ");

            try {
                choice = inputReader.getInt();
            } catch (NumberFormatException e) {
                view.showErrorMessage("Wrong input");
                continue;
            }

            switch (choice) {
                case 1:
                    fillTestData();
                    view.showMessageLine("Filled");
                    break;
                case 2:
                    showAllApartments();
                    break;
                case 3:
                    task1();
                    break;
                case 4:
                    task2();
                    break;
                case 5:
                    inMenu = false;
                    break;
                default:
                    view.showErrorMessage("Wrong number");
                    break;
            }
        }
    }

    private void showOrEmpty(@NotNull Apartment[] apartments) {
        if (apartments.length > 0)
            view.showApartments(apartments);
        else {
            view.showEmpty();
        }
    }

    private void showAllApartments() {
        Apartment[] result;
        view.drawDivisionLine(DIVISION_LINE_LEN);
        try {
            result = model.getApartments();
        } catch (EmptyDataException e) {
            view.showErrorMessage(e.getMessage());
            return;
        }

        showOrEmpty(result);
    }

    private void task1() {
        int roomNumber;

        do {
            roomNumber = getIntMenu("Room number: ");
        } while (!validator.isValidRoomNumber(roomNumber));

        Apartment[] result;

        try {
            result = model.getApartments(roomNumber);
        } catch (EmptyDataException | NotHigherZeroException e) {
            view.showErrorMessage(e.getMessage());
            return;
        }

        showOrEmpty(result);
    }

    private void task2() {
        double moreThanSquare;
        int higherThanFloor;

        do {
            moreThanSquare = getDoubleMenu("More than square: ");
        } while (!validator.isValidSquare(moreThanSquare));

        do {
            higherThanFloor = getIntMenu("Higher than floor: ");
        } while (!validator.isValidFloor(higherThanFloor));

        Apartment[] result;

        try {
            result = model.getApartments(moreThanSquare, higherThanFloor);
        } catch (EmptyDataException | NotHigherZeroException e) {
            view.showErrorMessage(e.getMessage());
            return;
        }

        showOrEmpty(result);
    }

    private int getIntMenu(String label)
    {
        int num = 0;
        boolean inLoop = true;

        while (inLoop) {
            view.drawDivisionLine(DIVISION_LINE_LEN);
            view.showMessage(label);
            try {
                num = inputReader.getInt();
                inLoop = false;
            } catch (NumberFormatException e) {
                view.showErrorMessage("Wrong input");
                continue;
            }
        }

        return num;
    }

    private double getDoubleMenu(String label)
    {
        double num = 0;
        boolean inLoop = true;

        while (inLoop) {
            view.drawDivisionLine(DIVISION_LINE_LEN);
            view.showMessage(label);
            try {
                num = inputReader.getDouble();
                inLoop = false;
            } catch (NumberFormatException e) {
                view.showErrorMessage("Wrong input");
                continue;
            }
        }

        return num;
    }

    public void fillTestData() {
        model.addApartment(new Apartment(1, 30, 1, 2, "Mid-rise", 3));
        model.addApartment(new Apartment(2, 35, 1, 2, "Mid-rise", 4));
        model.addApartment(new Apartment(3, 45, 2, 3, "Mid-rise", 3));
        model.addApartment(new Apartment(4, 45, 2, 3, "Mid-rise", 5));
        model.addApartment(new Apartment(5, 60, 3, 3, "Mid-rise", 2));
        model.addApartment(new Apartment(6, 30, 3, 2, "Mid-rise", 4));
        model.addApartment(new Apartment(7, 20, 4, 1, "Mid-rise", 3));
        model.addApartment(new Apartment(8, 40, 4, 3, "Mid-rise", 6));
        model.addApartment(new Apartment(9, 70, 5, 4, "Mid-rise", 5));
        model.addApartment(new Apartment(10, 90, 6, 5, "Mid-rise", 1));
    }

    private void addApartment(Apartment apartment) {
        model.addApartment(apartment);
    }

    @Deprecated
    public void egg() {
        //test features
    }
}

import java.util.Scanner;

public class ApartmentsController {
    private final int DIVISION_LINE_LEN = 10;
    private ApartmentsModel model;
    private ApartmentsView view;
    private InputReader inputReader;

    public ApartmentsController() {
        model = new ApartmentsRamModel();
        view = new ApartmentsConsoleView();
        inputReader = new InputConsoleReader();
    }

    public void run() {
        taskMenu();
    }

    private void printTaskMenu() {
        view.drawDivisionLine(DIVISION_LINE_LEN);
        view.showMessage("1 - fill test data");
        view.showMessage("2 - show all apartments");
        view.showMessage("3 - number of rooms");
        view.showMessage("4 - more than square and higher than floor");
        view.showMessage("5 - exit");
    }

    private void taskMenu() {
        int choice = -1;
        boolean inMenu = true;

        while (inMenu) {
            printTaskMenu();

            try {
                choice = inputReader.getInt();
            } catch (NumberFormatException e) {
                view.showErrorMessage("Wrong input");
                continue;
            }

            switch (choice) {
                case 1:
                    fillTestData();
                    view.showMessage("Filled");
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

    private void showOrEmpty(Apartment[] apartments) {
        if (apartments.length > 0)
            view.showApartments(apartments);
        else {
            view.showEmpty();
        }
    }

    private void showAllApartments() {
        view.drawDivisionLine(DIVISION_LINE_LEN);
        Apartment[] result = model.getApartments();
        showOrEmpty(result);
    }

    private void task1() {
        int roomNumber = 0;
        boolean inLoop = true;

        while (inLoop) {
            view.drawDivisionLine(DIVISION_LINE_LEN);
            view.showMessage("Number of rooms: ");

            try {
                roomNumber = inputReader.getInt();
                inLoop = false;
            } catch (NumberFormatException e) {
                view.showErrorMessage("Wrong input");
                continue;
            }
        }

        Apartment[] result = model.getApartments(roomNumber);
        showOrEmpty(result);
    }

    private void task2() {
        boolean inLoop = true;
        int moreThanSquare = 0;
        int higherThanFloor = 0;

        while (inLoop) {
            view.drawDivisionLine(DIVISION_LINE_LEN);
            view.showMessage("More than square: ");
            try {
                moreThanSquare = inputReader.getInt();
                inLoop = false;
            } catch (NumberFormatException ex) {
                view.showErrorMessage("Wrong input");
                continue;
            }
        }

        inLoop = true;
        while (inLoop) {
            view.drawDivisionLine(DIVISION_LINE_LEN);
            view.showMessage("Higher than floor: ");
            try {
                higherThanFloor = inputReader.getInt();
                inLoop = false;
            } catch (NumberFormatException ex) {
                view.showErrorMessage("Wrong input");
                continue;
            }
        }

        Apartment[] result = model.getApartments(moreThanSquare, higherThanFloor);
        showOrEmpty(result);
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

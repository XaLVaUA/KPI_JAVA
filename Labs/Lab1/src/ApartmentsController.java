import java.util.InputMismatchException;
import java.util.Scanner;

public class ApartmentsController {
    private IApartmentsModel model;
    private IApartmentView view;
    private Scanner scanner;

    public ApartmentsController() {
        model = new ApartmentsModel();
        view = new ApartmentsView();
        scanner = new Scanner(System.in);
    }

    public void run() {
        taskMenu();
    }

    private void taskMenu() {
        boolean inMenu = true;
        int choice = -1;

        while (inMenu) {
            view.showMessage("----------");
            view.showMessage("1 - show all apartments");
            view.showMessage("2 - number of rooms");
            view.showMessage("3 - more than square and higher than floor");
            view.showMessage("4 - exit");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    showAllApartments();
                    break;
                case 2:
                    task1();
                    break;
                case 3:
                    task2();
                    break;
                case 4:
                    inMenu = false;
                    break;
                default:
                    view.showErrorMessage("Wrong input");
                    break;
            }
        }
    }

    private void showAllApartments() {
        view.showMessage("----------");

        Apartment[] result = model.getApartments();
        view.showApartments(result);
    }

    private void task1() {
        boolean inMenu = true;
        int roomNumber = 0;

        while (inMenu) {
            view.showMessage("----------");
            view.showMessage("Number of rooms: ");
            try {
                roomNumber = Integer.parseInt(scanner.nextLine());
                inMenu = false;
            } catch (NumberFormatException ex) {
                view.showErrorMessage("Wrong input");
                continue;
            }
        }

        Apartment[] result = model.getApartments(roomNumber);
        view.showApartments(result);
    }

    private void task2() {
        boolean inMenu = true;
        int moreThanSquare = 0;
        int higherThanFloor = 0;

        while (inMenu) {
            view.showMessage("----------");
            view.showMessage("More than square: ");
            try {
                moreThanSquare = Integer.parseInt(scanner.nextLine());
                inMenu = false;
            } catch (NumberFormatException ex) {
                view.showErrorMessage("Wrong input");
                continue;
            }
        }

        inMenu = true;
        while (inMenu) {
            view.showMessage("----------");
            view.showMessage("Higher than floor: ");
            try {
                higherThanFloor = Integer.parseInt(scanner.nextLine());
                inMenu = false;
            } catch (NumberFormatException ex) {
                view.showErrorMessage("Wrong input");
                continue;
            }
        }

        Apartment[] result = model.getApartments(moreThanSquare, higherThanFloor);
        view.showApartments(result);
    }

    public void fillTestData() {
        model.recreateAppartments(10);
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
}

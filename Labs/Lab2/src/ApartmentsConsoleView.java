import java.io.PrintStream;

public class ApartmentsConsoleView implements ApartmentsView {
    private PrintStream printer;
    private PrintStream errorPrinter;

    public ApartmentsConsoleView() {
        printer = System.out;
        errorPrinter = System.err;
    }

    @Override
    public void showApartment(Apartment apartment) {
        printer.println(apartment);
    }

    @Override
    public void showApartments(Apartment[] apartments) {
        printer.println(String.format("| %4s | %8s | %5s | %12s | %20s | %8s", "no", "square", "floor", "roomNumber", "buildingType", "lifetime"));
        for (int i = 0; i < apartments.length; ++i) {
            printer.println(apartments[i]);
        }
    }

    public void drawDivisionLine(int len) {
        StringBuilder str = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            str.append("-");
        }
        printer.println(str);
    }

    @Override
    public void showMessage(String message) {
        printer.print(message);
    }

    @Override
    public void showMessageLine(String message) {
        printer.println(message);
    }

    @Override
    public void showErrorMessage(String message) {
        errorPrinter.println(message);
    }

    @Override
    public void showEmpty() {
        printer.println(String.format("No information"));
    }
}

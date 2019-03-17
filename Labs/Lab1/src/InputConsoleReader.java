import java.util.Scanner;

public class InputConsoleReader implements InputReader {
    private Scanner scanner;

    public InputConsoleReader() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int getInt() throws NumberFormatException {
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }
}

public class NotHigherZeroException extends Exception {
    private String message;

    public NotHigherZeroException() {
        buildMessage();
    }

    public NotHigherZeroException(int number) {
        buildMessage(number);
    }

    public NotHigherZeroException(double number) {
        buildMessage(number);
    }

    protected void buildMessage() {
        message = "Incorrect number must be > 0";
    }

    protected void buildMessage(int number) {
        message = String.format("Incorrect number %s must be > 0", number);
    }

    protected void buildMessage(double number) {
        message = String.format("Incorrect number %s must be > 0", number);
    }

    public String getMessage() {
        return message;
    }
}

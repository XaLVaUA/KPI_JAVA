public class IncorrectSquareException extends NotHigherZeroException {
    private String message;

    public IncorrectSquareException() {
        buildMessage();
    }

    public IncorrectSquareException(double number) {
        buildMessage(number);
    }

    @Override
    protected void buildMessage() {
        message = "Incorrect square must be > 0";
    }

    @Override
    protected void buildMessage(double number) {
        message = String.format("Incorrect square %s must be > 0", number);
    }

    public String getMessage() {
        return message;
    }
}

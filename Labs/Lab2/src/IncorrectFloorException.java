public class IncorrectFloorException extends NotHigherZeroException {
    private String message;

    public IncorrectFloorException() {
        buildMessage();
    }

    public IncorrectFloorException(int number) {
        buildMessage(number);
    }

    @Override
    protected void buildMessage() {
        message = "Incorrect floor must be > 0";
    }

    @Override
    protected void buildMessage(int number) {
        message = String.format("Incorrect floor %s must be > 0", number);
    }

    public String getMessage() {
        return message;
    }
}

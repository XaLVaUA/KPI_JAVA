public class IncorrectRoomNumberException extends NotHigherZeroException {
    private String message;

    public IncorrectRoomNumberException() {
        buildMessage();
    }

    public IncorrectRoomNumberException(int number) {
        buildMessage(number);
    }

    @Override
    protected void buildMessage() {
        message = "Incorrect number of rooms must be > 0";
    }

    @Override
    protected void buildMessage(int number) {
        message = String.format("Incorrect number of rooms %s must be > 0", number);
    }

    public String getMessage() {
        return message;
    }
}

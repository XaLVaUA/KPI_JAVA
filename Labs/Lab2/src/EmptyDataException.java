public class EmptyDataException extends Exception {
    private String message;

    public EmptyDataException() {
        buildMessage("Empty data");
    }

    protected void buildMessage(String msg) {
        message = msg;
    }

    public String getMessage() {
        return message;
    }
}

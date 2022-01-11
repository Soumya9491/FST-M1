package activities;

public class CustomException extends Exception{
    private String message;
    public CustomException(String msg)
    {
        this.message = msg;
    }

    public String getMessage()
    {
        return message;
    }
}

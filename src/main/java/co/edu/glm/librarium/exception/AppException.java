package co.edu.glm.librarium.exception;

public class AppException extends RuntimeException{

    private final int code;
    public AppException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

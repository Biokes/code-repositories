package exceptions;

public class InvalidDetailsException extends RuntimeException{
    public InvalidDetailsException(){
        super("Invalid login Details");
    }
}

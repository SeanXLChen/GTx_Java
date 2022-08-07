
import java.io.InvalidObjectException;

public class InvalidPetException extends InvalidObjectException{
    public InvalidPetException() {
        this("Your pet is invalid!");
    }

    public InvalidPetException(String s) {
        super(s);
    }
}

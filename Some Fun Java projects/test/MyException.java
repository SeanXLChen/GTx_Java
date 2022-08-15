public class MyException extends Exception {
    MyException(int val) {
        super(val + " is too low");
    }
 } 

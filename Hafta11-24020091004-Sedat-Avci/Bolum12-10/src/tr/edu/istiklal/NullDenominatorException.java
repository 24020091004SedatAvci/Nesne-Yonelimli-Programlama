package tr.edu.istiklal;

public class NullDenominatorException extends Exception {
    public NullDenominatorException() {
        super("Payda 0 olamaz!");
    }

    public NullDenominatorException(String message) {
        super(message);
    }
}

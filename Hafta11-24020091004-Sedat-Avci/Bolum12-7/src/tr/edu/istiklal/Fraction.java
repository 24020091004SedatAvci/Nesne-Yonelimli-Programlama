package tr.edu.istiklal;




import tr.edu.istiklal.NullDenominatorException;


public class Fraction {

    private int pay;
    private int payda;

    public Fraction(int pay, int payda) throws NullDenominatorException {

        if (payda == 0) {
            throw new NullDenominatorException();
        }

        this.pay = pay;
        this.payda = payda;
    }
}
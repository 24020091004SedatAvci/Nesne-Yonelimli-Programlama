package tr.edu.istiklal;

public class ManuelKontrol {

    private String op1, op2, operator;

    public ManuelKontrol() {}

    public ManuelKontrol(String operator, String op1, String op2) {
        this.op1 = op1;
        this.op2 = op2;
        this.operator = operator;
    }

    public double HataYazdirma() {

        if (!isNumeric(op1) || !isNumeric(op2)) {
            throw new IllegalArgumentException("Wrong input: nonnumeric operand");
        }

        int a = Integer.parseInt(op1);
        int b = Integer.parseInt(op2);

        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return (double) a / b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) return false;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}

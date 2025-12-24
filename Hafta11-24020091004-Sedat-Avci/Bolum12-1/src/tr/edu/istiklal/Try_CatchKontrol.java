
package tr.edu.istiklal;

public class Try_CatchKontrol {
    private String operator,op1,op2;
        

public Try_CatchKontrol(){}
        
public Try_CatchKontrol(String operator, String op1, String op2){
    this.op1=op1;
    this.op2=op2;
    this.operator=operator;
}


public double HataYazdirma(){
        try {
            int a = Integer.parseInt(getOp1());
            int b = Integer.parseInt(getOp2());
            switch (getOperator()) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    return a / b;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }

        } catch (NumberFormatException e) {
            System.out.println("Wrong input: nonnumeric operand");
            System.exit(1);
        }
        return 0;
}

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return the op1
     */
    public String getOp1() {
        return op1;
    }

    /**
     * @param op1 the op1 to set
     */
    public void setOp1(String op1) {
        this.op1 = op1;
    }

    /**
     * @return the op2
     */
    public String getOp2() {
        return op2;
    }

    /**
     * @param op2 the op2 to set
     */
    public void setOp2(String op2) {
        this.op2 = op2;
    }


};

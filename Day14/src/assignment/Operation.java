package assignment;

import java.io.Serializable;

public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    private double number1;
    private double number2;
    private String operator;

    public Operation(double number1, double number2, String operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public String getOperator() {
        return operator;
    }
}

package Tema8;

public class OperatorHandle implements MathOperator {
    @Override
    public String canHandle(String operator) throws InvalidOperator {
        while (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            throw new InvalidOperator("Invalid input please enter a valid operator {+, -, *, /}");
        }
        return operator;
    }
}

package Tema8;

public class Calculator implements MathOperations<Double> {
    @Override
    public Double addition(Double num1, Double num2)throws DivideByZero {
        return num1+num2;
    }

    @Override
    public Double subtraction(Double num1, Double num2) {
        return num1-num2;
    }

    @Override
    public Double multiply(Double num1, Double num2) {
        return num1*num2;
    }

    @Override
    public Double divide(Double num1, Double num2) throws DivideByZero {
        if ( num2 == 0 ){
            throw new DivideByZero("You can not divide by zero ");
        }
        return num1/num2;
    }
}

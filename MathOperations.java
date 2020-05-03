package Tema8;

public interface MathOperations<T extends Number> {
    T addition(T num1, T num2);
    T subtraction(T num1, T num2);
    T multiply(T num1, T num2);
    T divide(T num1, T num2) throws DivideByZero;


}

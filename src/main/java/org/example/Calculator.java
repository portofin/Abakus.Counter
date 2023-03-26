package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Calculator {

    public static void main(String[] args) {
        double num1 = 10.5;
        double num2 = 5.5;

        double additionResult = add(num1, num2);
        double subtractionResult = subtract(num1, num2);
        double multiplicationResult = multiply(num1, num2);
        double divisionResult = divide(num1, num2);

        System.out.println("Addition Result: " + additionResult);
        System.out.println("Subtraction Result: " + subtractionResult);
        System.out.println("Multiplication Result: " + multiplicationResult);
        System.out.println("Division Result: " + divisionResult);
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }

        return num1 / num2;
    }

}


class CalculatorTest {

    @Test
    void testAdd() {
        double result = Calculator.add(10, 5);
        assertEquals(15, result);
    }

    @Test
    void testSubtract() {
        double result = Calculator.subtract(10, 5);
        assertEquals(5, result);
    }

    @Test
    void testMultiply() {
        double result = Calculator.multiply(10, 5);
        assertEquals(50, result);
    }

    @Test
    void testDivide() {
        double result = Calculator.divide(10, 5);
        assertEquals(2, result);
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.divide(10, 0);
        });
    }
}
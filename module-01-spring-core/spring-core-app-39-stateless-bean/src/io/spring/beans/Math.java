package io.spring.beans;

public class Math {
    // In this example, Math is a stateless bean because its methods do not rely on any internal state of the class. Each method call is independent and only depend on the arguments passed to it.

    public Math() {
        System.out.println("Math stateless bean created!");
    }

    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int subtract(int firstNumber, int secondNumber) {
        return secondNumber - firstNumber;
    }
}

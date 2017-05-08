package fundamentals.java.core;

import java.time.LocalDate;

public interface InterfaceMembers {
    // All fields in an interface are implicitly public, static, and final.
    int FIELD = 1;
}

interface Choices {
    public static final int YES = 1;
    public static final int NO = 2;
}

class ChoicesTest {
    public static void main(String[] args) {
        System.out.println("Choices.YES = " + Choices.YES);
        System.out.println("Choices.NO = " + Choices.NO);
    }
}

/**
 * Unlike static methods in a class, static methods in an interface are not inherited
 * by implementing classes or subinterfaces.
 */
interface MethodsDeclarations {
    // An abstract method
    int m1();

    // A static method
    static int m2() {
        return 1;
    }

    // A default method
    // All classes implementing the interface will inherit the default implementation
    default void m3() {
    }
}

class G implements MethodsDeclarations {
    public int m1() {
        return MethodsDeclarations.m2();
    }
    public static void main(String[] args) {
        System.out.println(new G().m1());
    }
}

/**
 * Nested Type Declarations
 */
class AccountNotFoundException extends Exception {
}
class InsufficientFundException extends Exception {
}
interface ATM {
    boolean login(int account) throws AccountNotFoundException;
    boolean deposit(double amount);
    boolean withdraw(double amount) throws InsufficientFundException;
    double getBalance();

    // Card is a nested interface. You can omit the keywors public and static.
    public static interface Card {
        String getNumber();
        String getSecurityCode();
        LocalDate getExpirationDate();
        String getCardHolderName();
    }
}
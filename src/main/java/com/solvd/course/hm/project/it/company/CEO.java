package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.exceptions.UnauthorizedAccessException;
import com.solvd.course.hm.project.it.company.interfaces.CEOActions;
import com.solvd.course.hm.project.it.company.interfaces.TeamMember;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public final class CEO extends Person implements CEOActions, TeamMember {
    private static final int SHARE_PRICE = 100;
    private static int totalCEOs = 0;

    static {
        totalCEOs++;
    }

    private final int secretCode = 123;
    private int shares;

    public CEO(String name, int shares) {
        super(name);
        this.shares = shares;
    }

    public static void printSharePrice() {
        System.out.println("CEO's share price is " + SHARE_PRICE);
    }

    public void revealSecretCode() {
        if (isAuthorizedToAccessSecretCode()) {
            System.out.println("The CEO's secret code is correct!");
        } else {
            try {
                throw new UnauthorizedAccessException("Unauthorized access to the CEO's secret code.");
            } catch (UnauthorizedAccessException e) {
                System.err.println("Caught UnauthorizedAccessException: " + e.getMessage());
            }
        }
    }

    @Override
    public void workOnProject() {
        System.out.println(getName() + " is defining the company strategy.");
    }

    @Override
    public void defineCompanyStrategy() {
        System.out.println("CEO is defining the company strategy.");
    }

    @Override
    public String toString() {
        return "CEO{" +
                "name=" + getName() +
                " ; " +
                "shares=" + shares +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CEO ceo = (CEO) o;
        return shares == ceo.shares;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shares);
    }

    private boolean isAuthorizedToAccessSecretCode() {
        try {
            System.out.print("Enter the password to reveal the secret code: ");
            Scanner scanner = new Scanner(System.in);

            int enteredPassword = scanner.nextInt();

            return enteredPassword == 123;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid numeric password.");
            return false;
        }
    }
}

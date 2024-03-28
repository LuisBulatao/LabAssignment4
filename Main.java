import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int maximumAttempts = 3;
        String password = "password";

        System.out.println("You have only " + maximumAttempts + " attempts");
        while (attempts < maximumAttempts) {
            System.out.print("\nEnter Password: ");
            String enterPassword = scanner.next();

            if (enterPassword.equals(password)) {
                System.out.println("Access Granted");
                break;
            } else {
                try {
                    throw new InvalidPasswordException("You Entered Wrong Password");
                } catch (InvalidPasswordException e) {
                    attempts++;
                    System.out.println(e.getMessage());
                    System.out.println("You have only " + (maximumAttempts - attempts) + " Attempts left");
                }
            }
        }
        if (attempts == maximumAttempts) {
            try {
                throw new AttemptsPasswordException("Limit Exceed");
            } catch (AttemptsPasswordException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\nWould you like to attempt again? (yes/no)");
            String attemptAgain = scanner.next();

            if (attemptAgain.equals("yes")) {
                main(args);
            } else {
                System.out.println("Exit! Thank You!");
            }
        }
    }
}

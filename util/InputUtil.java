package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    public static String stringInput(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLine();
    }

    public static int intInput(String title) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(title);
                return scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Wrong entry!");
            }
        }

    }

    public static long longInput(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLong();
    }

    public static byte byteInput(String title) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(title);
                return scanner.nextByte();
            } catch (InputMismatchException ex) {
                System.out.println("Wrong type!");
            }
        }

    }

    public static double doubleInput(String title) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(title);
                return scanner.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("Wrong type!");
            }
        }

    }

}

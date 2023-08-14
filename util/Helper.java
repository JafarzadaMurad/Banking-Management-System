package util;

import exceptions.EmailAlReadyException;
import model.Card;
import model.Customer;

import java.time.LocalDate;
import java.util.Random;

import static globalData.GlobalData.customers;
import static util.InputUtil.stringInput;

public class Helper {

    public static Card fillCard() {
        long id = 0;
        Random random = new Random();
        int firstNumber = random.nextInt(1000, 9999);
        int lastNumber = random.nextInt(1000, 9999);
        String cardNumber = "4169 7388 " + firstNumber + " " + lastNumber;
        int currentBalance = 0;

        return new Card(id++, cardNumber, currentBalance, LocalDate.now());
    }

    public static Customer fillCustomers() {
        String name, surname, email, password;

        long id = 0;
        while (true) {
            name = stringInput("Name:");
            if (!name.isBlank()) break;
        }
        while (true) {
            surname = stringInput("Surname: ");
            if (!surname.isBlank()) break;
        }
        while (true) {
            try {
                if (customers.length == 1) {
                    email = stringInput("Email: ");
                    if (!email.isBlank()) break;
                } else {
                    email = stringInput("Email: ");
                    for (int i = 0; i < customers.length - 1; i++) {
                        if (!email.isBlank()) {
                            if (email.equalsIgnoreCase(customers[i].getEmail())) {
                                throw new EmailAlReadyException();
                            }
                        }
                    }
                    break;
                }
            } catch (EmailAlReadyException ex) {
                System.out.println("This email is already!");
            }


        }
        while (true) {
            password = stringInput("Password: ");
            if (!password.isBlank()) break;
        }
        boolean status = true;
        boolean blockStatus = false;
        LocalDate registerDate = LocalDate.now();
        LocalDate updateDate = null;
        return new Customer(id++, name, surname, email, password, status, blockStatus, registerDate, updateDate, fillCard());
    }
}

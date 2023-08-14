package service.impl;

import enums.SuccessEnums;
import exceptions.DatabaseNullException;
import exceptions.EntryLimitException;
import exceptions.NotNullException;
import model.Customer;
import service.CustomerService;

import java.time.LocalDate;

import static globalData.GlobalData.*;
import static util.Helper.*;
import static util.InputUtil.*;

public class ICustomerService implements CustomerService {

    @Override
    public void Register() {
        if (customers == null) {
            customers = new Customer[1];
            while (customers[0] == null) {
                customers[0] = fillCustomers();
            }
        } else {
            Customer temp[] = customers;
            customers = new Customer[customers.length + 1];
            for (int i = 0; i < customers.length; i++) {
                if (i < temp.length) {
                    customers[i] = temp[i];
                } else {
                    while (customers[i] == null) {
                        customers[i] = fillCustomers();
                    }
                }
            }
        }
    }

    public static Customer login;

    @Override
    public Customer Login() {
        if (customers != null) {
            byte limit = 0;
            while (true) {
                String email, password;
                while (true) {
                    email = stringInput("Email: ");
                    if (!email.isBlank()) break;
                }
                while (true) {
                    password = stringInput("Password: ");
                    if (!password.isBlank()) break;
                }
                for (int i = 0; i < customers.length; i++) {
                    if (email.equalsIgnoreCase(customers[i].getEmail())) {
                        if (password.equals(customers[i].getPassword())) {
                            System.out.println("Welcome dear " + customers[i].getName());
                            login = customers[i];
                            return customers[i];
                        } else {
                            limit++;
                            System.out.println("Wrong password!");
                        }
                        if (limit == 3) {
                            customers[i].setBlockStatus(true);
                            throw new EntryLimitException();
                        }
                    } else {
                        System.out.println("Wrong Username");
                        break;
                    }
                }

            }
        } else {
            throw new DatabaseNullException();
        }
    }

    @Override
    public void ShowDetails() {
        System.out.println(
                "Name: " + login.getName() + "\n" +
                "Surname: " + login.getSurname() + "\n" +
                "Email: " + login.getEmail() + "\n" +
                "Card number: " + login.getCard().getCardNumber() + "\n" +
                "Current balance: " + login.getCard().getCurrentBalance()
        );
    }

    @Override
    public void Update() {
        boolean update = false;
        String name = stringInput("Name:");
        String surname = stringInput("Surname: ");
        String email = stringInput("Email: ");
        String oldPassword = stringInput("Old password: ");
        if (!oldPassword.isBlank() && oldPassword.equals(login.getPassword())) {
            if (!name.isBlank()) {
                login.setName(name);
                update = true;
            }
            if (!surname.isBlank()) {
                login.setSurname(surname);
                update = true;
            }
            if (!email.isBlank()) {
                login.setEmail(email);
                update = true;
            }
            String newPassword = stringInput("New password");
            if (!newPassword.isBlank()) {
                login.setPassword(newPassword);
                update = true;
            }
        } else {
            System.out.println("Not updated!");
        }

        if (update) {
            login.setUpdateDate(LocalDate.now());
            System.out.println(SuccessEnums.SUCCESS_UPDATE.name());
        }

    }
}

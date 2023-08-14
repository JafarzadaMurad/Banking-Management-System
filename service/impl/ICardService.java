package service.impl;

import exceptions.DatabaseNullException;
import exceptions.LackOfFundsException;
import exceptions.LackOfFundsException;
import model.Customer;
import service.CardService;


import java.time.LocalDateTime;

import static util.InputUtil.*;
import static globalData.GlobalData.*;
import static service.impl.ICustomerService.*;

public class ICardService implements CardService {
    @Override
    public void IncreaseTheBalance() {
        if (customers != null) {
            String cardNumber = stringInput("Enter card number: ");
            cardNumber = cardNumber.replace(" ", "").replace("-", "");
            if (cardNumber.length() == 16) {
                for (int i = 0; i < customers.length; i++) {
                    if (cardNumber.equals(customers[i].getCard().getCardNumber().replace(" ", ""))) {
                        int amount = intInput("Enter the amount: ");
                        if (amount > 0) {
                            customers[i].getCard().setCurrentBalance(customers[i].getCard().getCurrentBalance() + amount);
                            String cardNumberParts[] = customers[i].getCard().getCardNumber().split(" ");
                            String safeCardNumber = customers[i].getCard().getCardNumber().replace(cardNumberParts[1], "****").replace(cardNumberParts[2], "****");
                            System.out.println(
                                    "----Cash Receipt----" + "\n" +
                                    "Date&Time: " + LocalDateTime.now() + "\n" +
                                    "Card number: " + safeCardNumber + "\n" +
                                    "Add amount: " + amount + " ₼" + "\n" +
                                    "Total remain balance: " + customers[i].getCard().getCurrentBalance() + " ₼"
                            );
                        }
                    }
                }
            }

        } else {
            throw new DatabaseNullException();
        }

    }

    @Override
    public void ShowBalance() {
        System.out.println(
                "Balance: " + login.getCard().getCurrentBalance() + " ₼"
        );
    }

    @Override
    public void CashingOut() {
        int money[] = {500, 200, 100, 50, 20, 10, 5, 1};
        int amount = intInput("Enter the amount withdraw: ");
        try {
            if (amount > 0 && amount < login.getCard().getCurrentBalance()) {

                int temp = amount;
                for (int i = 0; i < money.length; i++) {
                    byte moneyCount = 0;
                    while (temp / money[i] > 0) {
                        moneyCount++;
                        temp -= money[i];
                        login.getCard().setCurrentBalance(login.getCard().getCurrentBalance() - money[i]);
                    }
                    if (moneyCount > 0) {
                        System.out.println(moneyCount + " piece - " + money[i] + " ₼");
                    }
                }
                String cardNumberParts[] = login.getCard().getCardNumber().split(" ");
                String safeCardNumber = login.getCard().getCardNumber().replace(cardNumberParts[1], "****").replace(cardNumberParts[2], "****");

                System.out.println(
                        "----Cash Receipt----" + "\n" +
                        "Date&Time: " + LocalDateTime.now() + "\n" +
                        "Card number: " + safeCardNumber + "\n" +
                        "Cash amount: -" + amount + " ₼" + "\n" +
                        "Total remain balance: " + login.getCard().getCurrentBalance() + " ₼"
                );
            } else {
                throw new LackOfFundsException();
            }
        }catch (LackOfFundsException ex) {
            System.out.println("Wrong amount!");
        }
    }
}

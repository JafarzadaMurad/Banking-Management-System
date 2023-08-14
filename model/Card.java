package model;

import java.time.LocalDate;

public class Card {
    private long id;
    private String cardNumber;
    private int currentBalance;
    LocalDate updateDate;

    public Card() {}
    public Card(long id, String cardNumber, int currentBalance, LocalDate updateDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.currentBalance = currentBalance;
        this.updateDate = updateDate;
    }

    public long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}

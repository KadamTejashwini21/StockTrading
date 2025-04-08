package stocktrading;

import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private String stockSymbol;
    private int amount;
    private double pricePerShare;
    private LocalDateTime time;

    public Transaction(String type, String stockSymbol, int amount, double pricePerShare) {
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.amount = amount;
        this.pricePerShare = pricePerShare;
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("[%s] %s %d shares of %s at $%.2f each", time, type, amount, stockSymbol, pricePerShare);
    }
}


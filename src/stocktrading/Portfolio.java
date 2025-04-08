package stocktrading;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> stocks;
    private double balance;

    public Portfolio(double initialBalance) {
        this.stocks = new HashMap<>();
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void addStock(String symbol, int amount) {
        stocks.put(symbol, stocks.getOrDefault(symbol, 0) + amount);
    }

    public void removeStock(String symbol, int amount) {
        if (stocks.containsKey(symbol)) {
            int currentAmount = stocks.get(symbol);
            if (currentAmount >= amount) {
                stocks.put(symbol, currentAmount - amount);
                if (stocks.get(symbol) == 0) {
                    stocks.remove(symbol);
                }
            }
        }
    }

    public int getStockAmount(String symbol) {
        return stocks.getOrDefault(symbol, 0);
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    public void printPortfolio() {
        System.out.println("Your Portfolio:");
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " shares");
        }
        System.out.println("Balance: $" + balance);
    }
}

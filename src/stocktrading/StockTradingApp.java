package stocktrading;

import java.util.Scanner;

public class StockTradingApp {
    private static StockMarket stockMarket = new StockMarket();
    private static Portfolio portfolio = new Portfolio(100000);  // Starting balance of $100,000

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Stock Trading Platform ---");
            System.out.println("1. View Market");
            System.out.println("2. View Portfolio");
            System.out.println("3. Buy Stock");
            System.out.println("4. Sell Stock");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    stockMarket.printMarket();
                    break;
                case 2:
                    portfolio.printPortfolio();
                    break;
                case 3:
                    buyStock(scanner);
                    break;
                case 4:
                    sellStock(scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the platform!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void buyStock(Scanner scanner) {
        System.out.print("Enter the stock symbol: ");
        String symbol = scanner.next();
        System.out.print("Enter the number of shares to buy: ");
        int amount = scanner.nextInt();

        Stock stock = stockMarket.getStock(symbol);
        if (stock != null) {
            double totalPrice = stock.getPrice() * amount;
            if (portfolio.getBalance() >= totalPrice) {
                portfolio.addStock(symbol, amount);
                portfolio.updateBalance(-totalPrice);
                System.out.println("Successfully bought " + amount + " shares of " + symbol);
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Stock not found!");
        }
    }

    private static void sellStock(Scanner scanner) {
        System.out.print("Enter the stock symbol: ");
        String symbol = scanner.next();
        System.out.print("Enter the number of shares to sell: ");
        int amount = scanner.nextInt();

        int ownedAmount = portfolio.getStockAmount(symbol);
        if (ownedAmount >= amount) {
            Stock stock = stockMarket.getStock(symbol);
            if (stock != null) {
                double totalSale = stock.getPrice() * amount;
                portfolio.removeStock(symbol, amount);
                portfolio.updateBalance(totalSale);
                System.out.println("Successfully sold " + amount + " shares of " + symbol);
            }
        } else {
            System.out.println("You don't have enough shares to sell!");
        }
    }
}

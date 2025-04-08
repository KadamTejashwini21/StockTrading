package stocktrading;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private List<Stock> stocks;

    public StockMarket() {
        stocks = new ArrayList<>();
        initializeMarket();
    }

    private void initializeMarket() {
        stocks.add(new Stock("AAPL", "Apple", 150.00));
        stocks.add(new Stock("GOOGL", "Google", 2800.00));
        stocks.add(new Stock("AMZN", "Amazon", 3500.00));
        stocks.add(new Stock("TSLA", "Tesla", 700.00));
    }

    public Stock getStock(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equals(symbol)) {
                return stock;
            }
        }
        return null;
    }

    public void printMarket() {
        System.out.println("Available Stocks:");
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }

    public void updateStockPrice(String symbol, double newPrice) {
        Stock stock = getStock(symbol);
        if (stock != null) {
            stock.setPrice(newPrice);
        }
    }
}

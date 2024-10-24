package StockLedger;

public class Main {

    public static void main(String[]args) {

        StockLedger test = new StockLedger();

        test.buy("AAPL", 20, 45.0);
        test.buy("AAPL", 20, 75.0);
        test.buy("MSFT", 20, 95.0);
        test.printStockLedger();
        System.out.println();

        test.sell("AAPL", 30, 65.0);
        test.printStockLedger();
        System.out.println();

        test.sell("AAPL", 10, 65.0);
        test.printStockLedger();
        System.out.println();

        test.buy("AAPL", 100, 20.0);
        test.buy("AAPL", 20, 24.0);
        test.buy("TSLA", 200, 36.0);
        test.printStockLedger();
        System.out.println();

        test.sell("AAPL", 10, 65);
        test.printStockLedger();
        System.out.println();

        test.sell("TSLA", 150, 30.0);
        test.printStockLedger();
        System.out.println();

        test.buy("MSFT", 5, 60.0);
        test.buy("MSFT", 5, 70.0);
        test.printStockLedger();
        System.out.println();

        test.sell("MSFT", 4, 30.0);
        test.printStockLedger();
        System.out.println();

        test.sell("MSFT", 2, 30.0);
        test.printStockLedger();



    }
}

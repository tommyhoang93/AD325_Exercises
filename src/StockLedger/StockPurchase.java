package StockLedger;

public class StockPurchase {

    // fields
    private String stockSymbol;
    private int sharesBought;
    private double pricePerShare;

    // constructor with no parameters
    public StockPurchase() {
        this.stockSymbol = "";
        this.sharesBought = 0;
        this.pricePerShare = 0.0;

    }

    // constructor with parameters
    public StockPurchase(String stockSymbol, int sharesBought, double pricePerShare) {
        this.stockSymbol = stockSymbol;
        setSharesBought(sharesBought);
        setPricePerShare(pricePerShare);


    }

    // getters & setters
    public String getStockSymbol() {
        return stockSymbol;

    }

    public int getSharesBought() {
        return sharesBought;
    }
    public void setSharesBought(int sharesBought) {
        if(sharesBought < 0) {
            throw new IllegalArgumentException();

        }
        this.sharesBought = sharesBought;


    }

    public double getPricePerShare() {
        return pricePerShare;
    }
    public void setPricePerShare(double pricePerShare) {
        if(pricePerShare < 0) {
            throw new IllegalArgumentException("Cannot be negative");

        }
        this.pricePerShare = pricePerShare;

    }

    public double totalCost() {
        return sharesBought * pricePerShare;

    }




}



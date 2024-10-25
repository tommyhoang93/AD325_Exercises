package StockLedger;

public class LedgerEntry {

    // fields
    private String stockSymbol;
    private int sharesBought;
    private double pricePerShare;

    // constructor with no parameters
    public LedgerEntry() {
        this.stockSymbol = "";
        this.sharesBought = 0;
        this.pricePerShare = 0.0;

    }

    // constructor with parameters
    public LedgerEntry(String stockSymbol, int sharesBought, double pricePerShare) {
        this.stockSymbol = stockSymbol;
        this.sharesBought = sharesBought;
        if(sharesBought < 0) {
            throw new IllegalArgumentException("Cannot be negative");

        }
        this.pricePerShare = pricePerShare;
        if(pricePerShare < 0) {
            throw new IllegalArgumentException("Cannot be negative");

        }

    }

    // getters & setters
    public String getStockSymbol() {
        return stockSymbol;

    }
    public int getSharesBought() {
        return sharesBought;

    }
    public void setSharesBought(int sharesBought) {
        this.sharesBought = sharesBought;

    }
    public double getPricePerShare() {
        return pricePerShare;

    }
    public void setPricePerShare(double pricePerShare) {
        this.pricePerShare = pricePerShare;

    }

    public double stockValue() {
        return sharesBought * pricePerShare;


    }

    public String toString() {
        return stockSymbol + pricePerShare + sharesBought;

    }





}

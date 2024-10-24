package StockLedger;

import Deque.EmptyQueueException;
import Deque.LinkedDeque;
import java.util.ArrayList;

public class StockLedger implements StockLedgerInterface {

    // fields
    // create arraylist of linkedDeques that holds ledgerEntry
    private ArrayList<LinkedDeque<LedgerEntry>> stockLedger;


    // constructor with no parameters
    public StockLedger() {
        this.stockLedger = new ArrayList<>();


    }

    /**
     * Records a stock purchase in this ledger.
     *
     * @param stockSymbol   The stock's symbol.
     * @param sharesBought  The number of shares purchased.
     * @param pricePerShare The price per share.
     */
    public void buy(String stockSymbol, int sharesBought, double pricePerShare) {

        // runtime = o(N^2) due to nested loops
        // iterate through linkedDeque in arrayList of stockLedger
        for (LinkedDeque<LedgerEntry> deque : stockLedger) {
            // iterate through ledgerEntry of linkedDeque
            for (LedgerEntry entry : deque) {
                // if stock symbols match add ledger entry to deque
                if (entry.getStockSymbol().equals(stockSymbol)) {
                    deque.addToBack(new LedgerEntry(stockSymbol, sharesBought, pricePerShare));
                    return;

                }
            }

        }
        // stock symbols don't match, create new deque to add stock
        LinkedDeque<LedgerEntry> newDeque = new LinkedDeque<>();
        // add ledgeEntry to new Deque
        newDeque.addToBack(new LedgerEntry(stockSymbol, sharesBought, pricePerShare));
        // add newDeque to arrayList
        stockLedger.add(newDeque);

    }

    /**
     * Removes from this ledger any shares of a particular stock
     * that were sold and computes the capital gain or loss.
     *
     * @param stockSymbol   The stock's symbol.
     * @param sharesSold    The number of shares sold.
     * @param pricePerShare The price per share.
     * @return The capital gain (loss).
     */
    public double sell(String stockSymbol, int sharesSold, double pricePerShare) {
        double totalGainLoss = 0.0;
        int sharesToSell = sharesSold;
        // iterate through LinkedDeque in arrayList stockLedger
        for (LinkedDeque<LedgerEntry> deque : stockLedger) {
            // if deque is not empty entry = frontData
            if (!deque.isEmpty()) {
                LedgerEntry entry = deque.getFront();

                // if stock symbols are the same enter loop
                if (entry.getStockSymbol().equals(stockSymbol)) {
                    // while there are still shares to sell and deque is not empty
                    // frontEntry = getFront
                    while (sharesToSell > 0 && !deque.isEmpty()) {
                        LedgerEntry frontEntry = deque.getFront();

                        if (frontEntry.getSharesBought() <= sharesToSell) {
                            double gainLoss = (pricePerShare - frontEntry.getPricePerShare()) * frontEntry.getSharesBought();
                            totalGainLoss += gainLoss;

                            sharesToSell -= frontEntry.getSharesBought();

                            if(!deque.isEmpty()) {
                                try {
                                    deque.removeFront();
                                } catch (EmptyQueueException e) {
                                    throw new RuntimeException(e);
                                }
                            }


                        } else {
                            double gainLoss = (pricePerShare - frontEntry.getPricePerShare()) * sharesToSell;
                            totalGainLoss += gainLoss;

                            frontEntry.setSharesBought(frontEntry.getSharesBought() - sharesToSell);
                            sharesToSell = 0;


                        }
                    }
                }
            }
        }
        return totalGainLoss;

    }

    /**
     * Returns a boolean on whether the passed in stock symbol is contained in the ledger.
     *
     * @param stockSymbol The stock's symbol.
     * @return Boolean of if the stock exists in the ledger.
     */
    public boolean contains(String stockSymbol) {
        // iterate through linkedDeque in arrayList stockLedger
        for (LinkedDeque<LedgerEntry> deque : stockLedger) {
            // get data of first ledgerEntry
            LedgerEntry first = deque.getFront();
            // if first is not null and stock symbols match return true
            if (first != null && first.getStockSymbol().equals(stockSymbol)) {
                return true;

            }

        }
        return false;

    }

    /**
     * Returns a LedgerEntry object based on stock symbol.
     *
     * @param stockSymbol The stock's symbol.
     * @return LedgerEntry object of stock symbol.
     */
    public LedgerEntry getEntry(String stockSymbol) {
        // iterate through linkedDeque in arrayList stockLedger
        for (LinkedDeque<LedgerEntry> deque : stockLedger) {
            // get data of first entry
            LedgerEntry stock = deque.getFront();
            // if stock is not null and stock symbols are equal return ledgerEntry stock
            if (stock != null && stock.getStockSymbol().equals(stockSymbol)) {
                return stock;

            }
        }
        return null;

    }

    /**
     * method to print stock ledger
     * shows stock symbol
     * amount of shares
     * price per share
     */
    public void printStockLedger() {
        System.out.println("---- Stock Ledger ----");
        // iterate through linkedDeque in arrayList stockLedger
        for (LinkedDeque<LedgerEntry> deque : stockLedger) {
            // if deque is not empty get the first entry in deque
            if (!deque.isEmpty()) {
                LedgerEntry first = deque.getFront();
                String output = first.getStockSymbol() + ": ";

                // iterate through each entry in the deque
                for(LedgerEntry entry : deque) {
                    output += entry.getPricePerShare() + "(" + entry.getSharesBought() + " shares), ";

                }
                output = output.substring(0, output.length() - 2);
                System.out.println(output);

            }
        }
    }


}

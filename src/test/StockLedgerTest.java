import StockLedger.StockLedger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockLedgerTest {

    @Test
    void buy() {
        StockLedger test = new StockLedger();
        test.buy("AAPL", 10, 50.0);
        assertTrue(test.contains("AAPL"));

    }

    @Test
    void sell() {
        StockLedger test = new StockLedger();
        test.buy("AAPL", 10, 50.0);
        test.sell("AAPL", 10, 50.0);
        assertFalse(test.contains("AAPL"));



    }

    @Test
    void contains() {
        StockLedger test = new StockLedger();
        test.buy("AAPL", 10, 50.0);
        assertTrue(test.contains("AAPL"));
        assertFalse(test.contains("MSFT"));

    }

    @Test
    void getEntry() {
        StockLedger test = new StockLedger();
        test.buy("AAPL", 10, 50.0);
        assertTrue(test.contains("AAPL"));


    }

}
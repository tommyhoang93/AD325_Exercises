import Deque.EmptyQueueException;
import Deque.LinkedDeque;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedDequeTest {

    @Test
    void addToFront() {
        LinkedDeque<Integer> test = new LinkedDeque<>();
        test.addToFront(1);
        assertEquals(1, test.getFront());

    }

    @Test
    void addToBack() {
        LinkedDeque<Integer> test = new LinkedDeque<>();
        test.addToBack(1);
        assertEquals(1, test.getBack());

    }

    @Test
    void removeFront() throws EmptyQueueException {
        LinkedDeque<Integer> test = new LinkedDeque<>();
        test.addToFront(1);
        assertEquals(1, test.removeFront());

    }

    @Test
    void removeBack() {
        LinkedDeque<Integer> test = new LinkedDeque<>();
        test.addToBack(1);
        test.addToBack(2);
        assertEquals(2, test.getBack());
    }

    @Test
    void isEmpty() {
        LinkedDeque<Integer> test = new LinkedDeque<>();
        assertTrue(test.isEmpty());
        test.addToFront(1);
        assertFalse(test.isEmpty());

    }

    @Test
    void getFront() {
        LinkedDeque<Integer> test = new LinkedDeque<>();
        test.addToFront(1);
        assertEquals(1, test.getFront());

    }

    @Test
    void getBack() {
        LinkedDeque<Integer> test = new LinkedDeque<>();
        test.addToBack(1);
        assertEquals(1, test.getBack());
    }

    @Test
    void clear() {
        LinkedDeque<Integer> test = new LinkedDeque<>();
        test.addToFront(1);
        test.clear();
        assertTrue(test.isEmpty());

    }
}
package Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<T> implements DequeInterface<T> {

    // fields
    private DLNode<T> front;
    private DLNode<T> back;
    private int size;

    // constructor
    public LinkedDeque() {
        this.front = null;
        this.back = null;
        this.size = 0;

    }

    /**
     * Adds new entry to front of deque
     *
     * @param element An object to be added
     */
    public void addToFront(T element) {

        // create newNode to store element
        DLNode<T> newNode = new DLNode<>(element);

        // if deque is empty point front and back to newNode
        if (size == 0) {
            front = newNode;
            back = newNode;

        } else {
            // newNode points at front
            newNode.setNextNode(front);
            // current front points back at newNode
            front.setPreviousNode(newNode);
            // newNode is set as front
            front = newNode;

        }
        size++;

    }

    /**
     * Adds a new entry to the back of this deque.
     *
     * @param element An object to be added.
     */
    public void addToBack(T element) {

        // create newNode to store element
        DLNode<T> newNode = new DLNode<>(element);

        // // if deque is empty point front and back to newNode
        if (size == 0) {
            front = newNode;
            back = newNode;

        } else {
            // back points at newNode
            back.setNextNode(newNode);
            // newNode points back at previous node
            newNode.setPreviousNode(back);
            // newNode is at the back
            back = newNode;

        }
        size++;

    }

    /**
     * Removes and returns the front of this deque.
     *
     * @return The object at the front of the deque.
     * @throws EmptyQueueException if the deque is empty before the operation.
     */
    public T removeFront() throws EmptyQueueException {
        if (front == null) {
            throw new EmptyQueueException();

        }
        T data = front.getData();
        front = front.getNextNode();

        if (front != null) {
            front.setPreviousNode(null);
        } else {
            back = null;
        }
        size--;
        return data;
    }


    /**
     * Removes and returns the back of this deque.
     * @return The object at the back of the deque.
     * @throws EmptyQueueException if the deque is empty before the operation.
     */
    public T removeBack() throws EmptyQueueException {
        if (size == 0) {
            throw new EmptyQueueException();

        }
        T data = back.getData();
        back = back.getPreviousNode();

        if (back != null) {
            back.setNextNode(null);

        } else {
            front = null;

        }
        size--;
        return data;

    }

    /**
     * Detects whether this deque is empty.
     * @return True if deque is empty, or false otherwise.
     */
    public boolean isEmpty() {
        return front == null;

    }

    /**
     * Returns the front entry's data.
     * @return Entry data for front of node.
     */
    public T getFront() {
        if(front == null) {
            return null;
        }
        return front.getData();

    }

    /**
     * Returns the back entry's data.
     * @return Entry data for back of node.
     */
    public T getBack() {
        if(back == null) {
            return null;

        }
        return back.getData();

    }


    /* Removes all entries from this deque.
     */
    public void clear() {
        front = null;
        back = null;
        size = 0;

    }

    // private class for node of deque
    private static class DLNode<T> {
        // fields
        private DLNode<T> next;
        private DLNode<T> previous;
        private T data;

        // constructor
        public DLNode(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;

        }

        // getters/setters
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public DLNode<T> getNextNode() {
            return next;
        }

        public void setNextNode(DLNode<T> next) {
            this.next = next;
        }

        public DLNode<T> getPreviousNode() {
            return previous;
        }

        public void setPreviousNode(DLNode<T> previous) {
            this.previous = previous;
        }

    }

    public Iterator<T> iterator() {
        return new DequeIterator();


    }

    public Iterator<T> getIterator() {
        return new DequeIterator();


    }

    private class DequeIterator implements Iterator<T> {
        // starts at front of deque pointing at node
        private DLNode<T> currentNode = front;

        // returns true if there is another element
        public boolean hasNext() {
            return currentNode != null;

        }
        public T next() {
            // if there is no element throw new element exception
            if (!hasNext()) {
                throw new NoSuchElementException();


            }
            // move to next node and returns data of current node
            T data = currentNode.getData();
            currentNode = currentNode.getNextNode();
            return data;


        }
    }

}




















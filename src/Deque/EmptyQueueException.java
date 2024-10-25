package Deque;

public class EmptyQueueException extends Exception  {
        public EmptyQueueException() {
            super("Deque is empty");

        }
        public EmptyQueueException(String message) {
            super(message);


        }
    }








package Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 A class of stacks whose entries are stored in an array.
 @author Frank M. Carrano and Timothy M. Henry
 @version 5.1
 */
public final class ArrayStack<T>
{
    private T[] stack;    // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ArrayStack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end constructor

    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    public T peek()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    public T pop()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    public boolean isEmpty()
    {
        return topIndex < 0;
    } // end isEmpty

    public void clear()
    {
        checkIntegrity();

        // Remove references to the objects in the stack,
        // but do not deallocate the array
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        } // end while
        //	Assertion: topIndex is -1
    } // end clear

    // Throws an exception if this object is not initialized.
    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException ("ArrayStack object is corrupt.");
    } // end checkIntegrity

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
    } // end checkCapacity

    // Doubles the size of the array stack if it is full
    // Precondition: checkIntegrity has been called.
    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity

    public void display () {           //print the stack elements
        for(int i = topIndex; i>=0;i--) {
            System.out.print(stack[i] + " ");
        }
    }

    /**
     * method to remove minimum integer in a stack
     */
    public static int removeMin(Stack<Integer> value) {
        int min = Integer.MAX_VALUE;
        Stack<Integer> temp = new Stack<>();

        while(!value.isEmpty()) {
            int current = value.pop();
            if(current < min) {
                min = current;

            }

        }
        while(!temp.isEmpty()) {
            int current = temp.pop();
            if(current != min) {
                value.push(current);

            }

        }
        return min;

    }

    /* method to test if stack is sorted in ascending order
       returns true

     */
    public static boolean isSorted(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1) {
            return true;

        }
        Stack<Integer> temp = new Stack<>();
        boolean sort = true;

        int previous = stack.pop();
        temp.push(previous);

       while(!stack.isEmpty()) {
           int current = stack.pop();
           if(previous > current) {
               sort = false;


           }
           temp.push(current);
           previous = current;


       }
       while(!temp.isEmpty()) {
           stack.push(temp.pop());


       }
       return sort;

    }

} // end ArrayStack

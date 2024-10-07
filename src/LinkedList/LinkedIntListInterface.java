
package LinkedList;

public interface LinkedIntListInterface {

    /**
     * This method is used to add a value to the linked list at the back.
     * @param value Value to be added.
     * @return Nothing.
     */
    public void add(int value);

    /**
     * This method inserts the given value at the given index in the list.
     * @param index index value is to added at.
     * @param value value to be added.
     * @return Nothing.
     */
    // Precondition: 0 <= index <= size
    public void add(int index, int value);

    /**
     * This method compares two linked lists to determine if they are the same.
     * @param o object to be compared.
     * @return Nothing.
     */
    public boolean equals(Object o);

    /**
     * This method returns the integer at the given index in the list.
     * @param index index where the value is to be returned.
     * @return value at index.
     */
    // Precondition: 0 <= index < size
    public int get(int index);

    /**
     * This method removes the value at the given index from the list.
     * @param index index where the value is to be removed.
     * @return Nothing.
     */
    // Precondition: 0 <= index < size
    public void remove(int index);

    /**
     * This method returns the number of elements in the list.
     * @return size of the linked list.
     */
    //
    public int size();

    /**
     * This method returns a text representation of the list, giving
     * indications as to the nodes and link structure of the list.
     * @return printout of the linked list
     */
    //
    public String toFormattedString();

    /**
     * This method returns a text representation of the list, giving
     * indications as to the nodes and link structure of the list.
     * @return printout of the linked list
     */
    public String toString();

    /**
     * This method returns a shorter, more "java.util.LinkedList"-like text representation of the list.
     * @return printout of the linked list in shortened form
     */
    public String toStringShort();

}

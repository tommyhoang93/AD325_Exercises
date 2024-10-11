package Stacks;

import java.util.Stack;

import static Stacks.ArrayStack.isSorted;
import static Stacks.ArrayStack.removeMin;

public class ArrayMain {
    public static void main(String[] args) {

        Stack<Integer> test1 = new Stack<>();
        test1.push(20);
        test1.push(20);
        test1.push(17);
        test1.push(11);
        test1.push(8);
        test1.push(8);
        test1.push(3);
        test1.push(2);
        System.out.println("Before " + test1);
        System.out.println(removeMin(test1));

        Stack<Integer> test2 = new Stack<>();
        test2.push(1);
        test2.push(2);
        test2.push(3);
        test2.push(5);

        boolean sorted = isSorted(test2);
        System.out.println(sorted);








    }








}

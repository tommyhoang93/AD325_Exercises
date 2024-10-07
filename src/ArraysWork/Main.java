package ArraysWork;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> test = new ArrayList<>();
        test.add("hey");
        test.add("hey");
        test.add("are");
        test.add("you");
        test.add("you");

        //ArrMethods.repeat(test,2);
       // ArrMethods.deleteDuplicates(test);
        //System.out.println(test);

        int [] array1 = {1, 3, 5, 8, 10};
        int [] array2 = {1, 3 ,5, 8, 10};
        //ArrMethods.equals(array1, array2);
        //ystem.out.println(ArrMethods.equals(array1, array2));

        int [] array3 = {1, 2, 3, 4, 5 };
        int [] collaspedArray = ArrMethods.collapse(array3);

        System.out.println(Arrays.toString(collaspedArray));









    }
}

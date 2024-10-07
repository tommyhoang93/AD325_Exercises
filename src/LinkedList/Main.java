package LinkedList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(6);
        test.add(8);
        test.add(2);
        test.add(3);
        test.add(5);

        //LinkedIntList.removeEvens(test);
        //System.out.println(test);

        LinkedIntList testing = new LinkedIntList();
        testing.add(4);
        testing.add(5);
        testing.add(6);
        testing.add(6);
        testing.add(4);
        testing.add(5);
        testing.add(6);
        testing.removeDuplicates();
        System.out.println(testing);

        //System.out.println(testing.deleteBack());
        //System.out.println(testing);




    }
}

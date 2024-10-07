package ArraysWork;
import java.util.ArrayList;

public class ArrMethods {

    public static void repeat(ArrayList<String> list, int k) {
        if (k <= 0) {
            list.clear();
            return;
        }

        ArrayList<String> newList = new ArrayList<>();
        for (String element : list) {
            for (int j = 0; j < k; j++) {
                newList.add(element);
            }

        }

        list.clear();
        list.addAll(newList);

    }

    public static void deleteDuplicates(ArrayList<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);

            }
        }
    }

    public static boolean equals(int[] list1, int[] list2) {
        if (list1.length != list2.length) {
            return false;

        }
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) {
                return false;
            }

        }
        return true;

    }

    public static int[] collapse(int[] array1) {
        //size of new array
        int newSize = array1.length / 2 + array1.length % 2;

        //create new array
        int newArray[] = new int[newSize];

        //iterate through array
        int index = 0;
        for (int i = 0; i < array1.length - 1; i += 2) {
            newArray[index] = array1[i] + array1[i + 1];
            index ++;

        }
        if (array1.length % 2 == 1) {
            newArray[newSize - 1] = array1[array1.length - 1];

        }

        return newArray;

        


    }




}








    







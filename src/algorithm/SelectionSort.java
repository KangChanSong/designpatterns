package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

public class SelectionSort {

    static int findSmallest(LinkedList<Integer> list){
        int smallest = list.get(0);
        int smallestIndex = 0;

        for(int  i = 0 ; i < list.size() ; i++){

            if(list.get(i) < smallest){
                smallest = list.get(i);
                smallestIndex = i;
            }

        }
        return smallestIndex;
    }

    static LinkedList<Integer> selectionSort(LinkedList<Integer> list){

        LinkedList<Integer> sortedList = new LinkedList<>();

        int max = list.size();

        for(int i = 0 ; i < max ; i++){
            int smallestIndex = findSmallest(list);
            sortedList.add(list.get(smallestIndex));
            list.remove(smallestIndex);

        }

        return sortedList;
    }

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(8);

        System.out.println(selectionSort(list).toString());
    }


}

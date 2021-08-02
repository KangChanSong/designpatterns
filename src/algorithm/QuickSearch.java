package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuickSearch {

    static ArrayList<Integer> quickSearch(ArrayList<Integer> list){

        //기본단계
        if(list.size() < 2){
            return list;
        }
        //재귀단계
        else {
            int pivot = list.get(0);

            ArrayList low = (ArrayList) list.stream().filter(i -> {return i < pivot ? true : false; }).collect(Collectors.toList());
            ArrayList high = (ArrayList) list.stream().filter(i ->  { return i > pivot ? true : false; }).collect(Collectors.toList());

            ArrayList<Integer> result = new ArrayList<>();
            result.addAll(quickSearch(low));
            result.add(pivot);
            result.addAll(quickSearch(high));
            return result;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(8);

        System.out.println(quickSearch(list).toString());
    }
}

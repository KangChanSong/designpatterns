package algorithm;

import java.util.Scanner;

public class BinarySearch {

    static int binarysearch(int num ,int[] arr){
        int low = 0;
        int high = arr.length-1;

        int result = 0;
        boolean flag = true;
        while (flag){

            int mid = (low + high) / 2;
            int guess = arr[mid];
            if(guess < num){
                low = mid + 1;
            } else if (guess > num){
                high = mid - 1;
            } else {
                flag= false;
                result = mid;
            }
            System.out.println(guess);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int num = 10;
        System.out.println(binarysearch(num, arr));
    }
}

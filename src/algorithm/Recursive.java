package algorithm;

public class Recursive {
    
    static int fact(int i){
        //기본단계
        if(i == 1){
            return i;
        }
        //재귀단계
        else {
            return i * fact( i - 1 );

        }
    }


    public static void main(String[] args) {

        int i = 5;

        System.out.println(Recursive.fact(i));

    }
}

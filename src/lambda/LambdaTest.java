package lambda;

interface MyFuncInterface {
    int sum(int x , int y);
}

public class LambdaTest {

    int x = 10;
    static int staticX = 20;

    int myMethod(){

        int localVar = 10;
        MyFuncInterface mf = (x , y) -> {
            return x + y + staticX + this.x;
        };

        return mf.sum(1, 33);
    }

    public static void main(String[] args) {

        System.out.println(new LambdaTest().myMethod());
    }
}

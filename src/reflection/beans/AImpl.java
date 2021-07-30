package reflection.beans;

public class AImpl implements A{

    private B b;

    public AImpl(B b){
        this.b =b;
    }
    @Override
    public void aMethod() {
        System.out.println("aMethod 시작");
        b.bMethod();
        System.out.println("bMethod 끝");
    }
}

package reflection;

import reflection.beans.A;
import reflection.beans.AImpl;
import reflection.beans.B;
import reflection.beans.BImpl;

//설정용 클래스
public class BeanConfig {

    public A a(){
        return new AImpl(b());
    }

    public B b(){
        return new BImpl();
    }
}

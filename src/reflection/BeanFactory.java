package reflection;

import reflection.beans.B;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class BeanFactory {
    //빈 이름, 빈 오브젝트를 키와 값으로 담는 해시테이블
    private HashMap<String, Object> beanMap = new HashMap<>();

    public BeanFactory(){
        loadBeans();
    }
    
    //빈들을 해시테이블에 담는 메서드
    private void loadBeans() {
        try {
            //BeanConfig 클래스를 런타임시 조작하기 위한 Class 객체 생성
            Class cls = Class.forName("reflection.BeanConfig");
            //생성한 클래스 객체의 모든 메서드들을 불러온다.
            Method[] methods = cls.getDeclaredMethods();
            BeanConfig beanConfig = new BeanConfig();

            //모든 메서드들을 실행하며 해시테이블에 빈들을 담는다.
            for(int i = 0 ; i < methods.length ; i++){
                String mName = methods[i].getName();
                Object obj = methods[i].invoke(beanConfig);

                beanMap.put(mName, obj);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //해시테이블에서 빈의 이름을 찾아 꺼낸다.
    public Object getBean(String name){
        Object obj = beanMap.get(name);
        return obj;
    }

}

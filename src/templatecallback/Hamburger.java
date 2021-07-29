package templatecallback;

public class Hamburger {

    public void makeBurger(Patty patty){
        System.out.println("참깨빵");
        String pattyName = patty.getPattyName();

        if(pattyName.equals("순쇠고기")){
            pattyName += " 패티두장";
        } else if(pattyName.equals("특별한 소스")){
            pattyName += " 양상추";
        }

        System.out.println(pattyName);

        System.out.println("참깨빵");
    }
}

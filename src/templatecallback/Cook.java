package templatecallback;

public class Cook {

    public void cookBurger(){
        Hamburger hamburger = new Hamburger();
        hamburger.makeBurger(new Patty() {
            @Override
            public String getPattyName() {
                return "순쇠고기";
            }
        });
    }
}

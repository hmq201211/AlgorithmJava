package singleton;

public class Demo {
    private static final class Inner {
        public static final Demo DEMO = new Demo();
    }

    public Demo getInstance() {
        return Inner.DEMO;
    }

    public static void main(String[] args) {
        Demo d1 = new Demo().getInstance();
        Demo d2 = new Demo().getInstance();
        System.out.println(d1 == d2);
    }
}

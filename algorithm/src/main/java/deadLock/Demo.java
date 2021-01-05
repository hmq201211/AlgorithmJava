package deadLock;

import java.util.concurrent.CountDownLatch;

public class Demo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(
                () -> {
                    synchronized (lock1) {
                        sleep(2000L);
                        System.out.println("持有lock1，等待lock2");
                        synchronized (lock2){
                            System.out.println("持有两把锁，结束");
                        }
                    }
                }
        ).start();
        new Thread(
                () -> {
                    synchronized (lock2) {
                        sleep(2000L);
                        System.out.println("持有lock2，等待lock1");
                        synchronized (lock1){
                            System.out.println("持有两把锁，结束");
                        }
                    }
                }
        ).start();
    }

    private static void sleep(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package top.bfylu.synchronized_demo.demo;

/**
 * 项目名: synchronized_demo
 * 包名: top.bfylu.synchronized_demo.demo
 * 创建时间: 2019 2019-03-14
 *
 * @author bfy
 * @version 1.0.0
 * <p>
 * 描述:      类锁的第一种形式， static形式
 * @Email bfyjian@gmail.com
 **/
public class SynchronizedClassStatic implements Runnable{
    static SynchronizedClassStatic instance1 = new SynchronizedClassStatic();
    static SynchronizedClassStatic instance2 = new SynchronizedClassStatic();

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println("我是类锁的static形式。我叫：" + Thread.currentThread().getName());
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}

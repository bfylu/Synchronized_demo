package top.bfylu.synchronized_demo.demo;

/**
 * 项目名: synchronized_demo
 * 包名: top.bfylu.synchronized_demo.demo
 * 创建时间: 2019 2019-03-14
 *
 * @author bfy
 * @version 1.0.0
 * <p>
 * 描述:  类锁的第二种形式， class形式
 * @Email bfyjian@gmail.com
 **/
public class SynchronizedClassClass implements Runnable{
    static SynchronizedClassClass instance1 = new SynchronizedClassClass();
    static SynchronizedClassClass instance2 = new SynchronizedClassClass();

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method() throws InterruptedException {
        synchronized (SynchronizedClassClass.class) {
            System.out.println("我是类锁第二种形式： synchronized(*.class)。我叫" + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
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

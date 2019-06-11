package top.bfylu.synchronized_demo.demo;

/**
 * 项目名: synchronized_demo
 * 包名: top.bfylu.synchronized_demo.demo
 * 创建时间: 2019 2019-03-14
 *
 * @author bfy
 * @version 1.0.0
 * 描述:      对象锁实例2，方法锁形式
 * @Email bfyjian@gmail.com
 **/
public class SynchronizedObjectMethod implements Runnable{
    static SynchronizedObjectMethod instance = new SynchronizedObjectMethod();

    @Override
    public void run() {
        method();
    }

    public synchronized void method() {
        System.out.println("我是对象锁的方法修饰符形式。我叫：" + Thread.currentThread().getName());
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}

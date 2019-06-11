package top.bfylu.synchronized_demo.demo;

/**
 * 项目名: synchronized_demo
 * 包名: top.bfylu.synchronized_demo.demo
 * 创建时间: 2019 2019-03-14
 *
 * @author bfy
 * @version 1.0.0
 * @Email bfyjian@gmail.com
 * 描述:      对象锁示例1， 代码块形式
 **/
public class SynchronizedObjectCodelock implements Runnable{
    static SynchronizedObjectCodelock instance = new SynchronizedObjectCodelock();

    @Override
    public void run() {

        synchronized (this) {
            System.out.println("我是对象锁的代码块形式。我叫：" + Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }

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

#   Synchronized的两个用法

## 对象锁
-   包括方法锁（默认锁对象为this当前实例对象）和 同步代码块锁（自己指定锁对象）

   代码块形式 ： 手动指定锁对象
```java
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
```
    
   方法锁形式 ： synchronized 修饰普通方法，锁对象默认为 this
```java
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
```    
    

## 类锁
-  指synchronized修饰静态的方法或指定锁为Class对象

   概念（重要）：java类可能有很多对象，但只有一个Class对象 
   1. 只有一个Class对象 ：对于任何一个java类来讲，它可以有很多实例，类的对象只有一个
   2. 本质 ： 所以所谓的类锁，不过是Class对象的锁而已。
    
   形式1 ：synchronized加在 static 方法上
```java
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
```   
   
   形式2 ：synchronized（*.class）代码块 
```java
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
``` 
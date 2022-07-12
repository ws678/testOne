package sdkj.java;

import java.util.concurrent.TimeUnit;

/*
    a07：加锁的方法和不加锁的方法可以同时执行
    所以可能会出现本案例中复现的bug，即脏读
    解决方法之一是读取也加锁，但是对性能有很大影响，值得商榷
 */
public class B_01DirtyRead {

    static String name = "默认";
    static Double banlance = 0.0;
    public static void main(String[] args){

        B_01DirtyRead B_01DirtyRead = new B_01DirtyRead();
        new Thread(() -> B_01DirtyRead.set("zhangsan",5.5)).start();
        new Thread(() -> B_01DirtyRead.get()).start();
    }

    private synchronized void set(String name, Double banlance) {

        try {

            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.banlance = banlance;
        System.out.println(("Set" + name));
        System.out.println(("Get" + banlance));
    }

    private /*synchronized*/ void get(){

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Get:"+name);
        System.out.println("Get"+banlance);
    }
}

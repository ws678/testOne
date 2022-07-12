package sdkj.java;

//给对象加synchronized锁 程序能力范围执行代码是安全的
public class A_06Synchronized_Test {

    private static /*volatile*/ int count = 1000;
    private static Object o = new Object();

    public static void main(String[] args){//static静态方法没有this对象 不需要new出来就可以执行

        MyThread thread = new MyThread();
        thread.start();
        //m();
        //mm();
        for (int i = 0; i < 5; i++) {
            MyThread1 thread1 = new MyThread1();
            thread1.setName("Thread"+i);
            thread1.start();
        }
        /*
            尝试运行main方法。显然synchronized也不是绝对安全的 ×
            是安全的，程序设计有问题，代码每一行都要斟酌
            后续再做深入
         */
    }

    public static class  MyThread extends Thread{

        @Override
        public void run(){

            for (int i = 0; i < 10; i++) {

                System.out.println(i);
            }
        }
    }

    public static class  MyThread1 extends Thread{

        @Override
        public synchronized void run(){

            //      错误示例 while高并发情境下 即使加了synchronized 线程a代码执行到45行时，线程b已经执行到46行，此时线程b就会读取到错误的数据
            while (count > 0) {
                count--;
                System.out.println(Thread.currentThread().getName()+"当前count ---- "+count);
            }
            /*while (count-- > 0) {
                System.out.println(Thread.currentThread().getName()+"当前count ---- "+count);
            }*/
        }
    }

    public static void m() {

        synchronized (o){
            /*
                要执行下面的代码 必须获取到对象o的锁
                也可以说锁定了下面这段代码，当我拿到锁的时候才能执行下面这段代码
             */

            count--;
            while (count-- > 0)
                System.out.println(Thread.currentThread().getName()+" count= "+count);
        }
    }
    public static synchronized void mm(){

        synchronized (A_06Synchronized_Test.class){

            count--;
            System.out.println("ene"+count);
        }
    }
}

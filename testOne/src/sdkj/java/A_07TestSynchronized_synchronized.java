package sdkj.java;

//加锁的方法和不加锁的方法可以同时执行
public class A_07TestSynchronized_synchronized {
    
    public static void main(String[] args){
        
        new Thread(new SynchronizedMathod(),"M1").start();
        new Thread(new Mathod(),"M2").start();

        /*  jdk1.8之前写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                HaHa();
            }
        }).start();*/

        //1.8之后的写法  Java类直接实现Runnable接口
        A_07TestSynchronized_synchronized testSynchronized_synchronized = new A_07TestSynchronized_synchronized();
        new Thread(testSynchronized_synchronized::haHa,"T1").start();
    }

    //驼峰规则
    public void haHa(){

        System.out.println(Thread.currentThread().getName()+"is Running");
    }

    private  static  class SynchronizedMathod  implements Runnable{

        @Override
        public synchronized void run() {

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--has ended");
        }
    }

    private static class Mathod implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--has ended");
        }
    }
}
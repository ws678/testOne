package sdkj.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//怎样去创建一个线程
public class A_03HowToCreateThread {

    //继承Thread类
    static class MyThread extends Thread{

        @Override
        public void run(){
            System.out.println("Hello MyThread");
        }
    }
    //实现Runnable接口
    static class MyRun implements Runnable{

        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }
    //通过Callable和Future创建线程
    static class MyCall implements Callable{

        @Override
        public Integer call() throws Exception {
            System.out.println("Hello MyCallableAndFuture");
            return 555;
        }
    }
    public static void main(String[] args){

        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() ->{//jdk1.8之后 Lambda表达式实现

            System.out.println("Hello MyLambda");
        }
        ).start();
        MyCall mc = new MyCall();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        new Thread(ft,"我的名字是哈哈哈").start();
        try {
            System.out.println(("线程的返回值" + ft.get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

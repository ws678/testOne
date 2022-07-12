package sdkj.java;

import java.util.concurrent.TimeUnit;
//线程的基本概念  （程序的一条执行路径就是一个线程）
public class A_02WhatIsThread {

    private static class T1 extends Thread{


        public static void sout(String t) {

            try {

                TimeUnit.MICROSECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(t);
        }
        @Override
        public void run(){

            for (int i = 0; i < 10; i++) {

                sout("T1");
            }
        }

        public static void main(String[] args){

            new T1().run();
            //new T1().start();
            /*
                start 和run输出结果大不相同
                当调用run方法时，程序会先执行Thread，等待其执行完毕后执行main
                当调用start方法时，main方法不受影响继续运行，与此同时Thread同时执行
             */
            for (int i = 0; i < 10; i++) {

                sout("main");
            }
        }
    }
}

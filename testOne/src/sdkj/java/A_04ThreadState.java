package sdkj.java;

import static java.lang.Thread.sleep;

//写demo获取线程状态
public class A_04ThreadState {

    static class MyThread extends Thread{

        public void run(){

            System.out.println("B  "+this.getState());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("E  "+this.getState());
                return;
            }
            for (int i = 0; i < 10; i++) {

                System.out.println(i);
            }
        }
    }

    public static void main(String[] args){

        Thread thread = new MyThread();
        System.out.println("A  "+thread.getState());
        thread.start();

        try {
            sleep(80);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("C  "+thread.getState());
        }

        System.out.println("D "+thread.getState());
    }
}

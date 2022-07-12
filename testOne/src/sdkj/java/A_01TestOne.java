package sdkj.java;

public class A_01TestOne extends Thread{

    int i = 0;

    //重写run方法，run方法的方法体就是现场执行体
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  : " + i);
            if (i == 50) {

                /*
                start 和run输出结果大不相同
                当调用run方法时，程序会先执行Thread，等待其执行完毕后执行main
                当调用start方法时，main方法不受影响继续运行，与此同时Thread同时执行
                */
                new A_01TestOne().run();
                new A_01TestOne().start();
            }
        }
    }
}

package sdkj.java;

//多线程设计进阶  生产者与消费者
public class TestRedayToRun {

    enum RedayToRun{R1,R2}
    static volatile RedayToRun r = RedayToRun.R1;

    public static void main(String[] args){

        char[] aI = "123456789".toCharArray();
        char[] aJ = "ASDFGHJKL".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                while (r == RedayToRun.R2){}//while 条件为true时会一直执行
                System.out.println(c);
                r = RedayToRun.R2;
            }
        }).start();

        new Thread(() -> {
            for (char c : aJ) {
                while (r == RedayToRun.R1){}
                System.out.println(c);
                r = RedayToRun.R1;
            }
        }).start();
    }
}

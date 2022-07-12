package sdkj.java;


public class A_05Sleep_Yield {

    public static void main(String[] args){

        /*
            sleep 将线程状态变为睡眠，参数设置时长 调用后变为TimeWaiting状态
            当直接调用sleep()不加参数时，线程进入waiting状态此时需要调用notify或者notifyall()才可以继续执行
            yield 线程谦让 使线程进入等待队列中 即返回就绪状态
            join 线程加入 让别的任务到此线程来先执行
         */
        //testSleep();
        //testYield();
        testJoin();

    }

    static void testJoin() {
        Thread t1 = new Thread(() ->{

            for (int i = 0; i < 100; i++) {

                System.out.println(("C" + i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() ->{

            try {
                t1.join();
                System.out.println("哈哈，大家聊了这么多啊，刚醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    private static void testYield() {
        new Thread(() ->{

            for (int i = 0; i < 100; i++) {

                System.out.println(("B" + i));
                if (i%10 == 0)
                    Thread.yield();
            }
        }).start();
    }

    private static void testSleep() {
        new Thread(() ->{

            for (int i = 0; i < 100; i++) {

                System.out.println(("A" + i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

package sdkj.java;

/*
    程序在执行过程中如果出现异常，默认情况下会释放锁
    所以在并发处理过程中 有异常要多加小心 不然可能会发生数据不一致的情况
    比如在一个web app的处理过程中多个servlet线程共同访问同一个资源，
    此时第一个线程出现异常，异常处理不合适的话，其他线程进入同步代码区，
    有可能会访问到异常产生的数据
 */
public class B_02LockErrorDeal {

    static int count;
    public static void main(String[] args){

        B_02LockErrorDeal B_02LockErrorDeal = new B_02LockErrorDeal();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> B_02LockErrorDeal.mathod1()).start();
        }
    }

    public synchronized static void mathod1() throws ArithmeticException {

        System.out.println(Thread.currentThread().getName()+"has started");
        count++;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count%5 == 0) {
            /*try {
                count = 1/0;  //程序运行至此会发生除零异常，默认会释放锁 若想不释放只需try/catch一下即可
            }catch (ArithmeticException e){
                System.out.println(count);
            }*/
            count = 1/0;
        }
    }
}

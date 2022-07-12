package sdkj.java;

/*
    可重入 同步方法m1执行过程中可以调用同步方法m2
    synchronized锁是可重入锁
 */
public class A_08Synchronized_Re {

    public static void main(String[] args){

        A_08Synchronized_Re a_08Synchronized_re = new A_08Synchronized_Re();
        new Thread(() -> a_08Synchronized_re.m1()/*{}*/).start();

        Class2 class2 = new Class2();
        Thread thread = new Thread(() -> class2.class2());
        thread.setName("class2");
        thread.start();

        Classm1 class1 = new Classm1();
        Thread thread1 = new Thread(() -> class1.classm1(0));
        thread1.setName("class1");
        thread1.start();
    }

    private synchronized void m1() {

        System.out.println("m1 has started");
        m2();
    }

    private synchronized void m2() {

        System.out.println("The Mathod has ended");
    }

    public static class Classm1{

        synchronized void  classm1(int a){

            if ((0 != a)) {
                System.out.println(Thread.currentThread().getName()+"调用成功");
            }
        }
    }

    public static class Class2 extends Classm1{

        public synchronized void class2(){

            super.classm1(1);
        }
    }
}

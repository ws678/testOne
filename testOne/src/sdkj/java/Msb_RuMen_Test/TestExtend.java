package sdkj.java.Msb_RuMen_Test;

import sdkj.java.A_01TestOne;

/*
    探究访问控制

    与C/C++中的static不同，Java中的static关键字不会影响到变量或者方法的作用域。
        在Java中能够影响到访问权限的只有private、public、protected（包括包访问权限）这几个关键字
    子类继承父类之后就拥有了父类所有的方法和成员变量
    其实就是访问不到的根本没办法.出来，所以不讨论了
 */
public class TestExtend {

    public static void main(String[] args) {

        //一、  类a_01TestOne的方法和成员变量都是public的，所以可以跨包跨类访问
        A_01TestOne a_01TestOne = new A_01TestOne();
        a_01TestOne.run();
        S_Lei.haHa();
    }

    //parent类
    private static class P_Lei{

        static int a;

        public static void setA(int a) {
            P_Lei p_lei = new P_Lei();
            p_lei.a = a;
        }

        public static int getA() {
            return a;
        }
    }

    //son类
    public static class S_Lei extends P_Lei{

        private static void haHa(){
            P_Lei a1 = new P_Lei();
            setA(5);
            int b = getA();
            System.out.println("打印中-----------          "+b);
        }
    }
}

package sdkj.java.Msb_RuMen_Test;

import java.util.LinkedList;

/*
    枚举类型
    有点类似与set或者list

    collection.contain() --> 是否包含 返回布尔类型
 */
public class EnumClass {

    public static enum E1 {red,green,blue};

    public static void main(String[] args) {
        switch (E1.red){

            default:
                System.out.println("test");
            case red:
                System.out.println("red");
                break;
            case blue:
                System.out.println("blue");
                break;
            case green:
                System.out.println("green");
                break;
        }
        System.out.println(E1.red.hashCode());

        System.out.println("Test collection  start");
        LinkedList<Object> objects = new LinkedList<>();
        //构造， 会自动执行ConsumerA类的构造方法，给balance赋值
        ConsumerA consumerA = new ConsumerA();
        //将值添加到linkedlist中，默认第一个下标为0
        objects.add(consumerA.getBanance());
        System.out.println(objects.get(0));
        //是否包含
        boolean contains = objects.contains(5);
        //打印为true
        System.out.println(contains);
    }

    static class ConsumerA{

        static private String name;
        static private Integer banance;
        ConsumerA(){

            //自动构造
            System.out.println("init success!");
            setBanance(5);
        }
        void setName(String a){

            this.name = a;
        }
        String get(){

            return name;
        }
        void setBanance(Integer a){

            this.banance = a;
        }
        Integer getBanance(){

            return banance;
        }
    }
}

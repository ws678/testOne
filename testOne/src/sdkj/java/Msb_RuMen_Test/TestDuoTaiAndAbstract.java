package sdkj.java.Msb_RuMen_Test;


/*
    动态绑定：也叫多态
    lady1调用了myEnjoy，但是执行结果是dog enjoy 这就是代码在执行的过程中绑定了dog类
    优点：
    带来了极大的可扩展性
    可替换性
    灵活性
    简化性
    接口性
    消除了类型之间的耦合关系

    抽象类
    1、抽象类不能被实例化，即不能使用new关键字来实例化对象，只能被继承；

    2、包含抽象方法的一定是抽象类，但是抽象类不一定含有抽象方法；

    3、抽象类中的抽象方法的修饰符只能为public或者protected，默认为public；

    4、抽象类中的抽象方法只有方法体，没有具体实现；

    5、如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法。
        如果子类没有实现父类的抽象方法，则必须将子类也定义为为abstract类

    6、抽象类可以包含属性、方法、构造方法，但是构造方法不能用于实例化，主要用途是被子类调用。
 */
public class TestDuoTaiAndAbstract {

    public static void main(String[] args) {

        Dog animal = new Dog("狗", "black");
        Cat anima2 = new Cat("猫", "red");
        animal.enjoy();

        Lady lady1 = new Lady("李", animal);
        Lady lady2 = new Lady("王", anima2);
        lady1.myEnjoy();
        lady2.myEnjoy();
    }

    static class Lady {

        private String name;
        private Animal pet;

        Lady(String name, Animal pet) {
            this.name = name;
            this.pet = pet;
        }

        void myEnjoy() {
            pet.enjoy();
        }
    }

    static abstract class Animal {

        private String name;
        private String color;

        Animal(String a, String b) {

            this.name = a;
            this.color = b;
        }

        /*public void enjoy(){
            System.out.println("animal enjoy");
        }*/
        //抽象 只有定义没有实现
        public abstract void enjoy();
    }

    static class Cat extends Animal {

        private String name;

        //继承必须要实现构造方法
        Cat(String a, String b) {
            super(a, b);
            name = a;
        }

        public void enjoy() {
            System.out.println("cat enjoy");
        }
    }

    static class Dog extends Animal {

        private String name;

        Dog(String a, String b) {
            super(a, b);
            name = a;
        }

        public void enjoy() {
            System.out.println("dog enjoy");
        }
    }
}

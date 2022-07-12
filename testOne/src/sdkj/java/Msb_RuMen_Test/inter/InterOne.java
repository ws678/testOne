package sdkj.java.Msb_RuMen_Test.inter;

/*
    接口
    1、接口可以包含变量、方法；变量被隐式指定为public static final，方法被隐式指定为public abstract（JDK1.8之前）；

    2、接口支持多继承，即一个接口可以extends多个接口，间接的解决了Java中类的单继承问题；

    3、一个类可以实现多个接口；

    4、JDK1.8中对接口增加了新的特性：

        4.1、默认方法（default method）：JDK 1.8允许给接口添加非抽象的方法实现，但必须使用default关键字修饰；
             定义了default的方法可以不被实现子类所实现，但只能被实现子类的对象调用；
             如果子类实现了多个接口，并且这些接口包含一样的默认方法，则子类必须重写默认方法；

        4.2、静态方法（static method）：JDK 1.8中允许使用static关键字修饰一个方法，并提供实现，称为接口静态方法。
             接口静态方法只能通过接口调用（接口名.静态方法名）。
 */
public interface InterOne {

    TestService1 ts1 = new TestService1();
    int id = 1;//该变量是 public static final 的  只是省略了

      String run();

      default String get(){

          return ts1.get();
      }

      static String haHa(){

          return ts1.get();
      }
}

package sdkj.java.Msb_RuMen_Test.inter;

public class TestService1 implements InterOne/*,InterTwo   可以多继承，接口之间用英文都好分隔开就行  */ {


    public static void main(String[] args) {

        //这段代码不执行 没办法演示了
        new InterOne() {
            @Override
            public String run() {
                System.out.println("A");
                return "A";
            }
        };
    }

    @Override
    public String run() {
        return "jdk一点八之前    跑了跑了";
    }

    public String get() {

        return "jdk一点八后    跑了跑了";
    }
}

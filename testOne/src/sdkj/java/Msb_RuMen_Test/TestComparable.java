package sdkj.java.Msb_RuMen_Test;

/*
    只需要在大类下实现Comparable就可以
    compareTo
        返回0代表this == obj
        返回正数代表this > obj
        返回负数代表this < obj
 */
public class TestComparable implements Comparable{

    public static void main(String[] args) {

        new TestComparable("","");
    }

    private String firstName = "fN2",lastName = "lN2";
    //构造方法
    public TestComparable(String firstName,String lastName){

        //Test类不太好验证，只能传this进去了
        int i = compareTo(this);
        if (i != 0) {
            if (i > 0) {
                System.out.println("this > obj");
            } else {
                System.out.println("this > obj");
            }
        } else {
            System.out.println("this == obj");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Object o) {

        System.out.println("start");
        TestComparable tc = (TestComparable) o;
        return lastName.compareTo(tc.firstName);
    }
}

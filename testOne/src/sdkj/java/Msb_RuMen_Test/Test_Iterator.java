package sdkj.java.Msb_RuMen_Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/*
    boolean hasNext();  判断游标右边是否还有元素
    object next();      返回游标右边的元素并将游标移动至下一个元素
    void remove();      删除游标左边的元素，执行完next之后该操作只能执行一次
 */
public class Test_Iterator {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList();
        Random random = new Random();
        for (int i = 0; i <= 90; i++) {
            //Random.nextInt(bound: int)返回小于n的一个随机int数
            int i1 = random.nextInt(9);
            arrayList.add(i1);
        }
        //iterator迭代器
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());
            //这里只能用iterator.remove();  不能用arrayList.remove(); 因为上锁喽
            iterator.remove();
        }
        //执行完while 数组的值全部被remove 所以打印结果为false
        System.out.println(iterator.hasNext());
    }
}

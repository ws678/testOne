package sdkj.java.Msb_RuMen_Test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ListAndSetAndMap {

    public static void main(String[] args) {

        //Learn Set
        setTest();
        //learn List
        listTest();
        //learn Map
        mapTest();
    }


    //定义枚举类型季节
    enum Season
    {
        SPRING,SUMMER,FALL,WINTER
    }

    private static void setTest() {

        /*
            enum查询最快 性能最好 第二好：hashSet
            link开头的查询插入都稍慢，因为需要维护链表，但是遍历更快
            tree最慢 但可以实现排序
            enum较简单 平时使用较少

            三者保证数据不重复的底层实现也不一样
            hash和linkedHash实现了hashcode比较
            tree底层用compare方法同时实现了红黑树
         */
        Set hS = new HashSet();
        Set lHs = new LinkedHashSet();
        //简单实现一个插入时的排序
        TreeSet<Integer> tS = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : o1 < o2 ? -1 : 0;
            }
        });
        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            /*
                tS.add(random.nextInt(3));
                这里是给012三个数，循环十次，肯定有重复的
                set对象插重复数据时不会报错，会覆盖
             */
            tS.add(random.nextInt(99));
        }
        //验证一下排序是否生效
        Iterator<Integer> iterator = tS.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        //enumSet  初始化的时候要传进去一个枚举.class
        //创建一个EnumSet集合，集合元素就是Season枚举类的全部枚举值
        EnumSet es1 = EnumSet.allOf(Season.class);
        //输出[SPRING,SUMMER,FALL,WINTER]
        System.out.println(es1);

        //创建一个EnumSet空集合，指定其集合元素是Season类的枚举值。
        EnumSet es2 = EnumSet.noneOf(Season.class);
        //输出[]
        System.out.println(es2);
        //手动添加两个元素
        es2.add(Season.WINTER);
        es2.add(Season.SPRING);
        //输出[SPRING,WINTER]
        System.out.println(es2);

        //以指定枚举值创建EnumSet集合
        EnumSet es3 = EnumSet.of(Season.SUMMER , Season.WINTER);
        //输出[SUMMER,WINTER]
        System.out.println(es3);

        //range 返回两个元素之间的所有元素
        EnumSet es4 = EnumSet.range(Season.SUMMER , Season.WINTER);
        //输出[SUMMER,FALL,WINTER]
        System.out.println("es4" + es4);

        //新创建的EnumSet集合的元素和es4集合的元素有相同类型，
        //es5的集合元素 + es4集合元素 = Season枚举类的全部枚举值   即输出enum中除去参数外的剩余元素
        EnumSet es5 = EnumSet.complementOf(es4);
        //输出[SPRING]
        System.out.println("es5" + es5);

        //实现线程安全★
        Set<Object> s = Collections.synchronizedSet(new HashSet<>());
        SortedSet<Object> ts = Collections.synchronizedSortedSet(new TreeSet<>());
    }

    private static void listTest() {

        /*
            arraylist   查询快修改慢 以一块连续的内存来保存所有数据
            linkedlist  查询慢修改快 以链表的形式来保存
            vector  与ArrayList相似，但是Vector是同步的。所以说Vector是线程安全的动态数组。
                    它的操作与ArrayList几乎一样。
            stack  继承自vector先进先出

         */
        //创建一个大小为100的数组
        ArrayList<Object> al = new ArrayList<>(100);
        //将数组大小增加minCapacity:5
        al.ensureCapacity(5);
        //ArrayList.trimToSize() ---- 将当前数组的大小调整为元素的个数 在程序中调用此方法可以减少ArrayList对象占用的内存空间
        al.trimToSize();
        Stack<String> books = new Stack<>();
        books.push("Java SE入门到入土");
        books.push("Java EE入门到入土");
        books.push("数据结构与算法");
        //输出所有
        System.out.println("输出所有"+books);
        //peek()拿出第一个
        String peek = books.peek();
        System.out.println("peek()拿出第一个"+peek);
        //抛出第一个
        System.out.println("抛出第一个"+books.pop());
        //继续抛出
        String pop = books.pop();
        System.out.println("继续抛出"+pop);
        //再次输出所有
        System.out.println("再次输出所有"+books);

        LinkedList<String> ll = new LinkedList<>();
        //offer()将数据存入链表尾部
        ll.offer("Java SE");
        //push()将数据存入链表顶部
        ll.push("Java EE");
        //将字符串元素添加到队列的头(相当于栈的顶部)
        ll.offerFirst("数据结构");
        ll.add(0,"Test一下 0 是头还是尾部呢");//按结果来看add(0,Object)默认添加到头部，执行pop会第一个出来
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }
        //访问链表的头部数据
        System.out.println("访问链表的头部数据"+ll.peekFirst());
        //访问链表的尾部
        System.out.println("访问链表的尾部"+ll.peekLast());
        //将链表的头部压出栈并输出
        System.out.println("将链表的头部压出栈并输出"+ll.pop());
        //打印链表查看删除操作是否成功
        System.out.println("打印链表查看删除操作是否成功"+ll);
        //将链表尾部的数据压出栈
        System.out.println("将链表尾部的数据压出栈"+ll.pollLast());
        //再次验证
        System.out.println("再次验证"+ll);

        //priorityqueue  自动排序 不允许插入null  一样可以自定义升序还是降序
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : o1 < o2 ? -1 : 0;
            }
        });
        pq.offer(5);
        pq.offer(8);
        pq.offer(1);
        pq.offer(99);
        pq.offer(3);
        System.out.println("输出全部queue"+pq);
        for (Integer integer : pq) {
            System.out.println("输出queue"+integer);
        }//但是看输出结果好像有点bug 反正用不到 不管了
        //vector 可以理解为具有多线程安全性的ArrayList
        Vector<Object> vector = new Vector<>();
        vector.trimToSize();
    }

    //重写一个好玩的HashTable ---- 准备类
    public static class ZhunBeiEquals{

        public boolean equals(Object obj){

            return true;
        }
    }
    private static void mapTest() {

        /*
            HashMap
            HashTable   是线程安全的HashMap   比map要慢一点
            TreeMap     比map和table要慢一些  因为实现了红黑树维护排序
         */
        HashMap<Object, Object> hm = new HashMap<>();
        Hashtable<Object, Object> ht = new Hashtable<>();
        ht.put(1111,new ZhunBeiEquals());
        System.out.println(ht.containsValue("哈哈哈哈哈 true ht包含此字符串 父类引用指向子类的对象 这就是多态"));

        //LinkedHashMap
        LinkedHashMap<Object, Object> lhm = new LinkedHashMap<>();
        //Properite  继承自hashTable类
        Properties properties = new Properties();
        properties.put("A","1");
        properties.put("B","2");
        properties.put("C","3");
        properties.put("D","4");
        try {
            //将properties中的key-value对保存到a.txt文件中
            properties.store(new FileOutputStream("a.txt"),"我看看这是干啥的");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Properties properties1 = new Properties();
        properties1.put("E","5");
        try {
            //将properties1中的key-value对追加保存到a.txt文件中
            properties1.load(new FileInputStream("a.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("看看你的  -  "+properties1);

        //TreeMap   自动排序
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("C","3");
        tm.put("B","2");
        tm.put("A","1");
        tm.put("D","4");
        System.out.println("第一个对象："+(tm.firstEntry()+ "     第一个🗡：" + tm.firstKey())+"       第一个值："+tm.get(tm.firstKey()));
        System.out.println("最后一个对象"+tm.lastEntry());
        //输出比A大的第一个key
        System.out.println("输出比A大的key ： "+tm.higherKey("A"));
        //输出对应的值
        System.out.println(tm.get(tm.higherKey("A")));
        //输出比C小的第一个对象
        System.out.println(tm.lowerEntry("C"));
        //subMap(key1,key2)把key1到key2之间的所有键值对（包头不包尾）整合到一起返回
        SortedMap<String, String> sm = tm.subMap("B", "D");
        System.out.println(sm);
        //WeakHashMap  好像没啥用
        WeakHashMap<String, String> whm = new WeakHashMap<>();
        whm.put("A","1");
        whm.put("B","2");
        whm.put("C","3");
        whm.put("D","4");
        whm.put("java","12");
        System.gc();
        System.runFinalization();
        System.out.println("输出weakHashMap："+whm);

        //enumMap  初始化的时候要传进去一个枚举.class
        EnumMap enumMap = new EnumMap<>(Season.class);
        enumMap.put(Season.WINTER,"冬天不能穿大裤衩子");
        enumMap.put(Season.SUMMER,"夏天能穿大裤衩子");
        System.out.println(enumMap);
    }
}

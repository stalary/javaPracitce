package com.stalary.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/7
 */
public class CollectionTest {

    public static void main(String[] args) {


        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put(null, 3);
        map.put("b", 2);
        map.clear();
        System.out.println(map);
        /*LinkedHashMap<String, Integer> collect = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        map.replaceAll((k, v) -> v+1);
        map.forEach((k, v) -> System.out.print("key:" + k + " " + "value" + v));
        System.out.println(collect);*/
       /* //测试hashSet去重
        Set<User> set = new HashSet<>();
        set.add(new User(1,"zyw",19));
        set.add(new User(2,"stalary",20));
        set.add(new User(3,"stalary",20));
        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //测试ArrayList
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"stalary",20));
        userList.add(new User(2,"zyw",19));
        System.out.println(userList);

        //测试LinkedList
        List<String> list = new LinkedList<>();
        list.add("stalary");
        list.add("zyw");
        list.add("hawk");
        System.out.println(list);
        List<String> list1 = new LinkedList<>();
        list1.add("hawk");
        list.removeAll(list1);
        System.out.println(list);

        //测试将Map装入List
        List<Map<String,Object>> mapList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","stalary");
        map.put("age",20);
        mapList.add(map);
        System.out.println(mapList);

        //测试优先级队列,通过id进行排序，删除了id最小的
        PriorityQueue<User> priorityQueue = new PriorityQueue<>(idComparator);
        priorityQueue.add(new User(1,"zyw",19));
        priorityQueue.add(new User(2,"stalary",20));
        priorityQueue.add(new User(3,"hawk",20));
        System.out.println("删除前：" + priorityQueue);
        priorityQueue.remove();
        System.out.println("删除后：" + priorityQueue);

        //映射
        Map<String,Object> testMap = new HashMap<>();
        testMap.put("zyw",1);
        testMap.put("zyw",2);
        testMap.put("zyw",3);
        System.out.println(testMap);
        Iterator it=testMap.keySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Map<String,Object> treeMap = new TreeMap<>();
        treeMap.put("stalary",2);
        treeMap.put("zyw",1);
        treeMap.putIfAbsent("zyw",0);
        System.out.println(treeMap);
        Set<String> keys = treeMap.keySet();//枚举映射的所有键
        for(String key : keys) {
            System.out.println(key);
        }
        List<String> stringList = new ArrayList<>();
        stringList.add("zyw");
        stringList.add("zyw");
        System.out.println(stringList);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(5);
        integerList.add(0);
        System.out.println(Collections.max(integerList));

        //轻量级集合包装器
        User[] users = {
            new User(1,"stalary",20),new User(2,"zyw",21)
        };
        List<User> usersList = Arrays.asList(users);
        if(userList instanceof ArrayList) {
            System.out.println("ArrayList");
        }
        System.out.println(userList);

        //BitSet
        BitSet bitSet = new BitSet(2001);
        bitSet.set(1);
        bitSet.set(3);
        System.out.println(bitSet.get(1));
        System.out.println(bitSet.get(2));*/
    }

    //匿名Comparator实现
    public static Comparator<User> idComparator = (c1, c2) -> (int) (c1.getId() - c2.getId());

    //测试使用的内部类
    static class User {
        private Integer id;
        private String name;
        private Integer age;

        public User() {
        }

        public User(Integer id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            return name.hashCode() + age + id ;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof User))
                return false;
            User user = (User)obj;
            System.out.println(this.name+"...."+user.name);
            return this.name.equals(user.name)&&this.age==user.age&&this.id==id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

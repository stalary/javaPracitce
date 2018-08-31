import java.util.LinkedHashMap;

public class Test {
    public static void main(String[] args) {
        LinkedHashMap<User, String> map = new LinkedHashMap<>(10, 0.75f, true);
        map.put(new User("2"), "stalary");
        map.put(new User("3"), "stalary");
        String s = map.get(new User("1"));
        System.out.println(s);
    }

    static class User {
        public String id;

        public User(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            return true;
        }

        @Override
        public int hashCode() {

            return 1;
        }
    }

}
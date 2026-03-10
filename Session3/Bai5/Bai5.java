package Session3.Bai5;

import java.util.ArrayList;
import java.util.List;

public class Bai5 {
    public static class User{
        private String id;
        private String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("SV1","Chiến"));
        userList.add(new User("SV2","Vượng"));
        userList.add(new User("SV3","Nam"));
        userList.add(new User("SV4","Chi"));
        userList.add(new User("SV5","Tuấn"));


      List<String> u= userList.stream().map(e->e.getName()).sorted((a, b) -> b.length() - a.length()).limit(3).toList();
      for (String i:u){
          System.out.println(i);
      }
    }
}

package dmo;

import dmo.User;
import java.util.*;
import java.util.stream.Collectors;

public class UserBusiness {

    private static UserBusiness instance;
    private final List<User> userList;

    private UserBusiness(){
        userList = new ArrayList<>();
    }

    public static UserBusiness getInstance(){
        if(instance == null){
            instance = new UserBusiness();
        }
        return instance;
    }

    public void displayList(){
        if(userList.isEmpty()){
            System.out.println("Danh sách rỗng");
            return;
        }

        userList.forEach(User::displayData);
    }

    public void addUser(User user){
        boolean exist = userList.stream()
                .anyMatch(u -> u.getUserId().equals(user.getUserId()));

        if(exist){
            System.out.println("Mã người dùng đã tồn tại");
        }else{
            userList.add(user);
        }
    }

    public Optional<User> findById(String id){
        return userList.stream()
                .filter(u -> u.getUserId().equals(id))
                .findFirst();
    }

    public void deleteUser(String id){
        int oldSize = userList.size();

        userList.removeIf(u -> u.getUserId().equals(id));

        if(oldSize == userList.size()){
            System.out.println("Mã người dùng không tồn tại trong hệ thống");
        }
    }

    public void searchByName(String name){
        List<User> result = userList.stream()
                .filter(u -> u.getUserName().toLowerCase()
                        .contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if(result.isEmpty()){
            System.out.println("Không tìm thấy");
        }else{
            result.forEach(User::displayData);
            System.out.println("Tổng kết quả: " + result.size());
        }
    }

    public void filterAdmin(){
        userList.stream()
                .filter(u -> u.getRole().equalsIgnoreCase("ADMIN"))
                .forEach(User::displayData);
    }

    public void sortByScore(){
        userList.stream()
                .sorted((a,b)->Double.compare(b.getScore(),a.getScore()))
                .forEach(User::displayData);
    }
}

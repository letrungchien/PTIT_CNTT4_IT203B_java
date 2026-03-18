package Session9;

import java.util.*;

class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> list = new ArrayList<>();

    private ProductDatabase(){}

    public static ProductDatabase getInstance(){
        if(instance == null){
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void add(Product p){
        list.add(p);
    }

    public List<Product> getAll(){
        return list;
    }

    public void delete(String id){
        list.removeIf(p -> p.getId().equals(id));
    }
}

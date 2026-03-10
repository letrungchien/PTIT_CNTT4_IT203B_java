package Session3.lythu;

import java.util.Arrays;
import java.util.List;

public class demo_filter {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Lê Trung Chiến","Nguyễn Thị A","Lê Văn Vượng");
        list.stream().filter(name->name.startsWith("Lê")).forEach(e->System.out.println(e));


    }
}

package Session3.lythu;

import java.util.Arrays;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo_map {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("chie","chi","an");

       List<String> newName= names.stream().map(name->name.toUpperCase()).collect(Collectors.toList());
        System.out.println(newName);

        names.stream().sorted().forEach(System.out::println);

    }
}


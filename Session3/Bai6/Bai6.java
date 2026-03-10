package Session3.Bai6;

import java.util.List;

public class Bai6 {

    static class Post {
        List<String> tags;

        public Post(List<String> tags) {
            this.tags = tags;
        }

        public List<String> getTags() {
            return tags;
        }
    }

    public static void main(String[] args) {

        List<Post> posts = List.of(
                new Post(List.of("java", "backend")),
                new Post(List.of("python", "data"))
        );

        List<String> allTags = posts.stream()
                .flatMap(p -> p.getTags().stream())
                .toList();

        System.out.println(allTags);
    }
}

package mataedu.jpastudy.entity;


import jakarta.persistence.OneToMany;
import lombok.Builder;

import java.util.List;

@Builder
public class Author extends BaseEntity {

    private String name;
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public static Author toAuthor(String name, String email) {
        return Author.builder()
                .name(name)
                .email(email)
                .build();
    }
}

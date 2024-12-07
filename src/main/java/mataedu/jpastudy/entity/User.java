package mataedu.jpastudy.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "users")
@NamedQuery(
        name="User.findByName",
        query = "select u from User u where u.name=:name"
)
public class User extends BaseEntity {

    private String name;
    private String email;
    private Long age;

    public static User toUser(String name, String email) {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

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
public class User extends BaseEntity {

    private String name;
    private String email;

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
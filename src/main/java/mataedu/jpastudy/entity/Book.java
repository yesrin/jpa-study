package mataedu.jpastudy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {

    @Comment("도서명")
    public String title;

    @Comment("저자")
    @ManyToOne
    public Author author;

    @Comment("출판사")
    public String publisher;

    @Comment("가격")
    public int price;

}

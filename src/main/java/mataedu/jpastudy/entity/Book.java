package mataedu.jpastudy.entity;

import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Comment;

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

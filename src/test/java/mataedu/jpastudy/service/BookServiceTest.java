package mataedu.jpastudy.service;

import mataedu.jpastudy.entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    @DisplayName("책 추가 테스트")
    void addBook() {
        // given
        String title = "JPA";
        String name = "김영한";

        // when
        Book result = bookService.addBook(title, name);

        // then
        assertEquals(title, result.getTitle());
    }

}
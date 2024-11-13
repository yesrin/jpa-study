package mataedu.jpastudy.service;

import mataedu.jpastudy.entity.Author;
import mataedu.jpastudy.entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("저자의 책 리스트를 조회힌다.")
    void findBooksByAuthor() {
        //given
        String title = "JPA";
        String name = "김영한";

        bookService.addBook(title, name);

        //when
        List<Book> result = authorService.getBookList(name);

        //then
        assertThat(result).hasSize(1);

    }
}
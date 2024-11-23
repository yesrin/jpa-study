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
    @DisplayName("저자의 책 리스트를 조회힌다. N+1 ")
    void getAuthorBooks() {
        //given
        Author author = Author.builder().name("김영한").build();
        authorService.addAuthor(author);

        bookService.addBook("JPA", author.getName());
        bookService.addBook("Spring", author.getName());
        bookService.addBook("Spring Boot", author.getName());

        //when
        System.out.println("---------------------");
        List<Book> result = authorService.getAuthorBooks(author.getName());
        System.out.println("---------------------");

        //then
        assertThat(result).hasSize(3);
    }

    @Test
    @DisplayName("저자의 책 리스트를 조회힌다. fetch join ")
    void getAuthorBooksFetchJoin() {
        //given
        Author author = Author.builder().name("김영한").build();
        authorService.addAuthor(author);

        bookService.addBook("JPA", author.getName());
        bookService.addBook("Spring", author.getName());
        bookService.addBook("Spring Boot", author.getName());

        //when
        System.out.println("---------------------");
        List<Book> result = authorService.getAuthorBooksFetchJoin(author.getName());
        System.out.println("---------------------");

        //then
        assertThat(result).hasSize(3);
    }


    @Test
    @DisplayName("저자 추가")
    void addAuthor() {
        //given
        Author author = Author.builder().name("김영한").build();

        //when
        Author authorResult = authorService.addAuthor(author);

        //then
        assertThat(authorResult.getName()).isEqualTo(author.getName());
    }


}
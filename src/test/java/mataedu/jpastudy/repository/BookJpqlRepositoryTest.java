package mataedu.jpastudy.repository;

import mataedu.jpastudy.entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookJpqlRepositoryTest {

    @Autowired
    BookJpqlRepository bookJpqlRepository;

    @Test
    @DisplayName("FetchType.LAZY 일때 여러개 나감")
    void findBooks() {
        List<Book> books = bookJpqlRepository.findBooks();


        for (Book book : books) {
            book.getAuthor().getName();
            System.out.println("==========================");
        }
    }

    @Test
    @DisplayName("fetch join 시 쿼리 한개만 나감")
    void findBooksFetchJoin() {
        bookJpqlRepository.findBooksFetchJoin();
    }
}
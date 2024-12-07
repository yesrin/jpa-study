package mataedu.jpastudy.service;

import mataedu.jpastudy.entity.Book;
import mataedu.jpastudy.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

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


    @Test
    void testJpaCacheWithTransaction() {
        // given
        // 데이터 초기화
        Book book = Book.builder().title("원래 책").build();
        bookRepository.save(book);

        // 트랜잭션 내 제목 업데이트
        System.out.println("===== 업데이트 =====");
        Book updatedBook = bookService.updateBook(book.getId(), "바뀐 책");

        // when
        // 변경 사항 확인
        assertThat(updatedBook.getTitle()).isEqualTo("바뀐 책");

        // then
        // 트랜잭션 밖에서 DB에서 다시 확인
        System.out.println("++++++++++조회 쿼리 나갈껄++++++++");
        Book reloadedBook = bookRepository.findById(book.getId()).orElseThrow();
        assertThat(reloadedBook.getTitle()).isEqualTo("바뀐 책");
    }
}
package mataedu.jpastudy.service;

import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.Author;
import mataedu.jpastudy.entity.Book;
import mataedu.jpastudy.repository.AuthorRepository;
import mataedu.jpastudy.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Book addBook(String title, String authorName) {

        Author getAuthor = authorRepository.findByName(authorName).orElseThrow(() -> new IllegalArgumentException("해당 저자가 존재하지 않습니다."));

        Book book = Book.builder()
                .title(title)
                .build();

        book.changeAuthor(getAuthor);

        return bookRepository.save(book);
    }
    @Transactional
    public Book updateBook(Long bookId, String updateTitle) {
        // 1차 캐시 동작 확인: 동일한 트랜잭션 내에서는 DB 접근 없이 같은 엔티티를 반환
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        System.out.println("======Cached title 1 ======: " + book.getTitle());
        book.updateTitle(updateTitle);

        // 1차 캐시에 있는 동일 엔티티를 다시 조회
        System.out.println("+++++++++++조회 쿼리 안나갈껄 service +++++++++");
        Book cachedBook = bookRepository.findById(bookId).orElseThrow();
        System.out.println("======Cached title 2 ======: " + cachedBook.getTitle()); // 변경된 제목 출력

        return cachedBook; // 트랜잭션 종료 시점에 변경 사항이 DB에 반영됨
    }


}

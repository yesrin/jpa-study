package mataedu.jpastudy.service;

import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.Author;
import mataedu.jpastudy.entity.Book;
import mataedu.jpastudy.repository.AuthorRepository;
import mataedu.jpastudy.repository.BookRepository;
import org.springframework.stereotype.Service;

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
}

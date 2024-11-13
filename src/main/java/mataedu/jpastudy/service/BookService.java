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

    public Book addBook(String title, String name) {
        Author author = Author.builder().name(name).build();

        Author getAuthor = authorRepository.findByName(name).orElse(authorRepository.save(author));

        Book book = Book.builder()
                .title(title)
                .author(getAuthor)
                .build();

        return bookRepository.save(book);
    }
}

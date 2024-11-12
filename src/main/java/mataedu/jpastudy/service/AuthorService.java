package mataedu.jpastudy.service;


import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.Author;
import mataedu.jpastudy.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Book> getBookList(String name) {
        Author author = authorRepository.findByName(name);
        return author.getBooks();
    }
}

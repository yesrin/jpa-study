package mataedu.jpastudy.service;


import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.Author;
import mataedu.jpastudy.entity.Book;
import mataedu.jpastudy.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    public List<Book> getAuthorBooks(String name) {
        Optional<Author> optionalAuthor = authorRepository.findByName(name);

        optionalAuthor.orElseThrow(() -> new IllegalArgumentException("해당 저자의 도서가 존재하지 않습니다."));

        return optionalAuthor.get().getBooks();
    }
}

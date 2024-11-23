package mataedu.jpastudy.repository;

import mataedu.jpastudy.entity.Author;
import mataedu.jpastudy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.name = :name")
    Optional<Author> findByNameWithBooks(String name);
}

package mataedu.jpastudy.repository;

import mataedu.jpastudy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
}

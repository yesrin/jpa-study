package mataedu.jpastudy.repository;


import mataedu.jpastudy.entity.Author;
import mataedu.jpastudy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}

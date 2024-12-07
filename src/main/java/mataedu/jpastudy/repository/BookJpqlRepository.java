package mataedu.jpastudy.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.Author;
import mataedu.jpastudy.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BookJpqlRepository {
    private final EntityManager em;
    List<Book> findBooks(){
        return em.createQuery("select b from Book b", Book.class)
                .getResultList();
    }

    List<Book> findBooksFetchJoin(){
        return em.createQuery("select b from Book b join fetch b.author", Book.class)
                .getResultList();
    }
}

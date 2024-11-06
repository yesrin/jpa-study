package mataedu.jpastudy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserJpqlRepository {
    private final EntityManager em;


    public List<User> findUserName(String name) {
        return em.createQuery("select u.name from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getResultList();
    }
}

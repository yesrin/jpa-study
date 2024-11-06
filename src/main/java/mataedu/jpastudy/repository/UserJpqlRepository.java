package mataedu.jpastudy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJpqlRepository {

    @PersistenceContext // EntityManager 자동 주입 =>  스프링이 관리하는 EntityManager
    private final EntityManager entityManager;

    public User saveUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); //트랜젝션 시작
            entityManager.persist(user);
            transaction.commit(); //commit query
            return user;
        } catch (Exception e) {
            transaction.rollback();
            throw new IllegalArgumentException("저장에 실패했습니다.");
        }
    }

    public List<User> findUserName(String name) {
        return entityManager.createQuery("select u.name from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    public void delete(User user) {
        entityManager.remove(user);
    }
}

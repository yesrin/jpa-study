package mataedu.jpastudy.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class UserJpqlRepository {

    //@PersistenceContext // EntityManager 자동 주입 =>  스프링이 관리하는 EntityManager RAC 덕분에 안해도 됨.
    private final EntityManager entityManager;
    //private final JdbcTemplate jdbcTemplate;

    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    //JPQL
    public List<User> findUserName(String name) {
        return entityManager.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getResultList();
    }

    //JDBC
//    public List<User> findUserNameToJDBC(String name) {
//        String sql = "SELECT * FROM users WHERE name = ?";
//        return jdbcTemplate.query(sql, new Object[]{name}, new UserRowMapper());
//    }

    public List<User> getUsersUsingNameQuery(String name) {
        return entityManager.createNamedQuery("User.findByName")
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

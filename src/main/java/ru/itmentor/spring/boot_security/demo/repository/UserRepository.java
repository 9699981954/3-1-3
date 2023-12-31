package ru.itmentor.spring.boot_security.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("select u from User u join fetch u.roles where u.email = (:email)")
    User findByEmail(@Param("email") String email);
}

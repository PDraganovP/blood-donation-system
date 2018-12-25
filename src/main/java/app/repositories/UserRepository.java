package app.repositories;

import app.entities.Role;
import app.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User AS u WHERE u.username=:username AND u.password=:password")
    User findUser(@Param("username") String username, @Param("password") String password);

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    @Modifying
    @Query("UPDATE User AS u SET u.role=:role WHERE u.id=:id")
    void setRole(@Param("role") Role role, @Param("id") long userId);
}

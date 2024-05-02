package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.status.UserStatus;
import co.edu.icesi.sgiv.domain.type.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAll();
    @Query("select u from User u where u.username = (?1)")
    public Optional<User> findByUsername(String username);
    @Query("select u from User u join UserType ut on u.type = ut where ut.id = (?1)")
    public List<User> findAllByType(Long type);

    @Query("select us from UserStatus us join User u where u.id = ?1")
    public Optional<UserStatus> getStatus(Long uID);

    @Query("select u from User u join UserType ut where ut = ?1")
    public List<User> getByUserType(UserType ut);
}

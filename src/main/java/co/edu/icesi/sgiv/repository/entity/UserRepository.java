package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAll();

    public Optional<User> findById(Long id);

    @Query("select u from User u join UserType ut on u.type = ut where ut.id = (?1)")
    public List<User> findAllByType(Long type);

}

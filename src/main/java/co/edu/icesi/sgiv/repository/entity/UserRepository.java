package co.edu.icesi.sgiv.repository.entity;

import co.edu.icesi.sgiv.domain.entity.User;
import co.edu.icesi.sgiv.domain.type.UserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAll();
    @Query("select u from User u where u.username = (?1)")
    public Optional<User> findByUsername(String username);
    @Query("select u from User u join UserType ut on u.type = ut where ut.id = (?1)")
    public List<User> findAllByType(Long type);

    @Query("select u from User u join UserType ut where ut = ?1")
    public List<User> getByUserType(UserType ut);

    @Query(value="SELECT * FROM PUBLIC.USER U WHERE" +
                "(:name IS NULL OR LOWER(U.USERNAME) LIKE '%'||LOWER(:name)||'%') AND" +
                "(:type IS NULL OR U.TYPE_ID = :type) AND" +
                "(:status IS NULL OR U.STATUS = :status)", nativeQuery = true)
    public Page<User> findByFilter(@Param("name") String name, @Param("type") Long type, @Param("status") String status, Pageable page);
}

package api.repository;

import api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //find that is not deleted
    @Query(nativeQuery = true, value ="select * from user " +
            " where username = :username " +
            " AND is_deleted = '0' ")
    User findByUsername(@Param("username")String username);

    @Query(nativeQuery = true, value ="select * from user" +
            " where username = :username " +
            " AND password = :password " +
            " AND is_deleted = '0' ")
    User findByUsernameAndPassword (@Param("username")String username, @Param("password")String password);
}

package changePassword.Repository;

import changePassword.Entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
	@Modifying
	@Transactional
	@Query(value = "UPDATE tbl_user u SET u.password = :password WHERE u.id = :id")
	void updatePassword(@Param("password") String password, @Param("id") int id);
}

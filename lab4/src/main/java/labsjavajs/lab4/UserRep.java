package labsjavajs.lab4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userRep")
public interface UserRep extends JpaRepository<User, Long> {

		User findByName(String name);

		List<User> findAll();

		User findByHash(String hash);
}

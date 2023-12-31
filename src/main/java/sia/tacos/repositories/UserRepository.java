package sia.tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.tacos.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}

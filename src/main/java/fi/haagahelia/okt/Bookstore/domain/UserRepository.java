package fi.haagahelia.okt.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);

}

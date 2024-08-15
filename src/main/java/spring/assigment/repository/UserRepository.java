package spring.assigment.repository;

import spring.assigment.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);


}

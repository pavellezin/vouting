package pro.paullezin.bootjava.vouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.paullezin.bootjava.vouting.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}

package hit.repository;

import hit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findAllByUserId(Integer userId);
    User findAllByAccount(String account);


}
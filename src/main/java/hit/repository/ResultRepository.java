package hit.repository;

import hit.entity.Result;
import hit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Integer> {
}

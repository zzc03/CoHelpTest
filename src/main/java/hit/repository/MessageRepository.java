package hit.repository;

import hit.entity.Message;
import hit.entity.NeedApply;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    public List<Message> findAllByReceiverid(Integer userid);
    public Message getAllById(Integer id);
}

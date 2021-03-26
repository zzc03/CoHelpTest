package hit.repository;

import hit.entity.Need;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeedRepository extends JpaRepository<Need,Integer> {
   // List<Need> getByNeedTextContainingOrNeedTitleContaining(String needText, String needTitle);
}

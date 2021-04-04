package hit.repository;

import hit.entity.ItemNeed;
import hit.entity.Need;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeedRepository extends JpaRepository<Need,Integer> {
   List<Need> getByTextContainingOrTitleContaining(String content,String title);
   Need findByNeedId(Integer needid);
}

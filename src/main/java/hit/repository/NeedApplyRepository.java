package hit.repository;

import hit.entity.ItemNeedApply;
import hit.entity.Need;
import hit.entity.NeedApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeedApplyRepository extends JpaRepository<NeedApply,Integer> {
    NeedApply getAllByApplyid(Integer id);
    List<NeedApply> getAllByApplyuserid(Integer id);
}

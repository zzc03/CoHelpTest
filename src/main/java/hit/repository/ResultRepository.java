package hit.repository;

import hit.entity.ItemResult;
import hit.entity.Result;
import hit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Integer> {
    public List<Result> getAllByNeedid(Integer needid);
    public Result getAllByResultId(Integer resultid);
    public List<Result> getAllByAcceptuserid(Integer userid);
}

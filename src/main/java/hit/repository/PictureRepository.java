package hit.repository;

import hit.entity.Need;
import hit.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture,Integer> {
    public List<Picture> getAllByResultid(Integer resultid);
}

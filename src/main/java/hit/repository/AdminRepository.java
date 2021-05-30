package hit.repository;

import hit.entity.Admin;
import hit.entity.NeedApply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    public Admin findAdminById(Integer id);
}

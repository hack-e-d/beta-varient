package vijay.projects.betavarient.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vijay.projects.betavarient.Entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
}

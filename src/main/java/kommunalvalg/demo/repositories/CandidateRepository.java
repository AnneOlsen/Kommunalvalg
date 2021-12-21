package kommunalvalg.demo.repositories;

import kommunalvalg.demo.models.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidates, Long> {

}

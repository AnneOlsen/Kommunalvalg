package kommunalvalg.demo.repositories;

import kommunalvalg.demo.models.Votes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Votes, String> {
}

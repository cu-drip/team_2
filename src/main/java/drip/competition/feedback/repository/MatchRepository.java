package drip.competition.feedback.repository;

import drip.competition.feedback.entities.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {
    Page<Match> findByUserId(UUID userId, Pageable pageable);
    Page<Match> findByMatchId(UUID matchId, Pageable pageable);
}

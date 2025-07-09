package drip.competition.feedback.repository;

import drip.competition.feedback.entities.Tournament;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TournamentRepository extends JpaRepository<Tournament, UUID> {
    Page<Tournament> findByUserId(UUID userId, Pageable pageable);
    Page<Tournament> findByTournamentId(UUID tournamentId, Pageable pageable);
}

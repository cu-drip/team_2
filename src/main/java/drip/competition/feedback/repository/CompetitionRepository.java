package drip.competition.feedback.repository;

import drip.competition.feedback.entities.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompetitionRepository extends JpaRepository<Competition, UUID> {
    Page<Competition> findByIduser(UUID iduser, Pageable pageable);
    Page<Competition> findByIdcompetition(UUID idcompetition, Pageable pageable);
}

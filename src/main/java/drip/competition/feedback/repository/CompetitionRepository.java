package drip.competition.feedback.repository;

import drip.competition.feedback.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, UUID> {

    List<Competition> findByIdcompetition(UUID idcompetition);

    List<Competition> findByIduser(UUID iduser);

}

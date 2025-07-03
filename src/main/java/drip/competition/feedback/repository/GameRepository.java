package drip.competition.feedback.repository;

import drip.competition.feedback.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {

    List<Game> findByIdgame(UUID idgame);

    List<Game> findByIduser(UUID iduser);

}

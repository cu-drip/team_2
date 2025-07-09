package drip.competition.feedback.repository;

import drip.competition.feedback.entities.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
    Page<Game> findByIduser(UUID iduser, Pageable pageable);
    Page<Game> findByIdgame(UUID idgame, Pageable pageable);
}

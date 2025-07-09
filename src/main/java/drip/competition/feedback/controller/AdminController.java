package drip.competition.feedback.controller;

import drip.competition.feedback.entities.Competition;
import drip.competition.feedback.entities.Game;
import drip.competition.feedback.repository.CompetitionRepository;
import drip.competition.feedback.repository.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final GameRepository gameRepository;
    private final CompetitionRepository competitionRepository;

    public AdminController(GameRepository gameRepository,
                           CompetitionRepository competitionRepository) {
        this.gameRepository = gameRepository;
        this.competitionRepository = competitionRepository;
    }

    @GetMapping("/users/{id}/matches")
    @Transactional(readOnly = true)
    public Page<Game> getUserMatches(@PathVariable("id") UUID iduser, Pageable pageable) {
        return gameRepository.findByIduser(iduser, pageable);
    }

    @GetMapping("/users/{id}/tournaments")
    @Transactional(readOnly = true)
    public Page<Competition> getUserTournaments(@PathVariable("id") UUID iduser, Pageable pageable) {
        return competitionRepository.findByIduser(iduser, pageable);
    }
}

package drip.competition.feedback.controller;

import drip.competition.feedback.entities.Competition;
import drip.competition.feedback.entities.Game;
import drip.competition.feedback.repository.CompetitionRepository;
import drip.competition.feedback.repository.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/feedback")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private final GameRepository gameRepository;
    private final CompetitionRepository competitionRepository;

    public UserController(GameRepository gameRepository,
                          CompetitionRepository competitionRepository) {
        this.gameRepository = gameRepository;
        this.competitionRepository = competitionRepository;
    }

    @PostMapping("/matches")
    @Transactional
    public ResponseEntity<Void> createMatch(@RequestBody Game game, UriComponentsBuilder builder) {
        Game saved = gameRepository.save(game);
        URI location = builder.path("/api/v1/feedback/matches/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build(); // 201 Created
    }

    @PostMapping("/tournaments")
    @Transactional
    public ResponseEntity<Void> createTournament(@RequestBody Competition competition, UriComponentsBuilder builder) {
        Competition saved = competitionRepository.save(competition);
        URI location = builder.path("/api/v1/feedback/tournaments/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build(); // 201 Created
    }

    @GetMapping("/matches")
    public Page<Game> getMatches(@RequestParam UUID idgame, Pageable pageable) {
        return gameRepository.findByIdgame(idgame, pageable);
    }

    @GetMapping("/tournaments")
    public Page<Competition> getTournaments(@RequestParam UUID idcompetition, Pageable pageable) {
        return competitionRepository.findByIdcompetition(idcompetition, pageable);
    }
}

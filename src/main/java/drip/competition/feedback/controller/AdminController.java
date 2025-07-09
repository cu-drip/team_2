package drip.competition.feedback.controller;

import drip.competition.feedback.entities.Tournament;
import drip.competition.feedback.entities.Match;
import drip.competition.feedback.repository.TournamentRepository;
import drip.competition.feedback.repository.MatchRepository;
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

    private final MatchRepository matchRepository;
    private final TournamentRepository tournamentRepository;

    public AdminController(MatchRepository matchRepository,
                           TournamentRepository tournamentRepository) {
        this.matchRepository = matchRepository;
        this.tournamentRepository = tournamentRepository;
    }

    @GetMapping("/users/{id}/matches")
    @Transactional(readOnly = true)
    public Page<Match> getUserMatches(@PathVariable("id") UUID userId, Pageable pageable) {
        return matchRepository.findByUserId(userId, pageable);
    }

    @GetMapping("/users/{id}/tournaments")
    @Transactional(readOnly = true)
    public Page<Tournament> getUserTournaments(@PathVariable("id") UUID userId, Pageable pageable) {
        return tournamentRepository.findByUserId(userId, pageable);
    }
}

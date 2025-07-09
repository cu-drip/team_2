package drip.competition.feedback.controller;

import drip.competition.feedback.entities.Tournament;
import drip.competition.feedback.entities.Match;
import drip.competition.feedback.repository.TournamentRepository;
import drip.competition.feedback.repository.MatchRepository;
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

    private final MatchRepository matchRepository;
    private final TournamentRepository tournamentRepository;

    public UserController(MatchRepository matchRepository,
                          TournamentRepository tournamentRepository) {
        this.matchRepository = matchRepository;
        this.tournamentRepository = tournamentRepository;
    }

    @PostMapping("/matches")
    @Transactional
    public ResponseEntity<Void> createMatch(@RequestBody Match match, UriComponentsBuilder builder) {
        Match saved = matchRepository.save(match);
        URI location = builder.path("/api/v1/feedback/matches/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build(); // 201 Created
    }

    @PostMapping("/tournaments")
    @Transactional
    public ResponseEntity<Void> createTournament(@RequestBody Tournament tournament, UriComponentsBuilder builder) {
        Tournament saved = tournamentRepository.save(tournament);
        URI location = builder.path("/api/v1/feedback/tournaments/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build(); // 201 Created
    }

    @GetMapping("/matches")
    public Page<Match> getMatches(@RequestParam UUID matchId, Pageable pageable) {
        return matchRepository.findByMatchId(matchId, pageable);
    }

    @GetMapping("/tournaments")
    public Page<Tournament> getTournaments(@RequestParam UUID tournamentId, Pageable pageable) {
        return tournamentRepository.findByTournamentId(tournamentId, pageable);
    }
}

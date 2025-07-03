package drip.competition.feedback.controller.user;

import drip.competition.feedback.entities.Competition;
import drip.competition.feedback.entities.Game;
import drip.competition.feedback.repository.CompetitionRepository;
import drip.competition.feedback.repository.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class User {

    private final GameRepository gameRepository;
    private final CompetitionRepository competitionRepository;

    public User(GameRepository gameRepository, CompetitionRepository competitionRepository) {
        this.gameRepository = gameRepository;
        this.competitionRepository = competitionRepository;
    }

    @PostMapping("/add/game")
    @Transactional
    public Game addGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @PostMapping("/add/competition")
    @Transactional
    public Competition addCompetition(@RequestBody Competition competition) {
        return competitionRepository.save(competition);
    }

    @GetMapping("/game")
    public List<Game> getAllGame(@RequestParam UUID idgame) {
        return gameRepository.findByIdgame(idgame);
    }

    @GetMapping("/competition")
    public List<Competition> getAllCompetition(@RequestParam UUID idcompetition) {
        return competitionRepository.findByIdcompetition(idcompetition);
    }
}

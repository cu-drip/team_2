package drip.competition.feedback.controller.user;


import drip.competition.feedback.entities.Competition;
import drip.competition.feedback.entities.Game;
import drip.competition.feedback.repository.CompetitionRepository;
import drip.competition.feedback.repository.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void addGame(@RequestParam long iduser,
                        @RequestParam long idgame,
                        @RequestParam int rating,

                        @RequestBody String text
    ) {
        gameRepository.addGame(iduser, idgame, text, rating);
    }

    @PostMapping("/add/competition")
    @Transactional
    public void addCompetition(@RequestParam long iduser,
                               @RequestParam long idcompetition,
                               @RequestParam int rating,

                               @RequestBody String text
    ) {
        competitionRepository.addCompetition(iduser, idcompetition, text, rating);
    }

    @GetMapping("/game")
    public List<Game> getAllGame(@RequestParam long idgame) {
        return gameRepository.findByGameId(idgame);
    }

    @GetMapping("/competition")
    public List<Competition> getAllCompetition(@RequestParam long idcompetition) {
        return competitionRepository.findByCompetitionId(idcompetition);
    }
}

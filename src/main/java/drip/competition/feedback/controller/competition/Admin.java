package drip.competition.feedback.controller.competition;

import drip.competition.feedback.entities.Competition;
import drip.competition.feedback.entities.Game;
import drip.competition.feedback.repository.CompetitionRepository;
import drip.competition.feedback.repository.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class Admin {

    private final GameRepository gameRepository;
    private final CompetitionRepository competitionRepository;

    public Admin(GameRepository gameRepository, CompetitionRepository competitionRepository) {
        this.gameRepository = gameRepository;
        this.competitionRepository = competitionRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/user")
    public List<Object> getByUser(@RequestParam UUID iduser) {
        List<Game> games = gameRepository.findByIduser(iduser);
        List<Competition> competitions = competitionRepository.findByIduser(iduser);

        List<Object> combined = new ArrayList<>();
        combined.addAll(games);
        combined.addAll(competitions);
        return combined;
    }
}

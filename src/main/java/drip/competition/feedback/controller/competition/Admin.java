package drip.competition.feedback.controller.competition;

import drip.competition.feedback.entities.Competition;
import drip.competition.feedback.entities.Game;
import drip.competition.feedback.repository.CompetitionRepository;
import drip.competition.feedback.repository.GameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class Admin {

    private final GameRepository gameRepository;
    private final CompetitionRepository competitionRepository;

    public Admin(GameRepository gameRepository, CompetitionRepository competitionRepository) {
        this.gameRepository = gameRepository;
        this.competitionRepository = competitionRepository;
    }

    @GetMapping("/user")
    public List<Object> getByUser(@RequestParam long iduser) {
        List<Game> games =  gameRepository.findByUserId(iduser);
        List<Competition> competitions =  competitionRepository.findByUserId(iduser);

        List<Object> list = new ArrayList<>();
        list.addAll(games);
        list.addAll(competitions);
        return list;
    }
}

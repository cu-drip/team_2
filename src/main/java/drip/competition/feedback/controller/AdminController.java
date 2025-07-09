package drip.competition.feedback.controller;

import drip.competition.feedback.entities.Competition;
import drip.competition.feedback.entities.Game;
import drip.competition.feedback.repository.CompetitionRepository;
import drip.competition.feedback.repository.GameRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final GameRepository gameRepository;
    private final CompetitionRepository competitionRepository;

    public AdminController(GameRepository gameRepository,
                           CompetitionRepository competitionRepository) {
        this.gameRepository = gameRepository;
        this.competitionRepository = competitionRepository;
    }

    @GetMapping("/user")
    @Transactional(readOnly = true)
    public List<Object> getByUser(@RequestParam UUID iduser) {
        List<Game> games = gameRepository.findByIduser(iduser);
        List<Competition> competitions = competitionRepository.findByIduser(iduser);
        List<Object> result = new ArrayList<>();
        result.addAll(games);
        result.addAll(competitions);
        return result;
    }
}

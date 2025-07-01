package drip.competition.feedback.controller.competition;

import drip.competition.feedback.repository.CompetitionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Admin {

    private final CompetitionRepository competitionRepository;

    public Admin(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @GetMapping("/competition")
    public List<Map<String, Object>> getAllAdmin() {
        return competitionRepository.findAllCompetitions();
    }
}

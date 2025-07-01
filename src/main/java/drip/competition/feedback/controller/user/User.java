package drip.competition.feedback.controller.user;


import drip.competition.feedback.repository.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class User {

    private final GameRepository gameRepository;



    public User(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping("/add/game")
    @Transactional
    public void addUser(@RequestParam int iduser,
                          @RequestParam int idgame,
                          @RequestParam String text,
                          @RequestParam int rating) {
        gameRepository.addUser(iduser, idgame, text, rating);
    }

    @GetMapping("/game")
    public List<Map<String, Object>> getAllUser() {
        return gameRepository.findAllUser();
    }
}

package drip.competition.feedback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private UUID iduser;

    @Column
    private UUID idgame;

    @Column
    private String text;

    @Column
    private Integer rating;
}

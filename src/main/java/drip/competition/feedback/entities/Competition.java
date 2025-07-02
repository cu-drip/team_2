package drip.competition.feedback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long iduser;

    @Column
    private Long idcompetition;

    @Column
    private String text;

    @Column
    private Integer rating;
}

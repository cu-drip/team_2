package drip.competition.feedback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Match {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column
    private UUID userId;

    @Column
    private UUID matchId;

    @Column
    private String text;

    @Column
    private Integer rating;

    @CreationTimestamp
    @Column(name = "created_at", updatable = true, nullable = false)
    private LocalDateTime createdAt;
}

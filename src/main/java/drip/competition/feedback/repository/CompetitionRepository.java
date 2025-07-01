package drip.competition.feedback.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface CompetitionRepository extends Repository<Object, Long> {

    @Modifying
    @Query(value = "INSERT INTO competition (iduser, idcompetition, text, rating) VALUES (:iduser, :idcompetition, :text, :rating)", nativeQuery = true)
    void addCompetition(@Param("iduser") int iduser,
                 @Param("idcompetition") int ididcompetitiongame,
                 @Param("text") String text,
                 @Param("rating") int rating);

    @Query(value = "SELECT * FROM competition", nativeQuery = true)
    List<Map<String, Object>> findAllCompetitions();
}

package drip.competition.feedback.repository;

import drip.competition.feedback.entities.Competition;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompetitionRepository extends Repository<Competition, Long> {

    @Modifying
    @Query(value = "INSERT INTO competition (iduser, idcompetition, text, rating) VALUES (:iduser, :idcompetition, :text, :rating)", nativeQuery = true)
    void addCompetition(@Param("iduser") long iduser,
                 @Param("idcompetition") long idcompetition,
                 @Param("text") String text,
                 @Param("rating") int rating);

    @Query(value = "SELECT * FROM competition WHERE idcompetition = :idcompetition", nativeQuery = true)
    List<Competition> findByCompetitionId(@Param("idcompetition") long idcompetition);

    @Query(value = "SELECT * FROM competition WHERE iduser = :iduser", nativeQuery = true)
    List<Competition> findByUserId(@Param("iduser") long iduser);
}

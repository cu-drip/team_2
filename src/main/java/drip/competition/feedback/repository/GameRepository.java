package drip.competition.feedback.repository;

import drip.competition.feedback.entities.Game;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends Repository<Game, Long> {

    @Modifying
    @Query(value = "INSERT INTO game (iduser, idgame, text, rating) VALUES (:iduser, :idgame, :text, :rating)", nativeQuery = true)
    void addGame(@Param("iduser") long iduser,
                 @Param("idgame") long idgame,
                 @Param("text") String text,
                 @Param("rating") int rating);

    @Query(value = "SELECT * FROM game WHERE idgame = :idgame", nativeQuery = true)
    List<Game> findByGameId(@Param("idgame") long idgame);

    @Query(value = "SELECT * FROM game WHERE iduser = :iduser", nativeQuery = true)
    List<Game> findByUserId(@Param("iduser") long iduser);
}

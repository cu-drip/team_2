package drip.competition.feedback.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface GameRepository extends Repository<Object, Long> {

    @Modifying
    @Query(value = "INSERT INTO game (iduser, idgame, text, rating) VALUES (:iduser, :idgame, :text, :rating)", nativeQuery = true)
    void addUser(@Param("iduser") int iduser,
                 @Param("idgame") int idgame,
                 @Param("text") String text,
                 @Param("rating") int rating);

    @Query(value = "SELECT * FROM game", nativeQuery = true)
    List<Map<String, Object>> findAllUser();
}

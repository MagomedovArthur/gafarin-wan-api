package io.lekitech.gafarin_wan.repository;

import io.lekitech.gafarin_wan.entity.Expression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExpressionRepository extends JpaRepository<Expression, UUID> {

    @Query(value = """
            SELECT *
            FROM expression exp
            WHERE exp.language_id = :language
              AND exp.id NOT IN (SELECT mf.expression_id FROM media_file mf WHERE mf.media_type = 'AUDIO')
            ORDER BY RANDOM()
            LIMIT 1
            """,
            nativeQuery = true)
    Optional<Expression> getRandomExpressionByLang(@NonNull @Param("language") String language);
}

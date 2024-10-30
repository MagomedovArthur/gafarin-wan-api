package io.lekitech.gafarin_wan.repository;

import io.lekitech.gafarin_wan.entity.MediaFile;
import io.lekitech.gafarin_wan.entity.type.Mediatype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AudioExpressionRepository extends JpaRepository<MediaFile, UUID> {

    @Query(value = """
            SELECT COUNT(*)
            FROM media_file mf
                     JOIN expression exp on mf.expression_id = exp.id
            WHERE exp.language_id = :language
            """,
            nativeQuery = true)
    Integer getAllExpressionsWithAudio(@NonNull @Param("language") String language);

    @Query(value = """
            SELECT COUNT(*)
            FROM expression exp
            WHERE language_id = :language
            """,
            nativeQuery = true)
    Integer getAllExpressionByLanguage(@NonNull @Param("language") String language);

    @Query(value = """
            INSERT INTO media_file (expression_id, media_type, url)
            VALUES (:expressionId, CAST(:mediaType AS MEDIA_TYPE), :audioUrl)
            RETURNING *
            """,
            nativeQuery = true)
    MediaFile saveAudioExpressions(
            @NonNull @Param("expressionId") UUID expressionId,
            @NonNull @Param("mediaType") String mediaType,
            @NonNull @Param("audioUrl") String audioUrl);
}

package io.lekitech.gafarin_wan.service;

import io.lekitech.gafarin_wan.dto.ExpressionStatisticDto;
import io.lekitech.gafarin_wan.entity.MediaFile;
import io.lekitech.gafarin_wan.entity.type.Mediatype;
import io.lekitech.gafarin_wan.repository.AudioExpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AudioExpressionService {

    private final AudioExpressionRepository audioExpressionRepo;

    @Transactional
    public ExpressionStatisticDto getAllExpressionsWithAudio(String language) {
        Integer numberOfAudioExp = audioExpressionRepo.getAllExpressionsWithAudio(language);
        Integer totalNumberOfExp = audioExpressionRepo.getAllExpressionByLanguage(language);
        return new ExpressionStatisticDto(numberOfAudioExp, totalNumberOfExp);
    }

    @Transactional
    public void saveAudioExpressions(MultipartFile audioFile, UUID expressionId, String spelling) {
    /*
       todo Save in DigitalOcean storage and get audio's URL
    */
        UUID url = UUID.randomUUID();
        String tempAudioUrl = url.toString();
        // todo Добавить обработку исключений
        MediaFile result = audioExpressionRepo.saveAudioExpressions(expressionId, Mediatype.AUDIO.name(), tempAudioUrl);
    }
}
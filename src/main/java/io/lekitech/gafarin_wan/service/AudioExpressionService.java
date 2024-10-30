package io.lekitech.gafarin_wan.service;

import io.lekitech.gafarin_wan.dto.ExpressionStatisticDto;
import io.lekitech.gafarin_wan.repository.AudioExpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}

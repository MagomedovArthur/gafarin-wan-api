package io.lekitech.gafarin_wan.controller;

import io.lekitech.gafarin_wan.dto.ExpressionDto;
import io.lekitech.gafarin_wan.dto.ExpressionStatisticDto;
import io.lekitech.gafarin_wan.service.AudioExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/audio-expression")
@RequiredArgsConstructor
public class AudioExpression {

    private final AudioExpressionService audioExpressionService;

    @GetMapping(path = "/list")
    public ResponseEntity<ExpressionStatisticDto> getAllExpressionsWithAudio(
            @RequestParam(name = "language") String language) {
        final ExpressionStatisticDto statistic = audioExpressionService.getAllExpressionsWithAudio(language);
        return ResponseEntity.ok(statistic);
    }

    @PostMapping(consumes = "multipart/form-data")
    public void saveAudioExpressions(@RequestParam("audioFile") MultipartFile audioFile,
                                     @RequestParam("expressionId") UUID expressionId,
                                     @RequestParam("spelling") String spelling) {
        audioExpressionService.saveAudioExpressions(audioFile, expressionId, spelling);
    }
}

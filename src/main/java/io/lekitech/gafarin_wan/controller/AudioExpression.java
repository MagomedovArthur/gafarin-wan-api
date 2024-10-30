package io.lekitech.gafarin_wan.controller;

import io.lekitech.gafarin_wan.dto.ExpressionStatisticDto;
import io.lekitech.gafarin_wan.service.AudioExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

package io.lekitech.gafarin_wan.controller;

import io.lekitech.gafarin_wan.dto.ExpressionDto;
import io.lekitech.gafarin_wan.service.ExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ExpressionController {

    private final ExpressionService expressionService;

    @GetMapping(path = "/get-random-word")
    public ResponseEntity<ExpressionDto> getRandomExpression() {
        final ExpressionDto expression = expressionService.getRandomExpression();
        return ResponseEntity.ok(expression);
    }
}

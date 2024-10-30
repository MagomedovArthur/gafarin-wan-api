package io.lekitech.gafarin_wan.controller;

import io.lekitech.gafarin_wan.dto.ExpressionDto;
import io.lekitech.gafarin_wan.service.ExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expression")
@RequiredArgsConstructor
public class ExpressionController {

    private final ExpressionService expressionService;

    @GetMapping(path = "/get-random")
    public ResponseEntity<ExpressionDto> getRandomExpressionByLang(@RequestParam(name = "language") String language) {
        final ExpressionDto expression = expressionService.getRandomExpressionByLang(language);
        return ResponseEntity.ok(expression);
    }
}

package io.lekitech.gafarin_wan.service;

import io.lekitech.gafarin_wan.dto.ExpressionDto;
import io.lekitech.gafarin_wan.entity.Expression;
import io.lekitech.gafarin_wan.exception.ExpressionNotFound;
import io.lekitech.gafarin_wan.mapper.ExpressionMapper;
import io.lekitech.gafarin_wan.repository.ExpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpressionService {

    private final ExpressionRepository expressionRepo;
    private final ExpressionMapper expressionMapper;

    public ExpressionDto getRandomExpressionByLang(String language) {
        Optional<Expression> expression = expressionRepo.getRandomExpressionByLang(language);
        if (expression.isEmpty()) {
            throw new ExpressionNotFound("No expressions found for this language: " + language);
        }
        return expressionMapper.toExpressionDto(expression.get());
    }
}

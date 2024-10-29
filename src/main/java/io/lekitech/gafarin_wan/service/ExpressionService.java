package io.lekitech.gafarin_wan.service;

import io.lekitech.gafarin_wan.dto.ExpressionDto;
import io.lekitech.gafarin_wan.entity.Expression;
import io.lekitech.gafarin_wan.mapper.ExpressionMapper;
import io.lekitech.gafarin_wan.repository.ExpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpressionService {

    private final ExpressionRepository expressionRepository;
    private final ExpressionMapper expressionMapper;

    public ExpressionDto getRandomExpression() {
        Optional<Expression> expression = expressionRepository.getRandomExpression();
        if (expression.isEmpty()) {
            throw new RuntimeException(); // todo
        }
        return expressionMapper.toExpressionDto(expression.get());
    }
}

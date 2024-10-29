package io.lekitech.gafarin_wan.mapper;

import io.lekitech.gafarin_wan.dto.ExpressionDto;
import io.lekitech.gafarin_wan.entity.Expression;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExpressionMapper {

    ExpressionMapper INSTANCE = Mappers.getMapper(ExpressionMapper.class);

    ExpressionDto toExpressionDto(Expression expression);
}

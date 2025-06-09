package com.szmtr.business.domain.convert;

import com.szmtr.business.domain.Rdssection;
import com.szmtr.business.dto.RdssectionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RdssectionModelConvert {
    RdssectionModelConvert INSTANCE = Mappers.getMapper(RdssectionModelConvert.class);

    // 单实体转 DTO
    // 单个对象转换
    Rdssection toEntity(RdssectionDto dto);

    RdssectionDto toDTO(Rdssection entity);

    // 集合转换
    List<Rdssection> toEntityList(List<RdssectionDto> dtos);

    List<RdssectionDto> toDTOList(List<Rdssection> entities);
}

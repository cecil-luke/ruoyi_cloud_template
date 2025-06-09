package com.szmtr.business.domain.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import com.szmtr.business.domain.Rdsappsoption;
import com.szmtr.business.dto.query.RdsappsoptionQuery;
import com.szmtr.business.dto.RdsappsoptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RdsappsoptionModelConvert {
    RdsappsoptionModelConvert INSTANCE = Mappers.getMapper(RdsappsoptionModelConvert.class);

    // 单实体转 DTO
    // 单个对象转换
    Rdsappsoption toEntity(RdsappsoptionDto dto);

    RdsappsoptionDto toDTO(Rdsappsoption entity);

    // 集合转换
    List<Rdsappsoption> toEntityList(List<RdsappsoptionDto> dtos);

    List<RdsappsoptionDto> toDTOList(List<Rdsappsoption> entities);
}

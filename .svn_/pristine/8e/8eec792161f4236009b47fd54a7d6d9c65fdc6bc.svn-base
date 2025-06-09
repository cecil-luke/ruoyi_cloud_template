package com.szmtr.business.domain.convert;

import com.szmtr.business.domain.Rdscodetype;
import com.szmtr.business.dto.RdscodetypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RdscodetypeModelConvert {
    RdscodetypeModelConvert INSTANCE = Mappers.getMapper(RdscodetypeModelConvert.class);

    // 单实体转 DTO
    // 单个对象转换
    Rdscodetype toEntity(RdscodetypeDto dto);

    RdscodetypeDto toDTO(Rdscodetype entity);

    // 集合转换
    List<Rdscodetype> toEntityList(List<RdscodetypeDto> dtos);

    List<RdscodetypeDto> toDTOList(List<Rdscodetype> entities);
}

package com.szmtr.system.domain.convert;

import com.szmtr.system.domain.SysFileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import com.szmtr.system.domain.SysFileEntity;
import com.szmtr.system.dto.query.SysFileQuery;
import com.szmtr.system.dto.SysFileDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SysFileModelConvert {
    SysFileModelConvert INSTANCE = Mappers.getMapper(SysFileModelConvert.class);

    // 单实体转 DTO
    // 单个对象转换
    SysFileEntity toEntity(SysFileDto dto);

    SysFileDto toDTO(SysFileEntity entity);

    // 集合转换
    List<SysFileEntity> toEntityList(List<SysFileDto> dtos);

    List<SysFileDto> toDTOList(List<SysFileEntity> entities);
}

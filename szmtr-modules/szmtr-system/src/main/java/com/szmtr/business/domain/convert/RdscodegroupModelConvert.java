package com.szmtr.business.domain.convert;

import com.szmtr.business.dto.RdscodegroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import com.szmtr.business.domain.Rdscodegroup;
import com.szmtr.business.dto.query.RdscodegroupQuery;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RdscodegroupModelConvert {
    RdscodegroupModelConvert INSTANCE = Mappers.getMapper(RdscodegroupModelConvert.class);

    // 单实体转 DTO
    // 单个对象转换
    Rdscodegroup toEntity(RdscodegroupDto dto);

    RdscodegroupDto toDTO(Rdscodegroup entity);

    // 集合转换
    List<Rdscodegroup> toEntityList(List<RdscodegroupDto> dtos);

    List<RdscodegroupDto> toDTOList(List<Rdscodegroup> entities);
}

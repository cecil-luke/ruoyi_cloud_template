package com.szmtr.business.domain.convert;

import com.szmtr.common.core.boot.mapper.BaseModelMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import com.szmtr.business.domain.Rdsapps;
import com.szmtr.business.dto.query.RdsappsQuery;
import com.szmtr.business.dto.RdsappsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RdsappsModelConvert extends BaseModelMapper<RdsappsDto, Rdsapps> {
    RdsappsModelConvert INSTANCE = Mappers.getMapper(RdsappsModelConvert.class);
}

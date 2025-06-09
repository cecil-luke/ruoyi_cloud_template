package com.szmtr.business.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.szmtr.business.domain.Rdscodetype;
import com.szmtr.business.dto.RdscodetypeDto;
import com.szmtr.common.core.utils.StringUtils;

import java.io.IOException;
import java.util.List;

public class ConvertToRdscodetypeUtil {
    /**
     * 将JSON字符串数组转换为AcceptClassColumnUtil列表
     */
    public static List<AcceptClassColumnUtil> parseJsonArray(String jsonArray) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonArray, new TypeReference<List<AcceptClassColumnUtil>>() {
        });
    }

    /**
     * 将AcceptClassColumnUtil列表映射到Rdscodetype实体
     */
    public static RdscodetypeDto mapToRdscodetype(List<AcceptClassColumnUtil> columnList) {
        RdscodetypeDto rdscodetypeDto = new RdscodetypeDto();

        for (AcceptClassColumnUtil column : columnList) {
            String attributeCode = (column.getAttributeModelCode() != null) ? column.getAttributeModelCode().toUpperCase() : "";
            switch (attributeCode) {
                case "RDSCODETYPE":
                    rdscodetypeDto.setRdscodetype(column.getValue());
                    break;
                case "RDSCODETYPENAME":
                    rdscodetypeDto.setRdscodetypename(column.getValue());
                    break;
                case "RDSVERSION":
                    //不为空，且值为不包含0的自然数
                    if (StringUtils.isNotBlank(column.getValue()) && RegularUtil.isNaturalNumber(column.getValue(), false)) {
                        rdscodetypeDto.setRdsversion(Long.parseLong(column.getValue()));
                    } else {
                        // 处理版本号转换异常
                        rdscodetypeDto.setRdsversion(0L);
                    }
                    break;
                case "RDSREMARK":
                    rdscodetypeDto.setRdsremark(column.getValue());
                    break;

                // 可以继续添加其他字段的映射
            }
        }
        return rdscodetypeDto;
    }
}

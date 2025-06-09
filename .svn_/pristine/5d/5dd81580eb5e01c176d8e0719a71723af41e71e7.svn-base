package com.szmtr.gen.service;

import java.util.List;

import com.szmtr.common.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szmtr.common.core.text.Convert;
import com.szmtr.gen.domain.GenTableColumn;
import com.szmtr.gen.mapper.GenTableColumnMapper;
import com.szmtr.gen.util.GenUtils;

/**
 * 业务字段 服务层实现
 *
 * @author szmtr
 */
@Service
public class GenTableColumnServiceImpl implements IGenTableColumnService
{
	@Autowired
	private GenTableColumnMapper genTableColumnMapper;

	/**
	 * 查询业务字段列表
	 *
	 * @param tableId 业务字段编号
	 * @return 业务字段集合
	 */
	@Override
	public List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId)
	{
		List<GenTableColumn> columns = genTableColumnMapper.selectGenTableColumnListByTableId(tableId);
		// 对查询结果进行字段名转换处理
		processColumnNames(columns);
		return columns;
	}

	/**
	 * 新增业务字段
	 *
	 * @param genTableColumn 业务字段信息
	 * @return 结果
	 */
	@Override
	public int insertGenTableColumn(GenTableColumn genTableColumn)
	{
		// 插入前处理字段名
		processColumnName(genTableColumn);
		return genTableColumnMapper.insertGenTableColumn(genTableColumn);
	}

	/**
	 * 修改业务字段
	 *
	 * @param genTableColumn 业务字段信息
	 * @return 结果
	 */
	@Override
	public int updateGenTableColumn(GenTableColumn genTableColumn)
	{
		// 更新前处理字段名
		processColumnName(genTableColumn);
		return genTableColumnMapper.updateGenTableColumn(genTableColumn);
	}

	/**
	 * 删除业务字段对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteGenTableColumnByIds(String ids)
	{
		return genTableColumnMapper.deleteGenTableColumnByIds(Convert.toLongArray(ids));
	}

	/**
	 * 处理单个字段的列名转换
	 * @param column 字段对象
	 */
	private void processColumnName(GenTableColumn column) {
		if (column != null && StringUtils.isNotEmpty(column.getColumnName())) {
			// 统一转为小写
			String lowerName = column.getColumnName().toLowerCase();
			// 设置处理后的列名
			column.setColumnName(lowerName);
			// 设置Java字段名（有下划线转驼峰，无下划线保持小写）
			column.setJavaField(GenUtils.convertJavaField(lowerName));
		}
	}

	/**
	 * 批量处理字段列名转换
	 * @param columns 字段列表
	 */
	private void processColumnNames(List<GenTableColumn> columns) {
		if (columns != null) {
			for (GenTableColumn column : columns) {
				processColumnName(column);
			}
		}
	}
}
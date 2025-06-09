package com.szmtr.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName PageResult
 * @Author Lss
 * @Date 2025/5/21
 * @Description: 分页数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResults<T> {
    /** 当前页数据 */
    private List<T> data;

    /** 总记录数 */
    private long total;

    /** 当前页码 */
    private int currentPage;

    /** 每页数量 */
    private int pageSize;

    /** 总页数 */
    private int totalPages;
}

package com.otg.morning.common;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * @Author:zhaohengbin
 * @Despriction:
 * @Date:Created in 21:58 2018/12/5
 * @Modify By:
 */
public interface MorningDatabasesMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>,
        MySqlMapper<T>,
        IdsMapper<T>,
        ExampleMapper<T>,
        RowBoundsMapper<T> {
}

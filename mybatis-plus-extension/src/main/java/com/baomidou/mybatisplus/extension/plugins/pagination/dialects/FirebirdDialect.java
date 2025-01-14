package com.baomidou.mybatisplus.extension.plugins.pagination.dialects;

import com.baomidou.mybatisplus.extension.plugins.pagination.DialectModel;

/**
 * Firebird 数据库分页语句组装实现,SQL测试版本为4.0
 * 备注：The FIRST/SKIP and ROWS clause are non-standard alternatives
 *
 * @author cdtjj
 * @since 2022-04-26
 */
public class FirebirdDialect implements IDialect {

    @Override
    public DialectModel buildPaginationSql(String originalSql, long offset, long limit) {
        String sql = originalSql + " OFFSET " + FIRST_MARK + " ROWS FETCH NEXT " + SECOND_MARK + " ROWS ONLY";
        return new DialectModel(sql, offset, limit).setConsumerChain();
    }
}

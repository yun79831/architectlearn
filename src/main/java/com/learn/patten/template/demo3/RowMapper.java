package com.learn.patten.template.demo3;

import java.sql.ResultSet;

/**
 * Created by admin on 2018/3/31.
 */
public interface RowMapper<T> {
    public T mapRow(ResultSet rs, int rowNum) throws Exception;
}

package com.learn.patten.template.demo3;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/3/31.
 */
public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {

        List<Object> result = new ArrayList<Object>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i, values[i]);
            }
            ResultSet rs = pstmt.executeQuery();

            int rowNum = 1;
            while (rs.next()) {
                result.add(rowMapper.mapRow(rs, rowNum++));
            }
            pstmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return result;

    }

}

package com.learn.patten.template.tool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/3/11.
 */
public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, Object[] values) {
        try {
            //1.获取链接
            Connection conn = dataSource.getConnection();
            //创建语句
            PreparedStatement pst = getPreparedStatement(sql, conn);
            //执行语句
            ResultSet rs = pst.executeQuery();
            //解析语句
            List<Object> result = new ArrayList();
            if(rs.next()){
                result.add(processResult(rs,rs.getRow()));
            }
            //关闭结果集
            rs.close();
            //关闭语句集
            pst.close();
            //关闭链接
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    private PreparedStatement getPreparedStatement(String sql, Connection conn) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public abstract Object processResult(ResultSet rs,int row);
}

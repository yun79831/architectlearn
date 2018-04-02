package com.learn.patten.template.demo3.dao;

import com.learn.patten.template.demo3.JdbcTemplate;
import com.learn.patten.template.demo3.RowMapper;
import com.learn.patten.template.demo3.entity.User;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by admin on 2018/3/31.
 */
public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<?> query() {
        String sql = "select * from user";
        return jdbcTemplate.executeQuery(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws Exception {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setAge(rs.getString("age"));
                user.setSex(rs.getString("sex"));
                return null;
            }
        }, null);
    }
}

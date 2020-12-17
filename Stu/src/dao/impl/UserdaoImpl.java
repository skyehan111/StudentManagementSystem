package dao.impl;

import dao.Userdao;
import domain.UserBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JDBCUtil02;

import java.sql.SQLException;
import java.util.List;

public class UserdaoImpl implements Userdao {
    @Override
    public UserBean searchUser(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from user where username = ? and password = ?";
        UserBean user = runner.query(sql,new BeanHandler<UserBean>(UserBean.class),username,password);
        return user;
    }

    @Override
    public void register(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "insert into user values(?,?)";
        runner.update(sql,username,password);
    }
}

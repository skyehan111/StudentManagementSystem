package dao;

import domain.UserBean;

import java.sql.SQLException;
import java.util.List;

public interface Userdao {
    /*
    登录验证，根据用户输入的用户名和密码查找数据库，返回一个userbean
     */
    public UserBean searchUser(String username, String password)throws SQLException;

    /*
    注册
     */
    public void register(String username, String password)throws SQLException;
}

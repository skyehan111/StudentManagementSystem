package service.impl;

import dao.Userdao;
import dao.impl.UserdaoImpl;
import domain.UserBean;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public UserBean searchUser(String username, String password) throws SQLException {
        Userdao dao = new UserdaoImpl();
        return dao.searchUser(username,password );
    }

    @Override
    public void register(String username, String password) throws SQLException {
        Userdao dao = new UserdaoImpl();
        dao.register(username,password );
    }
}

package servlet;

import domain.UserBean;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserService service = new UserServiceImpl();
            UserBean user = service.searchUser(username,password );
            if (user!=null){
                request.setAttribute("username",user.getUsername() );
                request.getRequestDispatcher("welcome.jsp").forward(request,response );
            }else {
                response.getWriter().write("<script language=javascript>alert('The username and password you entered is incorrect');window.location='index.jsp'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

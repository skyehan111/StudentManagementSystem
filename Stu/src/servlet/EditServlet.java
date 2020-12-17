package servlet;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/*
单个学生的更新，获取学生的信息，跳转到更新界面edit.jsp
 */
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int sid = Integer.parseInt(request.getParameter("sid"));
            StudentService service = new StudentServiceImpl();
            Student student = service.findStudentById(sid);
            //存数据
            request.setAttribute("stu",student );
            //跳转
            request.getRequestDispatcher("edit.jsp").forward(request,response );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

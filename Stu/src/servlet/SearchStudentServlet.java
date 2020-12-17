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
import java.util.List;

/*
模糊查询
 */
public class SearchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            //取到了查询的条件
            String sname = request.getParameter("sname");
            String sgender = request.getParameter("sgender");

            StudentService service = new StudentServiceImpl();
            List<Student> list = service.searchStudent(sname,sgender );
            request.setAttribute("list", list);

            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

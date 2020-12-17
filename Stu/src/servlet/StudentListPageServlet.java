package servlet;

import domain.PageBean;
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
分页显示学生
 */
public class StudentListPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取需要显示的页码数
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            //根据指定的页数，获取该页的数据
            StudentService service = new StudentServiceImpl();
            PageBean pageBean = service.findStudentByPage(currentPage);

            //跳转页面
            request.setAttribute("pageBean", pageBean);
            request.getRequestDispatcher("list_page.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

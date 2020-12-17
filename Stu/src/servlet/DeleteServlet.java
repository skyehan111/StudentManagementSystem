package servlet;

import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.sql.SQLException;

/*
用于处理删除学生
 */
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int sid = Integer.parseInt(request.getParameter("sid"));
            StudentService service = new StudentServiceImpl();
            service.delete(sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("StudentListServlet").forward(request,response );
    }
}

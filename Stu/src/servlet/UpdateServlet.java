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
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //提交数据中有中文
        request.setCharacterEncoding("UTF-8");
        try {
            //获取客户端提交的数据
            int sid = Integer.parseInt(request.getParameter("sid"));
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            //String转到Date
            String birthday = request.getParameter("birthday");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            //getParameter只能取一个,用getParameterValue获取数组
            String[] h = request.getParameterValues("hobby");
            //数组转字符串
            String hobby = Arrays.toString(h).substring(1, Arrays.toString(h).length() - 1);
            String info = request.getParameter("info");
            //添加到数据库
            Student student = new Student(sid, sname, gender, phone, date, hobby, info);
            StudentService service = new StudentServiceImpl();
            service.update(student);
            request.getRequestDispatcher("StudentListServlet").forward(request,response );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

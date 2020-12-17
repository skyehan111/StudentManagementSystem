package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.PageBean;
import domain.Student;
import service.StudentService;

import java.sql.SQLException;
import java.util.List;

/*
学生业务实现
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findAll();
    }

    @Override
    public void insert(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.insert(student);
    }

    @Override
    public void delete(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.delete(sid);
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findStudentById(sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.update(student);

    }

    @Override
    public List<Student> searchStudent(String sname, String sgender) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.searchStudent(sname, sgender);
    }

    @Override
    public PageBean findStudentByPage(int currentPage) throws SQLException {
        //封装分页的数据
        PageBean<Student> pagebean = new PageBean<Student>();
        pagebean.setCurrentPage(currentPage);
        int pagesize = StudentDao.PAGE_SIZE;
        pagebean.setPageSize(pagesize);

        StudentDao dao = new StudentDaoImpl();
        List<Student> list = dao.findStudentByPage(currentPage);
        pagebean.setList(list);

        //总的记录数和总页数
        int count = dao.findCount();
        pagebean.setTotalSize(count);

        pagebean.setTotalPage(count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1);
        return pagebean;
    }

}

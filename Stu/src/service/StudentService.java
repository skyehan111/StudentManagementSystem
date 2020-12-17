package service;

import domain.PageBean;
import domain.Student;

import java.sql.SQLException;
import java.util.List;

/*
一个dao对应一个service
这是学生的业务处理规范
 */
public interface StudentService {
    /*
    查询所有学生
    @return List<Student>
    */
    List<Student> findAll() throws SQLException;

    /*
    添加学生
     */
    void insert(Student student) throws SQLException;

    /*
   删除学生
    */
    void delete(int sid) throws SQLException;

    /*
    根据id查学生
     */
    Student findStudentById(int sid) throws SQLException;

    /*
    更新学生
     */
    void update(Student student) throws SQLException;

    /*
    模糊查询
     */
    List<Student> searchStudent(String sname, String sgender) throws SQLException;

    /*
    查询当前页的学生数据
    @return List<Student>
     */
    PageBean findStudentByPage(int currentPage) throws SQLException;
}

package dao;

import domain.Student;

import java.sql.SQLException;
import java.util.List;

/*
针对学生表的数据访问
 */
public interface StudentDao {
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

    //设置分页中每页学生数据数量
    int PAGE_SIZE = 5;

    /*
    查询当前页的学生数据
    @return List<Student>
     */
    List<Student> findStudentByPage(int currentPage) throws SQLException;

    //查询总的记录数
    int findCount() throws SQLException;
}

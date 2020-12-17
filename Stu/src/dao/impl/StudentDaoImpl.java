package dao.impl;

import dao.StudentDao;
import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JDBCUtil02;
import util.TextUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
这是StudentDao的实现类。针对前面定义的规范，作出具体的实现
 */
public class StudentDaoImpl implements StudentDao {
    /*
    查询所有学生
     */
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from stu";
        List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
        return list;
    }

    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "insert into stu values(null,?,?,?,?,?,?)";
        runner.update(sql,
                student.getSname(), student.getGender(), student.getPhone(),
                student.getBirthday(), student.getHobby(), student.getInfo()
        );
    }

    @Override
    public void delete(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "delete from stu where sid = ?";
        runner.update(sql, sid);
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from stu where sid = ?";
        Student student = runner.query(sql, new BeanHandler<Student>(Student.class), sid);
        return student;
    }

    @Override
    public void update(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "update stu set sname = ?, gender = ?,phone = ?,birthday = ?,hobby = ?,info = ? where sid = ?";
        runner.update(sql, student.getSname(), student.getGender(), student.getPhone(),
                student.getBirthday(), student.getHobby(), student.getInfo(), student.getSid());
    }

    @Override
    public List<Student> searchStudent(String sname, String sgender) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        List<String> list = new ArrayList<String>();
        /*
        如果只有姓名无性别
        select * from stu where sname like ?
        如果只有性别无姓名
        select * from stu where sgender=?
        如果既有姓名又有性别
        select * from stu where sname like ? and sgender=?
        如果两个都没有，查询所有
        select * from stu
         */
        String sql = "select * from stu where 1=1";
        if (!TextUtil.isEmpty(sname)) {
            sql = sql + " and sname like ?";
            list.add("%" + sname + "%");
        }
        if (!TextUtil.isEmpty(sgender)) {
            sql = sql + " and gender = ?";
            list.add(sgender);
        }
        return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
    }

    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        //第一个问号表示一页显示多少数据，第二个问号表示跳过前面的几条记录
        String sql = "select * from stu limit ? offset ?";
        return runner.query(sql, new BeanListHandler<Student>(Student.class), PAGE_SIZE, (currentPage - 1) * PAGE_SIZE);
    }

    @Override
    public int findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select count(*) from stu";
        Long result = (long) runner.query(sql, new ScalarHandler());
        return result.intValue();
    }
}

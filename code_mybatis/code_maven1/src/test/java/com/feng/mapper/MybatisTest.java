package com.feng.mapper;

import com.feng.pojo.Student;
import com.feng.pojo.Student1;
import com.feng.pojo.Teacher;
import com.feng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MybatisTest {
    static Logger logger = Logger.getLogger(StudentMapper.class);
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student1> studentList = mapper.getStudentList();
//        List<Student1> selectList = sqlSession.selectList("com.feng.mapper.StudentMapper.getStudentList");
        for(Student1 i:studentList){
            System.out.println(i);
        }
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student studentById = mapper.getStudentById("%张%");
        System.out.println(studentById);
        sqlSession.close();
    }
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.UpdateStudent(new Student(1,"张三","125450"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.InsertStudent(new Student(4,"哇哇","312643"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test5(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.DeleteStudent(4);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test6(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("StudentId",4);
        stringObjectHashMap.put("StudentName","王五");
        stringObjectHashMap.put("StudentPwd","317458");
        mapper.addStudent(stringObjectHashMap);
        sqlSession.commit();
        sqlSession.close();
    }
//    @Test
//    public void test7(){
//        static Logger logger = Logger.getLogger(StudentMapper.class);
//        logger.info("info:进入了");
//        logger.warn("warn:进入了");
//        logger.trace("trace:进入了");
//        logger.fatal("fatal:进入了");
//        logger.error("error:错误了");
//        logger.debug("debug:测试中");
//    }
    @Test
    public void test8(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("startIndex",0);
        stringObjectHashMap.put("pageSize",2);
        List<Student> students = mapper.selectStudentByLimit(stringObjectHashMap);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void test9(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void test10(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("StudentId",9);
        stringObjectHashMap.put("StudentName","hello");
        stringObjectHashMap.put("StudentPwd","8938954");
        mapper.insertStudent(stringObjectHashMap);
        sqlSession.close();
    }
    @Test
    public void test11(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.deleteStudent(9);
        sqlSession.close();
    }
    @Test
    public void test12(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name","hello");
        stringObjectHashMap.put("id",2);
        mapper.updateStudent(stringObjectHashMap);
        sqlSession.close();
    }
    @Test
    public void test13(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void test14(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}

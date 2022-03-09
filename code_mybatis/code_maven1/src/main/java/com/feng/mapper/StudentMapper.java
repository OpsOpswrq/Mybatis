package com.feng.mapper;

import com.feng.pojo.Student1;
import com.feng.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Student1> getStudentList();
    Student getStudentById(String value);
    void UpdateStudent(Student student);
    void InsertStudent(Student student);
    void DeleteStudent(int id);
    void addStudent(Map<String,Object> map);
    List<Student> selectStudentByLimit(Map<String,Object> map);
    @Select("select * from student")
    List<Student> selectStudents();
    @Insert("insert into student(id,name,pwd) values(#{StudentId},#{StudentName},#{StudentPwd})")
    void insertStudent(Map<String,Object> map);
    @Delete("delete from student where id=#{did}")
    void deleteStudent(@Param("did") int id);
    @Update("update student set name=#{name} where id=#{id}")
    void updateStudent(Map<String,Object> map);
}

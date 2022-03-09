package com.feng.mapper;

import com.feng.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("select * from user.teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);
}

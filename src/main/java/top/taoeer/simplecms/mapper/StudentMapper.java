package top.taoeer.simplecms.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import top.taoeer.simplecms.domain.Student;

public interface StudentMapper {
    @Select("select * from student where id = #{id}")
    Student selectOne(int id);

    @Insert("insert into student(name,age,sex) value(#{name}, #{age}, #{sex})")
    void insert(Student student);

    @Delete("delete from student where id = #{id}")
    void delete(int id);
}

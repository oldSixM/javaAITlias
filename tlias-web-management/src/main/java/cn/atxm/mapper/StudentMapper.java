package cn.atxm.mapper;

import cn.atxm.pojo.Student;
import cn.atxm.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Mapper
public interface StudentMapper {
    List<Student> list(StudentQueryParam queryParam);

    void delete(List<Integer> list);

    void insert(Student student);

    @Select("select * from student where id=#{id}")
    Student getById(Integer id);

    void update(Student student);


    @MapKey("name")
    List<Map<Object, Object>> getStudentDegreeData();
}

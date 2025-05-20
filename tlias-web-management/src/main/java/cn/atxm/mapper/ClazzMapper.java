package cn.atxm.mapper;

import cn.atxm.pojo.Clazz;
import cn.atxm.pojo.ClazzQueryParam;
import cn.atxm.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Mapper
public interface ClazzMapper {
    List<Clazz> list(ClazzQueryParam queryParam);

    @Delete("delete from clazz where id = #{id}")
    void delete(Integer id);

    void insert(Clazz clazz);

    @Select("select id,name,room,begin_date,end_date,master_id,subject,create_time,update_time from clazz where id = #{id};")
    Clazz getById(Integer id);

    void update(Clazz clazz);

    @MapKey("pos")
    List<Map<Object, Object>> getStudentCountData();

    @Select("select * from clazz")
    List<Clazz> AllList();
}

package cn.atxm.mapper;

import cn.atxm.pojo.Emp;
import cn.atxm.pojo.EmpQueryParam;
import cn.atxm.pojo.LoginInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/3
 */
@Mapper
public interface EmpMapper {

    List<Emp> list(EmpQueryParam empQueryParam);

    @Select("select * from emp")
    List<Emp> alllist();

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into emp(username,password,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) " +
            "values(#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    void delete(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    @MapKey("pos")
    List<Map<Object, Object>> getJobCountData();

    @MapKey("name")
    List<Map<Object, Object>> getEmpGenderData();


    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp checkLogin(Emp emp);
}

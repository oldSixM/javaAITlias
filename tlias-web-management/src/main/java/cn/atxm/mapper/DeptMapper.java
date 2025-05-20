package cn.atxm.mapper;

import cn.atxm.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/3/31
 */
@Mapper
public interface DeptMapper{
    @Select("select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> getALLDept();

    @Delete("delete from dept where id=#{deptId}")
    void delete(Integer deptId);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Select("select id,name,create_time e,update_time from dept where id=#{deptId}")
    Dept getById(Integer deptId);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}

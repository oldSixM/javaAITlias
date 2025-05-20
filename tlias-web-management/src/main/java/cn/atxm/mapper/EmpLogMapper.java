package cn.atxm.mapper;

import cn.atxm.pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface EmpLogMapper {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Insert("insert into emp_log (operate_time, info) values (#{operateTime}, #{info})")
    void insert(EmpLog empLog);

}

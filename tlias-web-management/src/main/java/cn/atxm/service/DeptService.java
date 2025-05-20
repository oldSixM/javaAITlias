package cn.atxm.service;

import cn.atxm.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/3/31
 */
public interface DeptService {
    List<Dept> getALLDept();

    void delete(Integer deptId);

    void add(Dept dept);

    Dept getById(Integer deptId);

    void update(Dept dept);
}

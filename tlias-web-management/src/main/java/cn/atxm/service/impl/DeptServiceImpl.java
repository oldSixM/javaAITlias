package cn.atxm.service.impl;

import cn.atxm.mapper.DeptMapper;
import cn.atxm.pojo.Dept;
import cn.atxm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/3/31
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getALLDept() {
        return deptMapper.getALLDept();
    }

    @Override
    public void delete(Integer deptId) {
        deptMapper.delete(deptId);
    }

    @Override
    public void add(Dept dept) {
        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer deptId) {
        return deptMapper.getById(deptId);
    }

    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }
}

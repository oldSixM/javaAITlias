package cn.atxm.service.impl;

import cn.atxm.mapper.ClazzMapper;
import cn.atxm.pojo.Clazz;
import cn.atxm.pojo.ClazzQueryParam;
import cn.atxm.pojo.PageResult;
import cn.atxm.pojo.EmpQueryParam;
import cn.atxm.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/9
 */
@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public PageResult<Clazz> page(ClazzQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(),queryParam.getPageSize());
        List<Clazz> list = clazzMapper.list(queryParam);
        Page<Clazz> page = (Page<Clazz>) list;
        return new PageResult<>(page.getTotal(),list);
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
    }

    @Override
    public void insert(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> list() {
        List<Clazz> list = clazzMapper.AllList();
        return list;
    }

}

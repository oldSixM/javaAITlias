package cn.atxm.service.impl;

import cn.atxm.mapper.OperateLogMapper;
import cn.atxm.pojo.OperateLog;
import cn.atxm.pojo.PageResult;
import cn.atxm.service.OperateLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/18
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        List<OperateLog> operateLogs = operateLogMapper.list();

        Page<OperateLog> p = (Page<OperateLog>) operateLogs;
        return new PageResult<>(p.getTotal(),operateLogs);
    }
}
